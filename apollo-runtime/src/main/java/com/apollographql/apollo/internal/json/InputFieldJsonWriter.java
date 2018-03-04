package com.apollographql.apollo.internal.json;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.ScalarType;
import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import com.apollographql.apollo.response.ScalarTypeAdapters;

import java.io.IOException;

import javax.annotation.Nonnull;

import static com.apollographql.apollo.api.internal.Utils.checkNotNull;

public class InputFieldJsonWriter implements InputFieldWriter {
  private final JsonWriter jsonWriter;
  private final ScalarTypeAdapters scalarTypeAdapters;

  public InputFieldJsonWriter(JsonWriter jsonWriter, ScalarTypeAdapters scalarTypeAdapters) {
    this.jsonWriter = jsonWriter;
    this.scalarTypeAdapters = scalarTypeAdapters;
  }

  @Override public void writeString(@Nonnull String fieldName, String value) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (value != null) {
      jsonWriter.name(fieldName).value(value);
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  @Override public void writeInt(@Nonnull String fieldName, Integer value) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (value != null) {
      jsonWriter.name(fieldName).value(value);
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  @Override public void writeLong(@Nonnull String fieldName, Long value) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (value != null) {
      jsonWriter.name(fieldName).value(value);
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  @Override public void writeDouble(@Nonnull String fieldName, Double value) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (value != null) {
      jsonWriter.name(fieldName).value(value);
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  @Override public void writeNumber(@Nonnull String fieldName, Number value) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (value != null) {
      jsonWriter.name(fieldName).value(value);
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  @Override public void writeBoolean(@Nonnull String fieldName, Boolean value) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (value != null) {
      jsonWriter.name(fieldName).value(value);
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  @SuppressWarnings("unchecked")
  @Override public void writeCustom(@Nonnull String fieldName, ScalarType scalarType, Object value) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (value != null) {
      CustomTypeAdapter customTypeAdapter = scalarTypeAdapters.adapterFor(scalarType);
      CustomTypeValue customTypeValue = customTypeAdapter.encode(value);
      if (customTypeValue instanceof CustomTypeValue.GraphQLString) {
        writeString(fieldName, ((CustomTypeValue.GraphQLString) customTypeValue).value);
      } else if (customTypeValue instanceof CustomTypeValue.GraphQLBoolean) {
        writeBoolean(fieldName, ((CustomTypeValue.GraphQLBoolean) customTypeValue).value);
      } else if (customTypeValue instanceof CustomTypeValue.GraphQLNumber) {
        writeNumber(fieldName, ((CustomTypeValue.GraphQLNumber) customTypeValue).value);
      } else if (customTypeValue instanceof CustomTypeValue.GraphQLJsonString) {
        writeString(fieldName, ((CustomTypeValue.GraphQLJsonString) customTypeValue).value);
      } else {
        throw new IllegalArgumentException("Unsupported custom value type: " + customTypeValue);
      }
    } else {
      writeString(fieldName, null);
    }
  }

  @Override public void writeObject(@Nonnull String fieldName, InputFieldMarshaller marshaller) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (marshaller != null) {
      jsonWriter.name(fieldName).beginObject();
      marshaller.marshal(this);
      jsonWriter.endObject();
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  @Override public void writeList(@Nonnull String fieldName, ListWriter listWriter) throws IOException {
    checkNotNull(fieldName, "fieldName == null");
    if (listWriter != null) {
      jsonWriter.name(fieldName).beginArray();
      listWriter.write(new JsonListItemWriter(jsonWriter, scalarTypeAdapters));
      jsonWriter.endArray();
    } else {
      jsonWriter.name(fieldName).nullValue();
    }
  }

  private static final class JsonListItemWriter implements ListItemWriter {
    private final JsonWriter jsonWriter;
    private final ScalarTypeAdapters scalarTypeAdapters;

    JsonListItemWriter(JsonWriter jsonWriter, ScalarTypeAdapters scalarTypeAdapters) {
      this.jsonWriter = jsonWriter;
      this.scalarTypeAdapters = scalarTypeAdapters;
    }

    @Override public void writeString(String value) throws IOException {
      if (value == null) {
        jsonWriter.nullValue();
      } else {
        jsonWriter.value(value);
      }
    }

    @Override public void writeInt(Integer value) throws IOException {
      if (value == null) {
        jsonWriter.nullValue();
      } else {
        jsonWriter.value(value);
      }
    }

    @Override public void writeLong(Long value) throws IOException {
      if (value == null) {
        jsonWriter.nullValue();
      } else {
        jsonWriter.value(value);
      }
    }

    @Override public void writeDouble(Double value) throws IOException {
      if (value == null) {
        jsonWriter.nullValue();
      } else {
        jsonWriter.value(value);
      }
    }

    @Override public void writeNumber(Number value) throws IOException {
      if (value == null) {
        jsonWriter.nullValue();
      } else {
        jsonWriter.value(value);
      }
    }

    @Override public void writeBoolean(Boolean value) throws IOException {
      if (value == null) {
        jsonWriter.nullValue();
      } else {
        jsonWriter.value(value);
      }
    }

    @SuppressWarnings("unchecked")
    @Override public void writeCustom(ScalarType scalarType, Object value) throws IOException {
      if (value == null) {
        jsonWriter.nullValue();
      } else {
        CustomTypeAdapter customTypeAdapter = scalarTypeAdapters.adapterFor(scalarType);
        CustomTypeValue customTypeValue = customTypeAdapter.encode(value);
        if (customTypeValue instanceof CustomTypeValue.GraphQLString) {
          writeString(((CustomTypeValue.GraphQLString) customTypeValue).value);
        } else if (customTypeValue instanceof CustomTypeValue.GraphQLBoolean) {
          writeBoolean(((CustomTypeValue.GraphQLBoolean) customTypeValue).value);
        } else if (customTypeValue instanceof CustomTypeValue.GraphQLNumber) {
          writeNumber(((CustomTypeValue.GraphQLNumber) customTypeValue).value);
        } else if (customTypeValue instanceof CustomTypeValue.GraphQLJsonString) {
          writeString(((CustomTypeValue.GraphQLJsonString) customTypeValue).value);
        } else {
          throw new IllegalArgumentException("Unsupported custom value type: " + customTypeValue);
        }
      }
    }

    @Override public void writeObject(InputFieldMarshaller marshaller) throws IOException {
      if (marshaller == null) {
        jsonWriter.nullValue();
      } else {
        jsonWriter.beginObject();
        marshaller.marshal(new InputFieldJsonWriter(jsonWriter, scalarTypeAdapters));
        jsonWriter.endObject();
      }
    }

    @Override public void writeList(ListWriter listWriter) throws IOException {
      if (listWriter == null) {
        jsonWriter.nullValue();
      } else {
        listWriter.write(new JsonListItemWriter(jsonWriter, scalarTypeAdapters));
      }
    }
  }
}