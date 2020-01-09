// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_simple;

import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Optional;
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import com.apollographql.apollo.internal.QueryDocumentMinifier;
import com.apollographql.apollo.response.ScalarTypeAdapters;
import com.example.arguments_simple.fragment.HeroDetails;
import com.example.arguments_simple.type.Episode;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TestQuery implements Query<TestQuery.Data, Optional<TestQuery.Data>, TestQuery.Variables> {
  public static final String OPERATION_ID = "89afe30dd0fa5ddce3d0b743d3adf68e55a48d0c11d10e495c0ec095949e6d04";

  public static final String QUERY_DOCUMENT = QueryDocumentMinifier.minify(
    "query TestQuery($episode: Episode, $IncludeName: Boolean!, $friendsCount: Int!, $listOfListOfStringArgs: [[String]!]!) {\n"
        + "  hero(episode: $episode, listOfListOfStringArgs: $listOfListOfStringArgs) {\n"
        + "    __typename\n"
        + "    name @include(if: $IncludeName)\n"
        + "    ...HeroDetails\n"
        + "  }\n"
        + "  heroWithReview(episode: $episode, review: {}) {\n"
        + "    __typename\n"
        + "    name\n"
        + "  }\n"
        + "}\n"
        + "fragment HeroDetails on Character {\n"
        + "  __typename\n"
        + "  friendsConnection(first: $friendsCount) {\n"
        + "    __typename\n"
        + "    totalCount\n"
        + "    edges {\n"
        + "      __typename\n"
        + "      node {\n"
        + "        __typename\n"
        + "        name @include(if: $IncludeName)\n"
        + "      }\n"
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

  private final TestQuery.Variables variables;

  public TestQuery(@NotNull Input<Episode> episode, boolean includeName, int friendsCount,
      @NotNull List<List<String>> listOfListOfStringArgs) {
    Utils.checkNotNull(episode, "episode == null");
    Utils.checkNotNull(listOfListOfStringArgs, "listOfListOfStringArgs == null");
    variables = new TestQuery.Variables(episode, includeName, friendsCount, listOfListOfStringArgs);
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
  public TestQuery.Variables variables() {
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
    private Input<Episode> episode = Input.absent();

    private boolean includeName;

    private int friendsCount;

    private @NotNull List<List<String>> listOfListOfStringArgs;

    Builder() {
    }

    public Builder episode(@Nullable Episode episode) {
      this.episode = Input.fromNullable(episode);
      return this;
    }

    public Builder includeName(boolean includeName) {
      this.includeName = includeName;
      return this;
    }

    public Builder friendsCount(int friendsCount) {
      this.friendsCount = friendsCount;
      return this;
    }

    public Builder listOfListOfStringArgs(@NotNull List<List<String>> listOfListOfStringArgs) {
      this.listOfListOfStringArgs = listOfListOfStringArgs;
      return this;
    }

    public Builder episodeInput(@NotNull Input<Episode> episode) {
      this.episode = Utils.checkNotNull(episode, "episode == null");
      return this;
    }

    public TestQuery build() {
      Utils.checkNotNull(listOfListOfStringArgs, "listOfListOfStringArgs == null");
      return new TestQuery(episode, includeName, friendsCount, listOfListOfStringArgs);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final Input<Episode> episode;

    private final boolean includeName;

    private final int friendsCount;

    private final @NotNull List<List<String>> listOfListOfStringArgs;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(Input<Episode> episode, boolean includeName, int friendsCount,
        @NotNull List<List<String>> listOfListOfStringArgs) {
      this.episode = episode;
      this.includeName = includeName;
      this.friendsCount = friendsCount;
      this.listOfListOfStringArgs = listOfListOfStringArgs;
      if (episode.defined) {
        this.valueMap.put("episode", episode.value);
      }
      this.valueMap.put("IncludeName", includeName);
      this.valueMap.put("friendsCount", friendsCount);
      this.valueMap.put("listOfListOfStringArgs", listOfListOfStringArgs);
    }

    public Input<Episode> episode() {
      return episode;
    }

    public boolean includeName() {
      return includeName;
    }

    public int friendsCount() {
      return friendsCount;
    }

    public @NotNull List<List<String>> listOfListOfStringArgs() {
      return listOfListOfStringArgs;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          if (episode.defined) {
            writer.writeString("episode", episode.value != null ? episode.value.rawValue() : null);
          }
          writer.writeBoolean("includeName", includeName);
          writer.writeInt("friendsCount", friendsCount);
          writer.writeList("listOfListOfStringArgs", new InputFieldWriter.ListWriter() {
            @Override
            public void write(InputFieldWriter.ListItemWriter listItemWriter) throws IOException {
              for (final List<String> $item : listOfListOfStringArgs) {
                listItemWriter.writeList($item != null ? new InputFieldWriter.ListWriter() {
                  @Override
                  public void write(InputFieldWriter.ListItemWriter listItemWriter) throws
                      IOException {
                    for (final String $$item : $item) {
                      listItemWriter.writeString($$item);
                    }
                  }
                } : null);
              }
            }
          });
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("hero", "hero", new UnmodifiableMapBuilder<String, Object>(2)
      .put("episode", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "episode")
        .build())
      .put("listOfListOfStringArgs", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "listOfListOfStringArgs")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("heroWithReview", "heroWithReview", new UnmodifiableMapBuilder<String, Object>(2)
      .put("episode", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "episode")
        .build())
      .put("review", new UnmodifiableMapBuilder<String, Object>(0)
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final Optional<Hero> hero;

    final Optional<HeroWithReview> heroWithReview;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Data(@Nullable Hero hero, @Nullable HeroWithReview heroWithReview) {
      this.hero = Optional.fromNullable(hero);
      this.heroWithReview = Optional.fromNullable(heroWithReview);
    }

    public Optional<Hero> hero() {
      return this.hero;
    }

    public Optional<HeroWithReview> heroWithReview() {
      return this.heroWithReview;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], hero.isPresent() ? hero.get().marshaller() : null);
          writer.writeObject($responseFields[1], heroWithReview.isPresent() ? heroWithReview.get().marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "hero=" + hero + ", "
          + "heroWithReview=" + heroWithReview
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
        return this.hero.equals(that.hero)
         && this.heroWithReview.equals(that.heroWithReview);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= hero.hashCode();
        h *= 1000003;
        h ^= heroWithReview.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Hero.Mapper heroFieldMapper = new Hero.Mapper();

      final HeroWithReview.Mapper heroWithReviewFieldMapper = new HeroWithReview.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Hero hero = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Hero>() {
          @Override
          public Hero read(ResponseReader reader) {
            return heroFieldMapper.map(reader);
          }
        });
        final HeroWithReview heroWithReview = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<HeroWithReview>() {
          @Override
          public HeroWithReview read(ResponseReader reader) {
            return heroWithReviewFieldMapper.map(reader);
          }
        });
        return new Data(hero, heroWithReview);
      }
    }
  }

  public static class Hero {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Arrays.<ResponseField.Condition>asList(
        ResponseField.Condition.booleanCondition("IncludeName", false)
      ))
    };

    final @NotNull String __typename;

    final Optional<String> name;

    private final @NotNull Fragments fragments;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Hero(@NotNull String __typename, @Nullable String name, @NotNull Fragments fragments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = Optional.fromNullable(name);
      this.fragments = Utils.checkNotNull(fragments, "fragments == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The name of the character
     */
    public Optional<String> name() {
      return this.name;
    }

    public @NotNull Fragments fragments() {
      return this.fragments;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], name.isPresent() ? name.get() : null);
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Hero{"
          + "__typename=" + __typename + ", "
          + "name=" + name + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Hero) {
        Hero that = (Hero) o;
        return this.__typename.equals(that.__typename)
         && this.name.equals(that.name)
         && this.fragments.equals(that.fragments);
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
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      static final ResponseField[] $responseFields = {
        ResponseField.forFragment("__typename", "__typename", Arrays.<ResponseField.Condition>asList(
          ResponseField.Condition.typeCondition(new String[] {"Human", "Droid"})
        ))
      };

      final @NotNull HeroDetails heroDetails;

      private transient volatile String $toString;

      private transient volatile int $hashCode;

      private transient volatile boolean $hashCodeMemoized;

      public Fragments(@NotNull HeroDetails heroDetails) {
        this.heroDetails = Utils.checkNotNull(heroDetails, "heroDetails == null");
      }

      public @NotNull HeroDetails heroDetails() {
        return this.heroDetails;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final HeroDetails $heroDetails = heroDetails;
            if ($heroDetails != null) {
              $heroDetails.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "heroDetails=" + heroDetails
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.heroDetails.equals(that.heroDetails);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= heroDetails.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements ResponseFieldMapper<Fragments> {
        final HeroDetails.Mapper heroDetailsFieldMapper = new HeroDetails.Mapper();

        @Override
        public @NotNull Fragments map(ResponseReader reader) {
          final HeroDetails heroDetails = heroDetailsFieldMapper.map(reader);
          return new Fragments(heroDetails);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<Hero> {
      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public Hero map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final Fragments fragments = fragmentsFieldMapper.map(reader);
        return new Hero(__typename, name, fragments);
      }
    }
  }

  public static class HeroWithReview {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String name;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public HeroWithReview(@NotNull String __typename, @NotNull String name) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = Utils.checkNotNull(name, "name == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * What this human calls themselves
     */
    public @NotNull String name() {
      return this.name;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], name);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "HeroWithReview{"
          + "__typename=" + __typename + ", "
          + "name=" + name
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof HeroWithReview) {
        HeroWithReview that = (HeroWithReview) o;
        return this.__typename.equals(that.__typename)
         && this.name.equals(that.name);
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
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<HeroWithReview> {
      @Override
      public HeroWithReview map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        return new HeroWithReview(__typename, name);
      }
    }
  }
}
