// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.nested_conditional_inline.adapter

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ListResponseAdapter
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.doubleResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.nested_conditional_inline.TestQuery
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
  val nullableHeroAdapter: ResponseAdapter<TestQuery.Data.Hero?> =
      NullableResponseAdapter(Hero(customScalarAdapters))

  override fun fromResponse(reader: JsonReader): TestQuery.Data {
    var hero: TestQuery.Data.Hero? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> hero = nullableHeroAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return TestQuery.Data(
      hero = hero
    )
  }

  override fun toResponse(writer: JsonWriter, value: TestQuery.Data) {
    writer.beginObject()
    writer.name("hero")
    nullableHeroAdapter.toResponse(writer, value.hero)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.Named.Object("Character"),
        fieldName = "hero",
        arguments = mapOf<String, Any?>(
          "episode" to mapOf<String, Any?>(
            "kind" to "Variable",
            "variableName" to "episode")),
        fieldSets = listOf(
          ResponseField.FieldSet("Human", Hero.HumanHero.RESPONSE_FIELDS),
          ResponseField.FieldSet("Droid", Hero.DroidHero.RESPONSE_FIELDS),
          ResponseField.FieldSet(null, Hero.OtherHero.RESPONSE_FIELDS),
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class Hero(
    customScalarAdapters: CustomScalarAdapters
  ) : ResponseAdapter<TestQuery.Data.Hero> {
    val HumanHeroAdapter: HumanHero =
        com.example.nested_conditional_inline.adapter.TestQuery_ResponseAdapter.Hero.HumanHero(customScalarAdapters)

    val DroidHeroAdapter: DroidHero =
        com.example.nested_conditional_inline.adapter.TestQuery_ResponseAdapter.Hero.DroidHero(customScalarAdapters)

    val OtherHeroAdapter: OtherHero =
        com.example.nested_conditional_inline.adapter.TestQuery_ResponseAdapter.Hero.OtherHero(customScalarAdapters)

    override fun fromResponse(reader: JsonReader): TestQuery.Data.Hero {
      reader.beginObject()
      check(reader.nextName() == "__typename")
      val typename = reader.nextString()

      return when(typename) {
        "Human" -> HumanHeroAdapter.fromResponse(reader, typename)
        "Droid" -> DroidHeroAdapter.fromResponse(reader, typename)
        else -> OtherHeroAdapter.fromResponse(reader, typename)
      }
      .also { reader.endObject() }
    }

    override fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero) {
      when(value) {
        is TestQuery.Data.Hero.HumanHero -> HumanHeroAdapter.toResponse(writer, value)
        is TestQuery.Data.Hero.DroidHero -> DroidHeroAdapter.toResponse(writer, value)
        is TestQuery.Data.Hero.OtherHero -> OtherHeroAdapter.toResponse(writer, value)
      }
    }

<<<<<<< HEAD
    class HumanHero(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      val nullableListOfNullableFriendsAdapter:
          ResponseAdapter<List<TestQuery.Data.Hero.HumanHero.Friends?>?> =
          NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Friends(customScalarAdapters))))

      fun fromResponse(reader: JsonReader, __typename: String?): TestQuery.Data.Hero.HumanHero {
        var __typename: String? = __typename
        var name: String? = null
        var friends: List<TestQuery.Data.Hero.HumanHero.Friends?>? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> friends = nullableListOfNullableFriendsAdapter.fromResponse(reader)
            else -> break
=======
    object HumanHero : ResponseAdapter<TestQuery.Data.Hero.HumanHero> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
          responseName = "friends",
          fieldName = "friends",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = listOf(
            ResponseField.FieldSet("Human", Friends.HumanFriends.RESPONSE_FIELDS),
            ResponseField.FieldSet(null, Friends.OtherFriends.RESPONSE_FIELDS),
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.HumanHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var friends: List<TestQuery.Data.Hero.HumanHero.Friends?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> friends = readList<TestQuery.Data.Hero.HumanHero.Friends>(RESPONSE_FIELDS[2]) { reader ->
                reader.readObject<TestQuery.Data.Hero.HumanHero.Friends> { reader ->
                  Friends.fromResponse(reader)
                }
              }
              else -> break
            }
>>>>>>> dev-3.x
          }
        }
        return TestQuery.Data.Hero.HumanHero(
          __typename = __typename!!,
          name = name!!,
          friends = friends
        )
      }

