package com.apollographql.apollo3.compiler.unified

import com.apollographql.apollo3.compiler.PackageNameProvider
import com.apollographql.apollo3.compiler.backend.codegen.kotlinNameForFragment
import com.apollographql.apollo3.compiler.backend.codegen.kotlinNameForOperation
import com.apollographql.apollo3.compiler.frontend.GQLArgument
import com.apollographql.apollo3.compiler.frontend.GQLField
import com.apollographql.apollo3.compiler.frontend.GQLFieldDefinition
import com.apollographql.apollo3.compiler.frontend.GQLFragmentDefinition
import com.apollographql.apollo3.compiler.frontend.GQLFragmentSpread
import com.apollographql.apollo3.compiler.frontend.GQLInlineFragment
import com.apollographql.apollo3.compiler.frontend.GQLNamedType
import com.apollographql.apollo3.compiler.frontend.GQLSelection
import com.apollographql.apollo3.compiler.frontend.GQLType
import com.apollographql.apollo3.compiler.frontend.Schema
import com.apollographql.apollo3.compiler.frontend.SourceLocation
import com.apollographql.apollo3.compiler.frontend.coerce
import com.apollographql.apollo3.compiler.frontend.definitionFromScope
import com.apollographql.apollo3.compiler.frontend.findDeprecationReason
import com.apollographql.apollo3.compiler.frontend.leafType
import com.apollographql.apollo3.compiler.frontend.pretty

/**
 * For a list of selections collect all the typeConditions.
 * Then for each combination of typeConditions, collect all the fields recursively.
 *
 * While doing so, record all the used fragments and used types
 *
 * @param registerType a factory for IrType. This is used to track what types are used to only generate those
 */
