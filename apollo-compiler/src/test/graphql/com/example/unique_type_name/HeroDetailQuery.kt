// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.unique_type_name

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
import com.example.unique_type_name.adapter.HeroDetailQuery_ResponseAdapter
import com.example.unique_type_name.fragment.HeroDetail
import com.example.unique_type_name.type.Episode
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
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
class HeroDetailQuery : Query<HeroDetailQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      HeroDetailQuery_ResponseAdapter.fromResponse(reader)
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
    val heroDetailQuery: HeroDetailQuery?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetailQuery_ResponseAdapter.Data.toResponse(writer, this)
      }
    }

    /**
     * A character from the Star Wars universe
     */
    interface HeroDetailQuery {
      val __typename: String

      /**
       * The name of the character
       */
      val name: String

      /**
       * The friends of the character, or an empty list if they have none
       */
      val friends: List<Friend?>?

      fun marshaller(): ResponseFieldMarshaller

      /**
       * A character from the Star Wars universe
       */
      interface Friend {
        /**
         * The name of the character
         */
        val name: String

        fun marshaller(): ResponseFieldMarshaller
      }

      /**
       * A humanoid creature from the Star Wars universe
       */
      interface Human : HeroDetailQuery {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * The friends of the character, or an empty list if they have none
         */
        override val friends: List<Friend?>?

        /**
         * Height in the preferred unit, default is meters
         */
        val height: Double?

        override fun marshaller(): ResponseFieldMarshaller

        /**
         * A character from the Star Wars universe
         */
        interface Friend : HeroDetailQuery.Friend {
          /**
           * The name of the character
           */
          override val name: String

          /**
           * The movies this character appears in
           */
          val appearsIn: List<Episode?>

          /**
           * The friends of the character, or an empty list if they have none
           */
          val friends: List<Friend?>?

          override fun marshaller(): ResponseFieldMarshaller

          /**
           * A character from the Star Wars universe
           */
          interface Friend {
            val __typename: String

            fun marshaller(): ResponseFieldMarshaller

            interface Character : Friend, HeroDetail {
              override val __typename: String

              /**
               * The name of the character
               */
              override val name: String

              /**
               * The friends of the character exposed as a connection with edges
               */
              override val friendsConnection: FriendsConnection

              override fun marshaller(): ResponseFieldMarshaller

              /**
               * A connection object for a character's friends
               */
              interface FriendsConnection : HeroDetail.FriendsConnection {
                /**
                 * The total number of friends
                 */
                override val totalCount: Int?

                /**
                 * The edges for each of the character's friends.
                 */
                override val edges: List<Edge?>?

                override fun marshaller(): ResponseFieldMarshaller

                /**
                 * An edge object for a character's friends
                 */
                interface Edge : HeroDetail.FriendsConnection.Edge {
                  /**
                   * The character represented by this friendship edge
                   */
                  override val node: Node?

                  override fun marshaller(): ResponseFieldMarshaller

                  /**
                   * A character from the Star Wars universe
                   */
                  interface Node : HeroDetail.FriendsConnection.Edge.Node {
                    /**
                     * The name of the character
                     */
                    override val name: String

                    override fun marshaller(): ResponseFieldMarshaller
                  }
                }
              }
            }

            companion object {
              fun Friend.heroDetails(): HeroDetail? = this as? HeroDetail

              fun Friend.asCharacter(): Character? = this as? Character
            }
          }
        }
      }

      /**
       * A humanoid creature from the Star Wars universe
       */
      data class HumanHeroDetailQuery(
        override val __typename: String = "Human",
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * The friends of the character, or an empty list if they have none
         */
        override val friends: List<Friend?>?,
        /**
         * Height in the preferred unit, default is meters
         */
        override val height: Double?
      ) : HeroDetailQuery, Human {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.HumanHeroDetailQuery.toResponse(writer, this)
          }
        }

        /**
         * A character from the Star Wars universe
         */
        data class Friend(
          /**
           * The name of the character
           */
          override val name: String,
          /**
           * The movies this character appears in
           */
          override val appearsIn: List<Episode?>,
          /**
           * The friends of the character, or an empty list if they have none
           */
          override val friends: List<Friend?>?
        ) : HeroDetailQuery.Friend, Human.Friend {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.toResponse(writer, this)
            }
          }

          /**
           * A character from the Star Wars universe
           */
          interface Friend : Human.Friend.Friend {
            override val __typename: String

            override fun marshaller(): ResponseFieldMarshaller

            interface Character : Human.Friend.Friend, Human.Friend.Friend.Character, HeroDetail,
                Friend {
              override val __typename: String

              /**
               * The name of the character
               */
              override val name: String

              /**
               * The friends of the character exposed as a connection with edges
               */
              override val friendsConnection: FriendsConnection

              override fun marshaller(): ResponseFieldMarshaller

              /**
               * A connection object for a character's friends
               */
              interface FriendsConnection : Human.Friend.Friend.Character.FriendsConnection,
                  HeroDetail.FriendsConnection {
                /**
                 * The total number of friends
                 */
                override val totalCount: Int?

                /**
                 * The edges for each of the character's friends.
                 */
                override val edges: List<Edge?>?

                override fun marshaller(): ResponseFieldMarshaller

                /**
                 * An edge object for a character's friends
                 */
                interface Edge : Human.Friend.Friend.Character.FriendsConnection.Edge,
                    HeroDetail.FriendsConnection.Edge {
                  /**
                   * The character represented by this friendship edge
                   */
                  override val node: Node?

                  override fun marshaller(): ResponseFieldMarshaller

                  /**
                   * A character from the Star Wars universe
                   */
                  interface Node : Human.Friend.Friend.Character.FriendsConnection.Edge.Node,
                      HeroDetail.FriendsConnection.Edge.Node {
                    /**
                     * The name of the character
                     */
                    override val name: String

                    override fun marshaller(): ResponseFieldMarshaller
                  }
                }
              }
            }

            data class CharacterFriend(
              override val __typename: String,
              /**
               * The name of the character
               */
              override val name: String,
              /**
               * The friends of the character exposed as a connection with edges
               */
              override val friendsConnection: FriendsConnection
            ) : Human.Friend.Friend, Human.Friend.Friend.Character, HeroDetail, Friend {
              override fun marshaller(): ResponseFieldMarshaller {
                return ResponseFieldMarshaller { writer ->
                  HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.toResponse(writer, this)
                }
              }

              /**
               * A connection object for a character's friends
               */
              data class FriendsConnection(
                /**
                 * The total number of friends
                 */
                override val totalCount: Int?,
                /**
                 * The edges for each of the character's friends.
                 */
                override val edges: List<Edge?>?
              ) : Human.Friend.Friend.Character.FriendsConnection, HeroDetail.FriendsConnection {
                override fun marshaller(): ResponseFieldMarshaller {
                  return ResponseFieldMarshaller { writer ->
                    HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.toResponse(writer, this)
                  }
                }

                /**
                 * An edge object for a character's friends
                 */
                data class Edge(
                  /**
                   * The character represented by this friendship edge
                   */
                  override val node: Node?
                ) : Human.Friend.Friend.Character.FriendsConnection.Edge,
                    HeroDetail.FriendsConnection.Edge {
                  override fun marshaller(): ResponseFieldMarshaller {
                    return ResponseFieldMarshaller { writer ->
                      HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.toResponse(writer, this)
                    }
                  }

                  /**
                   * A character from the Star Wars universe
                   */
                  data class Node(
                    /**
                     * The name of the character
                     */
                    override val name: String
                  ) : Human.Friend.Friend.Character.FriendsConnection.Edge.Node,
                      HeroDetail.FriendsConnection.Edge.Node {
                    override fun marshaller(): ResponseFieldMarshaller {
                      return ResponseFieldMarshaller { writer ->
                        HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.Node.toResponse(writer, this)
                      }
                    }
                  }
                }
              }
            }

            /**
             * A character from the Star Wars universe
             */
            data class OtherFriend(
              override val __typename: String = "Character"
            ) : Human.Friend.Friend, Friend {
              override fun marshaller(): ResponseFieldMarshaller {
                return ResponseFieldMarshaller { writer ->
                  HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.OtherFriend.toResponse(writer, this)
                }
              }
            }

            companion object {
              fun Friend.heroDetails(): HeroDetail? = this as? HeroDetail

              fun Friend.asCharacter(): Character? = this as? Character
            }
          }
        }
      }

      /**
       * A character from the Star Wars universe
       */
      data class OtherHeroDetailQuery(
        override val __typename: String = "Character",
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * The friends of the character, or an empty list if they have none
         */
        override val friends: List<Friend?>?
      ) : HeroDetailQuery {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.OtherHeroDetailQuery.toResponse(writer, this)
          }
        }

        /**
         * A character from the Star Wars universe
         */
        data class Friend(
          /**
           * The name of the character
           */
          override val name: String
        ) : HeroDetailQuery.Friend {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              HeroDetailQuery_ResponseAdapter.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend.toResponse(writer, this)
            }
          }
        }
      }

      companion object {
        fun HeroDetailQuery.asHuman(): Human? = this as? Human
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "69ef2ada86ec094537d524f05f680155b2331dabf1b8420f7f63a84202ed34f7"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query HeroDetailQuery {
          |  heroDetailQuery {
          |    __typename
          |    name
          |    friends {
          |      name
          |    }
          |    ... on Human {
          |      height
          |      friends {
          |        appearsIn
          |        friends {
          |          __typename
          |          ...HeroDetails
          |        }
          |      }
          |    }
          |  }
          |}
          |fragment HeroDetails on Character {
          |  __typename
          |  name
          |  friendsConnection {
          |    totalCount
          |    edges {
          |      node {
          |        name
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "HeroDetailQuery"
      }
    }
  }
}
