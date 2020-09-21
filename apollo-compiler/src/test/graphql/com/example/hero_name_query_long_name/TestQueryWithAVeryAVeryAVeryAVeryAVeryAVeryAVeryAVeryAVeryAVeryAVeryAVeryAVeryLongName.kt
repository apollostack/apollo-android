// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.hero_name_query_long_name

import com.apollographql.apollo.api.Input
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
import com.example.hero_name_query_long_name.type.Episode
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
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName(
  val episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName:
      Input<Episode> = Input.absent()
) :
    Query<TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.Data,
    TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.Data,
    Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      if (this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.defined) {
        this["episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName"] = this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.value
      }
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      if (this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.defined) {
        writer.writeString("episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName",
            this@TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName.value?.rawValue)
      }
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
  data class HeroAVeryAVeryAVeryAVeryAVeryAVeryAV(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName:
        String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@HeroAVeryAVeryAVeryAVeryAVeryAVeryAV.__typename)
      writer.writeString(RESPONSE_FIELDS[1],
          this@HeroAVeryAVeryAVeryAVeryAVeryAVeryAV.nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName",
              "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): HeroAVeryAVeryAVeryAVeryAVeryAVeryAV =
          reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName
            = readString(RESPONSE_FIELDS[1])!!
        HeroAVeryAVeryAVeryAVeryAVeryAVeryAV(
          __typename = __typename,
          nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName =
              nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HeroAVeryAVeryAVeryAVeryAVeryAVeryAV> =
          ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val heroAVeryAVeryAVeryAVeryAVeryAVeryAV: HeroAVeryAVeryAVeryAVeryAVeryAVeryAV?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0],
          this@Data.heroAVeryAVeryAVeryAVeryAVeryAVeryAV?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("heroAVeryAVeryAVeryAVeryAVeryAVeryAV", "hero", mapOf<String,
              Any>(
            "episode" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to
              "episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName")),
              true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val heroAVeryAVeryAVeryAVeryAVeryAVeryAV =
            readObject<HeroAVeryAVeryAVeryAVeryAVeryAVeryAV>(RESPONSE_FIELDS[0]) { reader ->
          HeroAVeryAVeryAVeryAVeryAVeryAVeryAV(reader)
        }
        Data(
          heroAVeryAVeryAVeryAVeryAVeryAVeryAV = heroAVeryAVeryAVeryAVeryAVeryAVeryAV
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "da1b713dcfa710f7f5dbe01186d56ebdec768de44002ab965740de6acbee1d01"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName(${'$'}episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName:Episode) {
          |  heroAVeryAVeryAVeryAVeryAVeryAVeryAV: hero(episode: ${'$'}episodeAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName) {
          |    __typename
          |    nameAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName: name
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String =
          "TestQueryWithAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryAVeryLongName"
    }
  }
}
