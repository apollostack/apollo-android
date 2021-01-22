// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_with_variables.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.named_fragment_with_variables.fragment.UserFragmentImpl
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object UserFragmentImpl_ResponseAdapter : ResponseAdapter<UserFragmentImpl.Data> {
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
      responseName = "firstName",
      fieldName = "firstName",
      arguments = emptyMap(),
      conditions = emptyList(),
    ),
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
          ResponseField.Kind.OTHER)),
      responseName = "lastName",
      fieldName = "lastName",
      arguments = emptyMap(),
      conditions = emptyList(),
    ),
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
          ResponseField.Kind.OTHER)),
      responseName = "avatar",
      fieldName = "avatar",
      arguments = mapOf<String, Any?>(
        "size" to mapOf<String, Any?>(
          "kind" to "Variable",
          "variableName" to "size")),
      conditions = emptyList(),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): UserFragmentImpl.Data {
    return reader.run {
      var __typename: String? = __typename
      var firstName: String? = null
      var lastName: String? = null
      var avatar: String? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> firstName = readString(RESPONSE_FIELDS[1])
          2 -> lastName = readString(RESPONSE_FIELDS[2])
          3 -> avatar = readString(RESPONSE_FIELDS[3])
          else -> break
        }
      }
      UserFragmentImpl.Data(
        __typename = __typename!!,
        firstName = firstName!!,
        lastName = lastName!!,
        avatar = avatar!!
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: UserFragmentImpl.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.firstName)
    writer.writeString(RESPONSE_FIELDS[2], value.lastName)
    writer.writeString(RESPONSE_FIELDS[3], value.avatar)
  }
}
