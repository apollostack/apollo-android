// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.antlr_tokens.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.antlr_tokens.TestQuery
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("typeWithGraphQLKeywords", "typeWithGraphQLKeywords", null, true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return Data.fromResponse(reader, __typename)
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    Data.toResponse(writer, value)
  }

  object Data : ResponseAdapter<TestQuery.Data> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forObject("typeWithGraphQLKeywords", "typeWithGraphQLKeywords", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
      return reader.run {
        var typeWithGraphQLKeywords: TestQuery.Data.TypeWithGraphQLKeyword? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> typeWithGraphQLKeywords = readObject<TestQuery.Data.TypeWithGraphQLKeyword>(RESPONSE_FIELDS[0]) { reader ->
              TypeWithGraphQLKeyword.fromResponse(reader)
            }
            else -> break
          }
        }
        TestQuery.Data(
          typeWithGraphQLKeywords = typeWithGraphQLKeywords
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
      if(value.typeWithGraphQLKeywords == null) {
        writer.writeObject(RESPONSE_FIELDS[0], null)
      } else {
        writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
          TypeWithGraphQLKeyword.toResponse(writer, value.typeWithGraphQLKeywords)
        }
      }
    }

    object TypeWithGraphQLKeyword : ResponseAdapter<TestQuery.Data.TypeWithGraphQLKeyword> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("on", "on", null, true, null),
        ResponseField.forString("null", "null", mapOf<String, Any?>(
          "fragment" to mapOf<String, Any?>(
            "kind" to "Variable",
            "variableName" to "operation")), true, null),
        ResponseField.forString("alias", "null", mapOf<String, Any?>(
          "fragment" to """
          |A string
          |with a new line
          """.trimMargin()), true, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.TypeWithGraphQLKeyword {
        return reader.run {
          var on: String? = null
          var null_: String? = null
          var alias: String? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> on = readString(RESPONSE_FIELDS[0])
              1 -> null_ = readString(RESPONSE_FIELDS[1])
              2 -> alias = readString(RESPONSE_FIELDS[2])
              else -> break
            }
          }
          TestQuery.Data.TypeWithGraphQLKeyword(
            on = on,
            null_ = null_,
            alias = alias
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: TestQuery.Data.TypeWithGraphQLKeyword) {
        writer.writeString(RESPONSE_FIELDS[0], value.on)
        writer.writeString(RESPONSE_FIELDS[1], value.null_)
        writer.writeString(RESPONSE_FIELDS[2], value.alias)
      }
    }
  }
}
