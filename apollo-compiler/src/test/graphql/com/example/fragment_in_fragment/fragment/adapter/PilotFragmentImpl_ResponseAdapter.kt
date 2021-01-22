// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_in_fragment.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.fragment_in_fragment.fragment.PilotFragmentImpl
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object PilotFragmentImpl_ResponseAdapter : ResponseAdapter<PilotFragmentImpl.Data> {
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
      type = ResponseField.Type.Named.Other("String"),
      responseName = "name",
      fieldName = "name",
      arguments = emptyMap(),
      conditions = emptyList(),
      possibleFieldSets = emptyMap(),
    ),
    ResponseField(
      type = ResponseField.Type.Named.Object("Planet"),
      responseName = "homeworld",
      fieldName = "homeworld",
      arguments = emptyMap(),
      conditions = emptyList(),
      possibleFieldSets = mapOf(
        "Planet" to Homeworld.PlanetHomeworld.RESPONSE_FIELDS,
        "" to Homeworld.OtherHomeworld.RESPONSE_FIELDS,
      ),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): PilotFragmentImpl.Data {
    return reader.run {
      var __typename: String? = __typename
      var name: String? = null
      var homeworld: PilotFragmentImpl.Data.Homeworld? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> name = readString(RESPONSE_FIELDS[1])
          2 -> homeworld = readObject<PilotFragmentImpl.Data.Homeworld>(RESPONSE_FIELDS[2]) { reader ->
            Homeworld.fromResponse(reader)
          }
          else -> break
        }
      }
      PilotFragmentImpl.Data(
        __typename = __typename!!,
        name = name,
        homeworld = homeworld
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: PilotFragmentImpl.Data) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.name)
    if(value.homeworld == null) {
      writer.writeObject(RESPONSE_FIELDS[2], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
        Homeworld.toResponse(writer, value.homeworld)
      }
    }
  }

  object Homeworld : ResponseAdapter<PilotFragmentImpl.Data.Homeworld> {
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
        PilotFragmentImpl.Data.Homeworld {
      val typename = __typename ?: reader.readString(ResponseField.Typename)
      return when(typename) {
        "Planet" -> PlanetHomeworld.fromResponse(reader, typename)
        else -> OtherHomeworld.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: PilotFragmentImpl.Data.Homeworld) {
      when(value) {
        is PilotFragmentImpl.Data.Homeworld.PlanetHomeworld -> PlanetHomeworld.toResponse(writer, value)
        is PilotFragmentImpl.Data.Homeworld.OtherHomeworld -> OtherHomeworld.toResponse(writer, value)
      }
    }

    object PlanetHomeworld : ResponseAdapter<PilotFragmentImpl.Data.Homeworld.PlanetHomeworld> {
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
          type = ResponseField.Type.Named.Other("String"),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          PilotFragmentImpl.Data.Homeworld.PlanetHomeworld {
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
          PilotFragmentImpl.Data.Homeworld.PlanetHomeworld(
            __typename = __typename!!,
            name = name
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: PilotFragmentImpl.Data.Homeworld.PlanetHomeworld) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
      }
    }

    object OtherHomeworld : ResponseAdapter<PilotFragmentImpl.Data.Homeworld.OtherHomeworld> {
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
          PilotFragmentImpl.Data.Homeworld.OtherHomeworld {
        return reader.run {
          var __typename: String? = __typename
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              else -> break
            }
          }
          PilotFragmentImpl.Data.Homeworld.OtherHomeworld(
            __typename = __typename!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter,
          value: PilotFragmentImpl.Data.Homeworld.OtherHomeworld) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      }
    }
  }
}
