// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_fragment_with_nested_fragments.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.example.root_query_fragment_with_nested_fragments.fragment.adapter.QueryFragmentImpl_ResponseAdapter
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
interface QueryFragment : GraphqlFragment {
  val __typename: String

  val hero: Hero?

  val droid: Droid?

  val human: Human?

  /**
   * A character from the Star Wars universe
   */
  interface Hero {
    val __typename: String

    fun marshaller(): ResponseFieldMarshaller

    interface Character : Hero, HeroFragment {
      override val __typename: String

      /**
       * The name of the character
       */
      override val name: String

      override fun marshaller(): ResponseFieldMarshaller
    }

    companion object {
      fun Hero.heroFragment(): HeroFragment? = this as? HeroFragment

      fun Hero.asCharacter(): Character? = this as? Character
    }
  }

  /**
   * An autonomous mechanical character in the Star Wars universe
   */
  interface Droid {
    val __typename: String

    fun marshaller(): ResponseFieldMarshaller

    interface Droid : QueryFragment.Droid, DroidFragment {
      override val __typename: String

      /**
       * What others call this droid
       */
      override val name: String

      /**
       * This droid's primary function
       */
      override val primaryFunction: String?

      override fun marshaller(): ResponseFieldMarshaller
    }

    companion object {
      fun QueryFragment.Droid.droidFragment(): DroidFragment? = this as? DroidFragment

      fun QueryFragment.Droid.asDroid(): Droid? = this as? Droid
    }
  }

  /**
   * A humanoid creature from the Star Wars universe
   */
  interface Human {
    val __typename: String

    fun marshaller(): ResponseFieldMarshaller

    /**
     * A humanoid creature from the Star Wars universe
     */
    interface Human : QueryFragment.Human {
      override val __typename: String

      /**
       * What this human calls themselves
       */
      val name: String

      /**
       * The home planet of the human, or null if unknown
       */
      val homePlanet: String?

      override fun marshaller(): ResponseFieldMarshaller
    }

    companion object {
      fun QueryFragment.Human.asHuman(): Human? = this as? Human
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment QueryFragment on Query {
        |  __typename
        |  hero {
        |    __typename
        |    ...heroFragment
        |  }
        |  droid(id: 1) {
        |    __typename
        |    ...droidFragment
        |  }
        |  human(id: 1) {
        |    __typename
        |    ... on Human {
        |      name
        |      homePlanet
        |    }
        |  }
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): QueryFragment {
      return QueryFragmentImpl_ResponseAdapter.fromResponse(reader)
    }

    fun Mapper(): ResponseFieldMapper<QueryFragment> {
      return ResponseFieldMapper { reader ->
        QueryFragmentImpl_ResponseAdapter.fromResponse(reader)
      }
    }
  }
}
