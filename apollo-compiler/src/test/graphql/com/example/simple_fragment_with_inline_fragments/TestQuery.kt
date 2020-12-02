// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment_with_inline_fragments

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
import com.example.simple_fragment_with_inline_fragments.adapter.TestQuery_ResponseAdapter
import com.example.simple_fragment_with_inline_fragments.fragment.HeroDetail
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

      fun marshaller(): ResponseFieldMarshaller

      interface Character : Hero, HeroDetail {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * The friends of the character, or an empty list if they have none
         */
        override val friends: List<Friend?>?

        override fun marshaller(): ResponseFieldMarshaller

        /**
         * A character from the Star Wars universe
         */
        interface Friend : HeroDetail.Friend {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          override fun marshaller(): ResponseFieldMarshaller

          /**
           * A humanoid creature from the Star Wars universe
           */
          interface Human : Friend, HeroDetail.Friend.Human {
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
           * An autonomous mechanical character in the Star Wars universe
           */
          interface Droid : Friend, HeroDetail.Friend.Droid {
            override val __typename: String

            /**
             * The name of the character
             */
            override val name: String

            /**
             * This droid's primary function
             */
            override val primaryFunction: String?

            override fun marshaller(): ResponseFieldMarshaller
          }

          companion object {
            fun Friend.heroDetailsFriendsHuman(): HeroDetail.Friend.Human? = this as?
                HeroDetail.Friend.Human

            fun Friend.asHuman(): Human? = this as? Human

            fun Friend.heroDetailsFriendsDroid(): HeroDetail.Friend.Droid? = this as?
                HeroDetail.Friend.Droid

            fun Friend.asDroid(): Droid? = this as? Droid
          }
        }
      }

      data class CharacterHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * The friends of the character, or an empty list if they have none
         */
        override val friends: List<Friend?>?
      ) : Hero, Character, HeroDetail {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.CharacterHero.toResponse(writer, this)
          }
        }

        /**
         * A character from the Star Wars universe
         */
        interface Friend : Character.Friend, HeroDetail.Friend {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          override fun marshaller(): ResponseFieldMarshaller

          /**
           * A humanoid creature from the Star Wars universe
           */
          interface Human : Character.Friend, Character.Friend.Human, HeroDetail.Friend.Human,
              Friend {
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
           * An autonomous mechanical character in the Star Wars universe
           */
          interface Droid : Character.Friend, Character.Friend.Droid, HeroDetail.Friend.Droid,
              Friend {
            override val __typename: String

            /**
             * The name of the character
             */
            override val name: String

            /**
             * This droid's primary function
             */
            override val primaryFunction: String?

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
          ) : Character.Friend, Character.Friend.Human, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestQuery_ResponseAdapter.Data.Hero.CharacterHero.Friend.HumanFriend.toResponse(writer, this)
              }
            }
          }

          /**
           * An autonomous mechanical character in the Star Wars universe
           */
          data class DroidFriend(
            override val __typename: String = "Droid",
            /**
             * The name of the character
             */
            override val name: String,
            /**
             * This droid's primary function
             */
            override val primaryFunction: String?
          ) : Character.Friend, Character.Friend.Droid, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestQuery_ResponseAdapter.Data.Hero.CharacterHero.Friend.DroidFriend.toResponse(writer, this)
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
          ) : Character.Friend, HeroDetail.Friend, Friend {
            override fun marshaller(): ResponseFieldMarshaller {
              return ResponseFieldMarshaller { writer ->
                TestQuery_ResponseAdapter.Data.Hero.CharacterHero.Friend.OtherFriend.toResponse(writer, this)
              }
            }
          }

          companion object {
            fun Friend.heroDetailsFriendsHuman(): HeroDetail.Friend.Human? = this as?
                HeroDetail.Friend.Human

            fun Friend.asHuman(): Human? = this as? Human

            fun Friend.heroDetailsFriendsDroid(): HeroDetail.Friend.Droid? = this as?
                HeroDetail.Friend.Droid

            fun Friend.asDroid(): Droid? = this as? Droid
          }
        }
      }

      /**
       * A character from the Star Wars universe
       */
      data class OtherHero(
        override val __typename: String = "Character"
      ) : Hero {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.OtherHero.toResponse(writer, this)
          }
        }
      }

      companion object {
        fun Hero.heroDetails(): HeroDetail? = this as? HeroDetail

        fun Hero.asCharacter(): Character? = this as? Character
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "d5cb325c69027e05bed9d8cbfa589f8c521df26be01c87bf9169d7c931f04489"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  hero {
          |    __typename
          |    ...HeroDetails
          |  }
          |}
          |fragment HeroDetails on Character {
          |  __typename
          |  name
          |  friends {
          |    __typename
          |    name
          |    ... on Human {
          |      height
          |    }
          |    ... on Droid {
          |      primaryFunction
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
