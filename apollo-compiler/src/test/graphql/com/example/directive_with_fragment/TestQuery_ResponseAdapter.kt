// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.directive_with_fragment

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.directive_with_fragment.type.CustomType
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("hero", "hero", null, true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return Data.fromResponse(reader, __typename)
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    Data.toResponse(writer, value)
  }

  object Data : ResponseAdapter<TestQuery.Data> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forObject("hero", "hero", null, true, null)
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
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Hero {
        val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
        return when(typename) {
          "Droid" -> CharacterHero.fromResponse(reader, typename)
          "Human" -> CharacterHumanHero.fromResponse(reader, typename)
          else -> OtherHero.fromResponse(reader, typename)
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero) {
        when(value) {
          is TestQuery.Data.Hero.CharacterHero -> CharacterHero.toResponse(writer, value)
          is TestQuery.Data.Hero.CharacterHumanHero -> CharacterHumanHero.toResponse(writer, value)
          is TestQuery.Data.Hero.OtherHero -> OtherHero.toResponse(writer, value)
        }
      }

      object CharacterHero : ResponseAdapter<TestQuery.Data.Hero.CharacterHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null),
          ResponseField.forString("name", "name", null, false, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.CharacterHero {
          return reader.run {
            var __typename: String? = __typename
            var id: String? = null
            var name: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)
                2 -> name = readString(RESPONSE_FIELDS[2])
                else -> break
              }
            }
            TestQuery.Data.Hero.CharacterHero(
              __typename = __typename!!,
              id = id!!,
              name = name!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.CharacterHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, value.id)
          writer.writeString(RESPONSE_FIELDS[2], value.name)
        }
      }

      object CharacterHumanHero : ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forString("homePlanet", "homePlanet", null, true, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.CharacterHumanHero {
          return reader.run {
            var __typename: String? = __typename
            var id: String? = null
            var name: String? = null
            var homePlanet: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)
                2 -> name = readString(RESPONSE_FIELDS[2])
                3 -> homePlanet = readString(RESPONSE_FIELDS[3])
                else -> break
              }
            }
            TestQuery.Data.Hero.CharacterHumanHero(
              __typename = __typename!!,
              id = id!!,
              name = name!!,
              homePlanet = homePlanet
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.CharacterHumanHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, value.id)
          writer.writeString(RESPONSE_FIELDS[2], value.name)
          writer.writeString(RESPONSE_FIELDS[3], value.homePlanet)
        }
      }

      object OtherHero : ResponseAdapter<TestQuery.Data.Hero.OtherHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.OtherHero {
          return reader.run {
            var __typename: String? = __typename
            var id: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)
                else -> break
              }
            }
            TestQuery.Data.Hero.OtherHero(
              __typename = __typename!!,
              id = id!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.OtherHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, value.id)
        }
      }
    }
  }
}