<<<<<<< HEAD
      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.HumanHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("friends")
        nullableListOfNullableFriendsAdapter.toResponse(writer, value.friends)
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
            type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
            fieldName = "friends",
            fieldSets = listOf(
              ResponseField.FieldSet("Human", Friends.HumanFriends.RESPONSE_FIELDS),
              ResponseField.FieldSet(null, Friends.OtherFriends.RESPONSE_FIELDS),
            ),
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }

      class Friends(
        customScalarAdapters: CustomScalarAdapters
      ) : ResponseAdapter<TestQuery.Data.Hero.HumanHero.Friends> {
        val HumanFriendsAdapter: HumanFriends =
            com.example.nested_conditional_inline.adapter.TestQuery_ResponseAdapter.Hero.HumanHero.Friends.HumanFriends(customScalarAdapters)

        val OtherFriendsAdapter: OtherFriends =
            com.example.nested_conditional_inline.adapter.TestQuery_ResponseAdapter.Hero.HumanHero.Friends.OtherFriends(customScalarAdapters)

        override fun fromResponse(reader: JsonReader): TestQuery.Data.Hero.HumanHero.Friends {
          reader.beginObject()
          check(reader.nextName() == "__typename")
          val typename = reader.nextString()

          return when(typename) {
            "Human" -> HumanFriendsAdapter.fromResponse(reader, typename)
            else -> OtherFriendsAdapter.fromResponse(reader, typename)
=======
      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.HumanHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.friends) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Friends.toResponse(writer, value)
          }
        }
      }

      object Friends : ResponseAdapter<TestQuery.Data.Hero.HumanHero.Friends> {
        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.HumanHero.Friends {
          val typename = __typename ?: reader.readString(ResponseField.Typename)
          return when(typename) {
            "Human" -> HumanFriends.fromResponse(reader, typename)
            else -> OtherFriends.fromResponse(reader, typename)
>>>>>>> dev-3.x
          }
          .also { reader.endObject() }
        }

<<<<<<< HEAD
        override fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.HumanHero.Friends) {
          when(value) {
            is TestQuery.Data.Hero.HumanHero.Friends.HumanFriends -> HumanFriendsAdapter.toResponse(writer, value)
            is TestQuery.Data.Hero.HumanHero.Friends.OtherFriends -> OtherFriendsAdapter.toResponse(writer, value)
          }
        }

        class HumanFriends(
          customScalarAdapters: CustomScalarAdapters
        ) {
          val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

          val nullableFloatAdapter: ResponseAdapter<Double?> =
              NullableResponseAdapter(doubleResponseAdapter)

          fun fromResponse(reader: JsonReader, __typename: String?):
              TestQuery.Data.Hero.HumanHero.Friends.HumanFriends {
            var __typename: String? = __typename
            var name: String? = null
            var height: Double? = null
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> __typename = stringAdapter.fromResponse(reader)
                1 -> name = stringAdapter.fromResponse(reader)
                2 -> height = nullableFloatAdapter.fromResponse(reader)
                else -> break
              }
=======
        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.HumanHero.Friends) {
          when(value) {
            is TestQuery.Data.Hero.HumanHero.Friends.HumanFriends -> HumanFriends.toResponse(writer, value)
            is TestQuery.Data.Hero.HumanHero.Friends.OtherFriends -> OtherFriends.toResponse(writer, value)
          }
        }

        object HumanFriends : ResponseAdapter<TestQuery.Data.Hero.HumanHero.Friends.HumanFriends> {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "__typename",
              fieldName = "__typename",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
            ),
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "name",
              fieldName = "name",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
            ),
            ResponseField(
              type = ResponseField.Type.Named.Other("Float"),
              responseName = "height",
              fieldName = "height",
              arguments = mapOf<String, Any?>(
                "unit" to "FOOT"),
              conditions = emptyList(),
              fieldSets = emptyList(),
            )
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.Hero.HumanHero.Friends.HumanFriends {
            return reader.run {
              var __typename: String? = __typename
              var name: String? = null
              var height: Double? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> __typename = readString(RESPONSE_FIELDS[0])
                  1 -> name = readString(RESPONSE_FIELDS[1])
                  2 -> height = readDouble(RESPONSE_FIELDS[2])
                  else -> break
                }
              }
              TestQuery.Data.Hero.HumanHero.Friends.HumanFriends(
                __typename = __typename!!,
                name = name!!,
                height = height
              )
