// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.input_object_object_nameclash.type

import com.apollographql.apollo.api.InputType
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import kotlin.String
import kotlin.Suppress

/**
 * A Login INPUT_OBJECT used for tests
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class Login(
  val name: String = "johnDoe"
) : InputType {
  override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
    writer.writeString("name", this@Login.name)
  }
}
