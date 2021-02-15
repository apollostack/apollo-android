// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragment_for_non_optional_field.adapter

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.doubleResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.inline_fragment_for_non_optional_field.TestQuery
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery_ResponseAdapter(
  customScalarAdapters: CustomScalarAdapters
) : ResponseAdapter<TestQuery.Data> {
  val characterAdapter: ResponseAdapter<TestQuery.Data.NonOptionalHero> =
      NonOptionalHero(customScalarAdapters)

  override fun fromResponse(reader: JsonReader): TestQuery.Data {
    var nonOptionalHero: TestQuery.Data.NonOptionalHero? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> nonOptionalHero = characterAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return TestQuery.Data(
      nonOptionalHero = nonOptionalHero!!
    )
  }

  override fun toResponse(writer: JsonWriter, value: TestQuery.Data) {
    writer.beginObject()
    writer.name("nonOptionalHero")
    characterAdapter.toResponse(writer, value.nonOptionalHero)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("Character")),
        fieldName = "nonOptionalHero",
        arguments = mapOf<String, Any?>(
          "episode" to "EMPIRE"),
        fieldSets = listOf(
          ResponseField.FieldSet("Human", NonOptionalHero.HumanNonOptionalHero.RESPONSE_FIELDS),
          ResponseField.FieldSet(null, NonOptionalHero.OtherNonOptionalHero.RESPONSE_FIELDS),
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class NonOptionalHero(
    customScalarAdapters: CustomScalarAdapters
  ) : ResponseAdapter<TestQuery.Data.NonOptionalHero> {
    val HumanNonOptionalHeroAdapter: HumanNonOptionalHero =
        com.example.inline_fragment_for_non_optional_field.adapter.TestQuery_ResponseAdapter.NonOptionalHero.HumanNonOptionalHero(customScalarAdapters)

    val OtherNonOptionalHeroAdapter: OtherNonOptionalHero =
        com.example.inline_fragment_for_non_optional_field.adapter.TestQuery_ResponseAdapter.NonOptionalHero.OtherNonOptionalHero(customScalarAdapters)

    override fun fromResponse(reader: JsonReader): TestQuery.Data.NonOptionalHero {
      reader.beginObject()
      check(reader.nextName() == "__typename")
      val typename = reader.nextString()

      return when(typename) {
        "Human" -> HumanNonOptionalHeroAdapter.fromResponse(reader, typename)
        else -> OtherNonOptionalHeroAdapter.fromResponse(reader, typename)
      }
      .also { reader.endObject() }
    }

    override fun toResponse(writer: JsonWriter, value: TestQuery.Data.NonOptionalHero) {
      when(value) {
        is TestQuery.Data.NonOptionalHero.HumanNonOptionalHero -> HumanNonOptionalHeroAdapter.toResponse(writer, value)
        is TestQuery.Data.NonOptionalHero.OtherNonOptionalHero -> OtherNonOptionalHeroAdapter.toResponse(writer, value)
      }
    }

    class HumanNonOptionalHero(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      val nullablefloatAdapterAdapter: ResponseAdapter<Double?> =
          NullableResponseAdapter(doubleResponseAdapter)

      fun fromResponse(reader: JsonReader, __typename: String?):
          TestQuery.Data.NonOptionalHero.HumanNonOptionalHero {
        var __typename: String? = __typename
        var name: String? = null
        var height: Double? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> height = nullablefloatAdapterAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.NonOptionalHero.HumanNonOptionalHero(
          __typename = __typename!!,
          name = name!!,
          height = height
        )
      }

      fun toResponse(writer: JsonWriter,
          value: TestQuery.Data.NonOptionalHero.HumanNonOptionalHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("height")
        nullablefloatAdapterAdapter.toResponse(writer, value.height)
        writer.endObject()
      }

      companion object {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.Typename,
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
            fieldName = "name",
          ),
          ResponseField(
            type = ResponseField.Type.Named.Other("Float"),
            fieldName = "height",
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }

    class OtherNonOptionalHero(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      fun fromResponse(reader: JsonReader, __typename: String?):
          TestQuery.Data.NonOptionalHero.OtherNonOptionalHero {
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.NonOptionalHero.OtherNonOptionalHero(
          __typename = __typename!!,
          name = name!!
        )
      }

      fun toResponse(writer: JsonWriter,
          value: TestQuery.Data.NonOptionalHero.OtherNonOptionalHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.endObject()
      }

      companion object {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.Typename,
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
            fieldName = "name",
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }
  }
}
