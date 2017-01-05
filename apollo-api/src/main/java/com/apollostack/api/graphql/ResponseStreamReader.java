package com.apollostack.api.graphql;

import java.io.IOException;

/** TODO java doc **/
public interface ResponseStreamReader extends ResponseReader {
  boolean hasNext() throws IOException;

  void skipNext() throws IOException;

  boolean isNextObject() throws IOException;

  boolean isNextList() throws IOException;

  boolean isNextNull() throws IOException;

  boolean isNextBoolean() throws IOException;

  boolean isNextNumber() throws IOException;

  String nextName() throws IOException;

  ResponseReader buffer() throws IOException;
}
