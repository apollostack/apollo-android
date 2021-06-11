package com.apollographql.apollo3.ast

internal interface VariableReferencesScope {
  val variableReferences: MutableList<VariableReference>
}

interface IssuesScope {
  val issues: MutableList<Issue>
}

internal interface ValidationScope : IssuesScope {
  override val issues: MutableList<Issue>
  val typeDefinitions: Map<String, GQLTypeDefinition>
  val directiveDefinitions: Map<String, GQLDirectiveDefinition>

  fun registerIssue(
      message: String,
      sourceLocation: SourceLocation,
      severity: Issue.Severity = Issue.Severity.ERROR,
      details: ValidationDetails = ValidationDetails.Other,
  ) {
    issues.add(
        Issue.ValidationError(
            message,
            sourceLocation,
            severity,
            details
        )
    )
  }
}

internal class DefaultValidationScope(
    override val typeDefinitions: Map<String, GQLTypeDefinition>,
    override val directiveDefinitions: Map<String, GQLDirectiveDefinition>,
) : ValidationScope {
  constructor(schema: Schema) : this(schema.typeDefinitions, schema.directiveDefinitions)

  override val issues = mutableListOf<Issue>()
}

internal class ExecutableValidationScope2(
    override val typeDefinitions: Map<String, GQLTypeDefinition>,
    override val directiveDefinitions: Map<String, GQLDirectiveDefinition>,
    override val issues: MutableList<Issue> = mutableListOf(),
    override val variableReferences: MutableList<VariableReference> = mutableListOf(),
) : ValidationScope, VariableReferencesScope {
  constructor(validationScope: ValidationScope) : this(
      validationScope.typeDefinitions,
      validationScope.directiveDefinitions,
      validationScope.issues
  )

  constructor(schema: Schema) : this(
      schema.typeDefinitions,
      schema.directiveDefinitions,
  )
}


internal fun ValidationScope.validateDirective(
    directive: GQLDirective,
    directiveContext: GQLNode,
) {
  val directiveLocation = when (directiveContext) {
    is GQLField -> GQLDirectiveLocation.FIELD
    is GQLInlineFragment -> GQLDirectiveLocation.INLINE_FRAGMENT
    is GQLFragmentSpread -> GQLDirectiveLocation.FRAGMENT_SPREAD
    is GQLObjectTypeDefinition -> GQLDirectiveLocation.OBJECT
    is GQLOperationTypeDefinition -> {
      when (directiveContext.operationType) {
        "query" -> GQLDirectiveLocation.QUERY
        "mutation" -> GQLDirectiveLocation.MUTATION
        "subscription" -> GQLDirectiveLocation.SUBSCRIPTION
        else -> error("unknown operation: $directiveContext")
      }
    }
    is GQLFragmentDefinition -> GQLDirectiveLocation.FRAGMENT_DEFINITION
    is GQLVariableDefinition -> GQLDirectiveLocation.VARIABLE_DEFINITION
    is GQLSchemaDefinition -> GQLDirectiveLocation.SCHEMA
    is GQLScalarTypeDefinition -> GQLDirectiveLocation.SCALAR
    is GQLFieldDefinition -> GQLDirectiveLocation.FIELD_DEFINITION
    is GQLInputValueDefinition -> error("validating directices on input values is not supported yet as we need to distinguish between arguments and inputfields")
    is GQLInterfaceTypeDefinition -> GQLDirectiveLocation.INTERFACE
    is GQLUnionTypeDefinition -> GQLDirectiveLocation.UNION
    is GQLEnumTypeDefinition -> GQLDirectiveLocation.ENUM
    is GQLEnumValueDefinition -> GQLDirectiveLocation.ENUM_VALUE
    is GQLInputObjectTypeDefinition -> GQLDirectiveLocation.INPUT_OBJECT
    else -> error("Cannot determine directive location for $directiveContext")

  }
  val directiveDefinition = directiveDefinitions[directive.name]

  if (directiveDefinition == null) {
    registerIssue(
        message = "Unknown directive '${directive.name}'",
        sourceLocation = directive.sourceLocation,
        details = ValidationDetails.UnknownDirective,
        severity = Issue.Severity.WARNING
    )

    return
  }

  if (directiveLocation !in directiveDefinition.locations) {
    registerIssue(
        message = "Directive '${directive.name}' cannot be applied on '$directiveLocation'",
        sourceLocation = directive.sourceLocation
    )

    return
  }

  directive.arguments?.let {
    validateArguments(it, directiveDefinition.arguments, "directive '${directiveDefinition.name}'")
  }

  /**
   * Apollo specific validation
   */
  if (directive.name == "nonnull") {
    extraValidateNonNullDirective(directive, directiveContext)
  }
}

