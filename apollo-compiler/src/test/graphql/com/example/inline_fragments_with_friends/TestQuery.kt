// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragments_with_friends

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.inline_fragments_with_friends.type.CustomType
import com.example.inline_fragments_with_friends.type.Episode
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  interface HeroCharacter {
    fun marshaller(): ResponseFieldMarshaller
  }

  data class Friend(
    val __typename: String = "Character",
    /**
     * The movies this character appears in
     */
    val appearsIn: List<Episode?>
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Friend.__typename)
      writer.writeList(RESPONSE_FIELDS[1], this@Friend.appearsIn) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeString(value?.rawValue)}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forList("appearsIn", "appearsIn", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Friend = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val appearsIn = readList<Episode>(RESPONSE_FIELDS[1]) { reader ->
          reader.readString()?.let{ Episode.safeValueOf(it) }
        }!!
        Friend(
          __typename = __typename,
          appearsIn = appearsIn
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Friend> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class AsHuman(
    val __typename: String = "Human",
    /**
     * What this human calls themselves
     */
    val name: String,
    /**
     * Height in the preferred unit, default is meters
     */
    val height: Double?,
    /**
     * This human's friends, or an empty list if they have none
     */
    val friends: List<Friend?>?
  ) : HeroCharacter {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AsHuman.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@AsHuman.name)
      writer.writeDouble(RESPONSE_FIELDS[2], this@AsHuman.height)
      writer.writeList(RESPONSE_FIELDS[3], this@AsHuman.friends) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forDouble("height", "height", null, true, null),
          ResponseField.forList("friends", "friends", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): AsHuman = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val height = readDouble(RESPONSE_FIELDS[2])
        val friends = readList<Friend>(RESPONSE_FIELDS[3]) { reader ->
          reader.readObject<Friend> { reader ->
            Friend(reader)
          }
        }
        AsHuman(
          __typename = __typename,
          name = name,
          height = height,
          friends = friends
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<AsHuman> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Friend1(
    val __typename: String = "Character",
    /**
     * The ID of the character
     */
    val id: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Friend1.__typename)
      writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, this@Friend1.id)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null)
          )

      operator fun invoke(reader: ResponseReader): Friend1 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)!!
        Friend1(
          __typename = __typename,
          id = id
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Friend1> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class AsDroid(
    val __typename: String = "Droid",
    /**
     * What others call this droid
     */
    val name: String,
    /**
     * This droid's primary function
     */
    val primaryFunction: String?,
    /**
     * This droid's friends, or an empty list if they have none
     */
    val friends: List<Friend1?>?
  ) : HeroCharacter {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AsDroid.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@AsDroid.name)
      writer.writeString(RESPONSE_FIELDS[2], this@AsDroid.primaryFunction)
      writer.writeList(RESPONSE_FIELDS[3], this@AsDroid.friends) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forString("primaryFunction", "primaryFunction", null, true, null),
          ResponseField.forList("friends", "friends", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): AsDroid = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val primaryFunction = readString(RESPONSE_FIELDS[2])
        val friends = readList<Friend1>(RESPONSE_FIELDS[3]) { reader ->
          reader.readObject<Friend1> { reader ->
            Friend1(reader)
          }
        }
        AsDroid(
          __typename = __typename,
          name = name,
          primaryFunction = primaryFunction,
          friends = friends
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<AsDroid> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Hero(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String,
    val asHuman: AsHuman?,
    val asDroid: AsDroid?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Hero.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Hero.name)
      writer.writeFragment(this@Hero.asHuman?.marshaller())
      writer.writeFragment(this@Hero.asDroid?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("Human"))
          )),
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("Droid"))
          ))
          )

      operator fun invoke(reader: ResponseReader): Hero = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val asHuman = readFragment<AsHuman>(RESPONSE_FIELDS[2]) { reader ->
          AsHuman(reader)
        }
        val asDroid = readFragment<AsDroid>(RESPONSE_FIELDS[3]) { reader ->
          AsDroid(reader)
        }
        Hero(
          __typename = __typename,
          name = name,
          asHuman = asHuman,
          asDroid = asDroid
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Hero> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.hero?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("hero", "hero", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val hero = readObject<Hero>(RESPONSE_FIELDS[0]) { reader ->
          Hero(reader)
        }
        Data(
          hero = hero
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "6a20c9553e5f209b6cc63f98b9d154b5d5917cdea11a903e5dc7f8f420f949b6"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  hero {
          |    __typename
          |    name
          |    ... on Human {
          |      height
          |      friends {
          |        __typename
          |        appearsIn
          |      }
          |    }
          |    ... on Droid {
          |      primaryFunction
          |      friends {
          |        __typename
          |        id
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
