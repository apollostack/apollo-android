package com.apollographql.apollo.compiler.parser.graphql.ast

import com.apollographql.apollo.compiler.parser.antlr.GraphQLParser
import com.apollographql.apollo.compiler.parser.error.ParseException
import org.antlr.v4.runtime.tree.TerminalNode


private fun GraphQLParser.DocumentContext.parse(): GQLDocument {
  return GQLDocument(
      definitions = definition().map { it.parse() }
  )
}

private fun GraphQLParser.DefinitionContext.parse(): GQLDefinition {
  return executableDefinition()?.parse()
      ?: typeSystemDefinition()?.parse()
      ?: typeSystemExtension()?.parse()
      ?: throw ParseException("Unrecognized definition", start)
}

private fun GraphQLParser.TypeSystemDefinitionContext.parse(): GQLDefinition {
  return typeDefinition()?.parse()
      ?: directiveDefinition()?.parse()
      ?: typeDefinition()?.parse()
      ?: schemaDefinition()?.parse()
      ?: throw ParseException("Unrecognized executable definition", start)
}

private fun GraphQLParser.SchemaDefinitionContext.parse(): GQLSchemaDefinition {
  return GQLSchemaDefinition(
      description = description().parse(),
      directives = directives().parse(),
      rootOperationTypeDefinitions = operationTypesDefinition().parse()
  )
}

private fun GraphQLParser.DirectiveDefinitionContext.parse(): GQLDirectiveDefinition {
  return GQLDirectiveDefinition(
      description = description().parse(),
      name = name().text,
      arguments = argumentsDefinition().parse()
  )
}

private fun GraphQLParser.TypeDefinitionContext.parse(): GQLDefinition {
  return enumTypeDefinition()?.parse()
      ?: inputObjectDefinition()?.parse()
      ?: objectTypeDefinition()?.parse()
      ?: scalarTypeDefinition()?.parse()
      ?: unionTypeDefinition()?.parse()
      ?: interfaceTypeDefinition()?.parse()
      ?: throw ParseException("Unrecognized type definition", start)
}

private fun GraphQLParser.InterfaceTypeDefinitionContext.parse(): GQLInterfaceTypeDefinition {
  return GQLInterfaceTypeDefinition(
      description = description().parse(),
      name = name().text,
      implementsInterfaces = implementsInterfaces().parse(),
      fields = fieldsDefinition().parse()
  )
}

private fun GraphQLParser.DescriptionContext?.parse(): String {
  return this?.STRING()?.withoutQuotes()
      ?: this?.BLOCK_STRING()?.withoutBlockQuotes()
      ?: ""
}

private fun GraphQLParser.UnionTypeDefinitionContext.parse(): GQLUnionTypeDefinition {
  return GQLUnionTypeDefinition(
      description = description().parse(),
      name = name().text,
      directives = directives().parse(),
      memberTypes = unionMemberTypes().parse()
  )
}

private fun GraphQLParser.ScalarTypeDefinitionContext.parse(): GQLScalarTypeDefinition {
  return GQLScalarTypeDefinition(
      description = description().parse(),
      name = name().text,
      directives = directives().parse()
  )
}

private fun GraphQLParser.ObjectTypeDefinitionContext.parse(): GQLObjectTypeDefinition {
  return GQLObjectTypeDefinition(
      description = description().parse(),
      name = name().text,
      directives = directives().parse(),
      fields = fieldsDefinition().parse(),
      implementsInterfaces = implementsInterfaces().parse()
  )
}

private fun GraphQLParser.InputObjectDefinitionContext.parse(): GQLInputObjectTypeDefinition {
  return GQLInputObjectTypeDefinition(
      description = description().parse(),
      name = name().text,
      directives = directives().parse(),
      fields = inputFieldsDefinition().parse(),
  )
}


private fun GraphQLParser.EnumTypeDefinitionContext.parse(): GQLEnumTypeDefinition {
  return GQLEnumTypeDefinition(
      description = description().parse(),
      name = name().text,
      directives = directives().parse(),
      enumValues = enumValuesDefinition().parse()
  )
}

private fun GraphQLParser.ExecutableDefinitionContext.parse(): GQLDefinition {
  return operationDefinition()?.parse()
      ?: throw ParseException("Unrecognized executable definition", start)
}

private fun GraphQLParser.OperationDefinitionContext.parse(): GQLOperationDefinition {
  return GQLOperationDefinition(
      name = name().text,
      variableDefinitions = variableDefinitions().parse(),
      directives = directives().parse(),
      selections = selectionSet().parse()
  )
}

private fun GraphQLParser.SelectionContext.parse(): GQLSelection {
  return field()?.parse()
      ?: inlineFragment()?.parse()
      ?: fragmentSpread()?.parse()
      ?: throw ParseException("Unrecognized selection", start)
}

private fun GraphQLParser.FragmentSpreadContext.parse(): GQLFragmentSpread {
  return GQLFragmentSpread(
      name = fragmentName().text,
      directives = directives().parse()
  )
}

private fun GraphQLParser.InlineFragmentContext.parse(): GQLInlineFragment {
  return GQLInlineFragment(
      typeCondition = typeCondition()?.namedType()?.name()?.text,
      directives = directives().parse(),
      selectionSet = selectionSet().parse()
  )
}

private fun GraphQLParser.FieldContext.parse(): GQLField {
  return GQLField(
      alias = alias()?.name()?.text,
      name = name().text,
      arguments = arguments().parse(),
      directives = directives().parse(),
      selections = selectionSet().parse()
  )
}

