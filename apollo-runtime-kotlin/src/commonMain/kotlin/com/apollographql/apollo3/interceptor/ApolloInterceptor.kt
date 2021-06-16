package com.apollographql.apollo3.interceptor

import com.apollographql.apollo3.api.ApolloRequest
import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.api.ApolloResponse
import kotlinx.coroutines.flow.Flow

interface ApolloInterceptorChain {
  fun <D : Operation.Data> proceed(request: ApolloRequest<D>): Flow<ApolloResponse<D>>
}

interface ApolloInterceptor {
  fun <D : Operation.Data> intercept(request: ApolloRequest<D>, chain: ApolloInterceptorChain): Flow<ApolloResponse<D>>
}

internal class RealInterceptorChain(
    private val interceptors: List<ApolloInterceptor>,
    private val index: Int,
) : ApolloInterceptorChain {

  override fun <D : Operation.Data> proceed(request: ApolloRequest<D>): Flow<ApolloResponse<D>> {
    check(index < interceptors.size)
    return interceptors[index].intercept(
        request,
        RealInterceptorChain(
            interceptors = interceptors,
            index = index + 1,
        )
    )
  }
}
