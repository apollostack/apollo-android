package com.apollographql.apollo.compiler.backend

import com.apollographql.apollo.compiler.PackageNameProvider
import com.apollographql.apollo.compiler.backend.ast.AstBuilder.Companion.buildAst
import com.apollographql.apollo.compiler.backend.codegen.implementationTypeSpec
import com.apollographql.apollo.compiler.backend.codegen.interfaceTypeSpec
import com.apollographql.apollo.compiler.backend.codegen.patchKotlinNativeOptionalArrayProperties
import com.apollographql.apollo.compiler.backend.codegen.responseAdapterTypeSpec
import com.apollographql.apollo.compiler.backend.codegen.typeSpec
import com.apollographql.apollo.compiler.backend.ir.BackendIr
import com.apollographql.apollo.compiler.backend.ir.BackendIrBuilder
import com.apollographql.apollo.compiler.backend.ir.BackendIrBuilder.Companion.buildBackendIr
import com.apollographql.apollo.compiler.frontend.gql.Schema
import com.apollographql.apollo.compiler.frontend.gql.toIntrospectionSchema
import com.apollographql.apollo.compiler.introspection.IntrospectionSchema
import com.apollographql.apollo.compiler.operationoutput.OperationOutput
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File

internal class GraphQLCodeGenerator(
    private val input: BackendIrBuilder.BackendIrBuilderInput,
    private val backendIr: BackendIr,
    private val schema: Schema,
    private val customTypeMap: Map<String, String>,
    private val generateAsInternal: Boolean = false,
    private val operationOutput: OperationOutput,
    private val generateFilterNotNull: Boolean,
    private val enumAsSealedClassPatternFilters: List<Regex>
) {
  fun write(outputDir: File) {

    val introspectionSchema = schema.toIntrospectionSchema()
    val ast = backendIr.buildAst(
        schema = introspectionSchema,
        customScalarTypeMap = customTypeMap,
        operationOutput = operationOutput,
        typesPackageName = input.typesPackageName,
        fragmentsPackage = input.fragmentsPackageName
    )

    ast.customScalarScalarTypes
        .filterKeys { scalarType -> input.scalarsToGenerate.contains(scalarType) }
        .takeIf {
          /**
           * Skip generating the ScalarType enum if it's empty
           * This happens in multi-module for leaf modules
           */
          it.isNotEmpty()
        }?.typeSpec(generateAsInternal)
        ?.fileSpec(input.typesPackageName)
        ?.writeTo(outputDir)

    ast.enumTypes
        .filter { enumType -> input.enumsToGenerate.contains(enumType.graphqlName) }
        .forEach { enumType ->
          enumType
              .typeSpec(
                  generateAsInternal = generateAsInternal,
                  enumAsSealedClassPatternFilters = enumAsSealedClassPatternFilters
              )
              .fileSpec(input.typesPackageName)
              .writeTo(outputDir)
        }

    ast.inputTypes
        .filter { inputType -> input.inputObjectsToGenerate.contains(inputType.graphqlName) }
        .forEach { inputType ->
          inputType
              .typeSpec(generateAsInternal)
              .fileSpec(input.typesPackageName)
              .writeTo(outputDir)
        }

    ast.fragmentTypes
        .filter { fragmentType -> input.fragmentsToGenerate.contains(fragmentType.graphqlName) }
        .forEach { fragmentType ->
          fragmentType
              .interfaceTypeSpec(generateAsInternal)
              .fileSpec(input.fragmentsPackageName)
              .writeTo(outputDir)

          fragmentType
              .implementationTypeSpec(generateAsInternal)
              .fileSpec(input.fragmentsPackageName)
              .writeTo(outputDir)
        }

    ast.fragmentTypes
        .filter { input.fragmentsToGenerate.contains(it.graphqlName) }
        .forEach { fragmentType ->
          fragmentType
              .responseAdapterTypeSpec(generateAsInternal)
              .fileSpec("${input.fragmentsPackageName}.adapter")
              .writeTo(outputDir)
        }

    ast.operationTypes.forEach { operationType ->
      operationType
          .typeSpec(
              targetPackage = operationType.packageName,
              generateAsInternal = generateAsInternal
          )
          .let {
            if (generateFilterNotNull) {
              it.patchKotlinNativeOptionalArrayProperties()
            } else it
          }
          .fileSpec(operationType.packageName)
          .writeTo(outputDir)
    }

    ast.operationTypes.forEach { operationType ->
      operationType.responseAdapterTypeSpec(generateAsInternal)
          .fileSpec("${operationType.packageName}.adapter")
          .writeTo(outputDir)
    }
  }

  private fun TypeSpec.fileSpec(packageName: String) =
      FileSpec
          .builder(packageName, name!!)
          .addType(this)
          .addComment("AUTO-GENERATED FILE. DO NOT MODIFY.\n\n" +
              "This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.\n" +
              "It should not be modified by hand.\n"
          )
          .build()
}
