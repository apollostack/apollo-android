// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_in_fragment

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.example.fragment_in_fragment.fragment.StarshipFragment
import java.io.IOException
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.Throws
import okio.BufferedSource

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class AllStarships : Query<AllStarships.Data, AllStarships.Data, Operation.Variables> {
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

  data class Node(
    val __typename: String = "Starship",
    val fragments: Fragments
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Node.__typename)
      this@Node.fragments.marshaller().marshal(writer)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("__typename", "__typename", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Node = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val fragments = Fragments(reader)
        Node(
          __typename = __typename,
          fragments = fragments
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Node> = ResponseFieldMapper { invoke(it) }
    }

    data class Fragments(
      val starshipFragment: StarshipFragment
    ) {
      fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
        writer.writeFragment(this@Fragments.starshipFragment.marshaller())
      }

      companion object {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forFragment("__typename", "__typename", listOf(
              ResponseField.Condition.typeCondition(arrayOf("Starship"))
            ))
            )

        operator fun invoke(reader: ResponseReader): Fragments = reader.run {
          val starshipFragment = readFragment<StarshipFragment>(RESPONSE_FIELDS[0]) { reader ->
            StarshipFragment(reader)
          }!!
          Fragments(
            starshipFragment = starshipFragment
          )
        }

        @Suppress("FunctionName")
        fun Mapper(): ResponseFieldMapper<Fragments> = ResponseFieldMapper { invoke(it) }
      }
    }
  }

  data class Edge(
    val __typename: String = "StarshipsEdge",
    /**
     * The item at the end of the edge
     */
    val node: Node?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Edge.__typename)
      writer.writeObject(RESPONSE_FIELDS[1], this@Edge.node?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forObject("node", "node", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Edge = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val node = readObject<Node>(RESPONSE_FIELDS[1]) { reader ->
          Node(reader)
        }
        Edge(
          __typename = __typename,
          node = node
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Edge> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class AllStarships(
    val __typename: String = "StarshipsConnection",
    /**
     * A list of edges.
     */
    val edges: List<Edge?>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AllStarships.__typename)
      writer.writeList(RESPONSE_FIELDS[1], this@AllStarships.edges) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forList("edges", "edges", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): AllStarships = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val edges = readList<Edge>(RESPONSE_FIELDS[1]) { reader ->
          reader.readObject<Edge> { reader ->
            Edge(reader)
          }
        }
        AllStarships(
          __typename = __typename,
          edges = edges
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<AllStarships> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Data(
    val allStarships: AllStarships?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.allStarships?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("allStarships", "allStarships", mapOf<String, Any>(
            "first" to "7"), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val allStarships = readObject<AllStarships>(RESPONSE_FIELDS[0]) { reader ->
          AllStarships(reader)
        }
        Data(
          allStarships = allStarships
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "1296a4041eb330b2810e426f9347f76c6df3a969ab7f7e56f250bf9c6a07982e"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query AllStarships {
          |  allStarships(first: 7) {
          |    __typename
          |    edges {
          |      __typename
          |      node {
          |        __typename
          |        ...starshipFragment
          |      }
          |    }
          |  }
          |}
          |fragment starshipFragment on Starship {
          |  __typename
          |  id
          |  name
          |  pilotConnection {
          |    __typename
          |    edges {
          |      __typename
          |      node {
          |        __typename
          |        ...pilotFragment
          |      }
          |    }
          |  }
          |}
          |fragment pilotFragment on Person {
          |  __typename
          |  name
          |  homeworld {
          |    __typename
          |    ...planetFragment
          |  }
          |}
          |fragment planetFragment on Planet {
          |  __typename
          |  name
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "AllStarships"
    }
  }
}