/**
 * Extra Apollo-specific validations
 */
internal fun ValidationScope.extraValidateNonNullDirective(directive: GQLDirective, directiveContext: GQLNode) {
  if (directiveContext is GQLField && (directive.arguments?.arguments?.size ?: 0) > 0) {
    registerIssue(
        message = "'$directive.name' cannot have arguments when applied on a field",
        sourceLocation = directive.sourceLocation
    )

  } else if (directiveContext is GQLObjectTypeDefinition && (directive.arguments?.arguments?.size ?: 0) == 0) {
    registerIssue(
        message = "'${directive.name}' must contain a selection of fields",
        sourceLocation = directive.sourceLocation
    )
    val stringValue = (directive.arguments!!.arguments.first().value as GQLStringValue).value

    val selections = stringValue.parseAsSelections().getOrNull() ?: error("'$stringValue' is not a valid selectionSet")

    val badSelection = selections.firstOrNull { it !is GQLField }
    check(badSelection == null) {
      "'$badSelection' cannot be made non-null. '$stringValue' should only contain fields."
    }

    val nonNullFields = selections.map { (it as GQLField).name }.toSet()
    val schemaFields = directiveContext.fields.map { it.name }.toSet()

    val unknownFields = nonNullFields - schemaFields
    check(unknownFields.isEmpty()) {
      "Fields '${unknownFields.joinToString()}' are not defined in ${directiveContext.name}"
    }
  }

}


private fun ValidationScope.validateArgument(
    argument: GQLArgument,
    inputValueDefinitions: List<GQLInputValueDefinition>,
    debug: String,
) = with(argument) {
  val schemaArgument = inputValueDefinitions.firstOrNull { it.name == name }
  if (schemaArgument == null) {
    registerIssue(message = "Unknown argument `$name` on $debug", sourceLocation = sourceLocation)
    return@with
  }

  // 5.6.2 Input Object Field Names
  // Note that this does not modify the document, it calls coerce because it's easier
  // to validate at the same time but the coerced result is not used here
  validateAndCoerceValue(argument.value, schemaArgument.type)
}

internal fun ValidationScope.validateArguments(
    arguments: GQLArguments,
    inputValueDefinitions: List<GQLInputValueDefinition>,
    debug: String,
) {
  // 5.4.2 Argument Uniqueness
  arguments.arguments.groupBy { it.name }.filter { it.value.size > 1 }.toList().firstOrNull()?.let {
    registerIssue(message = "Argument `${it.first}` is defined multiple times", sourceLocation = it.second.first().sourceLocation)
    return
  }

  // 5.4.2.1 Required arguments
  inputValueDefinitions.forEach { inputValueDefinition ->
    if (inputValueDefinition.type is GQLNonNullType && inputValueDefinition.defaultValue == null) {
      val argumentValue = arguments.arguments.firstOrNull { it.name == inputValueDefinition.name }?.value
      if (argumentValue is GQLNullValue) {
        // This will be caught later when validating individual arguments
        // registerIssue((message = "Cannot pass `null` for a required argument", sourceLocation = argumentValue.sourceLocation))
      } else if (argumentValue == null) {
        registerIssue(message = "No value passed for required argument ${inputValueDefinition.name}", sourceLocation = arguments.sourceLocation)
      }
    }
  }

  arguments.arguments.forEach {
    validateArgument(it, inputValueDefinitions, debug)
  }
}

internal fun ValidationScope.validateVariable(operation: GQLOperationDefinition?, value: GQLVariableValue, expectedType: GQLType) {
  if (operation == null) {
    // if operation is null, it means we're currently validating a fragment outside the context of an operation
    return
  }

  val variableDefinition = operation.variableDefinitions.firstOrNull { it.name == value.name }
  if (variableDefinition == null) {
    registerIssue(
        message = "Variable `${value.name}` is not defined by operation `${operation.name}`",
        sourceLocation = value.sourceLocation
    )
    return
  }
  if (!variableDefinition.type.canInputValueBeAssignedTo(target = expectedType)) {
    registerIssue(
        message = "Variable `${value.name}` of type `${variableDefinition.type.pretty()}` used in position expecting type `${expectedType.pretty()}`",
        sourceLocation = value.sourceLocation
    )
  }
}