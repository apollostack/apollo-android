// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.unique_type_name.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.unique_type_name.HeroDetailQuery
import com.example.unique_type_name.type.Episode
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object HeroDetailQuery_ResponseAdapter : ResponseAdapter<HeroDetailQuery.Data> {
  val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.Named.Object("Character"),
      responseName = "heroDetailQuery",
      fieldName = "heroDetailQuery",
      arguments = emptyMap(),
      conditions = emptyList(),
      possibleFieldSets = mapOf(
        "Human" to HeroDetailQuery.HumanHeroDetailQuery.RESPONSE_FIELDS,
        "" to HeroDetailQuery.OtherHeroDetailQuery.RESPONSE_FIELDS,
      ),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?):
      com.example.unique_type_name.HeroDetailQuery.Data {
    return reader.run {
      var heroDetailQuery: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> heroDetailQuery = readObject<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery>(RESPONSE_FIELDS[0]) { reader ->
            HeroDetailQuery.fromResponse(reader)
          }
          else -> break
        }
      }
      com.example.unique_type_name.HeroDetailQuery.Data(
        heroDetailQuery = heroDetailQuery
      )
    }
  }

  override fun toResponse(writer: ResponseWriter,
      value: com.example.unique_type_name.HeroDetailQuery.Data) {
    if(value.heroDetailQuery == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        HeroDetailQuery.toResponse(writer, value.heroDetailQuery)
      }
    }
  }

  object HeroDetailQuery :
      ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery> {
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
        type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
        responseName = "friends",
        fieldName = "friends",
        arguments = emptyMap(),
        conditions = emptyList(),
        fields = HeroDetailQuery.Friend.RESPONSE_FIELDS,
      )
    )

=======
>>>>>>> 59f0461fb... fix field sets for types with multiple implementations
    override fun fromResponse(reader: ResponseReader, __typename: String?):
        com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery {
      val typename = __typename ?: reader.readString(ResponseField.Typename)
      return when(typename) {
        "Human" -> HumanHeroDetailQuery.fromResponse(reader, typename)
        else -> OtherHeroDetailQuery.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter,
        value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery) {
      when(value) {
        is com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery -> HumanHeroDetailQuery.toResponse(writer, value)
        is com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery -> OtherHeroDetailQuery.toResponse(writer, value)
      }
    }

    object HumanHeroDetailQuery :
        ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery>
        {
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
          type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
          responseName = "friends",
          fieldName = "friends",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = mapOf(
            "" to Friend.RESPONSE_FIELDS
          ),
        ),
        ResponseField(
          type = ResponseField.Type.Named.Other("Float"),
          responseName = "height",
          fieldName = "height",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var friends: List<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend?>? = null
          var height: Double? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> friends = readList<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend>(RESPONSE_FIELDS[2]) { reader ->
                reader.readObject<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend> { reader ->
                  Friend.fromResponse(reader)
                }
              }
              3 -> height = readDouble(RESPONSE_FIELDS[3])
              else -> break
            }
          }
          com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery(
            __typename = __typename!!,
            name = name!!,
            friends = friends,
            height = height
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.friends) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Friend.toResponse(writer, value)
          }
        }
        writer.writeDouble(RESPONSE_FIELDS[3], value.height)
      }

      object Friend :
          ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend>
          {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
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
            type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
            responseName = "friends",
            fieldName = "friends",
            arguments = emptyMap(),
            conditions = emptyList(),
            possibleFieldSets = mapOf(
              "Droid" to Friend.CharacterFriend.RESPONSE_FIELDS,
              "Human" to Friend.CharacterFriend.RESPONSE_FIELDS,
              "" to Friend.OtherFriend.RESPONSE_FIELDS,
            ),
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend {
          return reader.run {
            var name: String? = null
            var appearsIn: List<Episode?>? = null
            var friends: List<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend?>? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> name = readString(RESPONSE_FIELDS[0])
                1 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[1]) { reader ->
                  Episode.safeValueOf(reader.readString())
                }
                2 -> friends = readList<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend>(RESPONSE_FIELDS[2]) { reader ->
                  reader.readObject<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend> { reader ->
                    Friend.fromResponse(reader)
                  }
                }
                else -> break
              }
            }
            com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend(
              name = name!!,
              appearsIn = appearsIn!!,
              friends = friends
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend) {
          writer.writeString(RESPONSE_FIELDS[0], value.name)
          writer.writeList(RESPONSE_FIELDS[1], value.appearsIn) { value, listItemWriter ->
            listItemWriter.writeString(value?.rawValue)}
          writer.writeList(RESPONSE_FIELDS[2], value.friends) { value, listItemWriter ->
            listItemWriter.writeObject { writer ->
              Friend.toResponse(writer, value)
            }
          }
        }

        object Friend :
            ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend>
            {
<<<<<<< HEAD
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
              responseName = "__typename",
              fieldName = "__typename",
              arguments = emptyMap(),
              conditions = emptyList(),
              fields = emptyArray(),
            )
          )

