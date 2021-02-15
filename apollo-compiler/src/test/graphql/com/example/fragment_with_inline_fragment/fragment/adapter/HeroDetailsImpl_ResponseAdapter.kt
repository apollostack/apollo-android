// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_with_inline_fragment.fragment.adapter

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ListResponseAdapter
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.intResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.fragment_with_inline_fragment.fragment.HeroDetailsImpl
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class HeroDetailsImpl_ResponseAdapter(
  customScalarAdapters: CustomScalarAdapters
) : ResponseAdapter<HeroDetailsImpl.Data> {
  val DroidDataAdapter: DroidData =
      com.example.fragment_with_inline_fragment.fragment.adapter.HeroDetailsImpl_ResponseAdapter.DroidData(customScalarAdapters)

  val HumanDataAdapter: HumanData =
      com.example.fragment_with_inline_fragment.fragment.adapter.HeroDetailsImpl_ResponseAdapter.HumanData(customScalarAdapters)

  val OtherDataAdapter: OtherData =
      com.example.fragment_with_inline_fragment.fragment.adapter.HeroDetailsImpl_ResponseAdapter.OtherData(customScalarAdapters)

  override fun fromResponse(reader: JsonReader): HeroDetailsImpl.Data {
    reader.beginObject()
    check(reader.nextName() == "__typename")
    val typename = reader.nextString()

    return when(typename) {
      "Droid" -> DroidDataAdapter.fromResponse(reader, typename)
      "Human" -> HumanDataAdapter.fromResponse(reader, typename)
      else -> OtherDataAdapter.fromResponse(reader, typename)
    }
    .also { reader.endObject() }
  }

  override fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data) {
    when(value) {
      is HeroDetailsImpl.Data.DroidData -> DroidDataAdapter.toResponse(writer, value)
      is HeroDetailsImpl.Data.HumanData -> HumanDataAdapter.toResponse(writer, value)
      is HeroDetailsImpl.Data.OtherData -> OtherDataAdapter.toResponse(writer, value)
    }
  }

  class DroidData(
    customScalarAdapters: CustomScalarAdapters
  ) {
    val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

    val friendsConnectionAdapter: ResponseAdapter<HeroDetailsImpl.Data.DroidData.FriendsConnection>
        = FriendsConnection(customScalarAdapters)

    val nullableStringAdapter: ResponseAdapter<String?> =
        NullableResponseAdapter(stringResponseAdapter)

    fun fromResponse(reader: JsonReader, __typename: String?): HeroDetailsImpl.Data.DroidData {
      var __typename: String? = __typename
      var name: String? = null
      var friendsConnection: HeroDetailsImpl.Data.DroidData.FriendsConnection? = null
      var primaryFunction: String? = null
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = stringAdapter.fromResponse(reader)
          1 -> name = stringAdapter.fromResponse(reader)
          2 -> friendsConnection = friendsConnectionAdapter.fromResponse(reader)
          3 -> primaryFunction = nullableStringAdapter.fromResponse(reader)
          else -> break
        }
      }
      return HeroDetailsImpl.Data.DroidData(
        __typename = __typename!!,
        name = name!!,
        friendsConnection = friendsConnection!!,
        primaryFunction = primaryFunction
      )
    }

    fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data.DroidData) {
      writer.beginObject()
      writer.name("__typename")
      stringAdapter.toResponse(writer, value.__typename)
      writer.name("name")
      stringAdapter.toResponse(writer, value.name)
      writer.name("friendsConnection")
      friendsConnectionAdapter.toResponse(writer, value.friendsConnection)
      writer.name("primaryFunction")
      nullableStringAdapter.toResponse(writer, value.primaryFunction)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.Typename,
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "name",
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
          fieldName = "friendsConnection",
          fieldSets = listOf(
<<<<<<< HEAD
            ResponseField.FieldSet(null, FriendsConnection.RESPONSE_FIELDS)
=======
            ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
>>>>>>> dev-3.x
          ),
        ),
        ResponseField(
          type = ResponseField.Type.Named.Other("String"),
          fieldName = "primaryFunction",
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }

    class FriendsConnection(
      customScalarAdapters: CustomScalarAdapters
    ) : ResponseAdapter<HeroDetailsImpl.Data.DroidData.FriendsConnection> {
      val nullableIntAdapter: ResponseAdapter<Int?> = NullableResponseAdapter(intResponseAdapter)

      val nullableListOfNullableEdgesAdapter:
          ResponseAdapter<List<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges?>?> =
          NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Edges(customScalarAdapters))))

      override fun fromResponse(reader: JsonReader):
          HeroDetailsImpl.Data.DroidData.FriendsConnection {
<<<<<<< HEAD
        var totalCount: Int? = null
        var edges: List<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges?>? = null
        reader.beginObject()
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> totalCount = nullableIntAdapter.fromResponse(reader)
            1 -> edges = nullableListOfNullableEdgesAdapter.fromResponse(reader)
            else -> break
=======
        return reader.run {
          var totalCount: Int? = null
          var edges: List<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> totalCount = readInt(RESPONSE_FIELDS[0])
              1 -> edges = readList<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges>(RESPONSE_FIELDS[1]) { reader ->
                reader.readObject<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges> { reader ->
                  Edges.fromResponse(reader)
                }
              }
              else -> break
            }
>>>>>>> dev-3.x
          }
        }
        reader.endObject()
        return HeroDetailsImpl.Data.DroidData.FriendsConnection(
          totalCount = totalCount,
          edges = edges
        )
      }

      override fun toResponse(writer: JsonWriter,
          value: HeroDetailsImpl.Data.DroidData.FriendsConnection) {
<<<<<<< HEAD
        writer.beginObject()
        writer.name("totalCount")
        nullableIntAdapter.toResponse(writer, value.totalCount)
        writer.name("edges")
        nullableListOfNullableEdgesAdapter.toResponse(writer, value.edges)
        writer.endObject()
      }

      companion object {
=======
        writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
        writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Edges.toResponse(writer, value)
          }
        }
      }

      object Edges : ResponseAdapter<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges> {
>>>>>>> dev-3.x
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.Named.Other("Int"),
            fieldName = "totalCount",
          ),
          ResponseField(
            type = ResponseField.Type.List(ResponseField.Type.Named.Object("FriendsEdge")),
            fieldName = "edges",
            fieldSets = listOf(
              ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
            ),
          )
        )

