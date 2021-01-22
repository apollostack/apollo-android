// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_hardcoded.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.arguments_hardcoded.TestQuery
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.List(ResponseField.Type.Named.Object("Review")),
      responseName = "reviews",
      fieldName = "reviews",
      arguments = mapOf<String, Any?>(
        "episode" to "JEDI",
        "starsInt" to 10,
        "starsFloat" to 9.9),
      conditions = emptyList(),
      possibleFieldSets = mapOf(
        "" to Review.RESPONSE_FIELDS
      ),
    ),
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("Int")),
      responseName = "testNullableArguments",
      fieldName = "testNullableArguments",
      arguments = mapOf<String, Any?>(
        "int" to null,
        "string" to null,
        "float" to null,
        "review" to null,
        "episode" to null,
        "boolean" to null,
        "list" to null),
      conditions = emptyList(),
      possibleFieldSets = emptyMap(),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var reviews: List<TestQuery.Data.Review?>? = null
      var testNullableArguments: Int? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> reviews = readList<TestQuery.Data.Review>(RESPONSE_FIELDS[0]) { reader ->
            reader.readObject<TestQuery.Data.Review> { reader ->
              Review.fromResponse(reader)
            }
          }
          1 -> testNullableArguments = readInt(RESPONSE_FIELDS[1])
          else -> break
        }
      }
      TestQuery.Data(
        reviews = reviews,
        testNullableArguments = testNullableArguments!!
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    writer.writeList(RESPONSE_FIELDS[0], value.reviews) { value, listItemWriter ->
      listItemWriter.writeObject { writer ->
        Review.toResponse(writer, value)
      }
    }
    writer.writeInt(RESPONSE_FIELDS[1], value.testNullableArguments)
  }

  object Review : ResponseAdapter<TestQuery.Data.Review> {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("Int")),
        responseName = "stars",
        fieldName = "stars",
        arguments = emptyMap(),
        conditions = emptyList(),
        possibleFieldSets = emptyMap(),
      ),
      ResponseField(
        type = ResponseField.Type.Named.Other("String"),
        responseName = "commentary",
        fieldName = "commentary",
        arguments = emptyMap(),
        conditions = emptyList(),
        possibleFieldSets = emptyMap(),
      )
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Review {
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
        TestQuery.Data.Review(
          stars = stars!!,
          commentary = commentary
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Review) {
      writer.writeInt(RESPONSE_FIELDS[0], value.stars)
      writer.writeString(RESPONSE_FIELDS[1], value.commentary)
    }
  }
}
