// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_inside_inline_fragment

import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.ResponseAdapterCache
import com.apollographql.apollo3.api.ResponseField
import com.apollographql.apollo3.api.internal.QueryDocumentMinifier
import com.apollographql.apollo3.api.internal.ResponseAdapter
import com.example.named_fragment_inside_inline_fragment.adapter.GetHero_ResponseAdapter
import com.example.named_fragment_inside_inline_fragment.fragment.CharacterAppearsIn
import com.example.named_fragment_inside_inline_fragment.fragment.CharacterName
import com.example.named_fragment_inside_inline_fragment.type.Episode
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class GetHero : Query<GetHero.Data> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): String = OPERATION_NAME

  override fun adapter(customScalarAdapters: ResponseAdapterCache): ResponseAdapter<Data> {
    val adapter = customScalarAdapters.getOperationAdapter(name()) {
      GetHero_ResponseAdapter(customScalarAdapters)
    }
    return adapter
  }

  override fun responseFields(): List<ResponseField.FieldSet> = listOf(
    ResponseField.FieldSet(null, GetHero_ResponseAdapter.RESPONSE_FIELDS)
  )
  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    /**
     * A character from the Star Wars universe
     */
    interface Hero {
      val __typename: String

      data class CharacterHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * The movies this character appears in
         */
        override val appearsIn: List<Episode?>
      ) : Hero, CharacterName, CharacterAppearsIn

      data class OtherHero(
        override val __typename: String
      ) : Hero

      companion object {
        fun Hero.asCharacterHero(): CharacterHero? = this as? CharacterHero

        fun Hero.asCharacterName(): CharacterName? = this as? CharacterName

        fun Hero.asCharacterAppearsIn(): CharacterAppearsIn? = this as? CharacterAppearsIn
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "ed0f62fe5233d198a632f9231c1f34c7070b38b83d02e41deeb4bcfa632c8676"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query GetHero {
          |  hero {
          |    __typename
          |    ... on Character {
          |      __typename
          |      ...characterName
          |      ...characterAppearsIn
          |    }
          |  }
          |}
          |fragment characterName on Character {
          |  __typename
          |  name
          |}
          |fragment characterAppearsIn on Character {
          |  __typename
          |  appearsIn
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "GetHero"
  }
}