<<<<<<< HEAD
        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }

      class Edges(
        customScalarAdapters: CustomScalarAdapters
      ) : ResponseAdapter<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges> {
        val nullableNodeAdapter:
            ResponseAdapter<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node?> =
            NullableResponseAdapter(Node(customScalarAdapters))

        override fun fromResponse(reader: JsonReader):
            HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges {
          var node: HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node? = null
          reader.beginObject()
          while(true) {
            when (reader.selectName(RESPONSE_NAMES)) {
              0 -> node = nullableNodeAdapter.fromResponse(reader)
              else -> break
            }
=======
        override fun fromResponse(reader: ResponseReader, __typename: String?):
            HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges {
          return reader.run {
            var node: HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> node = readObject<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node>(RESPONSE_FIELDS[0]) { reader ->
                  Node.fromResponse(reader)
                }
                else -> break
              }
            }
            HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges(
              node = node
            )
>>>>>>> dev-3.x
          }
          reader.endObject()
          return HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges(
            node = node
          )
        }

<<<<<<< HEAD
        override fun toResponse(writer: JsonWriter,
            value: HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges) {
          writer.beginObject()
          writer.name("node")
          nullableNodeAdapter.toResponse(writer, value.node)
          writer.endObject()
        }

        companion object {
=======
        override fun toResponse(writer: ResponseWriter,
            value: HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges) {
          if(value.node == null) {
            writer.writeObject(RESPONSE_FIELDS[0], null)
          } else {
            writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
              Node.toResponse(writer, value.node)
            }
          }
        }

        object Node : ResponseAdapter<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node> {
>>>>>>> dev-3.x
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.Named.Object("Character"),
              fieldName = "node",
              fieldSets = listOf(
                ResponseField.FieldSet(null, Node.RESPONSE_FIELDS)
              ),
            )
          )

