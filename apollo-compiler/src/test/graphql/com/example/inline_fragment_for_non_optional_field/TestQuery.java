// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragment_for_non_optional_field;

import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.ScalarTypeAdapters;
import com.apollographql.apollo.api.internal.Optional;
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser;
import com.apollographql.apollo.api.internal.Utils;
import com.apollographql.apollo.internal.QueryDocumentMinifier;
import java.io.IOException;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.Collections;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TestQuery implements Query<TestQuery.Data, Optional<TestQuery.Data>, Operation.Variables> {
  public static final String OPERATION_ID = "5438a5b2731bc2f21c90dcc4bff5628dd91f65534a3f5cab0dbbbfdd3b4bf19b";

  public static final String QUERY_DOCUMENT = QueryDocumentMinifier.minify(
    "query TestQuery {\n"
        + "  hero {\n"
        + "    __typename\n"
        + "    ... on Human {\n"
        + "      height\n"
        + "    }\n"
        + "  }\n"
        + "}"
  );

  public static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "TestQuery";
    }
  };

  private final Operation.Variables variables;

  public TestQuery() {
    this.variables = Operation.EMPTY_VARIABLES;
  }

  @Override
  public String operationId() {
    return OPERATION_ID;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public Optional<TestQuery.Data> wrapData(TestQuery.Data data) {
    return Optional.fromNullable(data);
  }

  @Override
  public Operation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<TestQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  @Override
  @NotNull
  public Response<Optional<TestQuery.Data>> parse(@NotNull final BufferedSource source,
      @NotNull final ScalarTypeAdapters scalarTypeAdapters) throws IOException {
    return SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters);
  }

  @Override
  @NotNull
  public Response<Optional<TestQuery.Data>> parse(@NotNull final BufferedSource source) throws
      IOException {
    return parse(source, ScalarTypeAdapters.DEFAULT);
  }

  public static final class Builder {
    Builder() {
    }

    public TestQuery build() {
      return new TestQuery();
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("hero", "hero", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final Optional<Hero> hero;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Data(@Nullable Hero hero) {
      this.hero = Optional.fromNullable(hero);
    }

    public Optional<Hero> hero() {
      return this.hero;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], hero.isPresent() ? hero.get().marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "hero=" + hero
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return this.hero.equals(that.hero);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= hero.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Hero.Mapper heroFieldMapper = new Hero.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Hero hero = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Hero>() {
          @Override
          public Hero read(ResponseReader reader) {
            return heroFieldMapper.map(reader);
          }
        });
        return new Data(hero);
      }
    }
  }

  public interface Hero {
    @NotNull String __typename();

    ResponseFieldMarshaller marshaller();

    default <T> T visit(Visitor<T> visitor) {
      if (this instanceof AsHuman) {
        return visitor.visit((AsHuman) this);
      } else if (this instanceof AsCharacter) {
        return visitor.visit((AsCharacter) this);
      }
      return visitor.visitDefault(this);
    }

    final class Mapper implements ResponseFieldMapper<Hero> {
      final AsHuman.Mapper asHumanFieldMapper = new AsHuman.Mapper();

      final AsCharacter.Mapper asCharacterFieldMapper = new AsCharacter.Mapper();

      @Override
      public Hero map(ResponseReader reader) {
        final AsHuman asHuman = reader.readConditional(ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("Human")), new ResponseReader.ConditionalTypeReader<AsHuman>() {
          @Override
          public AsHuman read(String conditionalType, ResponseReader reader) {
            return asHumanFieldMapper.map(reader);
          }
        });
        if (asHuman != null) {
          return asHuman;
        }
        return asCharacterFieldMapper.map(reader);
      }
    }

    interface Visitor<T> {
      T visitDefault(@NotNull Hero hero);

      T visit(@NotNull AsHuman asHuman);

      T visit(@NotNull AsCharacter asCharacter);
    }
  }

  public static class AsHuman implements Hero {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("height", "height", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final Optional<Double> height;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public AsHuman(@NotNull String __typename, @Nullable Double height) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.height = Optional.fromNullable(height);
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * Height in the preferred unit, default is meters
     */
    public Optional<Double> height() {
      return this.height;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeDouble($responseFields[1], height.isPresent() ? height.get() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AsHuman{"
          + "__typename=" + __typename + ", "
          + "height=" + height
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AsHuman) {
        AsHuman that = (AsHuman) o;
        return this.__typename.equals(that.__typename)
         && this.height.equals(that.height);
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
        h ^= height.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<AsHuman> {
      @Override
      public AsHuman map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Double height = reader.readDouble($responseFields[1]);
        return new AsHuman(__typename, height);
      }
    }
  }

  public static class AsCharacter implements Hero {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public AsCharacter(@NotNull String __typename) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AsCharacter{"
          + "__typename=" + __typename
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AsCharacter) {
        AsCharacter that = (AsCharacter) o;
        return this.__typename.equals(that.__typename);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<AsCharacter> {
      @Override
      public AsCharacter map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        return new AsCharacter(__typename);
      }
    }
  }
}
