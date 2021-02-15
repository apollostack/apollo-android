// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment_with_inline_fragments.fragment.adapter

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ListResponseAdapter
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.doubleResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.simple_fragment_with_inline_fragments.fragment.HeroDetailsImpl
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
<<<<<<< HEAD
class HeroDetailsImpl_ResponseAdapter(
  customScalarAdapters: CustomScalarAdapters
) : ResponseAdapter<HeroDetailsImpl.Data> {
  val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

  val nullableListOfNullableFriendsAdapter: ResponseAdapter<List<HeroDetailsImpl.Data.Friends?>?> =
      NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Friends(customScalarAdapters))))

  override fun fromResponse(reader: JsonReader): HeroDetailsImpl.Data {
    var __typename: String? = null
    var name: String? = null
    var friends: List<HeroDetailsImpl.Data.Friends?>? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> __typename = stringAdapter.fromResponse(reader)
        1 -> name = stringAdapter.fromResponse(reader)
        2 -> friends = nullableListOfNullableFriendsAdapter.fromResponse(reader)
        else -> break
=======
object HeroDetailsImpl_ResponseAdapter : ResponseAdapter<HeroDetailsImpl.Data> {
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
        ResponseField.FieldSet("Droid", Friends.DroidFriends.RESPONSE_FIELDS),
        ResponseField.FieldSet(null, Friends.OtherFriends.RESPONSE_FIELDS),
      ),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HeroDetailsImpl.Data {
    return reader.run {
      var __typename: String? = __typename
      var name: String? = null
      var friends: List<HeroDetailsImpl.Data.Friends?>? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> name = readString(RESPONSE_FIELDS[1])
          2 -> friends = readList<HeroDetailsImpl.Data.Friends>(RESPONSE_FIELDS[2]) { reader ->
            reader.readObject<HeroDetailsImpl.Data.Friends> { reader ->
              Friends.fromResponse(reader)
            }
          }
          else -> break
        }
>>>>>>> dev-3.x
      }
    }
    reader.endObject()
    return HeroDetailsImpl.Data(
      __typename = __typename!!,
      name = name!!,
      friends = friends
    )
  }

