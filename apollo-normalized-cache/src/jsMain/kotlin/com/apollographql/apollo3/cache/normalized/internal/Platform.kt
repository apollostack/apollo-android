package com.apollographql.apollo3.cache.normalized.internal

import kotlin.js.Date

internal actual object Platform {
  actual fun currentTimeMillis(): Long {
    return Date().getTime().toLong()
  }
}

