// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.subscriptions

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.Subscription
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import kotlin.Any
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.BufferedSource
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class TestSubscription(
  val repo: String
) : Subscription<TestSubscription.Data, TestSubscription.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["repo"] = this@TestSubscription.repo
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      writer.writeString("repo", this@TestSubscription.repo)
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

  data class CommentAdded(
    val __typename: String = "Comment",
    /**
     * The SQL ID of this entry
     */
    val id: Int,
    /**
     * The text of the comment
     */
    val content: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@CommentAdded.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@CommentAdded.id)
      writer.writeString(RESPONSE_FIELDS[2], this@CommentAdded.content)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("id", "id", null, false, null),
          ResponseField.forString("content", "content", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): CommentAdded = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val id = readInt(RESPONSE_FIELDS[1])!!
        val content = readString(RESPONSE_FIELDS[2])!!
        CommentAdded(
          __typename = __typename,
          id = id,
          content = content
        )
      }
    }
  }

  data class Data(
    /**
     * Subscription fires on every comment added
     */
    val commentAdded: CommentAdded?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.commentAdded?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("commentAdded", "commentAdded", mapOf<String, Any>(
            "repoFullName" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "repo")), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val commentAdded = readObject<CommentAdded>(RESPONSE_FIELDS[0]) { reader ->
          CommentAdded(reader)
        }
        Data(
          commentAdded = commentAdded
        )
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "55460a650cce0aa4bb131446ec3e56225710e36940223934bee09e1723e41190"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |subscription TestSubscription(${'$'}repo: String!) {
          |  commentAdded(repoFullName: ${'$'}repo) {
          |    __typename
          |    id
          |    content
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestSubscription"
    }
  }
}
