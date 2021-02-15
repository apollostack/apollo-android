// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_inside_inline_fragment.adapter

<<<<<<< HEAD
import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ListResponseAdapter
import com.apollographql.apollo.api.internal.NullableResponseAdapter
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.stringResponseAdapter
import com.example.named_fragment_inside_inline_fragment.GetHero
import com.example.named_fragment_inside_inline_fragment.type.Episode
import com.example.named_fragment_inside_inline_fragment.type.Episode_ResponseAdapter
=======
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.named_fragment_inside_inline_fragment.GetHero
import com.example.named_fragment_inside_inline_fragment.type.Episode
>>>>>>> dev-3.x
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
<<<<<<< HEAD
class GetHero_ResponseAdapter(
  customScalarAdapters: CustomScalarAdapters
) : ResponseAdapter<GetHero.Data> {
  val nullableHeroAdapter: ResponseAdapter<GetHero.Data.Hero?> =
      NullableResponseAdapter(Hero(customScalarAdapters))

  override fun fromResponse(reader: JsonReader): GetHero.Data {
    var hero: GetHero.Data.Hero? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> hero = nullableHeroAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return GetHero.Data(
      hero = hero
    )
  }

  override fun toResponse(writer: JsonWriter, value: GetHero.Data) {
    writer.beginObject()
    writer.name("hero")
    nullableHeroAdapter.toResponse(writer, value.hero)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.Named.Object("Character"),
        fieldName = "hero",
        fieldSets = listOf(
          ResponseField.FieldSet("Droid", Hero.CharacterHero.RESPONSE_FIELDS),
          ResponseField.FieldSet("Human", Hero.CharacterHero.RESPONSE_FIELDS),
          ResponseField.FieldSet(null, Hero.OtherHero.RESPONSE_FIELDS),
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class Hero(
    customScalarAdapters: CustomScalarAdapters
  ) : ResponseAdapter<GetHero.Data.Hero> {
    val CharacterHeroAdapter: CharacterHero =
        com.example.named_fragment_inside_inline_fragment.adapter.GetHero_ResponseAdapter.Hero.CharacterHero(customScalarAdapters)

    val OtherHeroAdapter: OtherHero =
        com.example.named_fragment_inside_inline_fragment.adapter.GetHero_ResponseAdapter.Hero.OtherHero(customScalarAdapters)

    override fun fromResponse(reader: JsonReader): GetHero.Data.Hero {
      reader.beginObject()
      check(reader.nextName() == "__typename")
      val typename = reader.nextString()

      return when(typename) {
        "Droid" -> CharacterHeroAdapter.fromResponse(reader, typename)
        "Human" -> CharacterHeroAdapter.fromResponse(reader, typename)
        else -> OtherHeroAdapter.fromResponse(reader, typename)
      }
      .also { reader.endObject() }
    }

    override fun toResponse(writer: JsonWriter, value: GetHero.Data.Hero) {
      when(value) {
        is GetHero.Data.Hero.CharacterHero -> CharacterHeroAdapter.toResponse(writer, value)
        is GetHero.Data.Hero.OtherHero -> OtherHeroAdapter.toResponse(writer, value)
      }
    }

    class CharacterHero(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      val listOfNullableEpisodeAdapter: ResponseAdapter<List<Episode?>> =
          ListResponseAdapter(NullableResponseAdapter(Episode_ResponseAdapter))

      fun fromResponse(reader: JsonReader, __typename: String?): GetHero.Data.Hero.CharacterHero {
        var __typename: String? = __typename
        var name: String? = null
        var appearsIn: List<Episode?>? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> appearsIn = listOfNullableEpisodeAdapter.fromResponse(reader)
            else -> break
          }
        }
        return GetHero.Data.Hero.CharacterHero(
          __typename = __typename!!,
          name = name!!,
          appearsIn = appearsIn!!
        )
      }

      fun toResponse(writer: JsonWriter, value: GetHero.Data.Hero.CharacterHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("appearsIn")
        listOfNullableEpisodeAdapter.toResponse(writer, value.appearsIn)
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
            type =
                ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
            fieldName = "appearsIn",
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }

    class OtherHero(
      customScalarAdapters: CustomScalarAdapters
    ) {
      val stringAdapter: ResponseAdapter<String> = stringResponseAdapter

      fun fromResponse(reader: JsonReader, __typename: String?): GetHero.Data.Hero.OtherHero {
        var __typename: String? = __typename
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            else -> break
          }
        }
        return GetHero.Data.Hero.OtherHero(
          __typename = __typename!!
        )
      }

      fun toResponse(writer: JsonWriter, value: GetHero.Data.Hero.OtherHero) {
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
=======
object GetHero_ResponseAdapter : ResponseAdapter<GetHero.Data> {
  val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.Named.Object("Character"),
      responseName = "hero",
      fieldName = "hero",
      arguments = emptyMap(),
      conditions = emptyList(),
      fieldSets = listOf(
        ResponseField.FieldSet("Droid", Hero.CharacterHero.RESPONSE_FIELDS),
        ResponseField.FieldSet("Human", Hero.CharacterHero.RESPONSE_FIELDS),
        ResponseField.FieldSet(null, Hero.OtherHero.RESPONSE_FIELDS),
      ),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): GetHero.Data {
    return reader.run {
      var hero: GetHero.Data.Hero? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> hero = readObject<GetHero.Data.Hero>(RESPONSE_FIELDS[0]) { reader ->
            Hero.fromResponse(reader)
          }
          else -> break
        }
      }
      GetHero.Data(
        hero = hero
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: GetHero.Data) {
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        Hero.toResponse(writer, value.hero)
      }
    }
  }

  object Hero : ResponseAdapter<GetHero.Data.Hero> {
    override fun fromResponse(reader: ResponseReader, __typename: String?): GetHero.Data.Hero {
      val typename = __typename ?: reader.readString(ResponseField.Typename)
      return when(typename) {
        "Droid" -> CharacterHero.fromResponse(reader, typename)
        "Human" -> CharacterHero.fromResponse(reader, typename)
        else -> OtherHero.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetHero.Data.Hero) {
      when(value) {
        is GetHero.Data.Hero.CharacterHero -> CharacterHero.toResponse(writer, value)
        is GetHero.Data.Hero.OtherHero -> OtherHero.toResponse(writer, value)
      }
    }

    object CharacterHero : ResponseAdapter<GetHero.Data.Hero.CharacterHero> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        ),
        ResponseField(
          type =
              ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
          responseName = "appearsIn",
          fieldName = "appearsIn",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          GetHero.Data.Hero.CharacterHero {
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
          GetHero.Data.Hero.CharacterHero(
            __typename = __typename!!,
            name = name!!,
            appearsIn = appearsIn!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: GetHero.Data.Hero.CharacterHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { value, listItemWriter ->
          listItemWriter.writeString(value?.rawValue)}
      }
    }

    object OtherHero : ResponseAdapter<GetHero.Data.Hero.OtherHero> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
          fieldSets = emptyList(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          GetHero.Data.Hero.OtherHero {
        return reader.run {
          var __typename: String? = __typename
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              else -> break
            }
          }
          GetHero.Data.Hero.OtherHero(
            __typename = __typename!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: GetHero.Data.Hero.OtherHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
>>>>>>> dev-3.x
      }
    }
  }
}
