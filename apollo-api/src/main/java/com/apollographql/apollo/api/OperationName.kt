package com.apollographql.apollo.api

/**
 * GraphQL operation name.
 */
interface OperationName {
  /**
   * Returns operation name.
   *
   * @return operation name
   */
  fun name(): String
}
