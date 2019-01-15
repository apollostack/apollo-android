package com.apollographql.apollo.livedata

import android.arch.lifecycle.LiveData
import android.support.annotation.MainThread
import android.support.annotation.NonNull
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloPrefetch
import com.apollographql.apollo.ApolloQueryWatcher
import com.apollographql.apollo.ApolloSubscriptionCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.internal.Utils.checkNotNull
import com.apollographql.apollo.cache.normalized.ApolloStoreOperation
import com.apollographql.apollo.exception.ApolloException
import java.util.concurrent.atomic.AtomicBoolean

/**
 * The LiveDataApollo class provides methods for converting ApolloCall, ApolloPrefetch and ApolloWatcher types to LiveData
 * sources.
 */
@Suppress("unused")
internal object LiveDataApollo {
    /**
     * Converts an [ApolloQueryWatcher] to a LiveData.
     *
     * @param watcher the ApolloQueryWatcher to convert.
     * @param T       the value type.
     * @return the converted LiveData.
     * @throws NullPointerException if watcher == null
     */
    fun <T> from(@NonNull watcher: ApolloQueryWatcher<T>): LiveData<ApolloLiveDataResponse<T>> {
        checkNotNull(watcher, "watcher == null")
        return object : LiveData<ApolloLiveDataResponse<T>>() {
            var started = AtomicBoolean(false)

            @MainThread
            override fun setValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.setValue(value)
            }

            override fun postValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.postValue(value)
            }

            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    watcher.enqueueAndWatch(object : ApolloCall.Callback<T>() {
                        override fun onResponse(response: Response<T>) {
                            postValue(ApolloLiveDataResponse.of { response })
                        }

                        override fun onFailure(e: ApolloException) {
                            postValue(ApolloLiveDataResponse.Failure(e))
                        }
                    })
                }
            }
        }
    }

    /**
     * Converts an [ApolloCall] to a [LiveData]. The number of emissions this LiveData will have is based
     * on the [com.apollographql.apollo.fetcher.ResponseFetcher] used with the call.
     *
     * @param call the ApolloCall to convert.
     * @param T    the value type.
     * @return the converted LiveData.
     * @throws NullPointerException if originalCall == null
     */
    fun <T> from(@NonNull call: ApolloCall<T>): LiveData<ApolloLiveDataResponse<T>> {
        checkNotNull(call, "call == null")
        return object : LiveData<ApolloLiveDataResponse<T>>() {
            var started = AtomicBoolean(false)

            @MainThread
            override fun setValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.setValue(value)
            }

            override fun postValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.postValue(value)
            }

            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : ApolloCall.Callback<T>() {
                        override fun onResponse(response: Response<T>) {
                            postValue(ApolloLiveDataResponse.of { response })
                        }

                        override fun onFailure(e: ApolloException) {
                            postValue(ApolloLiveDataResponse.Failure(e))
                        }

                        override fun onStatusEvent(event: ApolloCall.StatusEvent) {
                            if (event == ApolloCall.StatusEvent.COMPLETED) {
                                postValue(ApolloLiveDataResponse.Complete())
                            }
                        }
                    })
                }
            }
        }
    }

    /**
     * Converts an [ApolloPrefetch] to a LiveData.
     *
     * @param prefetch the ApolloPrefetch to convert.
     * @return the converted LiveData.
     * @throws NullPointerException if prefetch == null
     */
    fun <T> from(@NonNull prefetch: ApolloPrefetch): LiveData<ApolloLiveDataResponse<T>> {
        checkNotNull(prefetch, "prefetch == null")
        return object : LiveData<ApolloLiveDataResponse<T>>() {
            var started = AtomicBoolean(false)

            @MainThread
            override fun setValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.setValue(value)
            }

            override fun postValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.postValue(value)
            }

            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    prefetch.enqueue(object : ApolloPrefetch.Callback() {
                        override fun onSuccess() {
                            postValue(ApolloLiveDataResponse.Complete())
                        }

                        override fun onFailure(e: ApolloException) {
                            postValue(ApolloLiveDataResponse.Failure(e))
                        }
                    })
                }
            }
        }
    }

    /**
     * Converts an [ApolloSubscriptionCall] to a LiveData.
     *
     * @param call the ApolloPrefetch to convert.
     * @return the converted LiveData.
     * @throws NullPointerException if prefetch == null
     */
    fun <T> from(@NonNull call: ApolloSubscriptionCall<T>): LiveData<ApolloLiveDataResponse<T>> {
        checkNotNull(call, "call == null")
        return object : LiveData<ApolloLiveDataResponse<T>>() {
            var started = AtomicBoolean(false)

            @MainThread
            override fun setValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.setValue(value)
            }

            override fun postValue(value: ApolloLiveDataResponse<T>?) {
                started.set(true)
                super.postValue(value)
            }

            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.execute(object : ApolloSubscriptionCall.Callback<T> {
                        override fun onResponse(response: Response<T>) {
                            postValue(ApolloLiveDataResponse.of { response })
                        }

                        override fun onFailure(e: ApolloException) {
                            postValue(ApolloLiveDataResponse.Failure(e))
                        }

                        override fun onCompleted() {
                            postValue(ApolloLiveDataResponse.Complete())
                        }
                    })
                }
            }
        }
    }

    /**
     * Converts an [ApolloStoreOperation] to a LiveData.
     *
     * @param operation the ApolloStoreOperation to convert.
     * @param T         the value type.
     * @return the converted LiveData.
     */
    fun <T> from(@NonNull operation: ApolloStoreOperation<T>): LiveData<T?> {
        checkNotNull(operation, "operation == null")
        return object : LiveData<T?>() {
            var started = AtomicBoolean(false)
            var onPosted = AtomicBoolean(false)

            override fun setValue(value: T?) {
                started.set(true)
                if (!onPosted.get()) {
                    super.setValue(value)
                }
            }

            override fun postValue(value: T?) {
                started.set(true)
                if (!onPosted.get()) {
                    super.postValue(value)
                }
            }

            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    operation.enqueue(object : ApolloStoreOperation.Callback<T> {
                        override fun onSuccess(result: T) {
                            postValue(result)
                            onPosted.set(true)
                        }

                        override fun onFailure(t: Throwable?) {
                            postValue(null)
                            onPosted.set(true)
                        }
                    })
                }
            }
        }
    }
}
