package com.apollographql.apollo3.cache.normalized.internal

import com.apollographql.apollo3.api.ApolloInternal
import com.apollographql.apollo3.api.Fragment
import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.internal.ApolloLogger
import com.apollographql.apollo3.cache.CacheHeaders
import com.apollographql.apollo3.cache.normalized.ApolloStore
import com.apollographql.apollo3.cache.normalized.CacheKey
import com.apollographql.apollo3.cache.normalized.CacheKeyResolver
import com.apollographql.apollo3.cache.normalized.NormalizedCacheFactory
import com.apollographql.apollo3.cache.normalized.Record
import com.benasher44.uuid.Uuid
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class RealApolloStore(
    normalizedCacheFactory: NormalizedCacheFactory,
    private val cacheKeyResolver: CacheKeyResolver,
    val logger: ApolloLogger = ApolloLogger(null),
) : ApolloStore() {
  private val changedKeysEvents = MutableSharedFlow<Set<String>>(
      // XXX: this is a potential code smell
      // I'm not sure what will happen if we ever reach that capacity
      // We need to buffer because the publish code is possibly reentrant so we can't just wait for all consumers to have received
      // the events or we will deadlock
      extraBufferCapacity = 10,
      onBufferOverflow = BufferOverflow.DROP_OLDEST
  )

  override val changedKeys = changedKeysEvents.asSharedFlow()

  private val cacheHolder = Guard("OptimisticCache") {
    OptimisticCache().chain(normalizedCacheFactory.createChain()) as OptimisticCache
  }

  /**
   * For backward compatibility only
   */
  private var subscribers = Guard("subscribers") {
    mutableListOf<Pair<RecordChangeSubscriber, Job>>()
  }

  override fun subscribe(subscriber: RecordChangeSubscriber) {
    val job = GlobalScope.launch {
      changedKeys.collect {
        subscriber.onCacheRecordsChanged(it)
      }
    }
    subscribers.blockingAccess {
      it.add(subscriber to job)
    }
  }

  override fun unsubscribe(subscriber: RecordChangeSubscriber) {
    val job = subscribers.blockingAccess {
      val index = it.indexOfFirst { it.first == subscriber }
      if (index >= 0) {
        it.removeAt(index).second
      } else {
        null
      }
    }

    job?.cancel()
  }

  override suspend fun publish(keys: Set<String>) {
    if (keys.isEmpty()) {
      return
    }

    changedKeysEvents.emit(keys)
  }

  override fun clearAll(): Boolean {
    cacheHolder.writeAndForget {
      it.clearAll()
    }
    return true
  }

  override suspend fun remove(
      cacheKey: CacheKey,
      cascade: Boolean,
  ): Boolean {
    return cacheHolder.access {
      it.remove(cacheKey, cascade)
    }
  }

  override suspend fun remove(
      cacheKeys: List<CacheKey>,
      cascade: Boolean,
  ): Int {
    return cacheHolder.access {
      var count = 0
      for (cacheKey in cacheKeys) {
        if (it.remove(cacheKey, cascade = cascade)) {
          count++
        }
      }
      count
    }
  }

  override fun <D : Operation.Data> normalize(
      operation: Operation<D>,
      data: D,
      customScalarAdapters: CustomScalarAdapters,
  ): Map<String, Record> {
    return operation.normalize(
        data,
        customScalarAdapters,
        cacheKeyResolver
    )
  }

  override suspend fun <D : Operation.Data> readOperation(
      operation: Operation<D>,
      customScalarAdapters: CustomScalarAdapters,
      cacheHeaders: CacheHeaders,
      mode: ReadMode,
  ): D? {
    // Capture a local reference so as not to freeze "this"
    val cacheKeyResolver = cacheKeyResolver


    return cacheHolder.access { cache ->
      operation.readDataFromCache(
          customScalarAdapters = customScalarAdapters,
          cache = cache,
          cacheKeyResolver = cacheKeyResolver,
          cacheHeaders = cacheHeaders,
          mode = mode,
      )
    }
  }

  override suspend fun <D : Fragment.Data> readFragment(
      fragment: Fragment<D>,
      cacheKey: CacheKey,
      customScalarAdapters: CustomScalarAdapters,
      cacheHeaders: CacheHeaders,
  ): D? {
    // Capture a local reference so as not to freeze "this"
    val cacheKeyResolver = cacheKeyResolver

    return cacheHolder.access { cache ->
      fragment.readDataFromCache(
          customScalarAdapters = customScalarAdapters,
          cache = cache,
          cacheKeyResolver = cacheKeyResolver,
          cacheHeaders = cacheHeaders,
          cacheKey = cacheKey
      )
    }
  }

  @OptIn(ApolloInternal::class)
  override suspend fun <D : Operation.Data> writeOperation(
      operation: Operation<D>,
      operationData: D,
      customScalarAdapters: CustomScalarAdapters,
      cacheHeaders: CacheHeaders,
      publish: Boolean,
  ): Set<String> {
    return writeOperationWithRecords(
        operation = operation,
        operationData = operationData,
        cacheHeaders = cacheHeaders,
        publish = publish,
        customScalarAdapters = customScalarAdapters
    ).second
  }

  override suspend fun <D : Fragment.Data> writeFragment(
      fragment: Fragment<D>,
      cacheKey: CacheKey,
      fragmentData: D,
      customScalarAdapters: CustomScalarAdapters,
      cacheHeaders: CacheHeaders,
      publish: Boolean,
  ): Set<String> {
    require(cacheKey != CacheKey.NO_KEY) {
      "ApolloGraphQL: writing a fragment requires a valid cache key"
    }

    // Capture a local reference so as not to freeze "this"
    val cacheKeyResolver = cacheKeyResolver

    val changedKeys =  cacheHolder.access { cache ->
      val records = fragment.normalize(
          data = fragmentData,
          customScalarAdapters = customScalarAdapters,
          cacheKeyResolver = cacheKeyResolver,
          rootKey = cacheKey.key
      ).values

      cache.merge(records, cacheHeaders)
    }

    if (publish) {
      publish(changedKeys)
    }

    return changedKeys
  }

  suspend fun <D : Operation.Data> writeOperationWithRecords(
      operation: Operation<D>,
      operationData: D,
      cacheHeaders: CacheHeaders,
      publish: Boolean,
      customScalarAdapters: CustomScalarAdapters,
  ): Pair<Set<Record>, Set<String>> {

    // Capture a local reference so as not to freeze "this"
    val cacheKeyResolver = cacheKeyResolver

    val (records, changedKeys) = cacheHolder.access { cache ->
      val records = operation.normalize(
          data = operationData,
          customScalarAdapters = customScalarAdapters,
          cacheKeyResolver = cacheKeyResolver
      )

      records to cache.merge(records.values.toList(), cacheHeaders)
    }
    if (publish) {
      publish(changedKeys)
    }

    return records.values.toSet() to changedKeys
  }

  override suspend fun <D : Operation.Data> writeOptimisticUpdates(
      operation: Operation<D>,
      operationData: D,
      mutationId: Uuid,
      customScalarAdapters: CustomScalarAdapters,
      publish: Boolean,
  ): Set<String> {

    // Capture a local reference so as not to freeze "this"
    val cacheKeyResolver = cacheKeyResolver

    val changedKeys = cacheHolder.access { cache ->
      val records = operation.normalize(
          data = operationData,
          customScalarAdapters = customScalarAdapters,
          cacheKeyResolver = cacheKeyResolver
      ).values.map { record ->
        Record(
            key = record.key,
            fields = record.fields,
            mutationId = mutationId
        )
      }

      /**
       * TODO: should we forward the cache headers to the optimistic store?
       */
      cache.mergeOptimisticUpdates(records)
    }

    if (publish) {
      publish(changedKeys)
    }

    return changedKeys
  }

  override suspend fun rollbackOptimisticUpdates(
      mutationId: Uuid,
      publish: Boolean,
  ): Set<String> {
    val changedKeys = cacheHolder.access { cache ->
      cache.removeOptimisticUpdates(mutationId)
    }

    if (publish) {
      publish(changedKeys)
    }

    return changedKeys
  }

  suspend fun merge(record: Record, cacheHeaders: CacheHeaders): Set<String> {
    return cacheHolder.access { cache ->
      cache.merge(record, cacheHeaders)
    }
  }

  override suspend fun dump(): Map<KClass<*>, Map<String, Record>> {
    return cacheHolder.access { cache ->
      cache.dump()
    }
  }
}

