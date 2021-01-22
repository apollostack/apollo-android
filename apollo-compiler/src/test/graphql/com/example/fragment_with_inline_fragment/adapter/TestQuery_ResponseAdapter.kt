// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_with_inline_fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.fragment_with_inline_fragment.TestQuery
import com.example.fragment_with_inline_fragment.type.Episode
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.Named.Object("Character"),
      responseName = "hero",
      fieldName = "hero",
      arguments = emptyMap(),
      conditions = emptyList(),
      possibleFieldSets = mapOf(
        "Droid" to Hero.CharacterDroidHero.RESPONSE_FIELDS,
        "Human" to Hero.CharacterHumanHero.RESPONSE_FIELDS,
      ),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var hero: TestQuery.Data.Hero? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> hero = readObject<TestQuery.Data.Hero>(RESPONSE_FIELDS[0]) { reader ->
            Hero.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        hero = hero
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        Hero.toResponse(writer, value.hero)
      }
    }
  }

  object Hero : ResponseAdapter<TestQuery.Data.Hero> {
<<<<<<< HEAD
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        responseName = "__typename",
        fieldName = "__typename",
        arguments = emptyMap(),
        conditions = emptyList(),
        fields = emptyArray(),
      ),
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        responseName = "name",
        fieldName = "name",
        arguments = emptyMap(),
        conditions = emptyList(),
        fields = emptyArray(),
      ),
      ResponseField(
        type =
            ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
        responseName = "appearsIn",
        fieldName = "appearsIn",
        arguments = emptyMap(),
        conditions = emptyList(),
        fields = emptyArray(),
      )
    )

