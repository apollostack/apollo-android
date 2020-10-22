// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_delegate.fragment

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
object DroidDetails_ResponseAdapter : ResponseAdapter<DroidDetails.DefaultImpl> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forString("name", "name", null, false, null),
    ResponseField.forString("primaryFunction", "primaryFunction", null, true, null),
    ResponseField.forList("friends", "friends", null, true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): DroidDetails.DefaultImpl {
    return reader.run {
      var __typename: String? = __typename
      var name: String? = null
      var primaryFunction: String? = null
      var friends: List<DroidDetails.Friend1?>? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> name = readString(RESPONSE_FIELDS[1])
          2 -> primaryFunction = readString(RESPONSE_FIELDS[2])
          3 -> friends = readList<DroidDetails.Friend1>(RESPONSE_FIELDS[3]) { reader ->
            reader.readObject<DroidDetails.Friend1> { reader ->
              Friend1_ResponseAdapter.fromResponse(reader)
            }
          }
          else -> break
        }
      }
      DroidDetails.DefaultImpl(
        __typename = __typename!!,
        name = name!!,
        primaryFunction = primaryFunction,
        friends = friends
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: DroidDetails.DefaultImpl) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.name)
    writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
    writer.writeList(RESPONSE_FIELDS[3], value.friends) { value, listItemWriter ->
      value?.forEach { value ->
        if(value == null) {
          listItemWriter.writeObject(null)
        } else {
          listItemWriter.writeObject {
            Friend1_ResponseAdapter.toResponse(writer, value)
          }
        }
      }
    }
  }

  object Friend1_ResponseAdapter : ResponseAdapter<DroidDetails.Friend1> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): DroidDetails.Friend1 {
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
        DroidDetails.Friend1(
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: DroidDetails.Friend1) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
    }
  }
}
