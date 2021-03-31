package com.apollographql.apollo3.compiler.unified.codegen

import com.apollographql.apollo3.compiler.VERSION
import com.apollographql.apollo3.compiler.operationoutput.OperationOutput
import com.apollographql.apollo3.compiler.operationoutput.findOperationId
import com.apollographql.apollo3.compiler.unified.CodegenLayout
import com.apollographql.apollo3.compiler.unified.IntermediateRepresentation
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import java.io.File

/**
 * KotlinPoet [FileSpec] are non qualified. This is a simple wrapper that carries a package name so that we can write the file
 *
 * If multiple [TypeSpec] are in the same [packageName], [fileName] is mandatory
 */
class ApolloFileSpec(
    val packageName: String,
    val typeSpec: List<TypeSpec>,
    val fileName: String,
) {
  constructor(packageName: String, typeSpec: TypeSpec) : this(packageName, listOf(typeSpec), typeSpec.name!!)
}

class KotlinCodeGenerator(
    private val ir: IntermediateRepresentation,
    private val generateAsInternal: Boolean = false,
    private val rootPackageName: String,
    private val schemaPackageName: String,
    private val enumAsSealedClassPatternFilters: Set<String>,
    private val generateScalarMapping: Boolean,
    private val generateFilterNotNull: Boolean,
    private val operationOutput: OperationOutput,
    private val generateFragmentImplementations: Boolean,
    private val generateResponseFields: Boolean,
    private val generateQueryDocument: Boolean,
    private val generateFragmentsAsInterfaces: Boolean,
    private val useSemanticNaming: Boolean,
) {
  fun write(outputDir: File) {
    val layout = CodegenLayout(
        operations = ir.operations,
        fragments = ir.fragments,
        rootPackageName = rootPackageName,
        schemaPackageName = schemaPackageName,
        useSemanticNaming = useSemanticNaming
    )

    val customScalars = if (generateScalarMapping) {
      listOf(ir.customScalars.qualifiedTypeSpec(layout))
    } else {
      emptyList()
    }

    val enums = ir.enums.flatMap { enum ->
      enum.apolloFileSpecs(layout = layout, enumAsSealedClassPatternFilters = enumAsSealedClassPatternFilters)
    }

    val inputObjects = ir.inputObjects.flatMap { inputObject ->
      inputObject.apolloFileSpecs(layout)
    }

    val operations = ir.operations.flatMap { operation ->
      operation.apolloFileSpecs(
          layout,
          generateFilterNotNull,
          operationOutput.findOperationId(operation.name),
          generateResponseFields,
          generateQueryDocument
      )
    }

    val fragments = ir.fragments.flatMap { fragment ->
      fragment.apolloFileSpecs(
          layout,
          generateFilterNotNull,
          generateFragmentImplementations,
          generateResponseFields
      )
    }

    val qualifiedTypeSpecs = customScalars + enums + inputObjects + operations + fragments

    // sanity check
    qualifiedTypeSpecs.groupBy { it.packageName to it.fileName }.forEach {
      check(it.value.size == 1) {
        "Duplicate type found: ${it.key}"
      }
    }

    qualifiedTypeSpecs.forEach {
      fileSpecBuilder(it.packageName, it.fileName)
          .apply {
            it.typeSpec.forEach {
              addType(it.internal(generateAsInternal))
            }
          }
          .build()
          .writeTo(outputDir)
    }
  }

  private fun fileSpecBuilder(packageName: String, name: String): FileSpec.Builder =
      FileSpec
          .builder(packageName, name)
          .addComment("\nAUTO-GENERATED FILE. DO NOT MODIFY.\n\n" +
              "This class was automatically generated by Apollo GraphQL version '$VERSION'.\n"
          )

  private fun TypeSpec.internal(generateAsInternal: Boolean): TypeSpec {
    return if (generateAsInternal) {
      this.toBuilder().addModifiers(KModifier.INTERNAL).build()
    } else {
      this
    }
  }
}