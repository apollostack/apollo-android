package com.apollographql.apollo3.integration.test.normalized

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.ApolloRequest
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Input
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.cache.normalized.ApolloStore
import com.apollographql.apollo3.cache.normalized.MemoryCacheFactory
import com.apollographql.apollo3.integration.IdFieldCacheKeyResolver
import com.apollographql.apollo3.integration.enqueue
import com.apollographql.apollo3.integration.httpcache.AllPlanetsQuery
import com.apollographql.apollo3.integration.normalizer.EpisodeHeroNameQuery
import com.apollographql.apollo3.integration.normalizer.HeroAndFriendsNamesQuery
import com.apollographql.apollo3.integration.normalizer.HeroAndFriendsNamesWithIDForParentOnlyQuery
import com.apollographql.apollo3.integration.normalizer.HeroAndFriendsNamesWithIDsQuery
import com.apollographql.apollo3.integration.normalizer.HeroAppearsInQuery
import com.apollographql.apollo3.integration.normalizer.HeroParentTypeDependentFieldQuery
import com.apollographql.apollo3.integration.normalizer.HeroParentTypeDependentFieldQuery.Data.DroidHero.Friend.Companion.asHuman
import com.apollographql.apollo3.integration.normalizer.HeroParentTypeDependentFieldQuery.Data.Hero.Companion.asDroid
import com.apollographql.apollo3.integration.normalizer.HeroTypeDependentAliasedFieldQuery
import com.apollographql.apollo3.integration.normalizer.HeroTypeDependentAliasedFieldQuery.Data.Hero.Companion.asDroid
import com.apollographql.apollo3.integration.normalizer.HeroTypeDependentAliasedFieldQuery.Data.Hero.Companion.asHuman
import com.apollographql.apollo3.integration.normalizer.SameHeroTwiceQuery
import com.apollographql.apollo3.integration.normalizer.StarshipByIdQuery
import com.apollographql.apollo3.integration.normalizer.type.Episode
import com.apollographql.apollo3.integration.readResource
import com.apollographql.apollo3.interceptor.cache.FetchPolicy
import com.apollographql.apollo3.interceptor.cache.withFetchPolicy
import com.apollographql.apollo3.interceptor.cache.withStore
import com.apollographql.apollo3.mockserver.MockServer
import com.apollographql.apollo3.testing.runWithMainLoop
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import com.apollographql.apollo3.integration.assertEquals2 as assertEquals

/**
 * A series of high level cache tests that use NetworkOnly to cache a json and then retrieve it with CacheOnly and make
 * sure everything works.
 *
 * The tests are simple and are most likely already covered by the other tests but it's kept here for consistency
 * and maybe they'll catch something one day?
 */
class BasicTest {
  private lateinit var mockServer: MockServer
  private lateinit var apolloClient: ApolloClient
  private lateinit var store: ApolloStore

  @BeforeTest
  fun setUp() {
    store = ApolloStore(MemoryCacheFactory(maxSizeBytes = Int.MAX_VALUE), IdFieldCacheKeyResolver)
    mockServer = MockServer()
    apolloClient = ApolloClient(mockServer.url()).withStore(store)
  }

  @Test
  fun episodeHeroName() = basicTest(
      "HeroNameResponse.json",
      EpisodeHeroNameQuery(Input.Present(Episode.EMPIRE))
  ) {

    assertFalse(hasErrors())
    assertEquals(data?.hero?.name, "R2-D2")
  }

  @Test
  @Throws(Exception::class)
  fun heroAndFriendsNameResponse() = basicTest(
      "HeroAndFriendsNameResponse.json",
      HeroAndFriendsNamesQuery(Input.Present(Episode.JEDI))
  ) {

    assertFalse(hasErrors())
    assertEquals(data?.hero?.name, "R2-D2")
    assertEquals(data?.hero?.friends?.size, 3)
    assertEquals(data?.hero?.friends?.get(0)?.name, "Luke Skywalker")
    assertEquals(data?.hero?.friends?.get(1)?.name, "Han Solo")
    assertEquals(data?.hero?.friends?.get(2)?.name, "Leia Organa")
  }

