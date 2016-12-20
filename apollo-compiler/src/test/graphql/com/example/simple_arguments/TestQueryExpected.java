package com.example.simple_arguments;

import com.apollostack.api.GraphQLOperation;
import com.apollostack.api.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Nullable;

public final class TestQuery implements GraphQLQuery<TestQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query TestQuery($episode: Episode, $includeName: Boolean!) {\n"
      + "  hero(episode: $episode) {\n"
      + "    __typename\n"
      + "    name @include(if: $includeName)\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private final TestQuery.Variables variables;

  public TestQuery(TestQuery.Variables variables) {
    this.variables = variables;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public TestQuery.Variables variables() {
    return variables;
  }

  public static final class Variables extends GraphQLOperation.Variables {
    @Nullable Episode episode;

    boolean includeName;

    Variables() {
    }

    public @Nullable Episode episode() {
      return episode;
    }

    public boolean includeName() {
      return includeName;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private final Variables variables = new Variables();

      Builder() {
      }

      public Builder episode(@Nullable Episode episode) {
        variables.episode = episode;
        return this;
      }

      public Builder includeName(boolean includeName) {
        variables.includeName = includeName;
        return this;
      }

      public Variables build() {
        return variables;
      }
    }
  }

  public interface Data extends GraphQLOperation.Data {
    @Nullable Hero hero();

    interface Hero {
      @Nullable String name();
    }
  }
}
