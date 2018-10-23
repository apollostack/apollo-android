package com.example.fragments_with_type_condition.fragment;

import com.apollographql.apollo.api.GraphqlFragment;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Optional;
import com.apollographql.apollo.api.internal.Utils;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated("Apollo GraphQL")
public class DroidDetails implements GraphqlFragment {
  static final ResponseField[] $responseFields = {
    ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
    ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
    ResponseField.forString("primaryFunction", "primaryFunction", null, true, Collections.<ResponseField.Condition>emptyList())
  };

  public static final String FRAGMENT_DEFINITION = "fragment DroidDetails on Droid {\n"
      + "  __typename\n"
      + "  name\n"
      + "  primaryFunction\n"
      + "}";

  public static final List<String> POSSIBLE_TYPES = Collections.unmodifiableList(Arrays.asList( "Droid"));

  final @NotNull String __typename;

  final @NotNull String name;

  final Optional<String> primaryFunction;

  private transient volatile String $toString;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  public DroidDetails(@NotNull String __typename, @NotNull String name,
      @Nullable String primaryFunction) {
    this.__typename = Utils.checkNotNull(__typename, "__typename == null");
    this.name = Utils.checkNotNull(name, "name == null");
    this.primaryFunction = Optional.fromNullable(primaryFunction);
  }

  public @NotNull String __typename() {
    return this.__typename;
  }

  /**
   * What others call this droid
   */
  public @NotNull String name() {
    return this.name;
  }

  /**
   * This droid's primary function
   */
  public Optional<String> primaryFunction() {
    return this.primaryFunction;
  }

  public ResponseFieldMarshaller marshaller() {
    return new ResponseFieldMarshaller() {
      @Override
      public void marshal(ResponseWriter writer) {
        writer.writeString($responseFields[0], __typename);
        writer.writeString($responseFields[1], name);
        writer.writeString($responseFields[2], primaryFunction.isPresent() ? primaryFunction.get() : null);
      }
    };
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "DroidDetails{"
        + "__typename=" + __typename + ", "
        + "name=" + name + ", "
        + "primaryFunction=" + primaryFunction
        + "}";
    }
    return $toString;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DroidDetails) {
      DroidDetails that = (DroidDetails) o;
      return this.__typename.equals(that.__typename)
       && this.name.equals(that.name)
       && this.primaryFunction.equals(that.primaryFunction);
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int h = 1;
      h *= 1000003;
      h ^= __typename.hashCode();
      h *= 1000003;
      h ^= name.hashCode();
      h *= 1000003;
      h ^= primaryFunction.hashCode();
      $hashCode = h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  public static final class Mapper implements ResponseFieldMapper<DroidDetails> {
    @Override
    public DroidDetails map(ResponseReader reader) {
      final String __typename = reader.readString($responseFields[0]);
      final String name = reader.readString($responseFields[1]);
      final String primaryFunction = reader.readString($responseFields[2]);
      return new DroidDetails(__typename, name, primaryFunction);
    }
  }
}