<<<<<<< HEAD
  override fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data) {
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
          ResponseField.FieldSet("Droid", Friends.DroidFriends.RESPONSE_FIELDS),
          ResponseField.FieldSet(null, Friends.OtherFriends.RESPONSE_FIELDS),
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class Friends(
    customScalarAdapters: CustomScalarAdapters
  ) : ResponseAdapter<HeroDetailsImpl.Data.Friends> {
    val HumanFriendsAdapter: HumanFriends =
        com.example.simple_fragment_with_inline_fragments.fragment.adapter.HeroDetailsImpl_ResponseAdapter.Friends.HumanFriends(customScalarAdapters)

    val DroidFriendsAdapter: DroidFriends =
        com.example.simple_fragment_with_inline_fragments.fragment.adapter.HeroDetailsImpl_ResponseAdapter.Friends.DroidFriends(customScalarAdapters)

    val OtherFriendsAdapter: OtherFriends =
        com.example.simple_fragment_with_inline_fragments.fragment.adapter.HeroDetailsImpl_ResponseAdapter.Friends.OtherFriends(customScalarAdapters)

    override fun fromResponse(reader: JsonReader): HeroDetailsImpl.Data.Friends {
      reader.beginObject()
      check(reader.nextName() == "__typename")
      val typename = reader.nextString()

      return when(typename) {
        "Human" -> HumanFriendsAdapter.fromResponse(reader, typename)
        "Droid" -> DroidFriendsAdapter.fromResponse(reader, typename)
        else -> OtherFriendsAdapter.fromResponse(reader, typename)
=======
  override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.name)
    writer.writeList(RESPONSE_FIELDS[2], value.friends) { value, listItemWriter ->
      listItemWriter.writeObject { writer ->
        Friends.toResponse(writer, value)
      }
    }
  }

  object Friends : ResponseAdapter<HeroDetailsImpl.Data.Friends> {
    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HeroDetailsImpl.Data.Friends {
      val typename = __typename ?: reader.readString(ResponseField.Typename)
      return when(typename) {
        "Human" -> HumanFriends.fromResponse(reader, typename)
        "Droid" -> DroidFriends.fromResponse(reader, typename)
        else -> OtherFriends.fromResponse(reader, typename)
>>>>>>> dev-3.x
      }
      .also { reader.endObject() }
    }

<<<<<<< HEAD
    override fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data.Friends) {
      when(value) {
        is HeroDetailsImpl.Data.Friends.HumanFriends -> HumanFriendsAdapter.toResponse(writer, value)
        is HeroDetailsImpl.Data.Friends.DroidFriends -> DroidFriendsAdapter.toResponse(writer, value)
        is HeroDetailsImpl.Data.Friends.OtherFriends -> OtherFriendsAdapter.toResponse(writer, value)
      }
    }

    class HumanFriends(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      val nullableFloatAdapter: ResponseAdapter<Double?> =
          NullableResponseAdapter(doubleResponseAdapter)

      fun fromResponse(reader: JsonReader, __typename: String?):
          HeroDetailsImpl.Data.Friends.HumanFriends {
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
    override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Data.Friends) {
      when(value) {
        is HeroDetailsImpl.Data.Friends.HumanFriends -> HumanFriends.toResponse(writer, value)
        is HeroDetailsImpl.Data.Friends.DroidFriends -> DroidFriends.toResponse(writer, value)
        is HeroDetailsImpl.Data.Friends.OtherFriends -> OtherFriends.toResponse(writer, value)
      }
    }

    object HumanFriends : ResponseAdapter<HeroDetailsImpl.Data.Friends.HumanFriends> {
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
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Data.Friends.HumanFriends {
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
          HeroDetailsImpl.Data.Friends.HumanFriends(
            __typename = __typename!!,
            name = name!!,
            height = height
          )
>>>>>>> dev-3.x
        }
        return HeroDetailsImpl.Data.Friends.HumanFriends(
          __typename = __typename!!,
          name = name!!,
          height = height
        )
      }

<<<<<<< HEAD
      fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data.Friends.HumanFriends) {
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
          value: HeroDetailsImpl.Data.Friends.HumanFriends) {
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
          )
=======
    object DroidFriends : ResponseAdapter<HeroDetailsImpl.Data.Friends.DroidFriends> {
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
          type = ResponseField.Type.Named.Other("String"),
          responseName = "primaryFunction",
          fieldName = "primaryFunction",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
>>>>>>> dev-3.x
        )

<<<<<<< HEAD
        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }

    class DroidFriends(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      val nullableStringAdapter: ResponseAdapter<String?> =
          NullableResponseAdapter(stringResponseAdapter)

      fun fromResponse(reader: JsonReader, __typename: String?):
          HeroDetailsImpl.Data.Friends.DroidFriends {
        var __typename: String? = __typename
        var name: String? = null
        var primaryFunction: String? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> primaryFunction = nullableStringAdapter.fromResponse(reader)
            else -> break
          }
=======
      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Data.Friends.DroidFriends {
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
          HeroDetailsImpl.Data.Friends.DroidFriends(
            __typename = __typename!!,
            name = name!!,
            primaryFunction = primaryFunction
          )
>>>>>>> dev-3.x
        }
        return HeroDetailsImpl.Data.Friends.DroidFriends(
          __typename = __typename!!,
          name = name!!,
          primaryFunction = primaryFunction
        )
      }

<<<<<<< HEAD
      fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data.Friends.DroidFriends) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("primaryFunction")
        nullableStringAdapter.toResponse(writer, value.primaryFunction)
        writer.endObject()
=======
      override fun toResponse(writer: ResponseWriter,
          value: HeroDetailsImpl.Data.Friends.DroidFriends) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
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
            type = ResponseField.Type.Named.Other("String"),
            fieldName = "primaryFunction",
          )
=======
    object OtherFriends : ResponseAdapter<HeroDetailsImpl.Data.Friends.OtherFriends> {
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
          HeroDetailsImpl.Data.Friends.OtherFriends {
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
          HeroDetailsImpl.Data.Friends.OtherFriends {
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
          HeroDetailsImpl.Data.Friends.OtherFriends(
            __typename = __typename!!,
            name = name!!
          )
>>>>>>> dev-3.x
        }
        return HeroDetailsImpl.Data.Friends.OtherFriends(
          __typename = __typename!!,
          name = name!!
        )
      }

      fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data.Friends.OtherFriends) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.endObject()
      }

<<<<<<< HEAD
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
          value: HeroDetailsImpl.Data.Friends.OtherFriends) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
>>>>>>> dev-3.x
      }
    }
  }
}
