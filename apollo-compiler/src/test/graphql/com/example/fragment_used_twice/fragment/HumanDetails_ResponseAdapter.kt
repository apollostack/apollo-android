// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.fragment_used_twice.type.CustomType
import kotlin.Any
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object HumanDetails_ResponseAdapter : ResponseAdapter<HumanDetails.DefaultImpl> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forString("name", "name", null, false, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HumanDetails.DefaultImpl {
    val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
    return when(typename) {
      "Droid" -> CharacterDetailsImpl_ResponseAdapter.fromResponse(reader, typename)
      "Human" -> CharacterDetailsImpl_ResponseAdapter.fromResponse(reader, typename)
      else -> OtherDefaultImpl_ResponseAdapter.fromResponse(reader, typename)
    }
  }

  override fun toResponse(writer: ResponseWriter, value: HumanDetails.DefaultImpl) {
    when(value) {
      is HumanDetails.CharacterDetailsImpl -> CharacterDetailsImpl_ResponseAdapter.toResponse(writer, value)
      is HumanDetails.OtherDefaultImpl -> OtherDefaultImpl_ResponseAdapter.toResponse(writer, value)
    }
  }

  object CharacterDetailsImpl_ResponseAdapter : ResponseAdapter<HumanDetails.CharacterDetailsImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forCustomType("birthDate", "birthDate", null, false, CustomType.DATE, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HumanDetails.CharacterDetailsImpl {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var birthDate: Any? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> birthDate = readCustomType<Any>(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField)
            else -> break
          }
        }
        HumanDetails.CharacterDetailsImpl(
          __typename = __typename!!,
          name = name!!,
          birthDate = birthDate!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HumanDetails.CharacterDetailsImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeCustom(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField, value.birthDate)
    }
  }

  object OtherDefaultImpl_ResponseAdapter : ResponseAdapter<HumanDetails.OtherDefaultImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HumanDetails.OtherDefaultImpl {
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
        HumanDetails.OtherDefaultImpl(
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HumanDetails.OtherDefaultImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
    }
  }
}
