package com.example.apollostack.sample;

import com.apollostack.api.GraphQLOperation;
import com.apollostack.api.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class TestQuery implements GraphQLQuery<GraphQLOperation.Variables> {
  public static final String OPERATION_DEFINITION = "query TestQuery {\n"
      + "  hero {\n"
      + "    __typename\n"
      + "    name\n"
      + "    appearsIn\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private final Variables variables;

  public TestQuery() {
    this.variables = Variables.EMPTY_VARIABLES;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public Variables variables() {
    return variables;
  }

  public interface Data extends GraphQLOperation.Data {
    @Nullable Hero hero();

    interface Hero {
      @Nonnull String name();

      @Nonnull List<Episode> appearsIn();
    }
  }
}