>>>>>>> dev-3.x
            }
            return TestQuery.Data.Hero.HumanHero.Friends.HumanFriends(
              __typename = __typename!!,
              name = name!!,
              height = height
            )
          }

<<<<<<< HEAD
          fun toResponse(writer: JsonWriter,
              value: TestQuery.Data.Hero.HumanHero.Friends.HumanFriends) {
            writer.beginObject()
            writer.name("__typename")
            stringAdapter.toResponse(writer, value.__typename)
            writer.name("name")
            stringAdapter.toResponse(writer, value.name)
            writer.name("height")
            nullableFloatAdapter.toResponse(writer, value.height)
            writer.endObject()
=======
          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.HumanHero.Friends.HumanFriends) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            writer.writeString(RESPONSE_FIELDS[1], value.name)
            writer.writeDouble(RESPONSE_FIELDS[2], value.height)
>>>>>>> dev-3.x
          }

<<<<<<< HEAD
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
                arguments = mapOf<String, Any?>(
                  "unit" to "FOOT"),
              )
=======
        object OtherFriends : ResponseAdapter<TestQuery.Data.Hero.HumanHero.Friends.OtherFriends> {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "__typename",
              fieldName = "__typename",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
            ),
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "name",
              fieldName = "name",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
>>>>>>> dev-3.x
            )

<<<<<<< HEAD
            val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
          }
        }

        class OtherFriends(
          customScalarAdapters: CustomScalarAdapters
        ) {
          val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

          fun fromResponse(reader: JsonReader, __typename: String?):
              TestQuery.Data.Hero.HumanHero.Friends.OtherFriends {
            var __typename: String? = __typename
            var name: String? = null
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> __typename = stringAdapter.fromResponse(reader)
                1 -> name = stringAdapter.fromResponse(reader)
                else -> break
              }
=======
          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.Hero.HumanHero.Friends.OtherFriends {
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
              TestQuery.Data.Hero.HumanHero.Friends.OtherFriends(
                __typename = __typename!!,
                name = name!!
              )
>>>>>>> dev-3.x
            }
            return TestQuery.Data.Hero.HumanHero.Friends.OtherFriends(
              __typename = __typename!!,
              name = name!!
            )
          }

<<<<<<< HEAD
          fun toResponse(writer: JsonWriter,
              value: TestQuery.Data.Hero.HumanHero.Friends.OtherFriends) {
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
=======
          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.HumanHero.Friends.OtherFriends) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            writer.writeString(RESPONSE_FIELDS[1], value.name)
>>>>>>> dev-3.x
          }
        }
      }
    }

<<<<<<< HEAD
    class DroidHero(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      val nullableListOfNullableFriendsAdapter:
          ResponseAdapter<List<TestQuery.Data.Hero.DroidHero.Friends?>?> =
          NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Friends(customScalarAdapters))))

      fun fromResponse(reader: JsonReader, __typename: String?): TestQuery.Data.Hero.DroidHero {
        var __typename: String? = __typename
        var name: String? = null
        var friends: List<TestQuery.Data.Hero.DroidHero.Friends?>? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> friends = nullableListOfNullableFriendsAdapter.fromResponse(reader)
            else -> break
=======
    object DroidHero : ResponseAdapter<TestQuery.Data.Hero.DroidHero> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
          responseName = "friends",
          fieldName = "friends",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = listOf(
            ResponseField.FieldSet("Human", Friends.HumanFriends.RESPONSE_FIELDS),
            ResponseField.FieldSet(null, Friends.OtherFriends.RESPONSE_FIELDS),
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.DroidHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var friends: List<TestQuery.Data.Hero.DroidHero.Friends?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> friends = readList<TestQuery.Data.Hero.DroidHero.Friends>(RESPONSE_FIELDS[2]) { reader ->
                reader.readObject<TestQuery.Data.Hero.DroidHero.Friends> { reader ->
                  Friends.fromResponse(reader)
                }
              }
              else -> break
            }
>>>>>>> dev-3.x
          }
        }
        return TestQuery.Data.Hero.DroidHero(
          __typename = __typename!!,
          name = name!!,
          friends = friends
        )
      }

