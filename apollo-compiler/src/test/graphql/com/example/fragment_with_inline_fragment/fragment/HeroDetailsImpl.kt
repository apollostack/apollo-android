// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_with_inline_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.example.fragment_with_inline_fragment.fragment.adapter.HeroDetailsImpl_ResponseAdapter
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * A character from the Star Wars universe
 */
interface HeroDetailsImpl : HeroDetail, GraphqlFragment {
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

  /**
   * An autonomous mechanical character in the Star Wars universe
   */
  interface Droid : HeroDetail, HeroDetail.Droid, DroidDetail, HeroDetailsImpl {
    override val __typename: String

    /**
     * The name of the character
     */
    override val name: String

    /**
     * The friends of the character exposed as a connection with edges
     */
    override val friendsConnection: FriendsConnection

    /**
     * This droid's primary function
     */
    override val primaryFunction: String?

    override fun marshaller(): ResponseFieldMarshaller

    /**
     * A connection object for a character's friends
     */
    interface FriendsConnection : HeroDetail.FriendsConnection, HeroDetail.Droid.FriendsConnection,
        HeroDetailsImpl.FriendsConnection {
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
      interface Edge : HeroDetail.FriendsConnection.Edge, HeroDetail.Droid.FriendsConnection.Edge,
          HeroDetailsImpl.FriendsConnection.Edge {
        /**
         * The character represented by this friendship edge
         */
        override val node: Node?

        override fun marshaller(): ResponseFieldMarshaller

        /**
         * A character from the Star Wars universe
         */
        interface Node : HeroDetail.FriendsConnection.Edge.Node,
            HeroDetail.Droid.FriendsConnection.Edge.Node,
            HeroDetailsImpl.FriendsConnection.Edge.Node {
          /**
           * The name of the character
           */
          override val name: String

          override fun marshaller(): ResponseFieldMarshaller
        }
      }
    }
  }

  interface Human : HeroDetail, HeroDetail.Human, HumanDetail, HeroDetailsImpl {
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
    interface FriendsConnection : HeroDetail.FriendsConnection, HeroDetail.Human.FriendsConnection,
        HeroDetailsImpl.FriendsConnection {
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
      interface Edge : HeroDetail.FriendsConnection.Edge, HeroDetail.Human.FriendsConnection.Edge,
          HeroDetailsImpl.FriendsConnection.Edge {
        /**
         * The character represented by this friendship edge
         */
        override val node: Node?

        override fun marshaller(): ResponseFieldMarshaller

        /**
         * A character from the Star Wars universe
         */
        interface Node : HeroDetail.FriendsConnection.Edge.Node,
            HeroDetail.Human.FriendsConnection.Edge.Node,
            HeroDetailsImpl.FriendsConnection.Edge.Node {
          /**
           * The name of the character
           */
          override val name: String

          override fun marshaller(): ResponseFieldMarshaller
        }
      }
    }
  }

  data class DroidHeroDetail(
    override val __typename: String = "Droid",
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The friends of the character exposed as a connection with edges
     */
    override val friendsConnection: FriendsConnection,
    /**
     * This droid's primary function
     */
    override val primaryFunction: String?
  ) : HeroDetail, HeroDetail.Droid, DroidDetail, HeroDetailsImpl, Droid {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetailsImpl_ResponseAdapter.DroidHeroDetail.toResponse(writer, this)
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
    ) : HeroDetail.FriendsConnection, HeroDetail.Droid.FriendsConnection,
        HeroDetailsImpl.FriendsConnection, Droid.FriendsConnection {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          HeroDetailsImpl_ResponseAdapter.DroidHeroDetail.FriendsConnection.toResponse(writer, this)
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
      ) : HeroDetail.FriendsConnection.Edge, HeroDetail.Droid.FriendsConnection.Edge,
          HeroDetailsImpl.FriendsConnection.Edge, Droid.FriendsConnection.Edge {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            HeroDetailsImpl_ResponseAdapter.DroidHeroDetail.FriendsConnection.Edge.toResponse(writer, this)
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
        ) : HeroDetail.FriendsConnection.Edge.Node, HeroDetail.Droid.FriendsConnection.Edge.Node,
            HeroDetailsImpl.FriendsConnection.Edge.Node, Droid.FriendsConnection.Edge.Node {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              HeroDetailsImpl_ResponseAdapter.DroidHeroDetail.FriendsConnection.Edge.Node.toResponse(writer, this)
            }
          }
        }
      }
    }
  }

  data class HumanHeroDetail(
    override val __typename: String = "Human",
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The friends of the character exposed as a connection with edges
     */
    override val friendsConnection: FriendsConnection
  ) : HeroDetail, HeroDetail.Human, HumanDetail, HeroDetailsImpl, Human {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetailsImpl_ResponseAdapter.HumanHeroDetail.toResponse(writer, this)
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
    ) : HeroDetail.FriendsConnection, HeroDetail.Human.FriendsConnection,
        HeroDetailsImpl.FriendsConnection, Human.FriendsConnection {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          HeroDetailsImpl_ResponseAdapter.HumanHeroDetail.FriendsConnection.toResponse(writer, this)
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
      ) : HeroDetail.FriendsConnection.Edge, HeroDetail.Human.FriendsConnection.Edge,
          HeroDetailsImpl.FriendsConnection.Edge, Human.FriendsConnection.Edge {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            HeroDetailsImpl_ResponseAdapter.HumanHeroDetail.FriendsConnection.Edge.toResponse(writer, this)
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
        ) : HeroDetail.FriendsConnection.Edge.Node, HeroDetail.Human.FriendsConnection.Edge.Node,
            HeroDetailsImpl.FriendsConnection.Edge.Node, Human.FriendsConnection.Edge.Node {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              HeroDetailsImpl_ResponseAdapter.HumanHeroDetail.FriendsConnection.Edge.Node.toResponse(writer, this)
            }
          }
        }
      }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class OtherHeroDetailsImpl(
    override val __typename: String = "Character",
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The friends of the character exposed as a connection with edges
     */
    override val friendsConnection: FriendsConnection
  ) : HeroDetail, HeroDetailsImpl {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetailsImpl_ResponseAdapter.OtherHeroDetailsImpl.toResponse(writer, this)
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
    ) : HeroDetail.FriendsConnection, HeroDetailsImpl.FriendsConnection {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          HeroDetailsImpl_ResponseAdapter.OtherHeroDetailsImpl.FriendsConnection.toResponse(writer, this)
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
      ) : HeroDetail.FriendsConnection.Edge, HeroDetailsImpl.FriendsConnection.Edge {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            HeroDetailsImpl_ResponseAdapter.OtherHeroDetailsImpl.FriendsConnection.Edge.toResponse(writer, this)
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
        ) : HeroDetail.FriendsConnection.Edge.Node, HeroDetailsImpl.FriendsConnection.Edge.Node {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              HeroDetailsImpl_ResponseAdapter.OtherHeroDetailsImpl.FriendsConnection.Edge.Node.toResponse(writer, this)
            }
          }
        }
      }
    }
  }
}