  @Test
  fun heroAndFriendsNamesWithIDs() = basicTest(
      "HeroAndFriendsNameWithIdsResponse.json",
      HeroAndFriendsNamesWithIDsQuery(Input.Present(Episode.NEWHOPE))
  ) {

    assertFalse(hasErrors())
    assertEquals(data?.hero?.id, "2001")
    assertEquals(data?.hero?.name, "R2-D2")
    assertEquals(data?.hero?.friends?.size, 3)
    assertEquals(data?.hero?.friends?.get(0)?.id, "1000")
    assertEquals(data?.hero?.friends?.get(0)?.name, "Luke Skywalker")
    assertEquals(data?.hero?.friends?.get(1)?.id, "1002")
    assertEquals(data?.hero?.friends?.get(1)?.name, "Han Solo")
    assertEquals(data?.hero?.friends?.get(2)?.id, "1003")
    assertEquals(data?.hero?.friends?.get(2)?.name, "Leia Organa")
  }

  @Test
  @Throws(Exception::class)
  fun heroAndFriendsNameWithIdsForParentOnly() = basicTest(
      "HeroAndFriendsNameWithIdsParentOnlyResponse.json",
      HeroAndFriendsNamesWithIDForParentOnlyQuery(Input.Present(Episode.NEWHOPE))
  ) {

    assertFalse(hasErrors())
    assertEquals(data?.hero?.id, "2001")
    assertEquals(data?.hero?.name, "R2-D2")
    assertEquals(data?.hero?.friends?.size, 3)
    assertEquals(data?.hero?.friends?.get(0)?.name, "Luke Skywalker")
    assertEquals(data?.hero?.friends?.get(1)?.name, "Han Solo")
    assertEquals(data?.hero?.friends?.get(2)?.name, "Leia Organa")
  }

  @Test
  @Throws(Exception::class)
  fun heroAppearsInResponse() = basicTest(
      "HeroAppearsInResponse.json",
      HeroAppearsInQuery()
  ) {

    assertFalse(hasErrors())
    assertEquals(data?.hero?.appearsIn?.size, 3)
    assertEquals(data?.hero?.appearsIn?.get(0), Episode.NEWHOPE)
    assertEquals(data?.hero?.appearsIn?.get(1), Episode.EMPIRE)
    assertEquals(data?.hero?.appearsIn?.get(2), Episode.JEDI)
  }

  @Test
  fun heroAppearsInResponseWithNulls() = basicTest(
      "HeroAppearsInResponseWithNulls.json",
      HeroAppearsInQuery()
  ) {

    assertFalse(hasErrors())
    assertEquals(data?.hero?.appearsIn?.size, 6)
    assertNull(data?.hero?.appearsIn?.get(0))
    assertEquals(data?.hero?.appearsIn?.get(1), Episode.NEWHOPE)
    assertEquals(data?.hero?.appearsIn?.get(2), Episode.EMPIRE)
    assertNull(data?.hero?.appearsIn?.get(3))
    assertEquals(data?.hero?.appearsIn?.get(4), Episode.JEDI)
    assertNull(data?.hero?.appearsIn?.get(5))
  }

  @Test
  @Throws(Exception::class)
  fun heroParentTypeDependentField() = basicTest(
      "HeroParentTypeDependentFieldDroidResponse.json",
      HeroParentTypeDependentFieldQuery(Input.Present(Episode.NEWHOPE))
  ) {

    assertFalse(hasErrors())
    assertEquals(data?.hero?.name, "R2-D2")
    assertEquals(data?.hero?.name, "R2-D2")
    val hero = data?.hero?.asDroid()!!
    assertEquals(hero.friends?.size, 3)
    assertEquals(hero.friends?.get(0)?.name, "Luke Skywalker")
    assertEquals(hero.friends?.get(0)?.name, "Luke Skywalker")
    assertEquals((hero.friends?.get(0)?.asHuman())?.height, 1.72)
  }


