package com.apollographql.apollo.compiler.codegen.kotlin

import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import com.apollographql.apollo.compiler.applyIf
import com.apollographql.apollo.compiler.ast.FieldType
import com.apollographql.apollo.compiler.ast.InputType
import com.apollographql.apollo.compiler.ast.ObjectType
import com.apollographql.apollo.compiler.ast.TypeRef
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

internal object KotlinCodeGen {

  val suppressWarningsAnnotation = AnnotationSpec
      .builder(Suppress::class)
      .addMember("%S, %S, %S, %S, %S", "NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
          "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
      .build()

  fun deprecatedAnnotation(message: String) = AnnotationSpec
      .builder(Deprecated::class)
      .apply {
        if (message.isNotBlank()) {
          addMember("message = %S", message)
        }
      }
      .build()

  fun FieldType.asTypeName(optional: Boolean = false): TypeName = when (this) {
    is FieldType.Scalar -> when (this) {
      FieldType.Scalar.String -> String::class.asClassName()
      FieldType.Scalar.Int -> INT
      FieldType.Scalar.Boolean -> BOOLEAN
      FieldType.Scalar.Float -> DOUBLE
      is FieldType.Scalar.Enum -> ClassName(
          packageName = typeRef.packageName,
          simpleName = typeRef.name
      )
      is FieldType.Scalar.Custom -> ClassName.bestGuess(mappedType)
    }
    is FieldType.Fragments -> ClassName.bestGuess(name)
    is FieldType.Object -> ClassName(
        packageName = typeRef.packageName,
        simpleName = typeRef.name
    )
    is FieldType.Fragment -> ClassName(
        packageName = typeRef.packageName,
        simpleName = typeRef.name
    )
    is FieldType.Array -> List::class.asClassName().parameterizedBy(rawType.asTypeName(optional = isOptional))
  }.let {
    if (optional) it.copy(nullable = true) else it.copy(nullable = false)
  }

  fun ObjectType.Field.asPropertySpec(initializer: CodeBlock) =
      PropertySpec
          .builder(
              name = name,
              type = if (isOptional) type.asTypeName().copy(nullable = true) else type.asTypeName()
          )
          .applyIf(isDeprecated) { addAnnotation(deprecatedAnnotation(deprecationReason)) }
          .applyIf(description.isNotBlank()) { addKdoc("%L\n", description) }
          .initializer(initializer)
          .build()

  fun responseFieldsPropertySpec(fields: List<ObjectType.Field>): PropertySpec {
    val initializer = fields
        .map { field -> field.responseFieldInitializerCode }
        .filterNot { it.isEmpty() }
        .joinToCode(prefix = "arrayOf(\n", separator = ",\n", suffix = "\n)")
    return PropertySpec
        .builder(
            name = "RESPONSE_FIELDS",
            type = Array<ResponseField>::class.asClassName().parameterizedBy(ResponseField::class.asClassName()),
            modifiers = *arrayOf(KModifier.PRIVATE)
        )
        .initializer(initializer)
        .build()
  }

  private val ObjectType.Field.responseFieldInitializerCode: CodeBlock
    get() {
      val factoryMethod = when (type) {
        is FieldType.Scalar -> when (type) {
          is FieldType.Scalar.String -> "forString"
          is FieldType.Scalar.Int -> "forInt"
          is FieldType.Scalar.Boolean -> "forBoolean"
          is FieldType.Scalar.Float -> "forDouble"
          is FieldType.Scalar.Enum -> "forEnum"
          is FieldType.Scalar.Custom -> "forCustomType"
        }
        is FieldType.Object -> "forObject"
        is FieldType.Fragment -> "forFragment"
        is FieldType.Fragments -> null
        is FieldType.Array -> "forList"
      } ?: return CodeBlock.of("")

      val builder = CodeBlock.builder().add("%T.%L", ResponseField::class, factoryMethod)
      when {
        type is FieldType.Scalar && type is FieldType.Scalar.Custom -> {
          builder.add("(%S, %S, %L, %L, %T.%L, %L)", responseName, schemaName, arguments.takeIf { it.isNotEmpty() }.toCode(), isOptional,
              type.customEnumType.asTypeName(), type.customEnumConst, conditionsListCode(conditions))
        }
        type is FieldType.Fragment -> {
          builder.add("(%S, %S, %L)", responseName, schemaName, conditionsListCode(conditions))
        }
        else -> {
          builder.add("(%S, %S, %L, %L, %L)", responseName, schemaName, arguments.takeIf { it.isNotEmpty() }.toCode(), isOptional,
              conditionsListCode(conditions))
        }
      }
      return builder.build()
    }

  private fun conditionsListCode(conditions: List<ObjectType.Field.Condition>): CodeBlock {
    return conditions
        .map { condition ->
          when (condition) {
            is ObjectType.Field.Condition.Type -> {
              val possibleTypes = condition.types.map { CodeBlock.of("%S", it) }.joinToCode(separator = ", ")
              CodeBlock.of("%T.typeCondition(arrayOf(%L))", ResponseField.Condition::class, possibleTypes)
            }
            is ObjectType.Field.Condition.Directive -> CodeBlock.of("%T.booleanCondition(%S, %L)",
                ResponseField.Condition::class, condition.variableName, condition.inverted)
          }
        }
        .joinToCode(separator = ",\n")
        .let {
          if (conditions.isEmpty()) {
            CodeBlock.of("null")
          } else {
            CodeBlock.builder()
                .add("listOf(\n")
                .indent().add(it).unindent()
                .add("\n)")
                .build()
          }
        }
  }

  fun List<ObjectType.Field>.toMapperFun(responseTypeName: TypeName): FunSpec {
    val readFieldsCode = mapIndexed { index, field ->
      CodeBlock.of("val %L = %L", field.name, field.type.readCode(
          reader = "reader",
          field = "RESPONSE_FIELDS[$index]",
          optional = field.isOptional
      ))
    }.joinToCode(separator = "\n", suffix = "\n")
    val mapFieldsCode = map { field ->
      CodeBlock.of("%L = %L", field.name, field.name)
    }.joinToCode(separator = ",\n", suffix = "\n")
    return FunSpec.builder("invoke")
        .addModifiers(KModifier.OPERATOR)
        .addParameter(ParameterSpec.builder("reader", ResponseReader::class).build())
        .returns(responseTypeName)
        .addCode(CodeBlock.builder()
            .add(readFieldsCode)
            .addStatement("return %T(", responseTypeName)
            .indent()
            .add(mapFieldsCode)
            .unindent()
            .addStatement(")")
            .build()
        )
        .build()
  }

  private fun FieldType.readCode(reader: String, field: String, optional: Boolean): CodeBlock {
    return when (this) {
      is FieldType.Scalar -> when (this) {
        is FieldType.Scalar.String -> CodeBlock.of("%L.readString(%L)", reader, field)
        is FieldType.Scalar.Int -> CodeBlock.of("%L.readInt(%L)", reader, field)
        is FieldType.Scalar.Boolean -> CodeBlock.of("%L.readBoolean(%L)", reader, field)
        is FieldType.Scalar.Float -> CodeBlock.of("%L.readDouble(%L)", reader, field)
        is FieldType.Scalar.Enum -> if (optional) {
          CodeBlock.of("%L.readString(%L)?.let{ %T.safeValueOf(it) }", reader, field, typeRef.asTypeName())
        } else {
          CodeBlock.of("%T.safeValueOf(%L.readString(%L))", typeRef.asTypeName(), reader, field)
        }
        is FieldType.Scalar.Custom -> if (field.isNotEmpty()) {
          CodeBlock.of("%L.readCustomType<%T>(%L as %T)", reader, ClassName.bestGuess(mappedType),
              field, ResponseField.CustomTypeField::class)
        } else {
          CodeBlock.of("%L.readCustomType<%T>(%T.%L)", reader, ClassName.bestGuess(mappedType),
              customEnumType.asTypeName(), customEnumConst)
        }
      }
      is FieldType.Object -> {
        val fieldCode = field.takeIf { it.isNotEmpty() }?.let { CodeBlock.of("(%L)", it) } ?: CodeBlock.of("")
        CodeBlock.builder()
            .add("%L.readObject<%T>%L { reader ->\n", reader, typeRef.asTypeName(), fieldCode)
            .indent()
            .addStatement("%T(reader)", typeRef.asTypeName())
            .unindent()
            .add("}\n")
            .build()
      }
      is FieldType.Array -> {
        CodeBlock.builder()
            .apply {
              if (field.isBlank()) {
                add("%L.readList<%T> {\n", reader, rawType.asTypeName())
              } else {
                add("%L.readList<%T>(%L) {\n", reader, rawType.asTypeName(), field)
              }
            }
            .indent()
            .add(rawType.readCode(reader = "it", field = "", optional = isOptional))
            .add("\n")
            .unindent()
            .add("}")
            .build()
      }
      is FieldType.Fragments -> {
        CodeBlock.of("%L(reader)", name)
      }
      is FieldType.Fragment -> {
        CodeBlock.builder()
            .add("%L.readFragment<%T>(%L) { reader ->\n", reader, typeRef.asTypeName(), field)
            .indent()
            .addStatement("%T(reader)", typeRef.asTypeName())
            .unindent()
            .add("}")
            .build()
      }
    }
  }

  fun marshallerFunSpec(fields: List<ObjectType.Field>, override: Boolean = false): FunSpec {
    val writeFieldsCode = fields.mapIndexed { index, field ->
      field.writeCode(field = "RESPONSE_FIELDS[$index]")
    }.joinToCode(separator = "\n", suffix = "\n")
    return FunSpec.builder("marshaller")
        .applyIf(override) { addModifiers(KModifier.OVERRIDE) }
        .returns(ResponseFieldMarshaller::class)
        .beginControlFlow("return %T { _writer ->", ResponseFieldMarshaller::class)
        .addCode(writeFieldsCode)
        .endControlFlow()
        .build()
  }

  private fun ObjectType.Field.writeCode(field: String): CodeBlock {
    return when (type) {
      is FieldType.Scalar -> when (type) {
        is FieldType.Scalar.String -> CodeBlock.of("_writer.writeString(%L, %L)", field, name)
        is FieldType.Scalar.Int -> CodeBlock.of("_writer.writeInt(%L, %L)", field, name)
        is FieldType.Scalar.Boolean -> CodeBlock.of("_writer.writeBoolean(%L, %L)", field, name)
        is FieldType.Scalar.Float -> CodeBlock.of("_writer.writeDouble(%L, %L)", field, name)
        is FieldType.Scalar.Enum -> {
          if (isOptional) {
            CodeBlock.of("_writer.writeString(%L, %L?.rawValue)", field, name)
          } else {
            CodeBlock.of("_writer.writeString(%L, %L.rawValue)", field, name)
          }
        }
        is FieldType.Scalar.Custom -> CodeBlock.of("_writer.writeCustom(%L as %T, %L)", field,
            ResponseField.CustomTypeField::class, name)
      }
      is FieldType.Object -> {
        if (isOptional) {
          CodeBlock.of("_writer.writeObject(%L, %L?.marshaller())", field, name)
        } else {
          CodeBlock.of("_writer.writeObject(%L, %L.marshaller())", field, name)
        }
      }
      is FieldType.Fragment -> {
        if (isOptional) {
          CodeBlock.of("_writer.writeFragment(%L?.marshaller())", name)
        } else {
          CodeBlock.of("_writer.writeFragment(%L.marshaller())", name)
        }
      }
      is FieldType.Array -> {
        CodeBlock.builder()
            .add("_writer.writeList(%L, %L) { _value, _listItemWriter ->\n", field, name)
            .indent()
            .add("_value?.forEach { _value ->\n")
            .indent()
            .add(type.rawType.writeListItemCode)
            .add("\n")
            .unindent()
            .add("}")
            .add("\n")
            .unindent()
            .add("}")
            .build()
      }
      is FieldType.Fragments -> CodeBlock.of("%L.marshaller().marshal(_writer)", name)
    }
  }

  private val FieldType.writeListItemCode: CodeBlock
    get() {
      return when (this) {
        is FieldType.Scalar -> when (this) {
          is FieldType.Scalar.String -> CodeBlock.of("_listItemWriter.writeString(_value)")
          is FieldType.Scalar.Int -> CodeBlock.of("_listItemWriter.writeInt(_value)")
          is FieldType.Scalar.Boolean -> CodeBlock.of("_listItemWriter.writeBoolean(_value)")
          is FieldType.Scalar.Float -> CodeBlock.of("_listItemWriter.writeDouble(_value)")
          is FieldType.Scalar.Enum -> CodeBlock.of("_listItemWriter.writeString(_value?.rawValue)")
          is FieldType.Scalar.Custom -> CodeBlock.of("_listItemWriter.writeCustom(%T.%L, _value)", customEnumType.asTypeName(),
              customEnumConst)
        }
        is FieldType.Object -> CodeBlock.of("_listItemWriter.writeObject(_value?.marshaller())",
            asTypeName())
        is FieldType.Array -> {
          CodeBlock.builder()
              .add(
                  "_listItemWriter.writeList(_value) { _value, _listItemWriter ->\n",
                  List::class.asClassName().parameterizedBy(rawType.asTypeName())
              )
              .indent()
              .add("_value?.forEach { _value ->\n", List::class.asClassName().parameterizedBy(rawType.asTypeName()))
              .indent()
              .add(rawType.writeListItemCode)
              .add("\n")
              .unindent()
              .add("}")
              .add("\n")
              .unindent()
              .add("}")
              .build()
        }
        else -> throw IllegalArgumentException("Unsupported field type: $this")
      }
    }

  fun InputType.Field.asPropertySpec(initializer: CodeBlock) =
      PropertySpec
          .builder(
              name = name,
              type = if (isOptional) Input::class.asClassName().parameterizedBy(
                  type.asTypeName()) else type.asTypeName()
          )
          .apply { if (description.isNotBlank()) addKdoc("%L\n", description) }
          .apply { initializer(initializer) }
          .build()

  fun String.normalizeGraphQLType(): String {
    val normalizedType = removeSuffix("!").removeSurrounding(prefix = "[", suffix = "]").removeSuffix("!")
    return if (normalizedType != this) {
      normalizedType.normalizeGraphQLType()
    } else {
      normalizedType
    }
  }

  fun Any.toDefaultValueCodeBlock(typeName: TypeName, fieldType: FieldType): CodeBlock = when {
    this is Number -> CodeBlock.of("%L%L", castTo(typeName), if (typeName == LONG) "L" else "")
    fieldType is FieldType.Scalar.Enum -> CodeBlock.of("%T.safeValueOf(%S)", typeName, this)
    fieldType is FieldType.Array -> {
      @Suppress("UNCHECKED_CAST")
      (this as List<Any>).toDefaultValueCodeBlock(typeName, fieldType)
    }
    this !is String -> CodeBlock.of("%L", this)
    else -> CodeBlock.of("%S", this)
  }

  private fun List<Any>.toDefaultValueCodeBlock(typeName: TypeName, fieldType: FieldType.Array): CodeBlock {
    return if (isEmpty()) {
      CodeBlock.of("emptyList()")
    } else {
      filterNotNull()
          .map { value ->
            val rawTypeName = (typeName as ParameterizedTypeName).typeArguments.first().copy(nullable = false)
            value.toDefaultValueCodeBlock(rawTypeName, fieldType.rawType)
          }
          .joinToCode(prefix = "listOf(", separator = ", ", suffix = ")")
    }
  }

  private fun Number.castTo(type: TypeName): Number = when (type) {
    INT -> toInt()
    LONG -> toLong()
    FLOAT, DOUBLE -> toDouble()
    else -> this
  }

  fun TypeRef.asTypeName() = ClassName(packageName = packageName, simpleName = name.capitalize())

  private fun Map<String, Any?>?.toCode(): CodeBlock? {
    return when {
      this == null -> null
      this.isEmpty() -> CodeBlock.of("emptyMap<%T, Any>()", String::class.asTypeName())
      else -> CodeBlock.builder()
          .add("mapOf<%T, Any>(\n", String::class.asTypeName())
          .indent()
          .add(map { it.toCode() }.joinToCode(separator = ",\n"))
          .unindent()
          .add(")")
          .build()
    }
  }

  @Suppress("UNCHECKED_CAST")
  private fun Map.Entry<String, Any?>.toCode() = when (value) {
    is Map<*, *> -> CodeBlock.of("%S to %L", key, (value as Map<String, Any>).toCode())
    null -> CodeBlock.of("%S to null", key)
    else -> CodeBlock.of("%S to %S", key, value)
  }
}
