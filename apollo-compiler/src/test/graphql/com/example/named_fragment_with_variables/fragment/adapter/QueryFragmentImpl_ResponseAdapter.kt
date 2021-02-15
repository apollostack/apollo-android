// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_with_variables.fragment.adapter

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ListResponseAdapter
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.named_fragment_with_variables.fragment.QueryFragmentImpl
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class QueryFragmentImpl_ResponseAdapter(
  customScalarAdapters: CustomScalarAdapters
) : ResponseAdapter<QueryFragmentImpl.Data> {
  val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

  val nullableorganizationAdapterAdapter: ResponseAdapter<QueryFragmentImpl.Data.Organization?> =
      NullableResponseAdapter(Organization(customScalarAdapters))

  override fun fromResponse(reader: JsonReader): QueryFragmentImpl.Data {
    var __typename: String? = null
    var organization: QueryFragmentImpl.Data.Organization? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> __typename = stringAdapter.fromResponse(reader)
        1 -> organization = nullableorganizationAdapterAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return QueryFragmentImpl.Data(
      __typename = __typename!!,
      organization = organization
    )
  }

  override fun toResponse(writer: JsonWriter, value: QueryFragmentImpl.Data) {
    writer.beginObject()
    writer.name("__typename")
    stringAdapter.toResponse(writer, value.__typename)
    writer.name("organization")
    nullableorganizationAdapterAdapter.toResponse(writer, value.organization)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.Typename,
      ResponseField(
        type = ResponseField.Type.Named.Object("Organization"),
        fieldName = "organization",
        arguments = mapOf<String, Any?>(
          "id" to mapOf<String, Any?>(
            "kind" to "Variable",
            "variableName" to "organizationId")),
        fieldSets = listOf(
          ResponseField.FieldSet(null, Organization.RESPONSE_FIELDS)
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class Organization(
    customScalarAdapters: CustomScalarAdapters
  ) : ResponseAdapter<QueryFragmentImpl.Data.Organization> {
    val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

    val listOfuserAdapterAdapter: ResponseAdapter<List<QueryFragmentImpl.Data.Organization.User>> =
        ListResponseAdapter(User(customScalarAdapters))

    override fun fromResponse(reader: JsonReader): QueryFragmentImpl.Data.Organization {
      var id: String? = null
      var user: List<QueryFragmentImpl.Data.Organization.User>? = null
      reader.beginObject()
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> id = stringAdapter.fromResponse(reader)
          1 -> user = listOfuserAdapterAdapter.fromResponse(reader)
          else -> break
        }
      }
      reader.endObject()
      return QueryFragmentImpl.Data.Organization(
        id = id!!,
        user = user!!
      )
    }

    override fun toResponse(writer: JsonWriter, value: QueryFragmentImpl.Data.Organization) {
      writer.beginObject()
      writer.name("id")
      stringAdapter.toResponse(writer, value.id)
      writer.name("user")
      listOfuserAdapterAdapter.toResponse(writer, value.user)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "id",
        ),
        ResponseField(
          type =
              ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.NotNull(ResponseField.Type.Named.Object("User")))),
          fieldName = "user",
          arguments = mapOf<String, Any?>(
            "query" to mapOf<String, Any?>(
              "kind" to "Variable",
              "variableName" to "query")),
          fieldSets = listOf(
            ResponseField.FieldSet("User", User.UserUser.RESPONSE_FIELDS),
            ResponseField.FieldSet(null, User.OtherUser.RESPONSE_FIELDS),
          ),
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }

    class User(
      customScalarAdapters: CustomScalarAdapters
    ) : ResponseAdapter<QueryFragmentImpl.Data.Organization.User> {
      val UserUserAdapter: UserUser =
          com.example.named_fragment_with_variables.fragment.adapter.QueryFragmentImpl_ResponseAdapter.Organization.User.UserUser(customScalarAdapters)

      val OtherUserAdapter: OtherUser =
          com.example.named_fragment_with_variables.fragment.adapter.QueryFragmentImpl_ResponseAdapter.Organization.User.OtherUser(customScalarAdapters)

      override fun fromResponse(reader: JsonReader): QueryFragmentImpl.Data.Organization.User {
        reader.beginObject()
        check(reader.nextName() == "__typename")
        val typename = reader.nextString()

        return when(typename) {
          "User" -> UserUserAdapter.fromResponse(reader, typename)
          else -> OtherUserAdapter.fromResponse(reader, typename)
        }
        .also { reader.endObject() }
      }

      override fun toResponse(writer: JsonWriter, value: QueryFragmentImpl.Data.Organization.User) {
        when(value) {
          is QueryFragmentImpl.Data.Organization.User.UserUser -> UserUserAdapter.toResponse(writer, value)
          is QueryFragmentImpl.Data.Organization.User.OtherUser -> OtherUserAdapter.toResponse(writer, value)
        }
      }

      class UserUser(
        customScalarAdapters: CustomScalarAdapters
      ) {
        val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

        fun fromResponse(reader: JsonReader, __typename: String?):
            QueryFragmentImpl.Data.Organization.User.UserUser {
          var __typename: String? = __typename
          var firstName: String? = null
          var lastName: String? = null
          var avatar: String? = null
          while(true) {
            when (reader.selectName(RESPONSE_NAMES)) {
              0 -> __typename = stringAdapter.fromResponse(reader)
              1 -> firstName = stringAdapter.fromResponse(reader)
              2 -> lastName = stringAdapter.fromResponse(reader)
              3 -> avatar = stringAdapter.fromResponse(reader)
              else -> break
            }
          }
          return QueryFragmentImpl.Data.Organization.User.UserUser(
            __typename = __typename!!,
            firstName = firstName!!,
            lastName = lastName!!,
            avatar = avatar!!
          )
        }

        fun toResponse(writer: JsonWriter,
            value: QueryFragmentImpl.Data.Organization.User.UserUser) {
          writer.beginObject()
          writer.name("__typename")
          stringAdapter.toResponse(writer, value.__typename)
          writer.name("firstName")
          stringAdapter.toResponse(writer, value.firstName)
          writer.name("lastName")
          stringAdapter.toResponse(writer, value.lastName)
          writer.name("avatar")
          stringAdapter.toResponse(writer, value.avatar)
          writer.endObject()
        }

        companion object {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.Typename,
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              fieldName = "firstName",
            ),
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              fieldName = "lastName",
            ),
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              fieldName = "avatar",
              arguments = mapOf<String, Any?>(
                "size" to mapOf<String, Any?>(
                  "kind" to "Variable",
                  "variableName" to "size")),
            )
          )

          val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
        }
      }

      class OtherUser(
        customScalarAdapters: CustomScalarAdapters
      ) {
        val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

        fun fromResponse(reader: JsonReader, __typename: String?):
            QueryFragmentImpl.Data.Organization.User.OtherUser {
          var __typename: String? = __typename
          while(true) {
            when (reader.selectName(RESPONSE_NAMES)) {
              0 -> __typename = stringAdapter.fromResponse(reader)
              else -> break
            }
          }
          return QueryFragmentImpl.Data.Organization.User.OtherUser(
            __typename = __typename!!
          )
        }

        fun toResponse(writer: JsonWriter,
            value: QueryFragmentImpl.Data.Organization.User.OtherUser) {
          writer.beginObject()
          writer.name("__typename")
          stringAdapter.toResponse(writer, value.__typename)
          writer.endObject()
        }

        companion object {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.Typename
          )

          val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
        }
      }
    }
  }
}