<<<<<<< HEAD
          val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
        }

        class Node(
          customScalarAdapters: CustomScalarAdapters
        ) : ResponseAdapter<HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node> {
          val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

          override fun fromResponse(reader: JsonReader):
              HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node {
            var name: String? = null
            reader.beginObject()
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> name = stringAdapter.fromResponse(reader)
                else -> break
              }
=======
          override fun fromResponse(reader: ResponseReader, __typename: String?):
              HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node {
            return reader.run {
              var name: String? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> name = readString(RESPONSE_FIELDS[0])
                  else -> break
                }
              }
              HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node(
                name = name!!
              )
>>>>>>> dev-3.x
            }
            reader.endObject()
            return HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node(
              name = name!!
            )
          }

<<<<<<< HEAD
          override fun toResponse(writer: JsonWriter,
              value: HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node) {
            writer.beginObject()
            writer.name("name")
            stringAdapter.toResponse(writer, value.name)
            writer.endObject()
          }

          companion object {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                fieldName = "name",
              )
            )

            val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
=======
          override fun toResponse(writer: ResponseWriter,
              value: HeroDetailsImpl.Data.DroidData.FriendsConnection.Edges.Node) {
            writer.writeString(RESPONSE_FIELDS[0], value.name)
>>>>>>> dev-3.x
          }
        }
      }
    }
  }

  class HumanData(
    customScalarAdapters: CustomScalarAdapters
  ) {
    val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

    val friendsConnectionAdapter: ResponseAdapter<HeroDetailsImpl.Data.HumanData.FriendsConnection>
        = FriendsConnection(customScalarAdapters)

    fun fromResponse(reader: JsonReader, __typename: String?): HeroDetailsImpl.Data.HumanData {
      var __typename: String? = __typename
      var name: String? = null
      var friendsConnection: HeroDetailsImpl.Data.HumanData.FriendsConnection? = null
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = stringAdapter.fromResponse(reader)
          1 -> name = stringAdapter.fromResponse(reader)
          2 -> friendsConnection = friendsConnectionAdapter.fromResponse(reader)
          else -> break
        }
      }
      return HeroDetailsImpl.Data.HumanData(
        __typename = __typename!!,
        name = name!!,
        friendsConnection = friendsConnection!!
      )
    }

    fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data.HumanData) {
      writer.beginObject()
      writer.name("__typename")
      stringAdapter.toResponse(writer, value.__typename)
      writer.name("name")
      stringAdapter.toResponse(writer, value.name)
      writer.name("friendsConnection")
      friendsConnectionAdapter.toResponse(writer, value.friendsConnection)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.Typename,
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "name",
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
          fieldName = "friendsConnection",
          fieldSets = listOf(
<<<<<<< HEAD
            ResponseField.FieldSet(null, FriendsConnection.RESPONSE_FIELDS)
=======
            ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
>>>>>>> dev-3.x
          ),
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }

    class FriendsConnection(
      customScalarAdapters: CustomScalarAdapters
    ) : ResponseAdapter<HeroDetailsImpl.Data.HumanData.FriendsConnection> {
      val nullableIntAdapter: ResponseAdapter<Int?> = NullableResponseAdapter(intResponseAdapter)

      val nullableListOfNullableEdgesAdapter:
          ResponseAdapter<List<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges?>?> =
          NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Edges(customScalarAdapters))))

      override fun fromResponse(reader: JsonReader):
          HeroDetailsImpl.Data.HumanData.FriendsConnection {
<<<<<<< HEAD
        var totalCount: Int? = null
        var edges: List<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges?>? = null
        reader.beginObject()
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> totalCount = nullableIntAdapter.fromResponse(reader)
            1 -> edges = nullableListOfNullableEdgesAdapter.fromResponse(reader)
            else -> break
=======
        return reader.run {
          var totalCount: Int? = null
          var edges: List<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> totalCount = readInt(RESPONSE_FIELDS[0])
              1 -> edges = readList<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges>(RESPONSE_FIELDS[1]) { reader ->
                reader.readObject<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges> { reader ->
                  Edges.fromResponse(reader)
                }
              }
              else -> break
            }
>>>>>>> dev-3.x
          }
        }
        reader.endObject()
        return HeroDetailsImpl.Data.HumanData.FriendsConnection(
          totalCount = totalCount,
          edges = edges
        )
      }

      override fun toResponse(writer: JsonWriter,
          value: HeroDetailsImpl.Data.HumanData.FriendsConnection) {
<<<<<<< HEAD
        writer.beginObject()
        writer.name("totalCount")
        nullableIntAdapter.toResponse(writer, value.totalCount)
        writer.name("edges")
        nullableListOfNullableEdgesAdapter.toResponse(writer, value.edges)
        writer.endObject()
      }

      companion object {
=======
        writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
        writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Edges.toResponse(writer, value)
          }
        }
      }

      object Edges : ResponseAdapter<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges> {
>>>>>>> dev-3.x
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.Named.Other("Int"),
            fieldName = "totalCount",
          ),
          ResponseField(
            type = ResponseField.Type.List(ResponseField.Type.Named.Object("FriendsEdge")),
            fieldName = "edges",
            fieldSets = listOf(
              ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
            ),
          )
        )

