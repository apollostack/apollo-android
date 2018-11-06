package com.example.fragment_in_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import javax.annotation.Generated
import kotlin.Array
import kotlin.String

/**
 * @param name The name of this person.
 * @param homeworld A planet that this person was born on or inhabits.
 */
@Generated("Apollo GraphQL")
data class PilotFragment(
    val __typename: String,
    val name: String?,
    val homeworld: Homeworld?
) : GraphqlFragment {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
        it.writeString(RESPONSE_FIELDS[0], __typename)
        it.writeString(RESPONSE_FIELDS[1], name)
        it.writeObject(RESPONSE_FIELDS[2], homeworld?.marshaller())
    }

    companion object {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                ResponseField.forString("__typename", "__typename", null, false, null),
                ResponseField.forString("name", "name", null, true, null),
                ResponseField.forObject("homeworld", "homeworld", null, true, null)
                )

        val FRAGMENT_DEFINITION: String = """
                |fragment pilotFragment on Person {
                |  __typename
                |  name
                |  homeworld {
                |    __typename
                |    name
                |  }
                |}
                """.trimMargin()

        val POSSIBLE_TYPES: Array<String> = arrayOf("Person")

        operator fun invoke(reader: ResponseReader): PilotFragment {
            val __typename = reader.readString(RESPONSE_FIELDS[0])
            val name = reader.readString(RESPONSE_FIELDS[1])
            val homeworld = reader.readObject<Homeworld>(RESPONSE_FIELDS[2]) {
                Homeworld(it)
            }

            return PilotFragment(
                __typename = __typename,
                name = name,
                homeworld = homeworld
            )
        }
    }

    /**
     * @param name The name of this planet.
     */
    data class Homeworld(
        val __typename: String,
        val name: String?
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeString(RESPONSE_FIELDS[1], name)
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forString("name", "name", null, true, null)
                    )

            operator fun invoke(reader: ResponseReader): Homeworld {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val name = reader.readString(RESPONSE_FIELDS[1])
                return Homeworld(
                    __typename = __typename,
                    name = name
                )
            }
        }
    }
}
