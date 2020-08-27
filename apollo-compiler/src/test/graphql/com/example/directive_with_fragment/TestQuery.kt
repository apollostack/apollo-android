// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.directive_with_fragment

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.directive_with_fragment.fragment.HeroDetails
import com.example.directive_with_fragment.fragment.HumanDetails
import com.example.directive_with_fragment.type.CustomType
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
data class TestQuery(
  val withDetails: Boolean,
  val skipHumanDetails: Boolean
) : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["withDetails"] = this@TestQuery.withDetails
      this["skipHumanDetails"] = this@TestQuery.skipHumanDetails
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      writer.writeBoolean("withDetails", this@TestQuery.withDetails)
      writer.writeBoolean("skipHumanDetails", this@TestQuery.skipHumanDetails)
    }
  }

  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = variables
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

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

  /**
   * A character from the Star Wars universe
   */
  data class HeroImpl(
    override val __typename: String = "Character",
    /**
     * The ID of the character
     */
    override val id: String
  ) : Hero {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@HeroImpl.__typename)
        writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, this@HeroImpl.id)
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null)
      )

      operator fun invoke(reader: ResponseReader): HeroImpl = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)!!
        HeroImpl(
          __typename = __typename,
          id = id
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HeroImpl> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class HeroDetailsImpl(
    override val __typename: String,
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The ID of the character
     */
    override val id: String
  ) : HeroDetails, Hero {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@HeroDetailsImpl.__typename)
        writer.writeString(RESPONSE_FIELDS[1], this@HeroDetailsImpl.name)
        writer.writeCustom(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField,
            this@HeroDetailsImpl.id)
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null),
        ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null)
      )

      operator fun invoke(reader: ResponseReader): HeroDetailsImpl = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val id = readCustomType<String>(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField)!!
        HeroDetailsImpl(
          __typename = __typename,
          name = name,
          id = id
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HeroDetailsImpl> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A humanoid creature from the Star Wars universe
   */
  data class HumanDetailsImpl(
    /**
     * The home planet of the human, or null if unknown
     */
    override val homePlanet: String?,
    /**
     * The ID of the character
     */
    override val id: String,
    override val __typename: String = "Human",
    /**
     * The name of the character
     */
    override val name: String
  ) : HeroDetails, Hero, HumanDetails {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@HumanDetailsImpl.homePlanet)
        writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField,
            this@HumanDetailsImpl.id)
        writer.writeString(RESPONSE_FIELDS[2], this@HumanDetailsImpl.__typename)
        writer.writeString(RESPONSE_FIELDS[3], this@HumanDetailsImpl.name)
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("homePlanet", "homePlanet", null, true, null),
        ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null),
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): HumanDetailsImpl = reader.run {
        val homePlanet = readString(RESPONSE_FIELDS[0])
        val id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)!!
        val __typename = readString(RESPONSE_FIELDS[2])!!
        val name = readString(RESPONSE_FIELDS[3])!!
        HumanDetailsImpl(
          homePlanet = homePlanet,
          id = id,
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HumanDetailsImpl> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  interface Hero {
    val __typename: String

    /**
     * The ID of the character
     */
    val id: String

    fun marshaller(): ResponseFieldMarshaller

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): Hero {
        val typename = reader.readString(RESPONSE_FIELDS[0])
        return when(typename) {
          "Droid" -> HeroDetailsImpl(reader)
          "Human" -> HumanDetailsImpl(reader)
          else -> HeroImpl(reader)
        }
      }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeObject(RESPONSE_FIELDS[0], this@Data.hero?.marshaller())
      }
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
        "e7ae0709b15d61fbba95a5c2e74b439fbed8ccf8d68fd389f4dd8250b55efeaf"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery(${'$'}withDetails: Boolean!, ${'$'}skipHumanDetails: Boolean!) {
          |  hero {
          |    __typename
          |    id
          |    ... HeroDetails @include(if: ${'$'}withDetails) @skip(if: ${'$'}skipHumanDetails)
          |    ... HumanDetails @include(if: ${'$'}withDetails)
          |  }
          |}
          |fragment HeroDetails on Character {
          |  __typename
          |  name
          |}
          |fragment HumanDetails on Human {
          |  __typename
          |  homePlanet
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