<<<<<<< HEAD
        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }

      class Edges(
        customScalarAdapters: CustomScalarAdapters
      ) : ResponseAdapter<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges> {
        val nullableNodeAdapter:
            ResponseAdapter<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node?> =
            NullableResponseAdapter(Node(customScalarAdapters))

        override fun fromResponse(reader: JsonReader):
            HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges {
          var node: HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node? = null
          reader.beginObject()
          while(true) {
            when (reader.selectName(RESPONSE_NAMES)) {
              0 -> node = nullableNodeAdapter.fromResponse(reader)
              else -> break
            }
=======
        override fun fromResponse(reader: ResponseReader, __typename: String?):
            HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges {
          return reader.run {
            var node: HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> node = readObject<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node>(RESPONSE_FIELDS[0]) { reader ->
                  Node.fromResponse(reader)
                }
                else -> break
              }
            }
            HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges(
              node = node
            )
>>>>>>> dev-3.x
          }
          reader.endObject()
          return HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges(
            node = node
          )
        }

<<<<<<< HEAD
        override fun toResponse(writer: JsonWriter,
            value: HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges) {
          writer.beginObject()
          writer.name("node")
          nullableNodeAdapter.toResponse(writer, value.node)
          writer.endObject()
        }

        companion object {
=======
        override fun toResponse(writer: ResponseWriter,
            value: HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges) {
          if(value.node == null) {
            writer.writeObject(RESPONSE_FIELDS[0], null)
          } else {
            writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
              Node.toResponse(writer, value.node)
            }
          }
        }

        object Node : ResponseAdapter<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node> {
>>>>>>> dev-3.x
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.Named.Object("Character"),
              fieldName = "node",
              fieldSets = listOf(
                ResponseField.FieldSet(null, Node.RESPONSE_FIELDS)
              ),
            )
          )

<<<<<<< HEAD
          val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
        }

        class Node(
          customScalarAdapters: CustomScalarAdapters
        ) : ResponseAdapter<HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node> {
          val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

          override fun fromResponse(reader: JsonReader):
              HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node {
            var name: String? = null
            reader.beginObject()
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> name = stringAdapter.fromResponse(reader)
                else -> break
              }
=======
          override fun fromResponse(reader: ResponseReader, __typename: String?):
              HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node {
            return reader.run {
              var name: String? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> name = readString(RESPONSE_FIELDS[0])
                  else -> break
                }
              }
              HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node(
                name = name!!
              )
>>>>>>> dev-3.x
            }
            reader.endObject()
            return HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node(
              name = name!!
            )
          }

          override fun toResponse(writer: JsonWriter,
              value: HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node) {
            writer.beginObject()
            writer.name("name")
            stringAdapter.toResponse(writer, value.name)
            writer.endObject()
          }

