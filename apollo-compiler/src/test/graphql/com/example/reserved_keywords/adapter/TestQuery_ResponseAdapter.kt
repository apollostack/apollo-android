// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.reserved_keywords.adapter

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ListResponseAdapter
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.reserved_keywords.TestQuery
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
  val nullablecharacterAdapterAdapter: ResponseAdapter<TestQuery.Data.Yield?> =
      NullableResponseAdapter(Yield(customScalarAdapters))

  val nullablelistOfnullablesearchResultAdapterAdapterAdapterAdapter:
      ResponseAdapter<List<TestQuery.Data.Object?>?> =
      NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Object(customScalarAdapters))))

  override fun fromResponse(reader: JsonReader): TestQuery.Data {
    var yield_: TestQuery.Data.Yield? = null
    var objects: List<TestQuery.Data.Object?>? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> yield_ = nullablecharacterAdapterAdapter.fromResponse(reader)
        1 -> objects = nullablelistOfnullablesearchResultAdapterAdapterAdapterAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return TestQuery.Data(
      yield_ = yield_,
      objects = objects
    )
  }

  override fun toResponse(writer: JsonWriter, value: TestQuery.Data) {
    writer.beginObject()
    writer.name("yield")
    nullablecharacterAdapterAdapter.toResponse(writer, value.yield_)
    writer.name("objects")
    nullablelistOfnullablesearchResultAdapterAdapterAdapterAdapter.toResponse(writer, value.objects)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.Named.Object("Character"),
        fieldName = "hero",
        responseName = "yield",
        fieldSets = listOf(
          ResponseField.FieldSet(null, Yield.RESPONSE_FIELDS)
        ),
      ),
      ResponseField(
        type = ResponseField.Type.List(ResponseField.Type.Named.Object("SearchResult")),
        fieldName = "search",
        responseName = "objects",
        arguments = mapOf<String, Any?>(
          "text" to "abc"),
        fieldSets = listOf(
          ResponseField.FieldSet("Human", Object.CharacterObject.RESPONSE_FIELDS),
          ResponseField.FieldSet("Droid", Object.CharacterObject.RESPONSE_FIELDS),
          ResponseField.FieldSet(null, Object.OtherObject.RESPONSE_FIELDS),
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class Yield(
    customScalarAdapters: CustomScalarAdapters
  ) : ResponseAdapter<TestQuery.Data.Yield> {
    val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

    override fun fromResponse(reader: JsonReader): TestQuery.Data.Yield {
      var it_: String? = null
      var name: String? = null
      reader.beginObject()
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> it_ = stringAdapter.fromResponse(reader)
          1 -> name = stringAdapter.fromResponse(reader)
          else -> break
        }
      }
      reader.endObject()
      return TestQuery.Data.Yield(
        it_ = it_!!,
        name = name!!
      )
    }

    override fun toResponse(writer: JsonWriter, value: TestQuery.Data.Yield) {
      writer.beginObject()
      writer.name("it")
      stringAdapter.toResponse(writer, value.it_)
      writer.name("name")
      stringAdapter.toResponse(writer, value.name)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "id",
          responseName = "it",
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "name",
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }
  }

  class Object(
    customScalarAdapters: CustomScalarAdapters
  ) : ResponseAdapter<TestQuery.Data.Object> {
    val CharacterObjectAdapter: CharacterObject =
        com.example.reserved_keywords.adapter.TestQuery_ResponseAdapter.Object.CharacterObject(customScalarAdapters)

    val OtherObjectAdapter: OtherObject =
        com.example.reserved_keywords.adapter.TestQuery_ResponseAdapter.Object.OtherObject(customScalarAdapters)

    override fun fromResponse(reader: JsonReader): TestQuery.Data.Object {
      reader.beginObject()
      check(reader.nextName() == "__typename")
      val typename = reader.nextString()

      return when(typename) {
        "Human" -> CharacterObjectAdapter.fromResponse(reader, typename)
        "Droid" -> CharacterObjectAdapter.fromResponse(reader, typename)
        else -> OtherObjectAdapter.fromResponse(reader, typename)
      }
      .also { reader.endObject() }
    }

    override fun toResponse(writer: JsonWriter, value: TestQuery.Data.Object) {
      when(value) {
        is TestQuery.Data.Object.CharacterObject -> CharacterObjectAdapter.toResponse(writer, value)
        is TestQuery.Data.Object.OtherObject -> OtherObjectAdapter.toResponse(writer, value)
      }
    }

    class CharacterObject(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      fun fromResponse(reader: JsonReader, __typename: String?):
          TestQuery.Data.Object.CharacterObject {
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.Object.CharacterObject(
          __typename = __typename!!,
          name = name!!
        )
      }

      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Object.CharacterObject) {
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

    class OtherObject(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      fun fromResponse(reader: JsonReader, __typename: String?): TestQuery.Data.Object.OtherObject {
        var __typename: String? = __typename
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.Object.OtherObject(
          __typename = __typename!!
        )
      }

      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Object.OtherObject) {
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
}
