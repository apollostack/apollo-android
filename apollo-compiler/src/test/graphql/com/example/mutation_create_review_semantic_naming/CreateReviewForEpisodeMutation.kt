// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mutation_create_review_semantic_naming

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.mutation_create_review_semantic_naming.type.Episode
import com.example.mutation_create_review_semantic_naming.type.ReviewInput
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
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
data class CreateReviewForEpisodeMutation(
  val ep: Episode,
  val review: ReviewInput
) : Query<CreateReviewForEpisodeMutation.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["ep"] = this@CreateReviewForEpisodeMutation.ep
      this["review"] = this@CreateReviewForEpisodeMutation.review
    }

    override fun marshaller(): InputFieldMarshaller {
      return InputFieldMarshaller.invoke { writer ->
        writer.writeString("ep", this@CreateReviewForEpisodeMutation.ep.rawValue)
        writer.writeObject("review", this@CreateReviewForEpisodeMutation.review.marshaller())
      }
    }
  }

  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = variables

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      CreateReviewForEpisodeMutation_ResponseAdapter.fromResponse(reader)
    }
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return parse(Buffer().write(byteString), scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> {
    return parse(source, DEFAULT)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> {
    return parse(byteString, DEFAULT)
  }

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString {
    return OperationRequestBodyComposer.compose(
      operation = this,
      autoPersistQueries = false,
      withQueryDocument = true,
      scalarTypeAdapters = scalarTypeAdapters
    )
  }

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
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val createReview: CreateReview?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        CreateReviewForEpisodeMutation_ResponseAdapter.Data.toResponse(writer, this)
      }
    }

    /**
     * Represents a review for a movie
     */
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
      fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          CreateReviewForEpisodeMutation_ResponseAdapter.Data.CreateReview.toResponse(writer, this)
        }
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "0cd4b32f15788d426344f5f8d2ee1a3cebb72c167005cb147d2a47761c120a41"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |mutation CreateReviewForEpisode(${'$'}ep: Episode!, ${'$'}review: ReviewInput!) {
          |  createReview(episode: ${'$'}ep, review: ${'$'}review) {
          |    __typename
          |    stars
          |    commentary
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "CreateReviewForEpisode"
      }
    }
  }
}