<<<<<<< HEAD
          companion object {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                fieldName = "name",
              )
            )

            val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
=======
          override fun toResponse(writer: ResponseWriter,
              value: HeroDetailsImpl.Data.HumanData.FriendsConnection.Edges.Node) {
            writer.writeString(RESPONSE_FIELDS[0], value.name)
>>>>>>> dev-3.x
          }
        }
      }
    }
  }

  class OtherData(
    customScalarAdapters: CustomScalarAdapters
  ) {
    val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

    val friendsConnectionAdapter: ResponseAdapter<HeroDetailsImpl.Data.OtherData.FriendsConnection>
        = FriendsConnection(customScalarAdapters)

    fun fromResponse(reader: JsonReader, __typename: String?): HeroDetailsImpl.Data.OtherData {
      var __typename: String? = __typename
      var name: String? = null
      var friendsConnection: HeroDetailsImpl.Data.OtherData.FriendsConnection? = null
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = stringAdapter.fromResponse(reader)
          1 -> name = stringAdapter.fromResponse(reader)
          2 -> friendsConnection = friendsConnectionAdapter.fromResponse(reader)
          else -> break
        }
      }
      return HeroDetailsImpl.Data.OtherData(
        __typename = __typename!!,
        name = name!!,
        friendsConnection = friendsConnection!!
      )
    }

    fun toResponse(writer: JsonWriter, value: HeroDetailsImpl.Data.OtherData) {
      writer.beginObject()
      writer.name("__typename")
      stringAdapter.toResponse(writer, value.__typename)
      writer.name("name")
      stringAdapter.toResponse(writer, value.name)
      writer.name("friendsConnection")
      friendsConnectionAdapter.toResponse(writer, value.friendsConnection)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.Typename,
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "name",
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
          fieldName = "friendsConnection",
          fieldSets = listOf(
<<<<<<< HEAD
            ResponseField.FieldSet(null, FriendsConnection.RESPONSE_FIELDS)
=======
            ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
>>>>>>> dev-3.x
          ),
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }

    class FriendsConnection(
      customScalarAdapters: CustomScalarAdapters
    ) : ResponseAdapter<HeroDetailsImpl.Data.OtherData.FriendsConnection> {
      val nullableIntAdapter: ResponseAdapter<Int?> = NullableResponseAdapter(intResponseAdapter)

      val nullableListOfNullableEdgesAdapter:
          ResponseAdapter<List<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges?>?> =
          NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Edges(customScalarAdapters))))

      override fun fromResponse(reader: JsonReader):
          HeroDetailsImpl.Data.OtherData.FriendsConnection {
<<<<<<< HEAD
        var totalCount: Int? = null
        var edges: List<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges?>? = null
        reader.beginObject()
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> totalCount = nullableIntAdapter.fromResponse(reader)
            1 -> edges = nullableListOfNullableEdgesAdapter.fromResponse(reader)
            else -> break
=======
        return reader.run {
          var totalCount: Int? = null
          var edges: List<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> totalCount = readInt(RESPONSE_FIELDS[0])
              1 -> edges = readList<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges>(RESPONSE_FIELDS[1]) { reader ->
                reader.readObject<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges> { reader ->
                  Edges.fromResponse(reader)
                }
              }
              else -> break
            }
>>>>>>> dev-3.x
          }
        }
        reader.endObject()
        return HeroDetailsImpl.Data.OtherData.FriendsConnection(
          totalCount = totalCount,
          edges = edges
        )
      }

      override fun toResponse(writer: JsonWriter,
          value: HeroDetailsImpl.Data.OtherData.FriendsConnection) {
<<<<<<< HEAD
        writer.beginObject()
        writer.name("totalCount")
        nullableIntAdapter.toResponse(writer, value.totalCount)
        writer.name("edges")
        nullableListOfNullableEdgesAdapter.toResponse(writer, value.edges)
        writer.endObject()
      }

      companion object {
=======
        writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
        writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Edges.toResponse(writer, value)
          }
        }
      }

      object Edges : ResponseAdapter<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges> {
>>>>>>> dev-3.x
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.Named.Other("Int"),
            fieldName = "totalCount",
          ),
          ResponseField(
            type = ResponseField.Type.List(ResponseField.Type.Named.Object("FriendsEdge")),
            fieldName = "edges",
            fieldSets = listOf(
              ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
            ),
          )
        )

