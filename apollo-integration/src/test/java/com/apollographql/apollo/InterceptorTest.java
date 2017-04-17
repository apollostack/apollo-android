package com.apollographql.apollo;


import com.apollographql.android.impl.normalizer.EpisodeHeroName;
import com.apollographql.android.impl.normalizer.type.Episode;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.cache.normalized.Record;
import com.apollographql.apollo.exception.ApolloException;
import com.apollographql.apollo.interceptor.ApolloInterceptor;
import com.apollographql.apollo.interceptor.ApolloInterceptorChain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

import javax.annotation.Nonnull;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static com.apollographql.apollo.interceptor.ApolloInterceptor.InterceptorResponse;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

public class InterceptorTest {

  private ApolloClient client;
  private MockWebServer mockWebServer;
  private OkHttpClient okHttpClient;

  private static final String FILE_EPISODE_HERO_NAME_WITH_ID = "EpisodeHeroNameResponseWithId.json";

  @Before
  public void setup() {
    mockWebServer = new MockWebServer();
    okHttpClient = new OkHttpClient.Builder().build();
  }

  @Test
  public void applicationInterceptorsCanShortCircuitResponses() throws IOException, ApolloException {
    mockWebServer.shutdown();

    EpisodeHeroName query = EpisodeHeroName.builder().episode(Episode.EMPIRE).build();

    okhttp3.Request request = new okhttp3.Request.Builder()
        .url(mockWebServer.url("/"))
        .build();

    okhttp3.Response okHttpResponse = new okhttp3.Response.Builder()
        .request(request)
        .protocol(Protocol.HTTP_2)
        .code(200)
        .message("Intercepted")
        .body(ResponseBody.create(MediaType.parse("text/plain; charset=utf-8"), "fakeResponse"))
        .build();

    Response<EpisodeHeroName.Data> apolloResponse = new Response<>(query);

    final InterceptorResponse expectedResponse = new InterceptorResponse(okHttpResponse,
        apolloResponse, Collections.<Record>emptyList());

    client = ApolloClient.builder()
        .serverUrl(mockWebServer.url("/"))
        .okHttpClient(okHttpClient)
        .applicationInterceptor(new ApolloInterceptor() {
          @Nonnull @Override
          public InterceptorResponse intercept(Operation operation, ApolloInterceptorChain chain) throws ApolloException {
            return expectedResponse;
          }

          @Override
          public void interceptAsync(@Nonnull Operation operation, @Nonnull ApolloInterceptorChain chain, @Nonnull ExecutorService dispatcher, @Nonnull CallBack callBack) {
            //No op
          }

          @Override public void dispose() {
            //No op
          }
        })
        .build();

    Response<EpisodeHeroName.Data> actualResponse = client.newCall(query).execute();

    assertThat(expectedResponse.parsedResponse.get()).isEqualTo(actualResponse);
  }

  private MockResponse mockResponse(String fileName) throws IOException {
    return new MockResponse().setChunkedBody(Utils.readFileToString(getClass(), "/" + fileName), 32);
  }
}
