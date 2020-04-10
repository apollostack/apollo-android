// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mutation_create_review

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
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
import com.example.mutation_create_review.type.CustomType
import com.example.mutation_create_review.type.Episode
import com.example.mutation_create_review.type.ReviewInput
import java.util.Date
import kotlin.Any
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
internal data class CreateReviewForEpisode(
  val ep: Episode,
  val review: ReviewInput
) : Mutation<CreateReviewForEpisode.Data, CreateReviewForEpisode.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["ep"] = this@CreateReviewForEpisode.ep
      this["review"] = this@CreateReviewForEpisode.review
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      writer.writeString("ep", this@CreateReviewForEpisode.ep.rawValue)
      writer.writeObject("review", this@CreateReviewForEpisode.review.marshaller())
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

  data class ListOfListOfObject(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@ListOfListOfObject.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@ListOfListOfObject.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): ListOfListOfObject = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        ListOfListOfObject(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<ListOfListOfObject> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class CreateReview(
    val __typename: String = "Review",
    /**
     * The number of stars this review gave, 1-5
     */
    val stars: Int,
    /**
     * Comment about the movie
     */
    val commentary: String?,
    /**
     * for test purpose only
     */
    val listOfListOfString: List<List<String>>?,
    /**
     * for test purpose only
     */
    val listOfListOfEnum: List<List<Episode>>?,
    /**
     * for test purpose only
     */
    val listOfListOfCustom: List<List<Date>>?,
    /**
     * for test purpose only
     */
    val listOfListOfObject: List<List<ListOfListOfObject>>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@CreateReview.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@CreateReview.stars)
      writer.writeString(RESPONSE_FIELDS[2], this@CreateReview.commentary)
      writer.writeList(RESPONSE_FIELDS[3], this@CreateReview.listOfListOfString) { value,
          listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeList(value) { value, listItemWriter ->
            value?.forEach { value ->
              listItemWriter.writeString(value)}
          }
        }
      }
      writer.writeList(RESPONSE_FIELDS[4], this@CreateReview.listOfListOfEnum) { value,
          listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeList(value) { value, listItemWriter ->
            value?.forEach { value ->
              listItemWriter.writeString(value?.rawValue)}
          }
        }
      }
      writer.writeList(RESPONSE_FIELDS[5], this@CreateReview.listOfListOfCustom) { value,
          listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeList(value) { value, listItemWriter ->
            value?.forEach { value ->
              listItemWriter.writeCustom(CustomType.DATE, value)}
          }
        }
      }
      writer.writeList(RESPONSE_FIELDS[6], this@CreateReview.listOfListOfObject) { value,
          listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeList(value) { value, listItemWriter ->
            value?.forEach { value ->
              listItemWriter.writeObject(value?.marshaller())}
          }
        }
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("stars", "stars", null, false, null),
          ResponseField.forString("commentary", "commentary", null, true, null),
          ResponseField.forList("listOfListOfString", "listOfListOfString", null, true, null),
          ResponseField.forList("listOfListOfEnum", "listOfListOfEnum", null, true, null),
          ResponseField.forList("listOfListOfCustom", "listOfListOfCustom", null, true, null),
          ResponseField.forList("listOfListOfObject", "listOfListOfObject", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): CreateReview = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val stars = readInt(RESPONSE_FIELDS[1])!!
        val commentary = readString(RESPONSE_FIELDS[2])
        val listOfListOfString = readList<List<String>>(RESPONSE_FIELDS[3]) { reader ->
          reader.readList<String> { reader ->
            reader.readString()
          }.map { it!! }
        }?.map { it!! }
        val listOfListOfEnum = readList<List<Episode>>(RESPONSE_FIELDS[4]) { reader ->
          reader.readList<Episode> { reader ->
            Episode.safeValueOf(reader.readString())
          }.map { it!! }
        }?.map { it!! }
        val listOfListOfCustom = readList<List<Date>>(RESPONSE_FIELDS[5]) { reader ->
          reader.readList<Date> { reader ->
            reader.readCustomType<Date>(CustomType.DATE)
          }.map { it!! }
        }?.map { it!! }
        val listOfListOfObject = readList<List<ListOfListOfObject>>(RESPONSE_FIELDS[6]) { reader ->
          reader.readList<ListOfListOfObject> { reader ->
            reader.readObject<ListOfListOfObject> { reader ->
              ListOfListOfObject(reader)
            }
          }.map { it!! }
        }?.map { it!! }
        CreateReview(
          __typename = __typename,
          stars = stars,
          commentary = commentary,
          listOfListOfString = listOfListOfString,
          listOfListOfEnum = listOfListOfEnum,
          listOfListOfCustom = listOfListOfCustom,
          listOfListOfObject = listOfListOfObject
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
        "c07e5abc4b4070cd773623194c07f546e609af467a1d34f7bf01c37272245296"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |mutation CreateReviewForEpisode(${'$'}ep: Episode!, ${'$'}review: ReviewInput!) {
          |  createReview(episode: ${'$'}ep, review: ${'$'}review) {
          |    __typename
          |    stars
          |    commentary
          |    listOfListOfString
          |    listOfListOfEnum
          |    listOfListOfCustom
          |    listOfListOfObject {
          |      __typename
          |      name
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "CreateReviewForEpisode"
    }
  }
}
