// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.unique_type_name.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
interface HeroDetail : GraphqlFragment {
  val __typename: String

  /**
   * The name of the character
   */
  val name: String

  /**
   * The friends of the character exposed as a connection with edges
   */
  val friendsConnection: FriendsConnection

  /**
   * A connection object for a character's friends
   */
  interface FriendsConnection {
    val __typename: String

    /**
     * The total number of friends
     */
    val totalCount: Int?

    /**
     * The edges for each of the character's friends.
     */
    val edges: List<Edge?>?

    fun marshaller(): ResponseFieldMarshaller

    /**
     * An edge object for a character's friends
     */
    interface Edge {
      val __typename: String

      /**
       * The character represented by this friendship edge
       */
      val node: Node?

      fun marshaller(): ResponseFieldMarshaller

      /**
       * A character from the Star Wars universe
       */
      interface Node {
        val __typename: String

        /**
         * The name of the character
         */
        val name: String

        fun marshaller(): ResponseFieldMarshaller
      }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment HeroDetails on Character {
        |  __typename
        |  name
        |  friendsConnection {
        |    __typename
        |    totalCount
        |    edges {
        |      __typename
        |      node {
        |        __typename
        |        name
        |      }
        |    }
        |  }
        |}
        """.trimMargin()
  }
}
