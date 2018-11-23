package com.example.fragment_with_inline_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import javax.annotation.Generated
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/**
 * @param name The name of the character
 * @param friendsConnection The friends of the character exposed as a connection with edges
 */
@Generated("Apollo GraphQL")
@Suppress("NAME_SHADOWING", "LocalVariableName")
data class HeroDetails(
    val __typename: String,
    val name: String,
    val friendsConnection: FriendsConnection1,
    val asDroid: AsDroid?
) : GraphqlFragment {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
        it.writeString(RESPONSE_FIELDS[0], __typename)
        it.writeString(RESPONSE_FIELDS[1], name)
        it.writeObject(RESPONSE_FIELDS[2], friendsConnection.marshaller())
        it.writeObject(RESPONSE_FIELDS[3], asDroid?.marshaller())
    }

    companion object {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                ResponseField.forString("__typename", "__typename", null, false, null),
                ResponseField.forString("name", "name", null, false, null),
                ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null),
                ResponseField.forInlineFragment("__typename", "__typename", listOf("Droid"))
                )

        val FRAGMENT_DEFINITION: String = """
                |fragment HeroDetails on Character {
                |  __typename
                |  name
                |  friendsConnection {
                |    __typename
                |    totalCount
                |    edges {
                |      __typename
                |      node {
                |        __typename
                |        name
                |      }
                |    }
                |  }
                |  ... on Droid {
                |    name
                |    primaryFunction
                |  }
                |}
                """.trimMargin()

        val POSSIBLE_TYPES: Array<String> = arrayOf("Human", "Droid")

        operator fun invoke(reader: ResponseReader): HeroDetails {
            val __typename = reader.readString(RESPONSE_FIELDS[0])
            val name = reader.readString(RESPONSE_FIELDS[1])
            val friendsConnection = reader.readObject<FriendsConnection1>(RESPONSE_FIELDS[2]) { reader ->
                FriendsConnection1(reader)
            }

            val asDroid = reader.readConditional(RESPONSE_FIELDS[3]) { conditionalType, reader ->
                AsDroid(reader)
            }

            return HeroDetails(
                __typename = __typename,
                name = name,
                friendsConnection = friendsConnection,
                asDroid = asDroid
            )
        }
    }

    /**
     * @param name The name of the character
     */
    data class Node(
        val __typename: String,
        val name: String
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeString(RESPONSE_FIELDS[1], name)
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forString("name", "name", null, false, null)
                    )

            operator fun invoke(reader: ResponseReader): Node {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val name = reader.readString(RESPONSE_FIELDS[1])
                return Node(
                    __typename = __typename,
                    name = name
                )
            }
        }
    }

    /**
     * @param node The character represented by this friendship edge
     */
    data class Edge(
        val __typename: String,
        val node: Node?
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeObject(RESPONSE_FIELDS[1], node?.marshaller())
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forObject("node", "node", null, true, null)
                    )

            operator fun invoke(reader: ResponseReader): Edge {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val node = reader.readObject<Node>(RESPONSE_FIELDS[1]) { reader ->
                    Node(reader)
                }

                return Edge(
                    __typename = __typename,
                    node = node
                )
            }
        }
    }

    /**
     * @param totalCount The total number of friends
     * @param edges The edges for each of the character's friends.
     */
    data class FriendsConnection(
        val __typename: String,
        val totalCount: Int?,
        val edges: List<Edge?>?
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeInt(RESPONSE_FIELDS[1], totalCount)
            it.writeList(RESPONSE_FIELDS[2], edges) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeObject(value?.marshaller())
                }
            }
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forInt("totalCount", "totalCount", null, true, null),
                    ResponseField.forList("edges", "edges", null, true, null)
                    )

            operator fun invoke(reader: ResponseReader): FriendsConnection {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val totalCount = reader.readInt(RESPONSE_FIELDS[1])
                val edges = reader.readList<Edge>(RESPONSE_FIELDS[2]) {
                    it.readObject<Edge> { reader ->
                        Edge(reader)
                    }

                }
                return FriendsConnection(
                    __typename = __typename,
                    totalCount = totalCount,
                    edges = edges
                )
            }
        }
    }

    /**
     * @param name What others call this droid
     * @param friendsConnection The friends of the droid exposed as a connection with edges
     * @param primaryFunction This droid's primary function
     */
    data class AsDroid(
        val __typename: String,
        val name: String,
        val friendsConnection: FriendsConnection,
        val primaryFunction: String?
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeString(RESPONSE_FIELDS[1], name)
            it.writeObject(RESPONSE_FIELDS[2], friendsConnection.marshaller())
            it.writeString(RESPONSE_FIELDS[3], primaryFunction)
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forString("name", "name", null, false, null),
                    ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null),
                    ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
                    )

            operator fun invoke(reader: ResponseReader): AsDroid {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val name = reader.readString(RESPONSE_FIELDS[1])
                val friendsConnection = reader.readObject<FriendsConnection>(RESPONSE_FIELDS[2]) { reader ->
                    FriendsConnection(reader)
                }

                val primaryFunction = reader.readString(RESPONSE_FIELDS[3])
                return AsDroid(
                    __typename = __typename,
                    name = name,
                    friendsConnection = friendsConnection,
                    primaryFunction = primaryFunction
                )
            }
        }
    }

    /**
     * @param name The name of the character
     */
    data class Node1(
        val __typename: String,
        val name: String
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeString(RESPONSE_FIELDS[1], name)
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forString("name", "name", null, false, null)
                    )

            operator fun invoke(reader: ResponseReader): Node1 {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val name = reader.readString(RESPONSE_FIELDS[1])
                return Node1(
                    __typename = __typename,
                    name = name
                )
            }
        }
    }

    /**
     * @param node The character represented by this friendship edge
     */
    data class Edge1(
        val __typename: String,
        val node: Node1?
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeObject(RESPONSE_FIELDS[1], node?.marshaller())
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forObject("node", "node", null, true, null)
                    )

            operator fun invoke(reader: ResponseReader): Edge1 {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val node = reader.readObject<Node1>(RESPONSE_FIELDS[1]) { reader ->
                    Node1(reader)
                }

                return Edge1(
                    __typename = __typename,
                    node = node
                )
            }
        }
    }

    /**
     * @param totalCount The total number of friends
     * @param edges The edges for each of the character's friends.
     */
    data class FriendsConnection1(
        val __typename: String,
        val totalCount: Int?,
        val edges: List<Edge1?>?
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeInt(RESPONSE_FIELDS[1], totalCount)
            it.writeList(RESPONSE_FIELDS[2], edges) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeObject(value?.marshaller())
                }
            }
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forInt("totalCount", "totalCount", null, true, null),
                    ResponseField.forList("edges", "edges", null, true, null)
                    )

            operator fun invoke(reader: ResponseReader): FriendsConnection1 {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val totalCount = reader.readInt(RESPONSE_FIELDS[1])
                val edges = reader.readList<Edge1>(RESPONSE_FIELDS[2]) {
                    it.readObject<Edge1> { reader ->
                        Edge1(reader)
                    }

                }
                return FriendsConnection1(
                    __typename = __typename,
                    totalCount = totalCount,
                    edges = edges
                )
            }
        }
    }
}