  @Test
  fun `polymorphic Droid fields get parsed to Droid`() = basicTest(
      "HeroTypeDependentAliasedFieldResponse.json",
      HeroTypeDependentAliasedFieldQuery(Input.Present(Episode.NEWHOPE))
  ) {

    assertFalse(hasErrors())
    assertTrue(data?.hero is HeroTypeDependentAliasedFieldQuery.Data.DroidHero)
    assertEquals(data?.hero?.asDroid()?.property, "Astromech")
  }

  @Test
  fun `polymorphic Human fields get parsed to Human`() = basicTest(
      "HeroTypeDependentAliasedFieldResponseHuman.json",
      HeroTypeDependentAliasedFieldQuery(Input.Present(Episode.NEWHOPE))
  ) {

    assertFalse(hasErrors())
    assertTrue(data?.hero is HeroTypeDependentAliasedFieldQuery.Data.HumanHero)
    assertEquals(data?.hero?.asHuman()?.property, "Tatooine")
  }


  @Test
  fun `requesting the same field twice with an alias`() = basicTest(
      "SameHeroTwiceResponse.json",
      SameHeroTwiceQuery()
  ) {
    assertFalse(hasErrors())
    assertEquals(data?.hero?.name, "R2-D2")
    assertEquals(data?.r2?.appearsIn?.size, 3)
    assertEquals(data?.r2?.appearsIn?.get(0), Episode.NEWHOPE)
    assertEquals(data?.r2?.appearsIn?.get(1), Episode.EMPIRE)
    assertEquals(data?.r2?.appearsIn?.get(2), Episode.JEDI)
  }

  @Test
  fun cacheResponseWithNullableFields() = basicTest(
      "AllPlanetsNullableField.json",
      AllPlanetsQuery()
  ) {
    assertFalse(hasErrors())
  }

  @Test
  fun readList() = basicTest(
      "HeroAndFriendsNameWithIdsResponse.json",
      HeroAndFriendsNamesWithIDsQuery(Input.Present(Episode.NEWHOPE))
  ) {
    assertEquals(data?.hero?.id, "2001")
    assertEquals(data?.hero?.name, "R2-D2")
    assertEquals(data?.hero?.friends?.size, 3)
    assertEquals(data?.hero?.friends?.get(0)?.id, "1000")
    assertEquals(data?.hero?.friends?.get(0)?.name, "Luke Skywalker")
    assertEquals(data?.hero?.friends?.get(1)?.id, "1002")
    assertEquals(data?.hero?.friends?.get(1)?.name, "Han Solo")
    assertEquals(data?.hero?.friends?.get(2)?.id, "1003")
    assertEquals(data?.hero?.friends?.get(2)?.name, "Leia Organa")
  }

  @Test
  fun listOfList() = basicTest(
      "StarshipByIdResponse.json",
      StarshipByIdQuery("Starship1")
  ) {
    assertEquals(data?.starship?.name, "SuperRocket")
    assertEquals(data?.starship?.coordinates,
        listOf(
            listOf(100.0, 200.0),
            listOf(300.0, 400.0),
            listOf(500.0, 600.0)
        )
    )
  }

  private fun <D : Query.Data> basicTest(resourceName: String, query: Query<D>, block: ApolloResponse<D>.() -> Unit) = runWithMainLoop {
    mockServer.enqueue(readResource(resourceName))
    var response = apolloClient.query(ApolloRequest(query).withFetchPolicy(FetchPolicy.NetworkOnly))
    response.block()
    response = apolloClient.query(ApolloRequest(query).withFetchPolicy(FetchPolicy.CacheOnly))
    response.block()
  }
}