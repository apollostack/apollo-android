package com.apollographql.apollo3.compiler.codegen.adapter

import com.apollographql.apollo3.api.BTerm
import com.apollographql.apollo3.api.BooleanExpression
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.compiler.codegen.Identifier
import com.apollographql.apollo3.compiler.codegen.CgContext
import com.apollographql.apollo3.compiler.codegen.Identifier.RESPONSE_NAMES
import com.apollographql.apollo3.compiler.codegen.Identifier.__typename
import com.apollographql.apollo3.compiler.codegen.Identifier.customScalarAdapters
import com.apollographql.apollo3.compiler.codegen.Identifier.fromJson
import com.apollographql.apollo3.compiler.codegen.Identifier.reader
import com.apollographql.apollo3.compiler.codegen.Identifier.typename
import com.apollographql.apollo3.compiler.codegen.Identifier.value
import com.apollographql.apollo3.compiler.codegen.Identifier.writer
import com.apollographql.apollo3.compiler.codegen.helpers.NamedType
import com.apollographql.apollo3.compiler.codegen.helpers.codeBlock
import com.apollographql.apollo3.compiler.codegen.helpers.writeToResponseCodeBlock
import com.apollographql.apollo3.compiler.ir.IrModel
import com.apollographql.apollo3.compiler.ir.IrModelId
import com.apollographql.apollo3.compiler.ir.IrModelType
import com.apollographql.apollo3.compiler.ir.IrNonNullType
import com.apollographql.apollo3.compiler.ir.IrOptionalType
import com.apollographql.apollo3.compiler.ir.IrProperty
import com.apollographql.apollo3.compiler.ir.IrType
import com.apollographql.apollo3.compiler.ir.isOptional
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.joinToCode

internal fun responseNamesPropertySpec(model: IrModel): PropertySpec {
  val initializer = model.properties.filter { !it.isSynthetic }.map {
    CodeBlock.of("%S", it.info.responseName)
  }.joinToCode(prefix = "listOf(", separator = ", ", suffix = ")")

  return PropertySpec.builder(Identifier.RESPONSE_NAMES, List::class.parameterizedBy(String::class))
      .initializer(initializer)
      .build()
}

internal fun readFromResponseCodeBlock(
    model: IrModel,
    context: CgContext,
    hasTypenameArgument: Boolean,
): CodeBlock {
  val (regularProperties, syntheticProperties) = model.properties.partition { !it.isSynthetic }
  val prefix = model.properties.map { property ->
    val variableInitializer = when {
      hasTypenameArgument && property.info.responseName == "__typename" -> CodeBlock.of(typename)
      (property.info.type is IrNonNullType && property.info.type.ofType is IrOptionalType) -> CodeBlock.of("%T", Optional.Absent::class.asClassName())
      else -> CodeBlock.of("null")
    }

    CodeBlock.of(
        "var·%L:·%T·=·%L",
        context.layout.variableName(property.info.responseName),
        context.resolver.resolveType(property.info.type).copy(nullable = !property.info.type.isOptional()),
        variableInitializer
    )
  }.joinToCode(separator = "\n", suffix = "\n")

  /**
   * Read the regular properties
   */
  val loop = CodeBlock.builder()
      .beginControlFlow("while(true)")
      .beginControlFlow("when·($reader.selectName($RESPONSE_NAMES))")
      .add(
          regularProperties.mapIndexed { index, property ->
            CodeBlock.of(
                "%L·->·%L·=·%L.$fromJson($reader, $customScalarAdapters)",
                index,
                context.layout.variableName(property.info.responseName),
                context.resolver.adapterInitializer(property.info.type, property.requiresBuffering)
            )
          }.joinToCode(separator = "\n", suffix = "\n")
      )
      .addStatement("else -> break")
      .endControlFlow()
      .endControlFlow()
      .build()

  /**
   * Read the synthetic properties
   */
  val checkTypename = if (syntheticProperties.isNotEmpty()) {
    CodeBlock.builder()
        .beginControlFlow("check($__typename·!=·null)")
        .add("%S\n", "__typename was not found")
        .endControlFlow()
        .build()
  } else {
    CodeBlock.of("")
  }

  val syntheticLoop = syntheticProperties.map { property ->
    val evaluate = MemberName("com.apollographql.apollo3.api", "evaluate")
    CodeBlock.builder()
        .beginControlFlow("if(%L.%M(emptySet(),·$__typename))", property.condition.codeBlock(), evaluate)
        .add("$reader.rewind()\n")
        .add(
            CodeBlock.of(
                "%L·=·%L.$fromJson($reader, $customScalarAdapters)\n",
                context.layout.variableName(property.info.responseName),
                context.resolver.resolveModelAdapter(property.info.type.modelId())
            )
        )
        .endControlFlow()
        .build()
  }.joinToCode("\n")

  val suffix = CodeBlock.builder()
      .addStatement("return·%T(", context.resolver.resolveModel(model.id))
      .indent()
      .add(model.properties.map { property ->
        val maybeAssertNotNull = if (property.info.type is IrNonNullType && !property.info.type.isOptional()) "!!" else ""
        CodeBlock.of(
            "%L·=·%L%L",
            context.layout.propertyName(property.info.responseName),
            context.layout.variableName(property.info.responseName),
            maybeAssertNotNull
        )
      }.joinToCode(separator = ",\n", suffix = "\n"))
      .unindent()
      .addStatement(")")
      .build()

  return CodeBlock.builder()
      .add(prefix)
      .add(loop)
      .add(checkTypename)
      .add(syntheticLoop)
      .add(suffix)
      .build()
}

private fun IrType.modelId(): IrModelId {
  return when (this) {
    is IrNonNullType -> ofType.modelId()
    is IrModelType -> id
    else -> error("Synthetic field has an invalid type: $this")
  }
}

internal fun writeToResponseCodeBlock(model: IrModel, context: CgContext): CodeBlock {
  return model.properties.map { it.writeToResponseCodeBlock(context) }.joinToCode("\n")
}

private fun IrProperty.writeToResponseCodeBlock(context: CgContext): CodeBlock {
  val builder = CodeBlock.builder()
  val propertyName = context.layout.propertyName(info.responseName)

  if (!isSynthetic) {
    val adapterInitializer = context.resolver.adapterInitializer(info.type, requiresBuffering)
    builder.addStatement("${writer}.name(%S)", info.responseName)
    builder.addStatement(
        "%L.${Identifier.toJson}($writer, $customScalarAdapters, $value.$propertyName)",
        adapterInitializer
    )
  } else {
    val adapterInitializer = context.resolver.resolveModelAdapter(info.type.modelId())

    /**
     * Output types do not distinguish between null and absent
     */
    builder.beginControlFlow("if·($value.$propertyName·!=·null)")
    builder.addStatement(
        "%L.${Identifier.toJson}($writer, $customScalarAdapters, $value.$propertyName)",
        adapterInitializer
    )
    builder.endControlFlow()
  }

  return builder.build()
}


internal fun ClassName.Companion.from(path: List<String>) = ClassName(
    packageName = path.first(),
    path.drop(1)
)

internal fun CodeBlock.obj(buffered: Boolean): CodeBlock {
  val params = when {
    buffered -> CodeBlock.of("true")
    else -> CodeBlock.of("")
  }
  return CodeBlock.Builder()
      .add("%L", this)
      .add(
          ".%M(%L)",
          MemberName("com.apollographql.apollo3.api", "obj"),
          params
      ).build()
}