private fun GraphQLParser.FieldDefinitionContext.parse(): GQLFieldDefinition {
  return GQLFieldDefinition(
      description = description().parse(),
      name = name().text,
      arguments = argumentsDefinition().parse(),
      type = type().parse(),
      directives = directives().parse()
  )
}

private fun GraphQLParser.ArgumentsContext?.parse() = this?.argument()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.DirectivesContext?.parse() = this?.directive()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.SelectionSetContext?.parse() = this?.selection()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.VariableDefinitionsContext?.parse() = this?.variableDefinition()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.ImplementsInterfacesContext?.parse() = this?.implementsInterface()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.FieldsDefinitionContext?.parse() = this?.fieldDefinition()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.ArgumentsDefinitionContext?.parse() = this?.inputValueDefinition()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.UnionMemberTypesContext?.parse() = this?.namedType()?.map { it.name().text }
private fun GraphQLParser.InputFieldsDefinitionContext?.parse() = this?.inputValueDefinition()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.EnumValuesDefinitionContext?.parse() = this?.enumValueDefinition()?.map { it.parse() } ?: emptyList()
private fun GraphQLParser.OperationTypesDefinitionContext?.parse() = this?.operationTypeDefinition()?.map { it.parse() } ?: emptyList()

private fun GraphQLParser.OperationTypeDefinitionContext.parse(): GQLOperationTypeDefinition {
  return GQLOperationTypeDefinition(
      operationType = operationType().text,
      namedType = namedType().text
  )
}

private fun GraphQLParser.EnumValueDefinitionContext.parse(): GQLEnumValueDefinition {
  return GQLEnumValueDefinition(
      description = description().parse(),
      name = name().text,
      directives = directives().parse(),
  )
}

private fun GraphQLParser.InputValueDefinitionContext.parse(): GQLInputValueDefinition {
  return GQLInputValueDefinition(
      description = description().parse(),
      name = name().text,
      directives = directives().parse(),
      type = type().parse(),
      defaultValue = defaultValue()?.parse()
  )
}

private fun GraphQLParser.ImplementsInterfaceContext.parse(): String {
  return namedType().text
}

private fun GraphQLParser.DirectiveContext.parse(): GQLDirective {
  return GQLDirective(
      name = name().text,
      arguments = arguments().parse()
  )
}

private fun GraphQLParser.ArgumentContext.parse(): GQLArgument {
  return GQLArgument(name().text, value().parse())
}

private fun GraphQLParser.VariableDefinitionContext.parse(): GQLVariableDefinition {
  return GQLVariableDefinition(
      name = variable().name().text,
      type = type().parse(),
      defaultValue = defaultValue().parse(),
      // TODO("support directives")
      // directives = directives().parse()
  )
}

private fun GraphQLParser.DefaultValueContext.parse(): GQLValue {
  return value().parse()
}

private fun GraphQLParser.ValueContext.parse(): GQLValue {
  return variable()?.parse()
      ?: intValue()?.parse()
      ?: floatValue()?.parse()
      ?: stringValue()?.parse()
      ?: booleanValue()?.parse()
      ?: enumValue()?.parse()
      ?: listValue()?.parse()
      ?: objectValue()?.parse()
      ?: nullValue()?.parse()
      ?: throw ParseException("Unrecognized value", start)
}

private fun GraphQLParser.NullValueContext.parse() = GQLNullValue

private fun GraphQLParser.ObjectValueContext.parse(): GQLObjectValue {
  return GQLObjectValue(
      objectField().map {
        GQLObjectField(it.name().text, it.value().parse())
      }
  )
}

private fun GraphQLParser.ListValueContext.parse(): GQLListValue {
  return GQLListValue(value().map { it.parse() })
}

private fun GraphQLParser.VariableContext.parse(): GQLVariableValue {
  return GQLVariableValue(name().text)
}

private fun GraphQLParser.IntValueContext.parse() = GQLIntValue(text.toInt())
private fun GraphQLParser.FloatValueContext.parse() = GQLFloatValue(text.toDouble())
private fun GraphQLParser.BooleanValueContext.parse() = GQLBooleanValue(text.toBoolean())
private fun GraphQLParser.EnumValueContext.parse() = GQLEnumValue(name().text)
private fun GraphQLParser.StringValueContext.parse(): GQLStringValue {
  return GQLStringValue(STRING()?.text?.removePrefix("\"")?.removeSuffix("\"")
      ?: BLOCK_STRING()?.text?.removePrefix("\"\"\"")?.removeSuffix("\"\"\"")
      ?: throw ParseException("Unrecognized string", start))
}

private fun TerminalNode?.withoutQuotes() = this?.text?.removePrefix("\"")?.removeSuffix("\"")
private fun TerminalNode?.withoutBlockQuotes() = this?.text?.removePrefix("\"\"\"")?.removeSuffix("\"\"\"")

private fun GraphQLParser.TypeContext.parse(): GQLType {
  return namedType()?.parse()
      ?: nonNullType()?.parse()
      ?: listType()?.parse()
      ?: throw ParseException("Unrecognized type", start)

}

private fun GraphQLParser.ListTypeContext.parse(): GQLListType {
  return GQLListType(type().parse())
}

private fun GraphQLParser.NamedTypeContext.parse(): GQLNamedType {
  return GQLNamedType(text)
}

private fun GraphQLParser.NonNullTypeContext.parse(): GQLNonNullType {
  return GQLNonNullType(namedType()?.parse()
      ?: listType()?.parse()
      ?: throw ParseException("Unrecognized on-null type", start)
  )
}
