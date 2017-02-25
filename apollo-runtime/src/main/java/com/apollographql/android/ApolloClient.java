package com.apollographql.android;

import com.apollographql.android.api.graphql.Operation;
import com.apollographql.android.api.graphql.ScalarType;
import com.apollographql.android.cache.HttpCache;
import com.apollographql.android.cache.HttpCacheInterceptor;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

import static com.apollographql.android.Utils.checkNotNull;

/** TODO */
public final class ApolloClient implements ApolloCallFactory {
  public static Builder builder() {
    return new Builder();
  }

  private final HttpUrl serverUrl;
  private final Call.Factory httpCallFactory;
  private final HttpCache httpCache;
  private final Map<ScalarType, CustomTypeAdapter> customTypeAdapters;
  private final Moshi moshi;

  private ApolloClient(Builder builder) {
    this.serverUrl = builder.serverUrl;
    this.httpCallFactory = builder.okHttpClient;
    this.httpCache = builder.httpCache;
    this.customTypeAdapters = builder.customTypeAdapters;
    this.moshi = builder.moshiBuilder.build();
  }

  @Nonnull public <T extends Operation> ApolloCall newCall(@Nonnull T operation) {
    return new RealApolloCall(operation, serverUrl, httpCallFactory, httpCache, moshi, operation.responseFieldMapper(),
        customTypeAdapters);
  }

  public static class Builder {
    OkHttpClient okHttpClient;
    HttpUrl serverUrl;
    Map<ScalarType, CustomTypeAdapter> customTypeAdapters = new LinkedHashMap<>();
    Moshi.Builder moshiBuilder = new Moshi.Builder();
    HttpCache httpCache;

    public Builder okHttpClient(@Nonnull OkHttpClient okHttpClient) {
      this.okHttpClient = checkNotNull(okHttpClient, "okHttpClient == null");
      return this;
    }

    public Builder serverUrl(@Nonnull HttpUrl serverUrl) {
      this.serverUrl = checkNotNull(serverUrl, "serverUrl == null");
      return this;
    }

    public Builder serverUrl(@Nonnull String baseUrl) {
      checkNotNull(baseUrl, "baseUrl == null");
      this.serverUrl = HttpUrl.parse(baseUrl);
      return this;
    }

    public <T> Builder withCustomTypeAdapter(@Nonnull ScalarType scalarType,
        @Nonnull final CustomTypeAdapter<T> customTypeAdapter) {
      customTypeAdapters.put(scalarType, customTypeAdapter);
      moshiBuilder.add(scalarType.javaType(), new JsonAdapter<T>() {
        @Override public T fromJson(com.squareup.moshi.JsonReader reader) throws IOException {
          return customTypeAdapter.decode(reader.nextString());
        }

        @Override public void toJson(JsonWriter writer, T value) throws IOException {
          //noinspection unchecked
          writer.value(customTypeAdapter.encode(value));
        }
      });
      return this;
    }

    public Builder httpCache(HttpCache httpCache) {
      this.httpCache = httpCache;
      return this;
    }

    public ApolloClient build() {
      checkNotNull(okHttpClient, "okHttpClient == null");
      checkNotNull(serverUrl, "serverUrl == null");

      if (httpCache != null) {
        okHttpClient = okHttpClient.newBuilder().addInterceptor(new HttpCacheInterceptor(httpCache)).build();
      }

      return new ApolloClient(this);
    }
  }
}
