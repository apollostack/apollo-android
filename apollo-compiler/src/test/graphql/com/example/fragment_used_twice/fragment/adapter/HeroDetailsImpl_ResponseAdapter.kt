// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.fragment_used_twice.fragment.HeroDetailsImpl
import com.example.fragment_used_twice.type.CustomScalars
import kotlin.Any
import kotlin.Array
import kotlin.String

object HeroDetailsImpl_ResponseAdapter : ResponseAdapter<HeroDetailsImpl> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HeroDetailsImpl {
    val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
    return when(typename) {
      "Droid" -> CharacterHeroDetailsImpl.fromResponse(reader, typename)
      "Human" -> CharacterHeroDetailsImpl.fromResponse(reader, typename)
      else -> OtherHeroDetailsImpl.fromResponse(reader, typename)
    }
  }

  override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl) {
    when(value) {
      is HeroDetailsImpl.CharacterHeroDetailsImpl -> CharacterHeroDetailsImpl.toResponse(writer, value)
      is HeroDetailsImpl.OtherHeroDetailsImpl -> OtherHeroDetailsImpl.toResponse(writer, value)
    }
  }

  object CharacterHeroDetailsImpl : ResponseAdapter<HeroDetailsImpl.CharacterHeroDetailsImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forCustomScalar("birthDate", "birthDate", null, false, CustomScalars.Date, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HeroDetailsImpl.CharacterHeroDetailsImpl {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var birthDate: Any? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> birthDate = readCustomScalar<Any>(RESPONSE_FIELDS[2] as ResponseField.CustomScalarField)
            else -> break
          }
        }
        HeroDetailsImpl.CharacterHeroDetailsImpl(
          __typename = __typename!!,
          name = name!!,
          birthDate = birthDate!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter,
        value: HeroDetailsImpl.CharacterHeroDetailsImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeCustom(RESPONSE_FIELDS[2] as ResponseField.CustomScalarField, value.birthDate)
    }
  }

  object OtherHeroDetailsImpl : ResponseAdapter<HeroDetailsImpl.OtherHeroDetailsImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HeroDetailsImpl.OtherHeroDetailsImpl {
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
        HeroDetailsImpl.OtherHeroDetailsImpl(
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.OtherHeroDetailsImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
    }
  }
}