=======
>>>>>>> 59f0461fb... fix field sets for types with multiple implementations
          override fun fromResponse(reader: ResponseReader, __typename: String?):
              com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend {
            val typename = __typename ?: reader.readString(ResponseField.Typename)
            return when(typename) {
              "Droid" -> CharacterFriend.fromResponse(reader, typename)
              "Human" -> CharacterFriend.fromResponse(reader, typename)
              else -> OtherFriend.fromResponse(reader, typename)
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend) {
            when(value) {
              is com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend -> CharacterFriend.toResponse(writer, value)
              is com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.OtherFriend -> OtherFriend.toResponse(writer, value)
            }
          }

          object CharacterFriend :
              ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend>
              {
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
                    ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
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
                com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend {
              return reader.run {
                var __typename: String? = __typename
                var name: String? = null
                var friendsConnection: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection? = null
                while(true) {
                  when (selectField(RESPONSE_FIELDS)) {
                    0 -> __typename = readString(RESPONSE_FIELDS[0])
                    1 -> name = readString(RESPONSE_FIELDS[1])
                    2 -> friendsConnection = readObject<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection>(RESPONSE_FIELDS[2]) { reader ->
                      FriendsConnection.fromResponse(reader)
                    }
                    else -> break
                  }
                }
                com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend(
                  __typename = __typename!!,
                  name = name!!,
                  friendsConnection = friendsConnection!!
                )
              }
            }

            override fun toResponse(writer: ResponseWriter,
                value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend) {
              writer.writeString(RESPONSE_FIELDS[0], value.__typename)
              writer.writeString(RESPONSE_FIELDS[1], value.name)
              writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
                FriendsConnection.toResponse(writer, value.friendsConnection)
              }
            }

            object FriendsConnection :
                ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection>
                {
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
                  com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection {
                return reader.run {
                  var totalCount: Int? = null
                  var edges: List<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge?>? = null
                  while(true) {
                    when (selectField(RESPONSE_FIELDS)) {
                      0 -> totalCount = readInt(RESPONSE_FIELDS[0])
                      1 -> edges = readList<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge>(RESPONSE_FIELDS[1]) { reader ->
                        reader.readObject<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge> { reader ->
                          Edge.fromResponse(reader)
                        }
                      }
                      else -> break
                    }
                  }
                  com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection(
                    totalCount = totalCount,
                    edges = edges
                  )
                }
              }

              override fun toResponse(writer: ResponseWriter,
                  value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection) {
                writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
                writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
                  listItemWriter.writeObject { writer ->
                    Edge.toResponse(writer, value)
                  }
                }
              }

              object Edge :
                  ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge>
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
                    com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge {
                  return reader.run {
                    var node: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.Node? = null
                    while(true) {
                      when (selectField(RESPONSE_FIELDS)) {
                        0 -> node = readObject<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                          Node.fromResponse(reader)
                        }
                        else -> break
                      }
                    }
                    com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge(
                      node = node
                    )
                  }
                }

                override fun toResponse(writer: ResponseWriter,
                    value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge) {
                  if(value.node == null) {
                    writer.writeObject(RESPONSE_FIELDS[0], null)
                  } else {
                    writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
                      Node.toResponse(writer, value.node)
                    }
                  }
                }

                object Node :
                    ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.Node>
                    {
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
                      com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.Node {
                    return reader.run {
                      var name: String? = null
                      while(true) {
                        when (selectField(RESPONSE_FIELDS)) {
                          0 -> name = readString(RESPONSE_FIELDS[0])
                          else -> break
                        }
                      }
                      com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.Node(
                        name = name!!
                      )
                    }
                  }

                  override fun toResponse(writer: ResponseWriter,
                      value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.CharacterFriend.FriendsConnection.Edge.Node) {
                    writer.writeString(RESPONSE_FIELDS[0], value.name)
                  }
                }
              }
            }
          }

          object OtherFriend :
              ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.OtherFriend>
              {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                responseName = "__typename",
                fieldName = "__typename",
                arguments = emptyMap(),
                conditions = emptyList(),
                possibleFieldSets = emptyMap(),
              )
            )

            override fun fromResponse(reader: ResponseReader, __typename: String?):
                com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.OtherFriend {
              return reader.run {
                var __typename: String? = __typename
                while(true) {
                  when (selectField(RESPONSE_FIELDS)) {
                    0 -> __typename = readString(RESPONSE_FIELDS[0])
                    else -> break
                  }
                }
                com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.OtherFriend(
                  __typename = __typename!!
                )
              }
            }

            override fun toResponse(writer: ResponseWriter,
                value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.HumanHeroDetailQuery.Friend.Friend.OtherFriend) {
              writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            }
          }
        }
      }
    }

    object OtherHeroDetailQuery :
        ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery>
        {
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
          type = ResponseField.Type.List(ResponseField.Type.Named.Object("Character")),
          responseName = "friends",
          fieldName = "friends",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = mapOf(
            "" to Friend.RESPONSE_FIELDS
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var friends: List<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> friends = readList<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend>(RESPONSE_FIELDS[2]) { reader ->
                reader.readObject<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend> { reader ->
                  Friend.fromResponse(reader)
                }
              }
              else -> break
            }
          }
          com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery(
            __typename = __typename!!,
            name = name!!,
            friends = friends
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.friends) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Friend.toResponse(writer, value)
          }
        }
      }

      object Friend :
          ResponseAdapter<com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend>
          {
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
            com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend {
          return reader.run {
            var name: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> name = readString(RESPONSE_FIELDS[0])
                else -> break
              }
            }
            com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend(
              name = name!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: com.example.unique_type_name.HeroDetailQuery.Data.HeroDetailQuery.OtherHeroDetailQuery.Friend) {
          writer.writeString(RESPONSE_FIELDS[0], value.name)
        }
      }
    }
  }
}
