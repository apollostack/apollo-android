// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.introspection_query

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery : Query<TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      TestQuery_ResponseAdapter.fromResponse(reader)
    }
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return parse(Buffer().write(byteString), scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> {
    return parse(source, DEFAULT)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> {
    return parse(byteString, DEFAULT)
  }

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString {
    return OperationRequestBodyComposer.compose(
      operation = this,
      autoPersistQueries = false,
      withQueryDocument = true,
      scalarTypeAdapters = scalarTypeAdapters
    )
  }

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val __schema: __Schema,
    val __type: __Type?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestQuery_ResponseAdapter.Data.toResponse(writer, this)
      }
    }

    /**
     * A GraphQL Schema defines the capabilities of a GraphQL server. It exposes all available types
     * and directives on the server, as well as the entry points for query, mutation, and subscription
     * operations.
     */
    data class __Schema(
      val __typename: String = "__Schema",
      /**
       * The type that query operations will be rooted at.
       */
      val queryType: QueryType,
      /**
       * A list of all types supported by this server.
       */
      val types: List<Type>
    ) {
      fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          TestQuery_ResponseAdapter.Data.__Schema.toResponse(writer, this)
        }
      }

      /**
       * The fundamental unit of any GraphQL Schema is the type. There are many kinds of types in
       * GraphQL as represented by the `__TypeKind` enum.
       *
       * Depending on the kind of a type, certain fields describe information about that type.
       * Scalar types provide no information beyond a name and description, while Enum types provide
       * their values. Object and Interface types provide the fields they describe. Abstract types,
       * Union and Interface, provide the Object types possible at runtime. List and NonNull types
       * compose other types.
       */
      data class QueryType(
        val __typename: String = "__Type",
        val name: String?
      ) {
        fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.__Schema.QueryType.toResponse(writer, this)
          }
        }
      }

      /**
       * The fundamental unit of any GraphQL Schema is the type. There are many kinds of types in
       * GraphQL as represented by the `__TypeKind` enum.
       *
       * Depending on the kind of a type, certain fields describe information about that type.
       * Scalar types provide no information beyond a name and description, while Enum types provide
       * their values. Object and Interface types provide the fields they describe. Abstract types,
       * Union and Interface, provide the Object types possible at runtime. List and NonNull types
       * compose other types.
       */
      data class Type(
        val __typename: String = "__Type",
        val name: String?
      ) {
        fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.__Schema.Type.toResponse(writer, this)
          }
        }
      }
    }

    /**
     * The fundamental unit of any GraphQL Schema is the type. There are many kinds of types in
     * GraphQL as represented by the `__TypeKind` enum.
     *
     * Depending on the kind of a type, certain fields describe information about that type. Scalar
     * types provide no information beyond a name and description, while Enum types provide their
     * values. Object and Interface types provide the fields they describe. Abstract types, Union and
     * Interface, provide the Object types possible at runtime. List and NonNull types compose other
     * types.
     */
    data class __Type(
      val __typename: String = "__Type",
      val name: String?
    ) {
      fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          TestQuery_ResponseAdapter.Data.__Type.toResponse(writer, this)
        }
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "08518fde8892d59c699c4d48f384d7199d933a5846e6936d910cb492b8f84684"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  __schema {
          |    __typename
          |    queryType {
          |      __typename
          |      name
          |    }
          |    types {
          |      __typename
          |      name
          |    }
          |  }
          |  __type(name: "Vehicle") {
          |    __typename
          |    name
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "TestQuery"
      }
    }
  }
}
