// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.input_object_type.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.input_object_type.TestQuery
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("createReview", "createReview", mapOf<String, Any?>(
      "episode" to mapOf<String, Any?>(
        "kind" to "Variable",
        "variableName" to "ep"),
      "review" to mapOf<String, Any?>(
        "kind" to "Variable",
        "variableName" to "review")), true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return Data.fromResponse(reader, __typename)
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    Data.toResponse(writer, value)
  }

  object Data : ResponseAdapter<TestQuery.Data> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forObject("createReview", "createReview", mapOf<String, Any?>(
        "episode" to mapOf<String, Any?>(
          "kind" to "Variable",
          "variableName" to "ep"),
        "review" to mapOf<String, Any?>(
          "kind" to "Variable",
          "variableName" to "review")), true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
      return reader.run {
        var createReview: TestQuery.Data.CreateReview? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> createReview = readObject<TestQuery.Data.CreateReview>(RESPONSE_FIELDS[0]) { reader ->
              CreateReview.fromResponse(reader)
            }
            else -> break
          }
        }
        TestQuery.Data(
          createReview = createReview
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
      if(value.createReview == null) {
        writer.writeObject(RESPONSE_FIELDS[0], null)
      } else {
        writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
          CreateReview.toResponse(writer, value.createReview)
        }
      }
    }

    object CreateReview : ResponseAdapter<TestQuery.Data.CreateReview> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forInt("stars", "stars", null, false, null),
        ResponseField.forString("commentary", "commentary", null, true, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.CreateReview {
        return reader.run {
          var stars: Int? = null
          var commentary: String? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> stars = readInt(RESPONSE_FIELDS[0])
              1 -> commentary = readString(RESPONSE_FIELDS[1])
              else -> break
            }
          }
          TestQuery.Data.CreateReview(
            stars = stars!!,
            commentary = commentary
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.CreateReview) {
        writer.writeInt(RESPONSE_FIELDS[0], value.stars)
        writer.writeString(RESPONSE_FIELDS[1], value.commentary)
      }
    }
  }
}
