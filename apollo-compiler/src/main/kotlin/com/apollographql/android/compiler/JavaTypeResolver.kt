package com.apollographql.android.compiler

import com.apollographql.android.compiler.ClassNames.parameterizedOptional
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.TypeName

class JavaTypeResolver(
    private val customScalarTypeMap: Map<String, String>,
    private val packageName: String
) {
  fun resolve(typeName: String, isOptional: Boolean = !typeName.endsWith("!")): TypeName {
    val normalizedTypeName = typeName.removeSuffix("!")
    val isList = normalizedTypeName.startsWith('[') && normalizedTypeName.endsWith(']')
    val customScalarType = customScalarTypeMap[normalizedTypeName]
    val javaType = when {
      isList -> ClassNames.parameterizedListOf(resolve(normalizedTypeName.removeSurrounding("[", "]"), false))
      normalizedTypeName == "String" -> ClassNames.STRING
      normalizedTypeName == "ID" -> ClassNames.STRING
      normalizedTypeName == "Int" -> if (isOptional) TypeName.INT.box() else TypeName.INT
      normalizedTypeName == "Boolean" -> if (isOptional) TypeName.BOOLEAN.box() else TypeName.BOOLEAN
      normalizedTypeName == "Float" -> if (isOptional) TypeName.DOUBLE.box() else TypeName.DOUBLE
      customScalarType != null -> customScalarType.toJavaType()
      else -> ClassName.get(packageName, normalizedTypeName)
    }

    return if (javaType.isPrimitive) {
      javaType
    } else if (isOptional) {
      parameterizedOptional(javaType)
    } else {
      javaType.annotated(Annotations.NONNULL)
    }
  }
}