=======
>>>>>>> 59f0461fb... fix field sets for types with multiple implementations
    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Hero {
      val typename = __typename ?: reader.readString(ResponseField.Typename)
      return when(typename) {
        "Droid" -> CharacterDroidHero.fromResponse(reader, typename)
        "Human" -> CharacterHumanHero.fromResponse(reader, typename)
        else -> OtherHero.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero) {
      when(value) {
        is TestQuery.Data.Hero.CharacterDroidHero -> CharacterDroidHero.toResponse(writer, value)
        is TestQuery.Data.Hero.CharacterHumanHero -> CharacterHumanHero.toResponse(writer, value)
        is TestQuery.Data.Hero.OtherHero -> OtherHero.toResponse(writer, value)
      }
    }

    object CharacterDroidHero : ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero> {
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
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type =
              ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
          responseName = "appearsIn",
          fieldName = "appearsIn",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
          responseName = "friendsConnection",
          fieldName = "friendsConnection",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = mapOf(
            "" to FriendsConnection.RESPONSE_FIELDS
          ),
        ),
        ResponseField(
          type = ResponseField.Type.Named.Other("String"),
          responseName = "primaryFunction",
          fieldName = "primaryFunction",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.CharacterDroidHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var appearsIn: List<Episode?>? = null
          var friendsConnection: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection? = null
          var primaryFunction: String? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
                Episode.safeValueOf(reader.readString())
              }
              3 -> friendsConnection = readObject<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection>(RESPONSE_FIELDS[3]) { reader ->
                FriendsConnection.fromResponse(reader)
              }
              4 -> primaryFunction = readString(RESPONSE_FIELDS[4])
              else -> break
            }
          }
          TestQuery.Data.Hero.CharacterDroidHero(
            __typename = __typename!!,
            name = name!!,
            appearsIn = appearsIn!!,
            friendsConnection = friendsConnection!!,
            primaryFunction = primaryFunction
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: TestQuery.Data.Hero.CharacterDroidHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { value, listItemWriter ->
          listItemWriter.writeString(value?.rawValue)}
        writer.writeObject(RESPONSE_FIELDS[3]) { writer ->
          FriendsConnection.toResponse(writer, value.friendsConnection)
        }
        writer.writeString(RESPONSE_FIELDS[4], value.primaryFunction)
      }

      object FriendsConnection :
          ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection> {
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
            TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection {
          return reader.run {
            var totalCount: Int? = null
            var edges: List<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge?>? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> totalCount = readInt(RESPONSE_FIELDS[0])
                1 -> edges = readList<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge>(RESPONSE_FIELDS[1]) { reader ->
                  reader.readObject<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge> { reader ->
                    Edge.fromResponse(reader)
                  }
                }
                else -> break
              }
            }
            TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection(
              totalCount = totalCount,
              edges = edges
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection) {
          writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
          writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
            listItemWriter.writeObject { writer ->
              Edge.toResponse(writer, value)
            }
          }
        }

        object Edge : ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge>
            {
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
              TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge {
            return reader.run {
              var node: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge.Node? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> node = readObject<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                    Node.fromResponse(reader)
                  }
                  else -> break
                }
              }
              TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge(
                node = node
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge) {
            if(value.node == null) {
              writer.writeObject(RESPONSE_FIELDS[0], null)
            } else {
              writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
                Node.toResponse(writer, value.node)
              }
            }
          }

          object Node :
              ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge.Node> {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                responseName = "name",
                fieldName = "name",
                arguments = emptyMap(),
                conditions = emptyList(),
                possibleFieldSets = emptyMap(),
              )
            )

            override fun fromResponse(reader: ResponseReader, __typename: String?):
                TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge.Node {
              return reader.run {
                var name: String? = null
                while(true) {
                  when (selectField(RESPONSE_FIELDS)) {
                    0 -> name = readString(RESPONSE_FIELDS[0])
                    else -> break
                  }
                }
                TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge.Node(
                  name = name!!
                )
              }
            }

            override fun toResponse(writer: ResponseWriter,
                value: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edge.Node) {
              writer.writeString(RESPONSE_FIELDS[0], value.name)
            }
          }
        }
      }
    }

    object CharacterHumanHero : ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero> {
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
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type =
              ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
          responseName = "appearsIn",
          fieldName = "appearsIn",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
          responseName = "friendsConnection",
          fieldName = "friendsConnection",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = mapOf(
            "" to FriendsConnection.RESPONSE_FIELDS
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.CharacterHumanHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var appearsIn: List<Episode?>? = null
          var friendsConnection: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
                Episode.safeValueOf(reader.readString())
              }
              3 -> friendsConnection = readObject<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection>(RESPONSE_FIELDS[3]) { reader ->
                FriendsConnection.fromResponse(reader)
              }
              else -> break
            }
          }
          TestQuery.Data.Hero.CharacterHumanHero(
            __typename = __typename!!,
            name = name!!,
            appearsIn = appearsIn!!,
            friendsConnection = friendsConnection!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: TestQuery.Data.Hero.CharacterHumanHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { value, listItemWriter ->
          listItemWriter.writeString(value?.rawValue)}
        writer.writeObject(RESPONSE_FIELDS[3]) { writer ->
          FriendsConnection.toResponse(writer, value.friendsConnection)
        }
      }

      object FriendsConnection :
          ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection> {
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
            TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection {
          return reader.run {
            var totalCount: Int? = null
            var edges: List<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge?>? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> totalCount = readInt(RESPONSE_FIELDS[0])
                1 -> edges = readList<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge>(RESPONSE_FIELDS[1]) { reader ->
                  reader.readObject<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge> { reader ->
                    Edge.fromResponse(reader)
                  }
                }
                else -> break
              }
            }
            TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection(
              totalCount = totalCount,
              edges = edges
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection) {
          writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
          writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
            listItemWriter.writeObject { writer ->
              Edge.toResponse(writer, value)
            }
          }
        }

        object Edge : ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge>
            {
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
              TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge {
            return reader.run {
              var node: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge.Node? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> node = readObject<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                    Node.fromResponse(reader)
                  }
                  else -> break
                }
              }
              TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge(
                node = node
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge) {
            if(value.node == null) {
              writer.writeObject(RESPONSE_FIELDS[0], null)
            } else {
              writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
                Node.toResponse(writer, value.node)
              }
            }
          }

          object Node :
              ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge.Node> {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                responseName = "name",
                fieldName = "name",
                arguments = emptyMap(),
                conditions = emptyList(),
                possibleFieldSets = emptyMap(),
              )
            )

            override fun fromResponse(reader: ResponseReader, __typename: String?):
                TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge.Node {
              return reader.run {
                var name: String? = null
                while(true) {
                  when (selectField(RESPONSE_FIELDS)) {
                    0 -> name = readString(RESPONSE_FIELDS[0])
                    else -> break
                  }
                }
                TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge.Node(
                  name = name!!
                )
              }
            }

            override fun toResponse(writer: ResponseWriter,
                value: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edge.Node) {
              writer.writeString(RESPONSE_FIELDS[0], value.name)
            }
          }
        }
      }
    }

    object OtherHero : ResponseAdapter<TestQuery.Data.Hero.OtherHero> {
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
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type =
              ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
          responseName = "appearsIn",
          fieldName = "appearsIn",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.OtherHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var appearsIn: List<Episode?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
                Episode.safeValueOf(reader.readString())
              }
              else -> break
            }
          }
          TestQuery.Data.Hero.OtherHero(
            __typename = __typename!!,
            name = name!!,
            appearsIn = appearsIn!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.OtherHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { value, listItemWriter ->
          listItemWriter.writeString(value?.rawValue)}
      }
    }
  }
}
