// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_inline_fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.root_query_inline_fragment.TestQuery
import com.example.root_query_inline_fragment.type.Episode
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return Data.fromResponse(reader, __typename)
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    Data.toResponse(writer, value)
  }

  object Data : ResponseAdapter<TestQuery.Data> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "Query" -> QueryDatum.fromResponse(reader, typename)
        else -> OtherDatum.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
      when(value) {
        is TestQuery.Data.QueryDatum -> QueryDatum.toResponse(writer, value)
        is TestQuery.Data.OtherDatum -> OtherDatum.toResponse(writer, value)
      }
    }

    object QueryDatum : ResponseAdapter<TestQuery.Data.QueryDatum> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forObject("hero", "hero", null, true, null),
        ResponseField.forObject("droid", "droid", mapOf<String, Any?>(
          "id" to 1), true, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.QueryDatum {
        return reader.run {
          var __typename: String? = __typename
          var hero: TestQuery.Data.QueryDatum.Hero? = null
          var droid: TestQuery.Data.QueryDatum.Droid? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> hero = readObject<TestQuery.Data.QueryDatum.Hero>(RESPONSE_FIELDS[1]) { reader ->
                Hero.fromResponse(reader)
              }
              2 -> droid = readObject<TestQuery.Data.QueryDatum.Droid>(RESPONSE_FIELDS[2]) { reader ->
                Droid.fromResponse(reader)
              }
              else -> break
            }
          }
          TestQuery.Data.QueryDatum(
            __typename = __typename!!,
            hero = hero,
            droid = droid
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.QueryDatum) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        if(value.hero == null) {
          writer.writeObject(RESPONSE_FIELDS[1], null)
        } else {
          writer.writeObject(RESPONSE_FIELDS[1]) { writer ->
            Hero.toResponse(writer, value.hero)
          }
        }
        if(value.droid == null) {
          writer.writeObject(RESPONSE_FIELDS[2], null)
        } else {
          writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
            Droid.toResponse(writer, value.droid)
          }
        }
      }

      object Hero : ResponseAdapter<TestQuery.Data.QueryDatum.Hero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forList("appearsIn", "appearsIn", null, false, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.QueryDatum.Hero {
          val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
          return when(typename) {
            "Human" -> HumanHero.fromResponse(reader, typename)
            else -> OtherHero.fromResponse(reader, typename)
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.QueryDatum.Hero) {
          when(value) {
            is TestQuery.Data.QueryDatum.Hero.HumanHero -> HumanHero.toResponse(writer, value)
            is TestQuery.Data.QueryDatum.Hero.OtherHero -> OtherHero.toResponse(writer, value)
          }
        }

        object HumanHero : ResponseAdapter<TestQuery.Data.QueryDatum.Hero.HumanHero> {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forString("__typename", "__typename", null, false, null),
            ResponseField.forString("name", "name", null, false, null),
            ResponseField.forList("appearsIn", "appearsIn", null, false, null),
            ResponseField.forDouble("height", "height", null, true, null)
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.QueryDatum.Hero.HumanHero {
            return reader.run {
              var __typename: String? = __typename
              var name: String? = null
              var appearsIn: List<Episode?>? = null
              var height: Double? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> __typename = readString(RESPONSE_FIELDS[0])
                  1 -> name = readString(RESPONSE_FIELDS[1])
                  2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
                    Episode.safeValueOf(reader.readString())
                  }
                  3 -> height = readDouble(RESPONSE_FIELDS[3])
                  else -> break
                }
              }
              TestQuery.Data.QueryDatum.Hero.HumanHero(
                __typename = __typename!!,
                name = name!!,
                appearsIn = appearsIn!!,
                height = height
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.QueryDatum.Hero.HumanHero) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            writer.writeString(RESPONSE_FIELDS[1], value.name)
            writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { values, listItemWriter ->
              values?.forEach { value ->
                listItemWriter.writeString(value?.rawValue)}
            }
            writer.writeDouble(RESPONSE_FIELDS[3], value.height)
          }
        }

        object OtherHero : ResponseAdapter<TestQuery.Data.QueryDatum.Hero.OtherHero> {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forString("__typename", "__typename", null, false, null),
            ResponseField.forString("name", "name", null, false, null),
            ResponseField.forList("appearsIn", "appearsIn", null, false, null)
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.QueryDatum.Hero.OtherHero {
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
              TestQuery.Data.QueryDatum.Hero.OtherHero(
                __typename = __typename!!,
                name = name!!,
                appearsIn = appearsIn!!
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.QueryDatum.Hero.OtherHero) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            writer.writeString(RESPONSE_FIELDS[1], value.name)
            writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { values, listItemWriter ->
              values?.forEach { value ->
                listItemWriter.writeString(value?.rawValue)}
            }
          }
        }
      }

      object Droid : ResponseAdapter<TestQuery.Data.QueryDatum.Droid> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.QueryDatum.Droid {
          val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
          return when(typename) {
            "Droid" -> DroidDroid.fromResponse(reader, typename)
            else -> OtherDroid.fromResponse(reader, typename)
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.QueryDatum.Droid) {
          when(value) {
            is TestQuery.Data.QueryDatum.Droid.DroidDroid -> DroidDroid.toResponse(writer, value)
            is TestQuery.Data.QueryDatum.Droid.OtherDroid -> OtherDroid.toResponse(writer, value)
          }
        }

        object DroidDroid : ResponseAdapter<TestQuery.Data.QueryDatum.Droid.DroidDroid> {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forString("__typename", "__typename", null, false, null),
            ResponseField.forString("name", "name", null, false, null),
            ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.QueryDatum.Droid.DroidDroid {
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
              TestQuery.Data.QueryDatum.Droid.DroidDroid(
                __typename = __typename!!,
                name = name!!,
                primaryFunction = primaryFunction
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.QueryDatum.Droid.DroidDroid) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
            writer.writeString(RESPONSE_FIELDS[1], value.name)
            writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
          }
        }

        object OtherDroid : ResponseAdapter<TestQuery.Data.QueryDatum.Droid.OtherDroid> {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forString("__typename", "__typename", null, false, null)
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.QueryDatum.Droid.OtherDroid {
            return reader.run {
              var __typename: String? = __typename
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> __typename = readString(RESPONSE_FIELDS[0])
                  else -> break
                }
              }
              TestQuery.Data.QueryDatum.Droid.OtherDroid(
                __typename = __typename!!
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.QueryDatum.Droid.OtherDroid) {
            writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          }
        }
      }
    }

    object OtherDatum : ResponseAdapter<TestQuery.Data.OtherDatum> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.OtherDatum {
        return reader.run {
          var __typename: String? = __typename
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              else -> break
            }
          }
          TestQuery.Data.OtherDatum(
            __typename = __typename!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.OtherDatum) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      }
    }
  }
}
