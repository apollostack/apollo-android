// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment_with_inline_fragments.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.simple_fragment_with_inline_fragments.fragment.HeroDetailsImpl
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object HeroDetailsImpl_ResponseAdapter : ResponseAdapter<HeroDetailsImpl.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
          ResponseField.Kind.OTHER)),
      responseName = "__typename",
      fieldName = "__typename",
      arguments = emptyMap(),
      conditions = emptyList(),
    ),
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
          ResponseField.Kind.OTHER)),
      responseName = "name",
      fieldName = "name",
      arguments = emptyMap(),
      conditions = emptyList(),
    ),
    ResponseField(
      type = ResponseField.Type.List(ResponseField.Type.Named("Character",
          ResponseField.Kind.OBJECT)),
      responseName = "friends",
      fieldName = "friends",
      arguments = emptyMap(),
      conditions = emptyList(),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HeroDetailsImpl.Data {
    return reader.run {
      var __typename: String? = __typename
      var name: String? = null
      var friends: List<HeroDetailsImpl.Data.Friend?>? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> name = readString(RESPONSE_FIELDS[1])
          2 -> friends = readList<HeroDetailsImpl.Data.Friend>(RESPONSE_FIELDS[2]) { reader ->
            reader.readObject<HeroDetailsImpl.Data.Friend> { reader ->
              Friend.fromResponse(reader)
            }
          }
          else -> break
        }
      }
      HeroDetailsImpl.Data(
        __typename = __typename!!,
        name = name!!,
        friends = friends
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.name)
    writer.writeList(RESPONSE_FIELDS[2], value.friends) { value, listItemWriter ->
      listItemWriter.writeObject { writer ->
        Friend.toResponse(writer, value)
      }
    }
  }

  object Friend : ResponseAdapter<HeroDetailsImpl.Data.Friend> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
            ResponseField.Kind.OTHER)),
        responseName = "__typename",
        fieldName = "__typename",
        arguments = emptyMap(),
        conditions = emptyList(),
      )
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HeroDetailsImpl.Data.Friend {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "Human" -> HumanFriend.fromResponse(reader, typename)
        "Droid" -> DroidFriend.fromResponse(reader, typename)
        else -> OtherFriend.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Data.Friend) {
      when(value) {
        is HeroDetailsImpl.Data.Friend.HumanFriend -> HumanFriend.toResponse(writer, value)
        is HeroDetailsImpl.Data.Friend.DroidFriend -> DroidFriend.toResponse(writer, value)
        is HeroDetailsImpl.Data.Friend.OtherFriend -> OtherFriend.toResponse(writer, value)
      }
    }

    object HumanFriend : ResponseAdapter<HeroDetailsImpl.Data.Friend.HumanFriend> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.Named("Float", ResponseField.Kind.OTHER),
          responseName = "height",
          fieldName = "height",
          arguments = emptyMap(),
          conditions = emptyList(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Data.Friend.HumanFriend {
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
          HeroDetailsImpl.Data.Friend.HumanFriend(
            __typename = __typename!!,
            name = name!!,
            height = height
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: HeroDetailsImpl.Data.Friend.HumanFriend) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeDouble(RESPONSE_FIELDS[2], value.height)
      }
    }

    object DroidFriend : ResponseAdapter<HeroDetailsImpl.Data.Friend.DroidFriend> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.Named("String", ResponseField.Kind.OTHER),
          responseName = "primaryFunction",
          fieldName = "primaryFunction",
          arguments = emptyMap(),
          conditions = emptyList(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Data.Friend.DroidFriend {
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
          HeroDetailsImpl.Data.Friend.DroidFriend(
            __typename = __typename!!,
            name = name!!,
            primaryFunction = primaryFunction
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: HeroDetailsImpl.Data.Friend.DroidFriend) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
      }
    }

    object OtherFriend : ResponseAdapter<HeroDetailsImpl.Data.Friend.OtherFriend> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Data.Friend.OtherFriend {
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
          HeroDetailsImpl.Data.Friend.OtherFriend(
            __typename = __typename!!,
            name = name!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: HeroDetailsImpl.Data.Friend.OtherFriend) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
      }
    }
  }
}
