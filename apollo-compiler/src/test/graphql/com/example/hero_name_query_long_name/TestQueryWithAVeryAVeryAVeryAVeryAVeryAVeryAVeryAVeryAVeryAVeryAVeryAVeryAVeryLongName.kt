// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.hero_name_query_long_name

import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.hero_name_query_long_name.adapter.TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName_ResponseAdapter
import com.example.hero_name_query_long_name.type.Episode
import kotlin.Any
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
data class TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName(
  val episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName:
      Input<Episode> = Input.absent()
) :
    Query<TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.Data>
    {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      if (this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.defined) {
        this["episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName"] = this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.value
      }
    }

    override fun marshaller(): InputFieldMarshaller {
      return InputFieldMarshaller.invoke { writer ->
        if (this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.defined) {
          writer.writeString("episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName",
              this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.value?.rawValue)
        }
      }
    }
  }

  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = variables

  override fun name(): String = OPERATION_NAME

  override fun adapter(): ResponseAdapter<Data> =
      TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName_ResponseAdapter
  override fun responseFields(): Array<ResponseField> =
      TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName_ResponseAdapter.RESPONSE_FIELDS
  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val heroAVeryAVeryAVeryAVeryAVeryAVeryAV: HeroAVeryAVeryAVeryAVeryAVeryAVeryAV?
  ) : Operation.Data {
    /**
     * A character from the Star Wars universe
     */
    data class HeroAVeryAVeryAVeryAVeryAVeryAVeryAV(
      /**
       * The name of the character
       */
      val nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName:
          String
    )
  }

  companion object {
    const val OPERATION_ID: String =
        "164dc148c38451cf968e075d4fd3114b0e03f4e5d8e126be67cf7156ef4cda9c"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName(${'$'}episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName: Episode) {
          |  heroAVeryAVeryAVeryAVeryAVeryAVeryAV: hero(episode: ${'$'}episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName) {
          |    nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName: name
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String =
        "TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName"
  }
}
