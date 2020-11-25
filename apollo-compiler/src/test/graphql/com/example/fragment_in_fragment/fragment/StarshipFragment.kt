// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_in_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
interface StarshipFragment : GraphqlFragment {
  val __typename: String

  /**
   * The ID of an object
   */
  val id: String

  /**
   * The name of this starship. The common name, such as "Death Star".
   */
  val name: String?

  val pilotConnection: PilotConnection?

  /**
   * A connection to a list of items.
   */
  interface PilotConnection {
    val __typename: String

    /**
     * A list of edges.
     */
    val edges: List<Edge?>?

    fun marshaller(): ResponseFieldMarshaller

    /**
     * An edge in a connection.
     */
    interface Edge {
      val __typename: String

      /**
       * The item at the end of the edge
       */
      val node: Node?

      fun marshaller(): ResponseFieldMarshaller

      /**
       * An individual person or character within the Star Wars universe.
       */
      interface Node {
        val __typename: String

        fun marshaller(): ResponseFieldMarshaller

        interface Person : Node, PilotFragment {
          override val __typename: String

          /**
           * The name of this person.
           */
          override val name: String?

          /**
           * A planet that this person was born on or inhabits.
           */
          override val homeworld: Homeworld?

          override fun marshaller(): ResponseFieldMarshaller

          /**
           * A large mass, planet or planetoid in the Star Wars Universe, at the time of
           * 0 ABY.
           */
          interface Homeworld : PilotFragment.Homeworld {
            override val __typename: String

            override fun marshaller(): ResponseFieldMarshaller

            interface Planet : Homeworld, PlanetFragment, PilotFragment.Homeworld.Planet {
              override val __typename: String

              /**
               * The name of this planet.
               */
              override val name: String?

              override fun marshaller(): ResponseFieldMarshaller
            }
          }
        }
      }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment starshipFragment on Starship {
        |  __typename
        |  id
        |  name
        |  pilotConnection {
        |    __typename
        |    edges {
        |      __typename
        |      node {
        |        __typename
        |        ...pilotFragment
        |      }
        |    }
        |  }
        |}
        """.trimMargin()
  }
}
