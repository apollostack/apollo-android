// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.nested_conditional_inline

import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.nested_conditional_inline.type.Episode
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
data class TestQuery(
  val episode: Input<Episode> = Input.absent()
) : Query<TestQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      if (this@TestQuery.episode.defined) {
        this["episode"] = this@TestQuery.episode.value
      }
    }

    override fun marshaller(): InputFieldMarshaller {
      return InputFieldMarshaller.invoke { writer ->
        if (this@TestQuery.episode.defined) {
          writer.writeString("episode", this@TestQuery.episode.value?.rawValue)
        }
      }
    }
  }

  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = variables

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
    val hero: Hero?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestQuery_ResponseAdapter.Data.toResponse(writer, this)
      }
    }

    /**
     * A character from the Star Wars universe
     */
    interface Hero {
      val __typename: String

      /**
       * The name of the character
       */
      val name: String

      fun asHuman(): Human? = this as? Human

      fun asDroid(): Droid? = this as? Droid

      fun marshaller(): ResponseFieldMarshaller

      /**
       * A humanoid creature from the Star Wars universe
       */
      interface Human : Hero {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * This human's friends, or an empty list if they have none
         */
        val friends: List<Friend?>?

        override fun marshaller(): ResponseFieldMarshaller

        /**
         * A character from the Star Wars universe
         */
        interface Friend {
          val __typename: String

          /**
           * The name of the character
           */
          val name: String

          fun marshaller(): ResponseFieldMarshaller

          /**
           * A humanoid creature from the Star Wars universe
           */
          interface Human : Friend {
            override val __typename: String

            /**
             * The name of the character
             */
            override val name: String

            /**
             * Height in the preferred unit, default is meters
             */
            val height: Double?

            override fun marshaller(): ResponseFieldMarshaller
          }
        }
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      interface Droid : Hero {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * This droid's friends, or an empty list if they have none
         */
        val friends: List<Friend?>?

        override fun marshaller(): ResponseFieldMarshaller

        /**
         * A character from the Star Wars universe
         */
        interface Friend {
          val __typename: String

          /**
           * The name of the character
           */
          val name: String

          fun marshaller(): ResponseFieldMarshaller

          /**
           * A humanoid creature from the Star Wars universe
           */
          interface Human : Friend {
            override val __typename: String

            /**
             * The name of the character
             */
            override val name: String

            /**
             * Height in the preferred unit, default is meters
             */
            val height: Double?

            override fun marshaller(): ResponseFieldMarshaller
          }
        }
      }

      /**
       * A humanoid creature from the Star Wars universe
       */
      data class HumanHero(
        override val __typename: String = "Human",
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * This human's friends, or an empty list if they have none
         */
        override val friends: List<Friend?>?
      ) : Hero, Human {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.HumanHero.toResponse(writer, this)
          }
        }

        /**
         * A character from the Star Wars universe
         */
        interface Friend : Human.Friend {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          fun asHuman(): Human? = this as? Human

          override fun marshaller(): ResponseFieldMarshaller

          /**
           * A humanoid creature from the Star Wars universe
           */
          interface Human : Hero.Human.Friend, Hero.Human.Friend.Human, Friend {
            override val __typename: String

            /**
             * The name of the character
             */
            override val name: String

            /**
             * Height in the preferred unit, default is meters
             */
            override val height: Double?

            override fun marshaller(): ResponseFieldMarshaller
          }

          /**
           * A humanoid creature from the Star Wars universe
           */
          data class HumanFriend(
            override val __typename: String = "Human",
            /**
             * The name of the character
             */
            override val name: String,
            /**
             * Height in the preferred unit, default is meters
             */
            override val height: Double?
          ) : Hero.Human.Friend, Hero.Human.Friend.Human, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestQuery_ResponseAdapter.Data.Hero.HumanHero.Friend.HumanFriend.toResponse(writer, this)
              }
            }
          }

          /**
           * A character from the Star Wars universe
           */
          data class OtherFriend(
            override val __typename: String = "Character",
            /**
             * The name of the character
             */
            override val name: String
          ) : Hero.Human.Friend, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestQuery_ResponseAdapter.Data.Hero.HumanHero.Friend.OtherFriend.toResponse(writer, this)
              }
            }
          }
        }
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      data class DroidHero(
        override val __typename: String = "Droid",
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * This droid's friends, or an empty list if they have none
         */
        override val friends: List<Friend?>?
      ) : Hero, Droid {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.DroidHero.toResponse(writer, this)
          }
        }

        /**
         * A character from the Star Wars universe
         */
        interface Friend : Droid.Friend {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          fun asHuman(): Human? = this as? Human

          override fun marshaller(): ResponseFieldMarshaller

          /**
           * A humanoid creature from the Star Wars universe
           */
          interface Human : Droid.Friend, Droid.Friend.Human, Friend {
            override val __typename: String

            /**
             * The name of the character
             */
            override val name: String

            /**
             * Height in the preferred unit, default is meters
             */
            override val height: Double?

            override fun marshaller(): ResponseFieldMarshaller
          }

          /**
           * A humanoid creature from the Star Wars universe
           */
          data class HumanFriend(
            override val __typename: String = "Human",
            /**
             * The name of the character
             */
            override val name: String,
            /**
             * Height in the preferred unit, default is meters
             */
            override val height: Double?
          ) : Droid.Friend, Droid.Friend.Human, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestQuery_ResponseAdapter.Data.Hero.DroidHero.Friend.HumanFriend.toResponse(writer, this)
              }
            }
          }

          /**
           * A character from the Star Wars universe
           */
          data class OtherFriend(
            override val __typename: String = "Character",
            /**
             * The name of the character
             */
            override val name: String
          ) : Droid.Friend, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestQuery_ResponseAdapter.Data.Hero.DroidHero.Friend.OtherFriend.toResponse(writer, this)
              }
            }
          }
        }
      }

      /**
       * A character from the Star Wars universe
       */
      data class OtherHero(
        override val __typename: String = "Character",
        /**
         * The name of the character
         */
        override val name: String
      ) : Hero {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.OtherHero.toResponse(writer, this)
          }
        }
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "a9f066a7d1092096ab154f16f32114a4bd71e959b789f37879249cdf6309ea86"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery(${'$'}episode: Episode) {
          |  hero(episode: ${'$'}episode) {
          |    __typename
          |    name
          |    ... on Human {
          |      friends {
          |        __typename
          |        name
          |        ... on Human {
          |          height(unit: FOOT)
          |        }
          |      }
          |    }
          |    ... on Droid {
          |      friends {
          |        __typename
          |        name
          |        ... on Human {
          |          height(unit: METER)
          |        }
          |      }
          |    }
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
