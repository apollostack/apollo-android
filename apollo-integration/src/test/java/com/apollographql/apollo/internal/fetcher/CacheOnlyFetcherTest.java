package com.apollographql.apollo.internal.fetcher;

import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.apollographql.apollo.integration.normalizer.EpisodeHeroNameQuery;
import com.apollographql.apollo.integration.normalizer.type.Episode;
import com.apollographql.apollo.rx2.Rx2Apollo;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.apollographql.apollo.fetcher.ApolloResponseFetchers.CACHE_ONLY;
import static com.apollographql.apollo.fetcher.ApolloResponseFetchers.NETWORK_ONLY;
import static com.google.common.truth.Truth.assertThat;

public class CacheOnlyFetcherTest extends BaseFetcherTest {
  @Test public void enqueue() throws IOException, ApolloException, TimeoutException, InterruptedException {
    EpisodeHeroNameQuery query = EpisodeHeroNameQuery.builder().episode(Episode.EMPIRE).build();
    TrackingCallback trackingCallback;

    // Is null when cache empty
    trackingCallback = new TrackingCallback();
    apolloClient.query(query).responseFetcher(CACHE_ONLY).enqueue(trackingCallback);
    assertThat(trackingCallback.exceptions.size()).isEqualTo(0);
    assertThat(trackingCallback.responseList.size()).isEqualTo(1);
    assertThat(trackingCallback.responseList.get(0).isFromCache()).isTrue();
    assertThat(trackingCallback.responseList.get(0).getData()).isNull();
    assertThat(server.getRequestCount()).isEqualTo(0);

    // Populate cache
    server.enqueue(mockResponse("HeroNameResponse.json"));

    final Response<EpisodeHeroNameQuery.Data> responseData
        = Rx2Apollo.from(apolloClient.query(query).responseFetcher(NETWORK_ONLY)).blockingFirst();
    assertThat(responseData.hasErrors()).isFalse();
    assertThat(responseData.getData().hero().name()).isEqualTo("R2-D2");
    assertThat(server.getRequestCount()).isEqualTo(1);

    // Success after cache populated
    server.enqueue(mockResponse("HeroNameResponse.json"));
    trackingCallback = new TrackingCallback();
    apolloClient.query(query).responseFetcher(CACHE_ONLY).enqueue(trackingCallback);
    assertThat(trackingCallback.exceptions.size()).isEqualTo(0);
    assertThat(trackingCallback.responseList.size()).isEqualTo(1);
    assertThat(trackingCallback.responseList.get(0).isFromCache()).isTrue();
    assertThat(trackingCallback.responseList.get(0).getData().hero().name()).isEqualTo("R2-D2");
    assertThat(server.getRequestCount()).isEqualTo(1);
  }
}
