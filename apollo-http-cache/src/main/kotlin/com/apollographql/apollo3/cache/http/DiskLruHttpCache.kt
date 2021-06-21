package com.apollographql.apollo3.cache.http

import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.cache.http.internal.DiskLruCache
import com.apollographql.apollo3.cache.http.internal.FileSystem
import com.squareup.moshi.Moshi
import okio.buffer
import java.io.File
import java.io.IOException
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

class DiskLruHttpCache(private val fileSystem: FileSystem, private val directory: File, private val maxSize: Long) {
  private var cache = createDiskLruCache()
  private val cacheLock = ReentrantReadWriteLock()
  private val adapter = Moshi.Builder().build().adapter(Any::class.java)

  constructor(directory: File, maxSize: Long) : this(FileSystem.SYSTEM, directory, maxSize)

  private fun createDiskLruCache(): DiskLruCache {
    return DiskLruCache.create(fileSystem, directory, VERSION, ENTRY_COUNT, maxSize)
  }

  @Suppress("UNCHECKED_CAST")
  fun read(cacheKey: String): HttpResponse {
    val snapshot = cacheLock.read {
      cache[cacheKey]
    } ?: error("HTTP cache: no snapshot")

    val source = snapshot.getSource(ENTRY_HEADERS)
    val map = source.buffer().use {
      adapter.fromJson(it)
    } as? Map<String, Any> ?: error("HTTP cache: no map")


    return HttpResponse(
        statusCode = (map["statusCode"] as? String)?.toInt() ?: error("HTTP cache: no statusCode"),
        headers = (map["headers"] as? Map<String, String>) ?: error("HTTP cache: no headers"),
        bodySource = snapshot.getSource(ENTRY_BODY).buffer(),
        bodyString = null
    )
  }

  fun write(response: HttpResponse, cacheKey: String) {
    val editor = cacheLock.read {
      cache.edit(cacheKey)
    }

    if (editor == null) {
      return
    }

    try {
      editor.newSink(ENTRY_HEADERS).buffer().use {
        val map = mapOf(
            "statusCode" to response.statusCode.toString(),
            "headers" to response.headers,
        )
        adapter.toJson(it, map)
      }
      editor.newSink(ENTRY_BODY).buffer().use {
        val map = mapOf(
            "statusCode" to response.statusCode,
            "headers" to response.headers,
        )
        val responseBody = response.body
        if (responseBody != null) {
          it.writeAll(responseBody)
          responseBody.close()
        }
      }
      editor.commit()
    } catch (e: Exception) {
      editor.abort()
    }
  }

  @Throws(IOException::class)
  fun delete() {
    cache = cacheLock.write {
      cache.delete()
      createDiskLruCache()
    }
  }

  @Throws(IOException::class)
  fun remove(cacheKey: String) {
    // is `read` ok here?
    cacheLock.read {
      cache.remove(cacheKey)
    }
  }

  companion object {
    private const val VERSION = 99991
    private const val ENTRY_HEADERS = 0
    private const val ENTRY_BODY = 1
    private const val ENTRY_COUNT = 2
  }
}