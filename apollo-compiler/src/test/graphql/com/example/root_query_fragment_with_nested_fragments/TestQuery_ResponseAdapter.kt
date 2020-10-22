// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_fragment_with_nested_fragments

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forObject("hero", "hero", null, true, null),
    ResponseField.forObject("droid", "droid", mapOf<String, Any>(
      "id" to "1"), true, null),
    ResponseField.forObject("human", "human", mapOf<String, Any>(
      "id" to "1"), true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var __typename: String? = __typename
      var hero: TestQuery.Hero? = null
      var droid: TestQuery.Droid? = null
      var human: TestQuery.Human? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> hero = readObject<TestQuery.Hero>(RESPONSE_FIELDS[1]) { reader ->
            TestQuery_ResponseAdapter.Hero_ResponseAdapter.fromResponse(reader)
          }
          2 -> droid = readObject<TestQuery.Droid>(RESPONSE_FIELDS[2]) { reader ->
            TestQuery_ResponseAdapter.Droid_ResponseAdapter.fromResponse(reader)
          }
          3 -> human = readObject<TestQuery.Human>(RESPONSE_FIELDS[3]) { reader ->
            TestQuery_ResponseAdapter.Human_ResponseAdapter.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        __typename = __typename!!,
        hero = hero,
        droid = droid,
        human = human
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[1], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[1]) {
        TestQuery_ResponseAdapter.Hero_ResponseAdapter.toResponse(writer, value.hero)
      }
    }
    if(value.droid == null) {
      writer.writeObject(RESPONSE_FIELDS[2], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[2]) {
        TestQuery_ResponseAdapter.Droid_ResponseAdapter.toResponse(writer, value.droid)
      }
    }
    if(value.human == null) {
      writer.writeObject(RESPONSE_FIELDS[3], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[3]) {
        TestQuery_ResponseAdapter.Human_ResponseAdapter.toResponse(writer, value.human)
      }
    }
  }

  object Hero_ResponseAdapter : ResponseAdapter<TestQuery.Hero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Hero {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            else -> break
          }
        }
        TestQuery.Hero(
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Hero) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
    }
  }

  object Droid_ResponseAdapter : ResponseAdapter<TestQuery.Droid> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Droid {
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
        TestQuery.Droid(
          __typename = __typename!!,
          name = name!!,
          primaryFunction = primaryFunction
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Droid) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
    }
  }

  object Human_ResponseAdapter : ResponseAdapter<TestQuery.Human> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forString("homePlanet", "homePlanet", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Human {
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
        TestQuery.Human(
          __typename = __typename!!,
          name = name!!,
          homePlanet = homePlanet
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Human) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeString(RESPONSE_FIELDS[2], value.homePlanet)
    }
  }
}
