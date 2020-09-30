// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment

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
import com.example.simple_fragment.fragment.HeroDetails
import com.example.simple_fragment.fragment.HumanDetails
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

/**
 *  Demonstration of Java / Kotlin docs generation
 *  for both query and fragments
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
internal class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
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
  data class HeroDetailsImpl(
    val heroDetailsDelegate: HeroDetails
  ) : Hero, HeroDetails by heroDetailsDelegate {
    companion object {
      operator fun invoke(reader: ResponseReader): HeroDetailsImpl {
        return HeroDetailsImpl(HeroDetails(reader))
      }
    }
  }

  data class HeroDetailsHumanDetailsImpl(
    override val __typename: String,
    /**
     * The name of the character
     */
    override val name: String
  ) : HeroDetails, HumanDetails, Hero {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@HeroDetailsHumanDetailsImpl.__typename)
        writer.writeString(RESPONSE_FIELDS[1], this@HeroDetailsHumanDetailsImpl.name)
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): HeroDetailsHumanDetailsImpl = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        HeroDetailsHumanDetailsImpl(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HeroDetailsHumanDetailsImpl> = ResponseFieldMapper {
          invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class HeroImpl(
    override val __typename: String = "Character"
  ) : Hero {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller.invoke { writer ->
        writer.writeString(RESPONSE_FIELDS[0], this@HeroImpl.__typename)
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): HeroImpl = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        HeroImpl(
          __typename = __typename
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HeroImpl> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  interface Hero {
    val __typename: String

    fun marshaller(): ResponseFieldMarshaller

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null)
      )

      operator fun invoke(reader: ResponseReader): Hero {
        val typename = reader.readString(RESPONSE_FIELDS[0])
        return when(typename) {
          "Droid" -> HeroDetailsImpl(reader)
          "Human" -> HeroDetailsHumanDetailsImpl(reader)
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
        "11b6156b253df199195798f2de386724580e3882c9888f7e5d1685c42b64e0cf"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  hero {
          |    __typename
          |    ...HeroDetails
          |    ...HumanDetails
          |  }
          |}
          |fragment HeroDetails on Character {
          |  __typename
          |  name
          |  ... HumanDetails
          |}
          |fragment HumanDetails on Human {
          |  __typename
          |  name
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
