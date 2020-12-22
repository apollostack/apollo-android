package com.apollographql.apollo.integration

import HeroNameQuery
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.simple.MapNormalizedCache
import com.apollographql.apollo.interceptor.cache.ApolloCacheInterceptor
import com.apollographql.apollo.interceptor.cache.ApolloStore
import com.apollographql.apollo.interceptor.cache.fromCache
import com.apollographql.apollo.interceptor.cache.normalizedCache
import com.apollographql.apollo.testing.MockNetworkTransport
import com.apollographql.apollo.testing.TestLoggerExecutor
import com.apollographql.apollo.testing.runBlocking
import kotlinx.coroutines.flow.single
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@Suppress("EXPERIMENTAL_API_USAGE")
class CacheInterceptorTest {
  private lateinit var networkTransport: MockNetworkTransport
  private lateinit var apolloClient: ApolloClient

  @BeforeTest
  fun setUp() {
    networkTransport = MockNetworkTransport()
    apolloClient = ApolloClient.DefaultBuilder()
        .networkTransport(networkTransport)
        .addInterceptor(TestLoggerExecutor)
        .normalizedCache(MapNormalizedCache())
        .build()
  }

  @Test
  fun `second request doesn't hit network`() {
    networkTransport.offer(fixtureResponse("HeroNameResponse.json"))

    runBlocking {
      var response = apolloClient
          .query(HeroNameQuery())
          .execute()
          .single()

      assertNotNull(response.data)
      assertFalse(response.fromCache)

      response = apolloClient
          .query(HeroNameQuery())
          .execute()
          .single()

      assertNotNull(response.data)
      assertTrue(response.fromCache)
    }
  }
}