<<<<<<< HEAD
      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.DroidHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("friends")
        nullableListOfNullableFriendsAdapter.toResponse(writer, value.friends)
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
            type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
            fieldName = "friends",
            fieldSets = listOf(
              ResponseField.FieldSet("Human", Friends.HumanFriends.RESPONSE_FIELDS),
              ResponseField.FieldSet(null, Friends.OtherFriends.RESPONSE_FIELDS),
            ),
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }

      class Friends(
        customScalarAdapters: CustomScalarAdapters
      ) : ResponseAdapter<TestQuery.Data.Hero.DroidHero.Friends> {
        val HumanFriendsAdapter: HumanFriends =
            com.example.nested_conditional_inline.adapter.TestQuery_ResponseAdapter.Hero.DroidHero.Friends.HumanFriends(customScalarAdapters)

        val OtherFriendsAdapter: OtherFriends =
            com.example.nested_conditional_inline.adapter.TestQuery_ResponseAdapter.Hero.DroidHero.Friends.OtherFriends(customScalarAdapters)

        override fun fromResponse(reader: JsonReader): TestQuery.Data.Hero.DroidHero.Friends {
          reader.beginObject()
          check(reader.nextName() == "__typename")
          val typename = reader.nextString()

          return when(typename) {
            "Human" -> HumanFriendsAdapter.fromResponse(reader, typename)
            else -> OtherFriendsAdapter.fromResponse(reader, typename)
=======
      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.DroidHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.friends) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Friends.toResponse(writer, value)
          }
        }
      }

      object Friends : ResponseAdapter<TestQuery.Data.Hero.DroidHero.Friends> {
        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.DroidHero.Friends {
          val typename = __typename ?: reader.readString(ResponseField.Typename)
          return when(typename) {
            "Human" -> HumanFriends.fromResponse(reader, typename)
            else -> OtherFriends.fromResponse(reader, typename)
>>>>>>> dev-3.x
          }
          .also { reader.endObject() }
        }

<<<<<<< HEAD
        override fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.DroidHero.Friends) {
          when(value) {
            is TestQuery.Data.Hero.DroidHero.Friends.HumanFriends -> HumanFriendsAdapter.toResponse(writer, value)
            is TestQuery.Data.Hero.DroidHero.Friends.OtherFriends -> OtherFriendsAdapter.toResponse(writer, value)
          }
        }

        class HumanFriends(
          customScalarAdapters: CustomScalarAdapters
        ) {
          val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

          val nullableFloatAdapter: ResponseAdapter<Double?> =
              NullableResponseAdapter(doubleResponseAdapter)

          fun fromResponse(reader: JsonReader, __typename: String?):
              TestQuery.Data.Hero.DroidHero.Friends.HumanFriends {
            var __typename: String? = __typename
            var name: String? = null
            var height: Double? = null
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> __typename = stringAdapter.fromResponse(reader)
                1 -> name = stringAdapter.fromResponse(reader)
                2 -> height = nullableFloatAdapter.fromResponse(reader)
                else -> break
              }
=======
        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.DroidHero.Friends) {
          when(value) {
            is TestQuery.Data.Hero.DroidHero.Friends.HumanFriends -> HumanFriends.toResponse(writer, value)
            is TestQuery.Data.Hero.DroidHero.Friends.OtherFriends -> OtherFriends.toResponse(writer, value)
          }
        }

        object HumanFriends : ResponseAdapter<TestQuery.Data.Hero.DroidHero.Friends.HumanFriends> {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "__typename",
              fieldName = "__typename",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
            ),
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "name",
              fieldName = "name",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
            ),
            ResponseField(
              type = ResponseField.Type.Named.Other("Float"),
              responseName = "height",
              fieldName = "height",
              arguments = mapOf<String, Any?>(
                "unit" to "METER"),
              conditions = emptyList(),
              fieldSets = emptyList(),
            )
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.Hero.DroidHero.Friends.HumanFriends {
            return reader.run {
              var __typename: String? = __typename
              var name: String? = null
              var height: Double? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> __typename = readString(RESPONSE_FIELDS[0])
                  1 -> name = readString(RESPONSE_FIELDS[1])
                  2 -> height = readDouble(RESPONSE_FIELDS[2])
                  else -> break
                }
              }
              TestQuery.Data.Hero.DroidHero.Friends.HumanFriends(
                __typename = __typename!!,
                name = name!!,
                height = height
              )
