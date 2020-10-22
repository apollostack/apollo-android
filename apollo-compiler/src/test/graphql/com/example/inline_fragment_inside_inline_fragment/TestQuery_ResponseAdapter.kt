// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragment_inside_inline_fragment

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forList("search", "search", mapOf<String, Any>(
      "text" to "bla-bla"), true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var search: List<TestQuery.Search?>? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> search = readList<TestQuery.Search>(RESPONSE_FIELDS[0]) { reader ->
            reader.readObject<TestQuery.Search> { reader ->
              TestQuery_ResponseAdapter.Search_ResponseAdapter.fromResponse(reader)
            }
          }
          else -> break
        }
      }
      TestQuery.Data(
        search = search
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    writer.writeList(RESPONSE_FIELDS[0], value.search) { value, listItemWriter ->
      value?.forEach { value ->
        if(value == null) {
          listItemWriter.writeObject(null)
        } else {
          listItemWriter.writeObject {
            TestQuery_ResponseAdapter.Search_ResponseAdapter.toResponse(writer, value)
          }
        }
      }
    }
  }

  object CharacterDroidImpl_ResponseAdapter : ResponseAdapter<TestQuery.CharacterDroidImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        TestQuery.CharacterDroidImpl {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var primaryFunction: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> primaryFunction = readString(RESPONSE_FIELDS[2])
            else -> break
          }
        }
        TestQuery.CharacterDroidImpl(
          __typename = __typename!!,
          name = name!!,
          primaryFunction = primaryFunction
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.CharacterDroidImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
    }
  }

  object CharacterHumanImpl_ResponseAdapter : ResponseAdapter<TestQuery.CharacterHumanImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forString("homePlanet", "homePlanet", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        TestQuery.CharacterHumanImpl {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var homePlanet: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> homePlanet = readString(RESPONSE_FIELDS[2])
            else -> break
          }
        }
        TestQuery.CharacterHumanImpl(
          __typename = __typename!!,
          name = name!!,
          homePlanet = homePlanet
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.CharacterHumanImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeString(RESPONSE_FIELDS[2], value.homePlanet)
    }
  }

  object OtherSearch_ResponseAdapter : ResponseAdapter<TestQuery.OtherSearch> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.OtherSearch {
      return reader.run {
        var __typename: String? = __typename
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            else -> break
          }
        }
        TestQuery.OtherSearch(
          __typename = __typename!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.OtherSearch) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    }
  }

  object Search_ResponseAdapter : ResponseAdapter<TestQuery.Search> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Search {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "Droid" -> TestQuery_ResponseAdapter.CharacterDroidImpl_ResponseAdapter.fromResponse(reader, typename)
        "Human" -> TestQuery_ResponseAdapter.CharacterHumanImpl_ResponseAdapter.fromResponse(reader, typename)
        else -> TestQuery_ResponseAdapter.OtherSearch_ResponseAdapter.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Search) {
      when(value) {
        is TestQuery.CharacterDroidImpl -> TestQuery_ResponseAdapter.CharacterDroidImpl_ResponseAdapter.toResponse(writer, value)
        is TestQuery.CharacterHumanImpl -> TestQuery_ResponseAdapter.CharacterHumanImpl_ResponseAdapter.toResponse(writer, value)
        is TestQuery.OtherSearch -> TestQuery_ResponseAdapter.OtherSearch_ResponseAdapter.toResponse(writer, value)
      }
    }
  }
}
