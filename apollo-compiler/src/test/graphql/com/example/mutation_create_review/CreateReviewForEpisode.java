// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mutation_create_review;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.ScalarTypeAdapters;
import com.apollographql.apollo.api.internal.Optional;
import com.apollographql.apollo.api.internal.QueryDocumentMinifier;
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import com.example.mutation_create_review.type.CustomType;
import com.example.mutation_create_review.type.Episode;
import com.example.mutation_create_review.type.ReviewInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CreateReviewForEpisode implements Mutation<CreateReviewForEpisode.Data, Optional<CreateReviewForEpisode.Data>, CreateReviewForEpisode.Variables> {
  public static final String OPERATION_ID = "a03fabd18e65530a10eeb22fa148067109b2bd93c21ffbdcb4a920fd90742154";

  public static final String QUERY_DOCUMENT = QueryDocumentMinifier.minify(
    "mutation CreateReviewForEpisode($ep: Episode!, $review: ReviewInput!) {\n"
        + "  createReview(episode: $ep, review: $review) {\n"
        + "    __typename\n"
        + "    stars\n"
        + "    commentary\n"
        + "    listOfListOfString\n"
        + "    listOfListOfEnum\n"
        + "    listOfListOfCustom\n"
        + "    listOfListOfObject {\n"
        + "      __typename\n"
        + "      name\n"
        + "    }\n"
        + "    listOfListOfListOfString\n"
        + "  }\n"
        + "}"
  );

  public static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "CreateReviewForEpisode";
    }
  };

  private final CreateReviewForEpisode.Variables variables;

  public CreateReviewForEpisode(@NotNull Episode ep, @NotNull ReviewInput review) {
    Utils.checkNotNull(ep, "ep == null");
    Utils.checkNotNull(review, "review == null");
    variables = new CreateReviewForEpisode.Variables(ep, review);
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
  public Optional<CreateReviewForEpisode.Data> wrapData(CreateReviewForEpisode.Data data) {
    return Optional.fromNullable(data);
  }

  @Override
  public CreateReviewForEpisode.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CreateReviewForEpisode.Data> responseFieldMapper() {
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
  public Response<Optional<CreateReviewForEpisode.Data>> parse(@NotNull final Map<String, ?> response,
      @NotNull final ScalarTypeAdapters scalarTypeAdapters) {
    return SimpleOperationResponseParser.parse(response, this, scalarTypeAdapters);
  }

  public static final class Builder {
    private @NotNull Episode ep;

    private @NotNull ReviewInput review;

    Builder() {
    }

    public Builder ep(@NotNull Episode ep) {
      this.ep = ep;
      return this;
    }

    public Builder review(@NotNull ReviewInput review) {
      this.review = review;
      return this;
    }

    public CreateReviewForEpisode build() {
      Utils.checkNotNull(ep, "ep == null");
      Utils.checkNotNull(review, "review == null");
      return new CreateReviewForEpisode(ep, review);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @NotNull Episode ep;

    private final @NotNull ReviewInput review;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@NotNull Episode ep, @NotNull ReviewInput review) {
      this.ep = ep;
      this.review = review;
      this.valueMap.put("ep", ep);
      this.valueMap.put("review", review);
    }

    public @NotNull Episode ep() {
      return ep;
    }

    public @NotNull ReviewInput review() {
      return review;
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
          writer.writeString("ep", ep.rawValue());
          writer.writeObject("review", review.marshaller());
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("createReview", "createReview", new UnmodifiableMapBuilder<String, Object>(2)
      .put("episode", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "ep")
        .build())
      .put("review", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "review")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final Optional<CreateReview> createReview;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Data(@Nullable CreateReview createReview) {
      this.createReview = Optional.fromNullable(createReview);
    }

    public Optional<CreateReview> createReview() {
      return this.createReview;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], createReview.isPresent() ? createReview.get().marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createReview=" + createReview
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
        return this.createReview.equals(that.createReview);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= createReview.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CreateReview.Mapper createReviewFieldMapper = new CreateReview.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final CreateReview createReview = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<CreateReview>() {
          @Override
          public CreateReview read(ResponseReader reader) {
            return createReviewFieldMapper.map(reader);
          }
        });
        return new Data(createReview);
      }
    }
  }

  public static class CreateReview {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("stars", "stars", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("commentary", "commentary", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("listOfListOfString", "listOfListOfString", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("listOfListOfEnum", "listOfListOfEnum", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("listOfListOfCustom", "listOfListOfCustom", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("listOfListOfObject", "listOfListOfObject", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("listOfListOfListOfString", "listOfListOfListOfString", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final int stars;

    final Optional<String> commentary;

    final Optional<List<List<String>>> listOfListOfString;

    final Optional<List<List<Episode>>> listOfListOfEnum;

    final Optional<List<List<Date>>> listOfListOfCustom;

    final Optional<List<List<ListOfListOfObject>>> listOfListOfObject;

    final Optional<List<List<List<String>>>> listOfListOfListOfString;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public CreateReview(@NotNull String __typename, int stars, @Nullable String commentary,
        @Nullable List<List<String>> listOfListOfString,
        @Nullable List<List<Episode>> listOfListOfEnum,
        @Nullable List<List<Date>> listOfListOfCustom,
        @Nullable List<List<ListOfListOfObject>> listOfListOfObject,
        @Nullable List<List<List<String>>> listOfListOfListOfString) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.stars = stars;
      this.commentary = Optional.fromNullable(commentary);
      this.listOfListOfString = Optional.fromNullable(listOfListOfString);
      this.listOfListOfEnum = Optional.fromNullable(listOfListOfEnum);
      this.listOfListOfCustom = Optional.fromNullable(listOfListOfCustom);
      this.listOfListOfObject = Optional.fromNullable(listOfListOfObject);
      this.listOfListOfListOfString = Optional.fromNullable(listOfListOfListOfString);
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The number of stars this review gave, 1-5
     */
    public int stars() {
      return this.stars;
    }

    /**
     * Comment about the movie
     */
    public Optional<String> commentary() {
      return this.commentary;
    }

    /**
     * for test purpose only
     */
    public Optional<List<List<String>>> listOfListOfString() {
      return this.listOfListOfString;
    }

    /**
     * for test purpose only
     */
    public Optional<List<List<Episode>>> listOfListOfEnum() {
      return this.listOfListOfEnum;
    }

    /**
     * for test purpose only
     */
    public Optional<List<List<Date>>> listOfListOfCustom() {
      return this.listOfListOfCustom;
    }

    /**
     * for test purpose only
     */
    public Optional<List<List<ListOfListOfObject>>> listOfListOfObject() {
      return this.listOfListOfObject;
    }

    /**
     * for test purpose only
     */
    public Optional<List<List<List<String>>>> listOfListOfListOfString() {
      return this.listOfListOfListOfString;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeInt($responseFields[1], stars);
          writer.writeString($responseFields[2], commentary.isPresent() ? commentary.get() : null);
          writer.writeList($responseFields[3], listOfListOfString.isPresent() ? listOfListOfString.get() : null, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeList((List) item, new ResponseWriter.ListWriter() {
                  @Override
                  public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
                    for (Object item : items) {
                      listItemWriter.writeString((String) item);
                    }
                  }
                });
              }
            }
          });
          writer.writeList($responseFields[4], listOfListOfEnum.isPresent() ? listOfListOfEnum.get() : null, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeList((List) item, new ResponseWriter.ListWriter() {
                  @Override
                  public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
                    for (Object item : items) {
                      listItemWriter.writeString(((Episode) item).rawValue());
                    }
                  }
                });
              }
            }
          });
          writer.writeList($responseFields[5], listOfListOfCustom.isPresent() ? listOfListOfCustom.get() : null, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeList((List) item, new ResponseWriter.ListWriter() {
                  @Override
                  public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
                    for (Object item : items) {
                      listItemWriter.writeCustom(CustomType.DATE, item);
                    }
                  }
                });
              }
            }
          });
          writer.writeList($responseFields[6], listOfListOfObject.isPresent() ? listOfListOfObject.get() : null, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeList((List) item, new ResponseWriter.ListWriter() {
                  @Override
                  public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
                    for (Object item : items) {
                      listItemWriter.writeObject(((ListOfListOfObject) item).marshaller());
                    }
                  }
                });
              }
            }
          });
          writer.writeList($responseFields[7], listOfListOfListOfString.isPresent() ? listOfListOfListOfString.get() : null, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeList((List) item, new ResponseWriter.ListWriter() {
                  @Override
                  public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
                    for (Object item : items) {
                      listItemWriter.writeList((List) item, new ResponseWriter.ListWriter() {
                        @Override
                        public void write(List items,
                            ResponseWriter.ListItemWriter listItemWriter) {
                          for (Object item : items) {
                            listItemWriter.writeString((String) item);
                          }
                        }
                      });
                    }
                  }
                });
              }
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CreateReview{"
          + "__typename=" + __typename + ", "
          + "stars=" + stars + ", "
          + "commentary=" + commentary + ", "
          + "listOfListOfString=" + listOfListOfString + ", "
          + "listOfListOfEnum=" + listOfListOfEnum + ", "
          + "listOfListOfCustom=" + listOfListOfCustom + ", "
          + "listOfListOfObject=" + listOfListOfObject + ", "
          + "listOfListOfListOfString=" + listOfListOfListOfString
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof CreateReview) {
        CreateReview that = (CreateReview) o;
        return this.__typename.equals(that.__typename)
         && this.stars == that.stars
         && this.commentary.equals(that.commentary)
         && this.listOfListOfString.equals(that.listOfListOfString)
         && this.listOfListOfEnum.equals(that.listOfListOfEnum)
         && this.listOfListOfCustom.equals(that.listOfListOfCustom)
         && this.listOfListOfObject.equals(that.listOfListOfObject)
         && this.listOfListOfListOfString.equals(that.listOfListOfListOfString);
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
        h ^= stars;
        h *= 1000003;
        h ^= commentary.hashCode();
        h *= 1000003;
        h ^= listOfListOfString.hashCode();
        h *= 1000003;
        h ^= listOfListOfEnum.hashCode();
        h *= 1000003;
        h ^= listOfListOfCustom.hashCode();
        h *= 1000003;
        h ^= listOfListOfObject.hashCode();
        h *= 1000003;
        h ^= listOfListOfListOfString.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<CreateReview> {
      final ListOfListOfObject.Mapper listOfListOfObjectFieldMapper = new ListOfListOfObject.Mapper();

      @Override
      public CreateReview map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final int stars = reader.readInt($responseFields[1]);
        final String commentary = reader.readString($responseFields[2]);
        final List<List<String>> listOfListOfString = reader.readList($responseFields[3], new ResponseReader.ListReader<List<String>>() {
          @Override
          public List<String> read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readList(new ResponseReader.ListReader<String>() {
              @Override
              public String read(ResponseReader.ListItemReader listItemReader) {
                return listItemReader.readString();
              }
            });
          }
        });
        final List<List<Episode>> listOfListOfEnum = reader.readList($responseFields[4], new ResponseReader.ListReader<List<Episode>>() {
          @Override
          public List<Episode> read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readList(new ResponseReader.ListReader<Episode>() {
              @Override
              public Episode read(ResponseReader.ListItemReader listItemReader) {
                return Episode.safeValueOf(listItemReader.readString());
              }
            });
          }
        });
        final List<List<Date>> listOfListOfCustom = reader.readList($responseFields[5], new ResponseReader.ListReader<List<Date>>() {
          @Override
          public List<Date> read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readList(new ResponseReader.ListReader<Date>() {
              @Override
              public Date read(ResponseReader.ListItemReader listItemReader) {
                return listItemReader.readCustomType(CustomType.DATE);
              }
            });
          }
        });
        final List<List<ListOfListOfObject>> listOfListOfObject = reader.readList($responseFields[6], new ResponseReader.ListReader<List<ListOfListOfObject>>() {
          @Override
          public List<ListOfListOfObject> read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readList(new ResponseReader.ListReader<ListOfListOfObject>() {
              @Override
              public ListOfListOfObject read(ResponseReader.ListItemReader listItemReader) {
                return listItemReader.readObject(new ResponseReader.ObjectReader<ListOfListOfObject>() {
                  @Override
                  public ListOfListOfObject read(ResponseReader reader) {
                    return listOfListOfObjectFieldMapper.map(reader);
                  }
                });
              }
            });
          }
        });
        final List<List<List<String>>> listOfListOfListOfString = reader.readList($responseFields[7], new ResponseReader.ListReader<List<List<String>>>() {
          @Override
          public List<List<String>> read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readList(new ResponseReader.ListReader<List<String>>() {
              @Override
              public List<String> read(ResponseReader.ListItemReader listItemReader) {
                return listItemReader.readList(new ResponseReader.ListReader<String>() {
                  @Override
                  public String read(ResponseReader.ListItemReader listItemReader) {
                    return listItemReader.readString();
                  }
                });
              }
            });
          }
        });
        return new CreateReview(__typename, stars, commentary, listOfListOfString, listOfListOfEnum, listOfListOfCustom, listOfListOfObject, listOfListOfListOfString);
      }
    }
  }

  public static class ListOfListOfObject {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String name;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public ListOfListOfObject(@NotNull String __typename, @NotNull String name) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = Utils.checkNotNull(name, "name == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The name of the character
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
        $toString = "ListOfListOfObject{"
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
      if (o instanceof ListOfListOfObject) {
        ListOfListOfObject that = (ListOfListOfObject) o;
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

    public static final class Mapper implements ResponseFieldMapper<ListOfListOfObject> {
      @Override
      public ListOfListOfObject map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        return new ListOfListOfObject(__typename, name);
      }
    }
  }
}
