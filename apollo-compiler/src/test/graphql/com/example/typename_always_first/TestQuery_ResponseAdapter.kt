// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.typename_always_first

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.Double
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
        ResponseField.forString("__typename", "__typename", null, false, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Hero {
        val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
        return when(typename) {
          "Human" -> HumanHero.fromResponse(reader, typename)
          "Droid" -> DroidHero.fromResponse(reader, typename)
          else -> OtherHero.fromResponse(reader, typename)
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero) {
        when(value) {
          is TestQuery.Data.Hero.HumanHero -> HumanHero.toResponse(writer, value)
          is TestQuery.Data.Hero.DroidHero -> DroidHero.toResponse(writer, value)
          is TestQuery.Data.Hero.OtherHero -> OtherHero.toResponse(writer, value)
        }
      }

      object HumanHero : ResponseAdapter<TestQuery.Data.Hero.HumanHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forDouble("height", "height", null, true, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.HumanHero {
          return reader.run {
            var __typename: String? = __typename
            var height: Double? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> height = readDouble(RESPONSE_FIELDS[1])
                else -> break
              }
            }
            TestQuery.Data.Hero.HumanHero(
              __typename = __typename!!,
              height = height
            )
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.HumanHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeDouble(RESPONSE_FIELDS[1], value.height)
        }
      }

      object DroidHero : ResponseAdapter<TestQuery.Data.Hero.DroidHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.DroidHero {
          return reader.run {
            var __typename: String? = __typename
            var name: String? = null
            var primaryFunction: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> name = readString(RESPONSE_FIELDS[1])
                2 -> primaryFunction = readString(RESPONSE_FIELDS[2])
                else -> break
              }
            }
            TestQuery.Data.Hero.DroidHero(
              __typename = __typename!!,
              name = name!!,
              primaryFunction = primaryFunction
            )
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.DroidHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeString(RESPONSE_FIELDS[1], value.name)
          writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
        }
      }

      object OtherHero : ResponseAdapter<TestQuery.Data.Hero.OtherHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.OtherHero {
          return reader.run {
            var __typename: String? = __typename
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                else -> break
              }
            }
            TestQuery.Data.Hero.OtherHero(
              __typename = __typename!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.OtherHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        }
      }
    }
  }
}
