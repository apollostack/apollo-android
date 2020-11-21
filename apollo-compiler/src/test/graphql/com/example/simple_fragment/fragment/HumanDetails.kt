// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.String
import kotlin.Suppress

/**
 * Fragment with Java / Kotlin docs generation
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
internal interface HumanDetails : GraphqlFragment {
  val __typename: String

  /**
   * What this human calls themselves
   */
  val name: String

  /**
   * A humanoid creature from the Star Wars universe
   */
  data class HumanDetailsImpl(
    override val __typename: String = "Human",
    /**
     * What this human calls themselves
     */
    override val name: String
  ) : HumanDetails {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HumanDetails_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment HumanDetails on Human {
        |  __typename
        |  name
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): HumanDetails {
      return HumanDetails_ResponseAdapter.fromResponse(reader)
    }

    fun Mapper(): ResponseFieldMapper<HumanDetails> {
      return ResponseFieldMapper { reader ->
        HumanDetails_ResponseAdapter.fromResponse(reader)
      }
    }
  }
}
