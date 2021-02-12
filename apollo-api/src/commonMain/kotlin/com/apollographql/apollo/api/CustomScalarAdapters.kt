package com.apollographql.apollo.api

import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.apollographql.apollo.api.internal.json.Utils.readRecursively
import com.apollographql.apollo.api.internal.json.Utils.writeToJson

/**
 * A wrapper around a Map of [CustomScalarAdapter] that allows to easily retrieve an adapter for the given [CustomScalar]
 */
class CustomScalarAdapters(val customScalarAdapters: Map<CustomScalar, CustomScalarAdapter<*>>) {

  private val adapterByGraphQLName = customScalarAdapters.mapKeys { it.key.graphqlName }

  @Suppress("UNCHECKED_CAST")
  fun <T : Any> adapterFor(customScalar: CustomScalar): CustomScalarAdapter<T> {
    /**
     * Look in user-registered adapters by scalar type name first
     */
    var customScalarAdapter: CustomScalarAdapter<*>? = adapterByGraphQLName[customScalar.graphqlName]
    if (customScalarAdapter == null) {
      /**
       * If none is found, provide a default adapter based on the implementation class name
       * This saves the user the hassle of registering a scalar adapter for mapping to widespread such as Long, Map, etc...
       * The ScalarType must still be declared in the Gradle plugin configuration.
       */
      customScalarAdapter = adapterByClassName[customScalar.className]
    }
    return requireNotNull(customScalarAdapter) {
      "Can't map GraphQL type: `${customScalar.graphqlName}` to: `${customScalar.className}`. Did you forget to add a CustomScalarAdapter?"
    } as CustomScalarAdapter<T>
  }

  @Suppress("UNCHECKED_CAST")
  fun <T : Any> adapterFor(graphqlName: String): CustomScalarAdapter<T> {
    return adapterByGraphQLName[graphqlName] as CustomScalarAdapter<T>? ?: throw IllegalStateException("Cannot find a CustomScalarAdapter for $graphqlName")
  }

  @Suppress("UNCHECKED_CAST")
  fun <T : Any> responseAdapterFor(graphqlName: String): ResponseAdapter<T> {
    return CustomResponseAdapter(adapterFor(graphqlName))
  }

  class CustomResponseAdapter<T: Any>(private val wrappedAdapter: CustomScalarAdapter<T>) : ResponseAdapter<T> {
    override fun fromResponse(reader: JsonReader, customScalarAdapters: CustomScalarAdapters): T {
      return wrappedAdapter.decode(JsonElement.fromRawValue(reader.readRecursively()))
    }

    override fun toResponse(writer: JsonWriter, value: T, customScalarAdapters: CustomScalarAdapters) {
      writeToJson(wrappedAdapter.encode(value).toRawValue(), writer)
    }
  }

  companion object {
    val DEFAULT = CustomScalarAdapters(emptyMap())

    private val adapterByClassName = mapOf(
        "java.lang.String" to BuiltinCustomScalarAdapters.STRING_ADAPTER,
        "kotlin.String" to  BuiltinCustomScalarAdapters.STRING_ADAPTER,

        "java.lang.Boolean" to BuiltinCustomScalarAdapters.BOOLEAN_ADAPTER,
        "boolean" to  BuiltinCustomScalarAdapters.BOOLEAN_ADAPTER,
        "kotlin.Boolean" to  BuiltinCustomScalarAdapters.BOOLEAN_ADAPTER,

        "java.lang.Integer" to BuiltinCustomScalarAdapters.INT_ADAPTER,
        "int" to BuiltinCustomScalarAdapters.INT_ADAPTER,
        "kotlin.Int" to  BuiltinCustomScalarAdapters.INT_ADAPTER,

        "java.lang.Long" to BuiltinCustomScalarAdapters.LONG_ADAPTER,
        "long" to BuiltinCustomScalarAdapters.LONG_ADAPTER,
        "kotlin.Long" to  BuiltinCustomScalarAdapters.LONG_ADAPTER,

        "java.lang.Float" to BuiltinCustomScalarAdapters.FLOAT_ADAPTER,
        "float" to BuiltinCustomScalarAdapters.FLOAT_ADAPTER,
        "kotlin.Float" to  BuiltinCustomScalarAdapters.FLOAT_ADAPTER,

        "java.lang.Double" to BuiltinCustomScalarAdapters.DOUBLE_ADAPTER,
        "double" to BuiltinCustomScalarAdapters.DOUBLE_ADAPTER,
        "kotlin.Double" to  BuiltinCustomScalarAdapters.DOUBLE_ADAPTER,

        "java.util.Map" to BuiltinCustomScalarAdapters.MAP_ADAPTER,
        "kotlin.collections.Map" to  BuiltinCustomScalarAdapters.MAP_ADAPTER,

        "java.util.List" to BuiltinCustomScalarAdapters.LIST_ADAPTER,
        "kotlin.collections.List" to  BuiltinCustomScalarAdapters.LIST_ADAPTER,

        "com.apollographql.apollo.api.FileUpload" to  BuiltinCustomScalarAdapters.FILE_UPLOAD_ADAPTER,

        "java.lang.Object" to  BuiltinCustomScalarAdapters.FALLBACK_ADAPTER,
        "kotlin.Any" to  BuiltinCustomScalarAdapters.FALLBACK_ADAPTER,
    )
  }
}