class IrFieldSetBuilder(
    private val schema: Schema,
    private val allGQLFragmentDefinitions: Map<String, GQLFragmentDefinition>,
    private val packageNameProvider: PackageNameProvider,
    private val registerType: (GQLType) -> IrType,
) {
  private var cachedFragmentsFields = mutableMapOf<String, IrField>()

  fun buildOperation(
      selections: List<GQLSelection>,
      fieldType: String,
      name: String,
  ): IrField {
    val path = ModelPath(packageNameProvider.operationPackageName(
        selections.filePath()),
        listOf(kotlinNameForOperation(name))
    )

    val dataField = buildDataField(
        selections = selections,
        fieldType = fieldType,
        path = path
    )

    return dataField.withInterfacesAndImplementations(
        pruneInterfaces = true,
        addImplementations = true,
        prefix = { "Other$it" },
        path = path
    )
  }

  /**
   * TODO: find a more robust way to get the filePath
   *
   * Note: there might be synthetic selections with filePath == null for __typename fields
   */
  private fun List<GQLSelection>.filePath() = mapNotNull { it.sourceLocation.filePath }.first()

  fun buildFragment(
      selections: List<GQLSelection>,
      fieldType: String,
      name: String,
  ): IrField {
    val path = ModelPath(packageNameProvider.fragmentPackageName(
        selections.filePath()),
        listOf(kotlinNameForFragment(name))
    )

    val dataField = cachedFragmentsFields.getOrPut(name) {
      buildDataField(
          selections = selections,
          fieldType = fieldType,
          path = path
      )
    }

    return dataField.withInterfacesAndImplementations(
        pruneInterfaces = false,
        addImplementations = true,
        prefix = { "${it}Impl" },
        path = path
    )
  }

  private fun buildDataField(
      selections: List<GQLSelection>,
      fieldType: String,
      path: ModelPath,
  ): IrField {
    return buildField(
        name = "data",
        alias = null,
        description = null,
        deprecationReason = null,
        arguments = emptyList(),
        selections = selections,
        type = GQLNamedType(SourceLocation.UNKNOWN, fieldType),
        superFields = emptyList(),
        path = path,
        condition = BooleanExpression.True,
    )
  }

  private fun IrField.withInterfacesAndImplementations(
      pruneInterfaces: Boolean,
      addImplementations: Boolean,
      prefix: (String) -> String,
      path: ModelPath,
  ): IrField {
    if (fieldSets.isEmpty()) {
      // scalar type, exit early
      return this
    }

    val interfaces = mutableListOf<IrFieldSet>()
    val implementations = mutableListOf<IrFieldSet>()

    fieldSets.forEach { fieldSet ->
      var isInterface = false
      if (requiredAsInterface.contains(fieldSet.typeSet) || !pruneInterfaces) {
        isInterface = true
      }

      if (isInterface) {
        val iface = fieldSet.withInterfacesAndImplementations(
            pruneInterfaces = false,
            addImplementations = false,
            prefix = prefix,
            path = path,
            modelName = fieldSet.modelName,
        )
        interfaces.add(iface)
      }

      if (addImplementations && requiredAsImplementation.contains(fieldSet.typeSet)) {
        val implementation = if (isInterface) {
          // both an interface and an implementation
          // make the implementation inherit the interface
          fieldSet
              .withSuper(fieldSet)
              .withInterfacesAndImplementations(
                  pruneInterfaces = true, // for fragments we only need top level interfaces
                  addImplementations = true,
                  prefix = prefix,
                  path = path,
                  modelName = prefix(fieldSet.modelName),
              )
        } else {
          // Just take the fieldSet and make it an implementation
          fieldSet.withInterfacesAndImplementations(
              pruneInterfaces = true, // for fragments we only need top level interfaces
              addImplementations = true,
              prefix = prefix,
              path = path,
              modelName = fieldSet.modelName,
          )
        }
        implementations.add(implementation)
      }
    }

    /**
     * By construction, if there is only one implementation it will be used as type
     */
    val typeFieldSet = if (implementations.size == 1) {
      implementations.first()
    } else {
      interfaces.first { it.typeSet.size == 1 }
    }

    return this.copy(
        interfaces = interfaces,
        implementations = implementations,
        typeFieldSet = typeFieldSet
    )
  }

  private fun IrFieldSet.withInterfacesAndImplementations(
      pruneInterfaces: Boolean,
      addImplementations: Boolean,
      prefix: (String) -> String,
      path: ModelPath,
      modelName: String,
  ): IrFieldSet {
    return this.copy(
        modelName = modelName,
        fields = fields.map { field ->
          field.withInterfacesAndImplementations(
              pruneInterfaces,
              addImplementations,
              prefix,
              path + modelName,
          )
        },
        path = path,
    )
  }

  private fun IrField.withSuper(superField: IrField?): IrField {
    return copy(
        override = override || superField != null,
        fieldSets = fieldSets.map {
          if (it.typeSet.size == 1 && superField != null) {
            it.withSuper(superField.fieldSets.first { it.typeSet.size == 1 })
          } else {
            it
          }
        }
    )
  }

  private fun IrFieldSet.withSuper(fieldSet: IrFieldSet): IrFieldSet {
    return copy(
        fields = fields.map { field ->
          val superField = fieldSet.fields.firstOrNull { it.responseName == field.responseName }
          field.withSuper(superField)
        },
        implements = implements + setOf(fieldSet.fullPath)
    )
  }

  private fun modelName(typeSet: TypeSet, fieldType: String, responseName: String): String {
    return ((typeSet - fieldType).sorted() + responseName).map { it.capitalize() }.joinToString("")
  }

  private fun buildField(
      alias: String?,
      name: String,
      arguments: List<IrArgument>,
      description: String?,
      deprecationReason: String?,
      type: GQLType,
      condition: BooleanExpression,
      selections: List<GQLSelection>,
      superFields: List<IrField>,
      path: ModelPath,
  ): IrField {
    val fieldSets: List<IrFieldSet>
    val shapeTypeSetToPossibleTypes: Map<TypeSet, PossibleTypes>
    val commonTypeSets: Set<TypeSet>
    val fieldType = type.leafType().name

    if (selections.isNotEmpty()) {
      val collectionResult = FragmentCollectionScope(selections, type.leafType().name, allGQLFragmentDefinitions).collect()
      val typeConditions = collectionResult.typeSet.union()

      shapeTypeSetToPossibleTypes = computeShapes(schema, typeConditions)
      val shapesTypeSets = shapeTypeSetToPossibleTypes.keys

      /**
       * Generate the common interfaces
       * We need those to access the shapes in a generic way
       */
      commonTypeSets = shapesTypeSets.toList().combinations()
          .filter { it.size >= 2 }
          .map { it.intersection() }
          .toSet()

      val fragmentFields = collectionResult.namedFragments.map { collectedFragment ->
        val gqlFragmentDefinition = allGQLFragmentDefinitions[collectedFragment.name]!!
        buildFragment(
            selections = gqlFragmentDefinition.selectionSet.selections,
            fieldType = gqlFragmentDefinition.typeCondition.name,
            name = collectedFragment.name,
        )
      }

      /**
       * Create a cache of interface IrFieldSets so that we don't end up building the same FieldSets all the time
       */
      val cachedFieldSets = mutableMapOf<TypeSet, IrFieldSet>()

      val responseName = alias ?: name

      /**
       * Always add the base fieldType in case new types are added to the schema
       */
      val allTypeSets = commonTypeSets + shapesTypeSets + setOf(setOf(fieldType))

      /**
       * Build the field sets starting from the less qualified so we can look up the super
       * interfaces in fieldSetCache when needed
       */
      fieldSets = allTypeSets.sortedBy { it.size }.map { typeSet ->
        val modelName = modelName(typeSet, fieldType, responseName)

        val superFieldSet = cachedFieldSets.values
            .sortedByDescending { it.typeSet.size }
            .firstOrNull {
              it.typeSet.size < typeSet.size && typeSet.implements(it.typeSet)
            }

        val superFragmentFieldSets = fragmentFields.mapNotNull { field ->
          field.fieldSets.sortedByDescending { it.typeSet.size }
              .firstOrNull {
                typeSet.implements(it.typeSet)
              }
        }

        val relatedFieldSets = superFields.mapNotNull { field ->
          field.fieldSets.sortedByDescending { it.typeSet.size }
              .firstOrNull {
                typeSet.implements(it.typeSet)
              }
        }

        buildFieldSet(
            selections = selections,
            fieldType = fieldType,
            typeSet = typeSet,
            modelName = modelName,
            possibleTypes = shapeTypeSetToPossibleTypes[typeSet] ?: emptySet(),
            superFieldSets = superFragmentFieldSets + listOfNotNull(superFieldSet) + relatedFieldSets,
            path = path,
        ).also {
          cachedFieldSets[typeSet] = it
        }
      }
    } else {
      fieldSets = emptyList()
      shapeTypeSetToPossibleTypes = emptyMap()
      commonTypeSets = emptySet()
    }

    return IrField(
        alias = alias,
        name = name,
        arguments = arguments,
        description = description,
        deprecationReason = deprecationReason,
        type = registerType(type),
        condition = condition,
        override = superFields.isNotEmpty(),
        fieldSets = fieldSets,
        requiredAsImplementation = shapeTypeSetToPossibleTypes.keys + setOf(setOf(fieldType)),
        requiredAsInterface = commonTypeSets,
        // will be set later on
        typeFieldSet = null,
        implementations = emptyList(),
        interfaces = emptyList(),
    )
  }

  /**
   * An intermediate class used during collection
   */
  private class CollectedField(
      /**
       * All fields with the same response name should have the same infos here
       */
      val name: String,
      val alias: String?,
      val arguments: List<IrArgument>,

      val description: String?,
      val type: GQLType,
      val deprecationReason: String?,

      /**
       * Merged field will merge their conditions and selectionSets
       */
      val condition: BooleanExpression,
      val selections: List<GQLSelection>,
  ) {
    val responseName = alias ?: name
  }

  private fun collectFields(
      selections: List<GQLSelection>,
      typeCondition: String,
      typeSet: TypeSet,
  ): List<CollectedField> {
    if (!typeSet.contains(typeCondition)) {
      return emptyList()
    }
    val typeDefinition = schema.typeDefinition(typeCondition)

    return selections.flatMap {
      when (it) {
        is GQLField -> {
          val fieldDefinition = it.definitionFromScope(schema, typeDefinition)!!
          listOf(
              CollectedField(
                  name = it.name,
                  alias = it.alias,
                  arguments = it.arguments?.arguments?.map { it.toIr(fieldDefinition) } ?: emptyList(),
                  condition = it.directives.toBooleanExpression(),
                  selections = it.selectionSet?.selections ?: emptyList(),
                  type = fieldDefinition.type,
                  description = fieldDefinition.description,
                  deprecationReason = fieldDefinition.directives.findDeprecationReason(),
              )
          )
        }
        is GQLInlineFragment -> {
          collectFields(it.selectionSet.selections, it.typeCondition.name, typeSet)
        }
        is GQLFragmentSpread -> {
          val fragment = allGQLFragmentDefinitions[it.name]!!
          collectFields(fragment.selectionSet.selections, fragment.typeCondition.name, typeSet)
        }
      }
    }
  }

  private fun GQLArgument.toIr(fieldDefinition: GQLFieldDefinition): IrArgument {
    val argumentDefinition = fieldDefinition.arguments.first { it.name == name }

    return IrArgument(
        name = name,
        value = value.coerce(argumentDefinition.type, schema).orThrow().toIr(),
        defaultValue = argumentDefinition.defaultValue?.coerce(argumentDefinition.type, schema)?.orThrow()?.toIr(),
        type = registerType(argumentDefinition.type)
    )
  }

  private fun buildFieldSet(
      selections: List<GQLSelection>,
      fieldType: String,
      typeSet: TypeSet,
      modelName: String,
      possibleTypes: PossibleTypes,
      superFieldSets: List<IrFieldSet>,
      path: ModelPath,
  ): IrFieldSet {
    val collectedFields = collectFields(selections, fieldType, typeSet)

    val fields = collectedFields.groupBy {
      it.responseName
    }.values.map { fieldsWithSameResponseName ->
      /**
       * Sanity checks, might be removed as this should be done during validation
       */
      check(fieldsWithSameResponseName.map { it.alias }.distinct().size == 1)
      check(fieldsWithSameResponseName.map { it.name }.distinct().size == 1)
      check(fieldsWithSameResponseName.map { it.arguments }.distinct().size == 1)
      // TODO: The same field can have different descriptions in two different objects in which case
      // we should certainly use the interface description
      // check(fieldsWithSameResponseName.map { it.description }.distinct().size == 1)
      check(fieldsWithSameResponseName.map { it.deprecationReason }.distinct().size == 1)
      // GQLTypes might differ because of their source location. Use pretty()
      // to canonicalize them
      check(fieldsWithSameResponseName.map { it.type }.distinctBy { it.pretty() }.size == 1)

      val first = fieldsWithSameResponseName.first()
      val childSelections = fieldsWithSameResponseName.flatMap { it.selections }

      val superFields = superFieldSets.mapNotNull {
        it.fields.firstOrNull { it.responseName == first.responseName }
      }

      buildField(
          alias = first.alias,
          name = first.name,
          arguments = first.arguments,
          description = first.description,
          deprecationReason = first.deprecationReason,
          type = first.type,
          condition = BooleanExpression.Or(fieldsWithSameResponseName.map { it.condition }.toSet()),
          selections = childSelections,
          superFields = superFields,
          path = path + modelName,
      )
    }

    val implements = superFieldSets.map { it.fullPath }.toSet()

    return IrFieldSet(
        modelName = modelName,
        typeSet = typeSet,
        possibleTypes = possibleTypes,
        fields = fields,
        implements = implements,
        path = path,
    )
  }
}