// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_simple.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.arguments_simple.fragment.HeroDetailsImpl
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object HeroDetailsImpl_ResponseAdapter : ResponseAdapter<HeroDetailsImpl.Data> {
  val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
      responseName = "__typename",
      fieldName = "__typename",
      arguments = emptyMap(),
      conditions = emptyList(),
      possibleFieldSets = emptyMap(),
    ),
    ResponseField(
      type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
      responseName = "friendsConnection",
      fieldName = "friendsConnection",
      arguments = mapOf<String, Any?>(
        "first" to mapOf<String, Any?>(
          "kind" to "Variable",
          "variableName" to "friendsCount")),
      conditions = emptyList(),
      possibleFieldSets = mapOf(
        "" to FriendsConnection.RESPONSE_FIELDS
      ),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HeroDetailsImpl.Data {
    return reader.run {
      var __typename: String? = __typename
      var friendsConnection: HeroDetailsImpl.Data.FriendsConnection? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> friendsConnection = readObject<HeroDetailsImpl.Data.FriendsConnection>(RESPONSE_FIELDS[1]) { reader ->
            FriendsConnection.fromResponse(reader)
          }
          else -> break
        }
      }
      HeroDetailsImpl.Data(
        __typename = __typename!!,
        friendsConnection = friendsConnection!!
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeObject(RESPONSE_FIELDS[1]) { writer ->
      FriendsConnection.toResponse(writer, value.friendsConnection)
    }
  }

  object FriendsConnection : ResponseAdapter<HeroDetailsImpl.Data.FriendsConnection> {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.Named.Other("Int"),
        responseName = "totalCount",
        fieldName = "totalCount",
        arguments = emptyMap(),
        conditions = emptyList(),
        possibleFieldSets = emptyMap(),
      ),
      ResponseField(
        type = ResponseField.Type.List(ResponseField.Type.Named.Object("FriendsEdge")),
        responseName = "edges",
        fieldName = "edges",
        arguments = emptyMap(),
        conditions = emptyList(),
        possibleFieldSets = mapOf(
          "" to Edge.RESPONSE_FIELDS
        ),
      )
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HeroDetailsImpl.Data.FriendsConnection {
      return reader.run {
        var totalCount: Int? = null
        var edges: List<HeroDetailsImpl.Data.FriendsConnection.Edge?>? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> totalCount = readInt(RESPONSE_FIELDS[0])
            1 -> edges = readList<HeroDetailsImpl.Data.FriendsConnection.Edge>(RESPONSE_FIELDS[1]) { reader ->
              reader.readObject<HeroDetailsImpl.Data.FriendsConnection.Edge> { reader ->
                Edge.fromResponse(reader)
              }
            }
            else -> break
          }
        }
        HeroDetailsImpl.Data.FriendsConnection(
          totalCount = totalCount,
          edges = edges
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Data.FriendsConnection) {
      writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
      writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
        listItemWriter.writeObject { writer ->
          Edge.toResponse(writer, value)
        }
      }
    }

    object Edge : ResponseAdapter<HeroDetailsImpl.Data.FriendsConnection.Edge> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.Named.Object("Character"),
          responseName = "node",
          fieldName = "node",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = mapOf(
            "" to Node.RESPONSE_FIELDS
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Data.FriendsConnection.Edge {
        return reader.run {
          var node: HeroDetailsImpl.Data.FriendsConnection.Edge.Node? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> node = readObject<HeroDetailsImpl.Data.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                Node.fromResponse(reader)
              }
              else -> break
            }
          }
          HeroDetailsImpl.Data.FriendsConnection.Edge(
            node = node
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: HeroDetailsImpl.Data.FriendsConnection.Edge) {
        if(value.node == null) {
          writer.writeObject(RESPONSE_FIELDS[0], null)
        } else {
          writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
            Node.toResponse(writer, value.node)
          }
        }
      }

      object Node : ResponseAdapter<HeroDetailsImpl.Data.FriendsConnection.Edge.Node> {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.Named.Other("String"),
            responseName = "name",
            fieldName = "name",
            arguments = emptyMap(),
            conditions = listOf(
              ResponseField.Condition.booleanCondition("IncludeName", false)
            ),
            possibleFieldSets = emptyMap(),
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            HeroDetailsImpl.Data.FriendsConnection.Edge.Node {
          return reader.run {
            var name: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> name = readString(RESPONSE_FIELDS[0])
                else -> break
              }
            }
            HeroDetailsImpl.Data.FriendsConnection.Edge.Node(
              name = name
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: HeroDetailsImpl.Data.FriendsConnection.Edge.Node) {
          writer.writeString(RESPONSE_FIELDS[0], value.name)
        }
      }
    }
  }
}
