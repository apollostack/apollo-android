// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_with_inline_fragment.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.fragment_with_inline_fragment.fragment.HumanDetailsImpl
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object HumanDetailsImpl_ResponseAdapter : ResponseAdapter<HumanDetailsImpl.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named("String")),
      responseName = "__typename",
      fieldName = "__typename",
      arguments = emptyMap(),
      conditions = emptyList(),
    ),
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named("String")),
      responseName = "name",
      fieldName = "name",
      arguments = emptyMap(),
      conditions = emptyList(),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HumanDetailsImpl.Data {
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
      HumanDetailsImpl.Data(
        __typename = __typename!!,
        name = name!!
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: HumanDetailsImpl.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.name)
  }
}
