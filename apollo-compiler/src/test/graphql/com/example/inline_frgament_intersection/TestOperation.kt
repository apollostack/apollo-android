// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_frgament_intersection

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
import com.example.inline_frgament_intersection.type.Race
import kotlin.Boolean
import kotlin.Double
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
class TestOperation : Query<TestOperation.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      TestOperation_ResponseAdapter.fromResponse(reader)
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

  data class Data(
    val random: Random
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestOperation_ResponseAdapter.Data.toResponse(writer, this)
      }
    }

    interface Random {
      val __typename: String

      fun asBeing(): Being? = this as? Being

      fun asHuman(): Human? = this as? Human

      fun asWookie(): Wookie? = this as? Wookie

      fun marshaller(): ResponseFieldMarshaller

      interface Being : Random {
        override val __typename: String

        val name: String

        val friends: List<Friend>

        override fun marshaller(): ResponseFieldMarshaller

        interface Friend {
          val __typename: String

          val name: String

          fun marshaller(): ResponseFieldMarshaller
        }
      }

      interface Human : Random, Being {
        override val __typename: String

        override val name: String

        override val friends: List<Friend>

        val profilePictureUrl: String?

        override fun marshaller(): ResponseFieldMarshaller

        interface Friend : Being.Friend {
          override val __typename: String

          override val name: String

          val isFamous: Boolean?

          override fun marshaller(): ResponseFieldMarshaller

          interface Wookie : Friend {
            override val __typename: String

            override val isFamous: Boolean?

            val race: Race

            override val name: String

            override fun marshaller(): ResponseFieldMarshaller
          }
        }
      }

      interface Wookie : Random, Being {
        override val __typename: String

        override val name: String

        override val friends: List<Friend>

        val race: Race

        override fun marshaller(): ResponseFieldMarshaller

        interface Friend : Being.Friend {
          override val __typename: String

          override val name: String

          val lifeExpectancy: Double?

          override fun marshaller(): ResponseFieldMarshaller
        }
      }

      data class BeingHumanRandom(
        override val __typename: String = "Human",
        override val name: String,
        override val friends: List<Friend>,
        override val profilePictureUrl: String?
      ) : Random, Being, Human {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestOperation_ResponseAdapter.Data.Random.BeingHumanRandom.toResponse(writer, this)
          }
        }

        interface Friend : Being.Friend, Human.Friend {
          override val __typename: String

          override val name: String

          override val isFamous: Boolean?

          fun asWookie(): Wookie? = this as? Wookie

          override fun marshaller(): ResponseFieldMarshaller

          interface Wookie : Human.Friend, Human.Friend.Wookie, Friend {
            override val __typename: String

            override val isFamous: Boolean?

            override val race: Race

            override val name: String

            override fun marshaller(): ResponseFieldMarshaller
          }

          data class WookieFriend(
            override val __typename: String = "Wookie",
            override val isFamous: Boolean?,
            override val race: Race,
            override val name: String
          ) : Human.Friend, Human.Friend.Wookie, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestOperation_ResponseAdapter.Data.Random.BeingHumanRandom.Friend.WookieFriend.toResponse(writer, this)
              }
            }
          }

          data class OtherFriend(
            override val __typename: String = "Being",
            override val name: String,
            override val isFamous: Boolean?
          ) : Being.Friend, Human.Friend, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestOperation_ResponseAdapter.Data.Random.BeingHumanRandom.Friend.OtherFriend.toResponse(writer, this)
              }
            }
          }
        }
      }

      data class BeingWookieRandom(
        override val __typename: String = "Wookie",
        override val name: String,
        override val friends: List<Friend>,
        override val race: Race
      ) : Random, Being, Wookie {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestOperation_ResponseAdapter.Data.Random.BeingWookieRandom.toResponse(writer, this)
          }
        }

        data class Friend(
          override val __typename: String = "Being",
          override val name: String,
          override val lifeExpectancy: Double?
        ) : Being.Friend, Wookie.Friend {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestOperation_ResponseAdapter.Data.Random.BeingWookieRandom.Friend.toResponse(writer, this)
            }
          }
        }
      }

      data class OtherRandom(
        override val __typename: String = "Anything"
      ) : Random {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestOperation_ResponseAdapter.Data.Random.OtherRandom.toResponse(writer, this)
          }
        }
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "266ee67aca335d39a844395b33ced4530282dc7f4346add6f8b2dbe95b0e38d6"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestOperation {
          |  random {
          |    __typename
          |    ... on Being {
          |      __typename
          |      name
          |      friends {
          |        __typename
          |        name
          |      }
          |      ... on Human {
          |        profilePictureUrl
          |        friends {
          |          __typename
          |          isFamous
          |          ... on Wookie {
          |            race
          |          }
          |        }
          |      }
          |      ... on Wookie {
          |        race
          |        friends {
          |          __typename
          |          lifeExpectancy
          |        }
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "TestOperation"
      }
    }
  }
}
