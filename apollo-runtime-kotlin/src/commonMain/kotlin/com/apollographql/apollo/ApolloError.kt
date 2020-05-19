package com.apollographql.apollo

sealed class ApolloError {
  object SerializationError : ApolloError()

  object ParseError : ApolloError()

  object Network : ApolloError()

  data class Http(val statusCode: Int, val headers: Map<String, String>) : ApolloError()
}