<<<<<<< HEAD
        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }

      class Edges(
        customScalarAdapters: CustomScalarAdapters
      ) : ResponseAdapter<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges> {
        val nullableNodeAdapter:
            ResponseAdapter<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node?> =
            NullableResponseAdapter(Node(customScalarAdapters))

        override fun fromResponse(reader: JsonReader):
            HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges {
          var node: HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node? = null
          reader.beginObject()
          while(true) {
            when (reader.selectName(RESPONSE_NAMES)) {
              0 -> node = nullableNodeAdapter.fromResponse(reader)
              else -> break
            }
=======
        override fun fromResponse(reader: ResponseReader, __typename: String?):
            HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges {
          return reader.run {
            var node: HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> node = readObject<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node>(RESPONSE_FIELDS[0]) { reader ->
                  Node.fromResponse(reader)
                }
                else -> break
              }
            }
            HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges(
              node = node
            )
>>>>>>> dev-3.x
          }
          reader.endObject()
          return HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges(
            node = node
          )
        }

<<<<<<< HEAD
        override fun toResponse(writer: JsonWriter,
            value: HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges) {
          writer.beginObject()
          writer.name("node")
          nullableNodeAdapter.toResponse(writer, value.node)
          writer.endObject()
        }

        companion object {
=======
        override fun toResponse(writer: ResponseWriter,
            value: HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges) {
          if(value.node == null) {
            writer.writeObject(RESPONSE_FIELDS[0], null)
          } else {
            writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
              Node.toResponse(writer, value.node)
            }
          }
        }

        object Node : ResponseAdapter<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node> {
>>>>>>> dev-3.x
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.Named.Object("Character"),
              fieldName = "node",
              fieldSets = listOf(
                ResponseField.FieldSet(null, Node.RESPONSE_FIELDS)
              ),
            )
          )

<<<<<<< HEAD
          val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
        }

        class Node(
          customScalarAdapters: CustomScalarAdapters
        ) : ResponseAdapter<HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node> {
          val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

          override fun fromResponse(reader: JsonReader):
              HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node {
            var name: String? = null
            reader.beginObject()
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> name = stringAdapter.fromResponse(reader)
                else -> break
              }
=======
          override fun fromResponse(reader: ResponseReader, __typename: String?):
              HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node {
            return reader.run {
              var name: String? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> name = readString(RESPONSE_FIELDS[0])
                  else -> break
                }
              }
              HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node(
                name = name!!
              )
>>>>>>> dev-3.x
            }
            reader.endObject()
            return HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node(
              name = name!!
            )
          }

<<<<<<< HEAD
          override fun toResponse(writer: JsonWriter,
              value: HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node) {
            writer.beginObject()
            writer.name("name")
            stringAdapter.toResponse(writer, value.name)
            writer.endObject()
          }

          companion object {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                fieldName = "name",
              )
            )

            val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
=======
          override fun toResponse(writer: ResponseWriter,
              value: HeroDetailsImpl.Data.OtherData.FriendsConnection.Edges.Node) {
            writer.writeString(RESPONSE_FIELDS[0], value.name)
>>>>>>> dev-3.x
          }
        }
      }
    }
  }
}
