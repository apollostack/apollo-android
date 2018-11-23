package com.example.scalar_types

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMapper
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import com.example.scalar_types.type.CustomType
import javax.annotation.Generated
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Generated("Apollo GraphQL")
@Suppress("NAME_SHADOWING", "LocalVariableName")
class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
    override fun operationId(): String = OPERATION_ID
    override fun queryDocument(): String = QUERY_DOCUMENT
    override fun wrapData(data: TestQuery.Data): TestQuery.Data = data
    override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
    override fun name(): OperationName = OPERATION_NAME
    override fun responseFieldMapper(): ResponseFieldMapper<TestQuery.Data> = ResponseFieldMapper {
        TestQuery.Data(it)
    }

    data class Data(
        val graphQlString: String?,
        val graphQlIdNullable: String?,
        val graphQlIdNonNullable: String,
        val graphQlIntNullable: Int?,
        val graphQlIntNonNullable: Int,
        val graphQlFloatNullable: Double?,
        val graphQlFloatNonNullable: Double,
        val graphQlBooleanNullable: Boolean?,
        val graphQlBooleanNonNullable: Boolean,
        val graphQlListOfStringNullable: List<String?>,
        val graphQlListOfStringNonNullable: List<String?>,
        val graphQlListOfIdNullable: List<String?>?,
        val graphQlListOfIdNonNullable: List<String?>,
        val graphQlListOfIntNullable: List<Int?>?,
        val graphQlListOfIntNonNullable: List<Int?>,
        val graphQlListOfFloatNullable: List<Double?>?,
        val graphQlListOfFloatNonNullable: List<Double?>,
        val graphQlListOfBooleanNullable: List<Boolean?>?,
        val graphQlListOfListOfString: List<List<String?>?>,
        val graphQlListOfListOfId: List<List<String?>?>,
        val graphQlListOfListOfInt: List<List<Int?>?>,
        val graphQlListOfListOfFloat: List<List<Double?>?>,
        val graphQlListOfListOfBoolean: List<List<Boolean?>?>
    ) : Operation.Data {
        override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], graphQlString)
            it.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, graphQlIdNullable)
            it.writeCustom(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField, graphQlIdNonNullable)
            it.writeInt(RESPONSE_FIELDS[3], graphQlIntNullable)
            it.writeInt(RESPONSE_FIELDS[4], graphQlIntNonNullable)
            it.writeDouble(RESPONSE_FIELDS[5], graphQlFloatNullable)
            it.writeDouble(RESPONSE_FIELDS[6], graphQlFloatNonNullable)
            it.writeBoolean(RESPONSE_FIELDS[7], graphQlBooleanNullable)
            it.writeBoolean(RESPONSE_FIELDS[8], graphQlBooleanNonNullable)
            it.writeList(RESPONSE_FIELDS[9], graphQlListOfStringNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeString(value)
                }
            }
            it.writeList(RESPONSE_FIELDS[10], graphQlListOfStringNonNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeString(value)
                }
            }
            it.writeList(RESPONSE_FIELDS[11], graphQlListOfIdNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeCustom(CustomType.ID, value)
                }
            }
            it.writeList(RESPONSE_FIELDS[12], graphQlListOfIdNonNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeCustom(CustomType.ID, value)
                }
            }
            it.writeList(RESPONSE_FIELDS[13], graphQlListOfIntNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeInt(value)
                }
            }
            it.writeList(RESPONSE_FIELDS[14], graphQlListOfIntNonNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeInt(value)
                }
            }
            it.writeList(RESPONSE_FIELDS[15], graphQlListOfFloatNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeDouble(value)
                }
            }
            it.writeList(RESPONSE_FIELDS[16], graphQlListOfFloatNonNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeDouble(value)
                }
            }
            it.writeList(RESPONSE_FIELDS[17], graphQlListOfBooleanNullable) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeBoolean(value)
                }
            }
            it.writeList(RESPONSE_FIELDS[18], graphQlListOfListOfString) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeList(value) { value, listItemWriter ->
                        value?.forEach { value ->
                            listItemWriter.writeString(value)
                        }
                    }
                }
            }
            it.writeList(RESPONSE_FIELDS[19], graphQlListOfListOfId) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeList(value) { value, listItemWriter ->
                        value?.forEach { value ->
                            listItemWriter.writeCustom(CustomType.ID, value)
                        }
                    }
                }
            }
            it.writeList(RESPONSE_FIELDS[20], graphQlListOfListOfInt) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeList(value) { value, listItemWriter ->
                        value?.forEach { value ->
                            listItemWriter.writeInt(value)
                        }
                    }
                }
            }
            it.writeList(RESPONSE_FIELDS[21], graphQlListOfListOfFloat) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeList(value) { value, listItemWriter ->
                        value?.forEach { value ->
                            listItemWriter.writeDouble(value)
                        }
                    }
                }
            }
            it.writeList(RESPONSE_FIELDS[22], graphQlListOfListOfBoolean) { value, listItemWriter ->
                value?.forEach { value ->
                    listItemWriter.writeList(value) { value, listItemWriter ->
                        value?.forEach { value ->
                            listItemWriter.writeBoolean(value)
                        }
                    }
                }
            }
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("graphQlString", "graphQlString", null, true, null),
                    ResponseField.forCustomType("graphQlIdNullable", "graphQlIdNullable", null, true, CustomType.ID, null),
                    ResponseField.forCustomType("graphQlIdNonNullable", "graphQlIdNonNullable", null, false, CustomType.ID, null),
                    ResponseField.forInt("graphQlIntNullable", "graphQlIntNullable", null, true, null),
                    ResponseField.forInt("graphQlIntNonNullable", "graphQlIntNonNullable", null, false, null),
                    ResponseField.forDouble("graphQlFloatNullable", "graphQlFloatNullable", null, true, null),
                    ResponseField.forDouble("graphQlFloatNonNullable", "graphQlFloatNonNullable", null, false, null),
                    ResponseField.forBoolean("graphQlBooleanNullable", "graphQlBooleanNullable", null, true, null),
                    ResponseField.forBoolean("graphQlBooleanNonNullable", "graphQlBooleanNonNullable", null, false, null),
                    ResponseField.forList("graphQlListOfStringNullable", "graphQlListOfStringNullable", null, false, null),
                    ResponseField.forList("graphQlListOfStringNonNullable", "graphQlListOfStringNonNullable", null, false, null),
                    ResponseField.forList("graphQlListOfIdNullable", "graphQlListOfIdNullable", null, true, null),
                    ResponseField.forList("graphQlListOfIdNonNullable", "graphQlListOfIdNonNullable", null, false, null),
                    ResponseField.forList("graphQlListOfIntNullable", "graphQlListOfIntNullable", null, true, null),
                    ResponseField.forList("graphQlListOfIntNonNullable", "graphQlListOfIntNonNullable", null, false, null),
                    ResponseField.forList("graphQlListOfFloatNullable", "graphQlListOfFloatNullable", null, true, null),
                    ResponseField.forList("graphQlListOfFloatNonNullable", "graphQlListOfFloatNonNullable", null, false, null),
                    ResponseField.forList("graphQlListOfBooleanNullable", "graphQlListOfBooleanNullable", null, true, null),
                    ResponseField.forList("graphQlListOfListOfString", "graphQlListOfListOfString", null, false, null),
                    ResponseField.forList("graphQlListOfListOfId", "graphQlListOfListOfId", null, false, null),
                    ResponseField.forList("graphQlListOfListOfInt", "graphQlListOfListOfInt", null, false, null),
                    ResponseField.forList("graphQlListOfListOfFloat", "graphQlListOfListOfFloat", null, false, null),
                    ResponseField.forList("graphQlListOfListOfBoolean", "graphQlListOfListOfBoolean", null, false, null)
                    )

            operator fun invoke(reader: ResponseReader): Data {
                val graphQlString = reader.readString(RESPONSE_FIELDS[0])
                val graphQlIdNullable = reader.readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)
                val graphQlIdNonNullable = reader.readCustomType<String>(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField)
                val graphQlIntNullable = reader.readInt(RESPONSE_FIELDS[3])
                val graphQlIntNonNullable = reader.readInt(RESPONSE_FIELDS[4])
                val graphQlFloatNullable = reader.readDouble(RESPONSE_FIELDS[5])
                val graphQlFloatNonNullable = reader.readDouble(RESPONSE_FIELDS[6])
                val graphQlBooleanNullable = reader.readBoolean(RESPONSE_FIELDS[7])
                val graphQlBooleanNonNullable = reader.readBoolean(RESPONSE_FIELDS[8])
                val graphQlListOfStringNullable = reader.readList<String>(RESPONSE_FIELDS[9]) {
                    it.readString()
                }
                val graphQlListOfStringNonNullable = reader.readList<String>(RESPONSE_FIELDS[10]) {
                    it.readString()
                }
                val graphQlListOfIdNullable = reader.readList<String>(RESPONSE_FIELDS[11]) {
                    it.readCustomType<String>(CustomType.ID)
                }
                val graphQlListOfIdNonNullable = reader.readList<String>(RESPONSE_FIELDS[12]) {
                    it.readCustomType<String>(CustomType.ID)
                }
                val graphQlListOfIntNullable = reader.readList<Int>(RESPONSE_FIELDS[13]) {
                    it.readInt()
                }
                val graphQlListOfIntNonNullable = reader.readList<Int>(RESPONSE_FIELDS[14]) {
                    it.readInt()
                }
                val graphQlListOfFloatNullable = reader.readList<Double>(RESPONSE_FIELDS[15]) {
                    it.readDouble()
                }
                val graphQlListOfFloatNonNullable = reader.readList<Double>(RESPONSE_FIELDS[16]) {
                    it.readDouble()
                }
                val graphQlListOfBooleanNullable = reader.readList<Boolean>(RESPONSE_FIELDS[17]) {
                    it.readBoolean()
                }
                val graphQlListOfListOfString = reader.readList<List<String?>>(RESPONSE_FIELDS[18]) {
                    it.readList<String> {
                        it.readString()
                    }
                }
                val graphQlListOfListOfId = reader.readList<List<String?>>(RESPONSE_FIELDS[19]) {
                    it.readList<String> {
                        it.readCustomType<String>(CustomType.ID)
                    }
                }
                val graphQlListOfListOfInt = reader.readList<List<Int?>>(RESPONSE_FIELDS[20]) {
                    it.readList<Int> {
                        it.readInt()
                    }
                }
                val graphQlListOfListOfFloat = reader.readList<List<Double?>>(RESPONSE_FIELDS[21]) {
                    it.readList<Double> {
                        it.readDouble()
                    }
                }
                val graphQlListOfListOfBoolean = reader.readList<List<Boolean?>>(RESPONSE_FIELDS[22]) {
                    it.readList<Boolean> {
                        it.readBoolean()
                    }
                }
                return Data(
                    graphQlString = graphQlString,
                    graphQlIdNullable = graphQlIdNullable,
                    graphQlIdNonNullable = graphQlIdNonNullable,
                    graphQlIntNullable = graphQlIntNullable,
                    graphQlIntNonNullable = graphQlIntNonNullable,
                    graphQlFloatNullable = graphQlFloatNullable,
                    graphQlFloatNonNullable = graphQlFloatNonNullable,
                    graphQlBooleanNullable = graphQlBooleanNullable,
                    graphQlBooleanNonNullable = graphQlBooleanNonNullable,
                    graphQlListOfStringNullable = graphQlListOfStringNullable,
                    graphQlListOfStringNonNullable = graphQlListOfStringNonNullable,
                    graphQlListOfIdNullable = graphQlListOfIdNullable,
                    graphQlListOfIdNonNullable = graphQlListOfIdNonNullable,
                    graphQlListOfIntNullable = graphQlListOfIntNullable,
                    graphQlListOfIntNonNullable = graphQlListOfIntNonNullable,
                    graphQlListOfFloatNullable = graphQlListOfFloatNullable,
                    graphQlListOfFloatNonNullable = graphQlListOfFloatNonNullable,
                    graphQlListOfBooleanNullable = graphQlListOfBooleanNullable,
                    graphQlListOfListOfString = graphQlListOfListOfString,
                    graphQlListOfListOfId = graphQlListOfListOfId,
                    graphQlListOfListOfInt = graphQlListOfListOfInt,
                    graphQlListOfListOfFloat = graphQlListOfListOfFloat,
                    graphQlListOfListOfBoolean = graphQlListOfListOfBoolean
                )
            }
        }
    }

    companion object {
        val OPERATION_DEFINITION: String = ""

        const val OPERATION_ID: String =
                "7824113c9abde76f3c8ffbee5d7065129bc5c47757f34dd5959d5cd16464d014"

        val QUERY_DOCUMENT: String = "query TestQuery {}"

        val OPERATION_NAME: OperationName = OperationName { "TestQuery" }
    }
}