>>>>>>> dev-3.x
            }
            return TestQuery.Data.Hero.DroidHero.Friends.HumanFriends(
              __typename = __typename!!,
              name = name!!,
              height = height
            )
          }

<<<<<<< HEAD
          fun toResponse(writer: JsonWriter,
              value: TestQuery.Data.Hero.DroidHero.Friends.HumanFriends) {
            writer.beginObject()
            writer.name("__typename")
            stringAdapter.toResponse(writer, value.__typename)
            writer.name("name")
            stringAdapter.toResponse(writer, value.name)
            writer.name("height")
            nullableFloatAdapter.toResponse(writer, value.height)
            writer.endObject()
=======
          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.DroidHero.Friends.HumanFriends) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            writer.writeString(RESPONSE_FIELDS[1], value.name)
            writer.writeDouble(RESPONSE_FIELDS[2], value.height)
>>>>>>> dev-3.x
          }

<<<<<<< HEAD
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
                arguments = mapOf<String, Any?>(
                  "unit" to "METER"),
              )
=======
        object OtherFriends : ResponseAdapter<TestQuery.Data.Hero.DroidHero.Friends.OtherFriends> {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "__typename",
              fieldName = "__typename",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
            ),
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "name",
              fieldName = "name",
              arguments = emptyMap(),
              conditions = emptyList(),
              fieldSets = emptyList(),
>>>>>>> dev-3.x
            )

<<<<<<< HEAD
            val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
          }
        }

        class OtherFriends(
          customScalarAdapters: CustomScalarAdapters
        ) {
          val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

          fun fromResponse(reader: JsonReader, __typename: String?):
              TestQuery.Data.Hero.DroidHero.Friends.OtherFriends {
            var __typename: String? = __typename
            var name: String? = null
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> __typename = stringAdapter.fromResponse(reader)
                1 -> name = stringAdapter.fromResponse(reader)
                else -> break
              }
=======
          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.Hero.DroidHero.Friends.OtherFriends {
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
              TestQuery.Data.Hero.DroidHero.Friends.OtherFriends(
                __typename = __typename!!,
                name = name!!
              )
>>>>>>> dev-3.x
            }
            return TestQuery.Data.Hero.DroidHero.Friends.OtherFriends(
              __typename = __typename!!,
              name = name!!
            )
          }

<<<<<<< HEAD
          fun toResponse(writer: JsonWriter,
              value: TestQuery.Data.Hero.DroidHero.Friends.OtherFriends) {
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
=======
          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.DroidHero.Friends.OtherFriends) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            writer.writeString(RESPONSE_FIELDS[1], value.name)
>>>>>>> dev-3.x
          }
        }
      }
    }

    class OtherHero(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      fun fromResponse(reader: JsonReader, __typename: String?): TestQuery.Data.Hero.OtherHero {
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.Hero.OtherHero(
          __typename = __typename!!,
          name = name!!
        )
      }

      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.OtherHero) {
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
