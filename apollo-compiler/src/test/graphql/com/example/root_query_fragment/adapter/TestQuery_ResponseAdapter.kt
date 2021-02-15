// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_fragment.adapter

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.root_query_fragment.TestQuery
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery_ResponseAdapter(
  customScalarAdapters: CustomScalarAdapters
) : ResponseAdapter<TestQuery.Data> {
  val QueryDataAdapter: QueryData =
      com.example.root_query_fragment.adapter.TestQuery_ResponseAdapter.QueryData(customScalarAdapters)

  val OtherDataAdapter: OtherData =
      com.example.root_query_fragment.adapter.TestQuery_ResponseAdapter.OtherData(customScalarAdapters)

  override fun fromResponse(reader: JsonReader): TestQuery.Data {
    reader.beginObject()
    check(reader.nextName() == "__typename")
    val typename = reader.nextString()

    return when(typename) {
      "Query" -> QueryDataAdapter.fromResponse(reader, typename)
      else -> OtherDataAdapter.fromResponse(reader, typename)
    }
    .also { reader.endObject() }
  }

  override fun toResponse(writer: JsonWriter, value: TestQuery.Data) {
    when(value) {
      is TestQuery.Data.QueryData -> QueryDataAdapter.toResponse(writer, value)
      is TestQuery.Data.OtherData -> OtherDataAdapter.toResponse(writer, value)
    }
  }

  class QueryData(
    customScalarAdapters: CustomScalarAdapters
  ) {
    val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

    val nullablecharacterAdapterAdapter: ResponseAdapter<TestQuery.Data.QueryData.Hero?> =
        NullableResponseAdapter(Hero(customScalarAdapters))

    fun fromResponse(reader: JsonReader, __typename: String?): TestQuery.Data.QueryData {
      var __typename: String? = __typename
      var hero: TestQuery.Data.QueryData.Hero? = null
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = stringAdapter.fromResponse(reader)
          1 -> hero = nullablecharacterAdapterAdapter.fromResponse(reader)
          else -> break
        }
      }
      return TestQuery.Data.QueryData(
        __typename = __typename!!,
        hero = hero
      )
    }

    fun toResponse(writer: JsonWriter, value: TestQuery.Data.QueryData) {
      writer.beginObject()
      writer.name("__typename")
      stringAdapter.toResponse(writer, value.__typename)
      writer.name("hero")
      nullablecharacterAdapterAdapter.toResponse(writer, value.hero)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.Typename,
        ResponseField(
          type = ResponseField.Type.Named.Object("Character"),
          fieldName = "hero",
          fieldSets = listOf(
            ResponseField.FieldSet(null, Hero.RESPONSE_FIELDS)
          ),
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }

    class Hero(
      customScalarAdapters: CustomScalarAdapters
    ) : ResponseAdapter<TestQuery.Data.QueryData.Hero> {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      override fun fromResponse(reader: JsonReader): TestQuery.Data.QueryData.Hero {
        var name: String? = null
        reader.beginObject()
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> name = stringAdapter.fromResponse(reader)
            else -> break
          }
        }
        reader.endObject()
        return TestQuery.Data.QueryData.Hero(
          name = name!!
        )
      }

      override fun toResponse(writer: JsonWriter, value: TestQuery.Data.QueryData.Hero) {
        writer.beginObject()
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.endObject()
      }

      companion object {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
            fieldName = "name",
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }
  }

  class OtherData(
    customScalarAdapters: CustomScalarAdapters
  ) {
    val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

    fun fromResponse(reader: JsonReader, __typename: String?): TestQuery.Data.OtherData {
      var __typename: String? = __typename
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = stringAdapter.fromResponse(reader)
          else -> break
        }
      }
      return TestQuery.Data.OtherData(
        __typename = __typename!!
      )
    }

    fun toResponse(writer: JsonWriter, value: TestQuery.Data.OtherData) {
      writer.beginObject()
      writer.name("__typename")
      stringAdapter.toResponse(writer, value.__typename)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.Typename
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }
  }
}
