// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mutation_create_review_semantic_naming

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object CreateReviewForEpisodeMutation_ResponseAdapter :
    ResponseAdapter<CreateReviewForEpisodeMutation.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("createReview", "createReview", mapOf<String, Any>(
      "episode" to mapOf<String, Any>(
        "kind" to "Variable",
        "variableName" to "ep"),
      "review" to mapOf<String, Any>(
        "kind" to "Variable",
        "variableName" to "review")), true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?):
      CreateReviewForEpisodeMutation.Data {
    return reader.run {
      var createReview: CreateReviewForEpisodeMutation.CreateReview? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> createReview = readObject<CreateReviewForEpisodeMutation.CreateReview>(RESPONSE_FIELDS[0]) { reader ->
            CreateReviewForEpisodeMutation_ResponseAdapter.CreateReview_ResponseAdapter.fromResponse(reader)
          }
          else -> break
        }
      }
      CreateReviewForEpisodeMutation.Data(
        createReview = createReview
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: CreateReviewForEpisodeMutation.Data) {
    if(value.createReview == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) {
        CreateReviewForEpisodeMutation_ResponseAdapter.CreateReview_ResponseAdapter.toResponse(writer, value.createReview)
      }
    }
  }

  object CreateReview_ResponseAdapter : ResponseAdapter<CreateReviewForEpisodeMutation.CreateReview>
      {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forInt("stars", "stars", null, false, null),
      ResponseField.forString("commentary", "commentary", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        CreateReviewForEpisodeMutation.CreateReview {
      return reader.run {
        var __typename: String? = __typename
        var stars: Int? = null
        var commentary: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> stars = readInt(RESPONSE_FIELDS[1])
            2 -> commentary = readString(RESPONSE_FIELDS[2])
            else -> break
          }
        }
        CreateReviewForEpisodeMutation.CreateReview(
          __typename = __typename!!,
          stars = stars!!,
          commentary = commentary
        )
      }
    }

    override fun toResponse(writer: ResponseWriter,
        value: CreateReviewForEpisodeMutation.CreateReview) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], value.stars)
      writer.writeString(RESPONSE_FIELDS[2], value.commentary)
    }
  }
}
