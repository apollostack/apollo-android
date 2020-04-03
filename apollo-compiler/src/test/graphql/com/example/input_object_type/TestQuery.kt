// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.input_object_type

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.example.input_object_type.type.Episode
import com.example.input_object_type.type.ReviewInput
import java.io.IOException
import kotlin.Any
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Throws
import kotlin.jvm.Transient
import okio.BufferedSource

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class TestQuery(
  val ep: Episode,
  val review: ReviewInput
) : Mutation<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["ep"] = this@TestQuery.ep
      this["review"] = this@TestQuery.review
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      writer.writeString("ep", this@TestQuery.ep.rawValue)
      writer.writeObject("review", this@TestQuery.review.marshaller())
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
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  data class CreateReview(
    val __typename: String = "Review",
    /**
     * The number of stars this review gave, 1-5
     */
    val stars: Int,
    /**
     * Comment about the movie
     */
    val commentary: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@CreateReview.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@CreateReview.stars)
      writer.writeString(RESPONSE_FIELDS[2], this@CreateReview.commentary)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("stars", "stars", null, false, null),
          ResponseField.forString("commentary", "commentary", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): CreateReview = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val stars = readInt(RESPONSE_FIELDS[1])!!
        val commentary = readString(RESPONSE_FIELDS[2])
        CreateReview(
          __typename = __typename,
          stars = stars,
          commentary = commentary
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<CreateReview> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Data(
    val createReview: CreateReview?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.createReview?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("createReview", "createReview", mapOf<String, Any>(
            "episode" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "ep"),
            "review" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "review")), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val createReview = readObject<CreateReview>(RESPONSE_FIELDS[0]) { reader ->
          CreateReview(reader)
        }
        Data(
          createReview = createReview
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "9850c60bd20e2361afd7a41d51b709fcba9637809e387afe5c7a1cb738fc254b"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |mutation TestQuery(${'$'}ep: Episode!, ${'$'}review: ReviewInput!) {
          |  createReview(episode: ${'$'}ep, review: ${'$'}review) {
          |    __typename
          |    stars
          |    commentary
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
