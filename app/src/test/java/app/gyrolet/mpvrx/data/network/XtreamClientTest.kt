/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

package app.gyrolet.mpvrx.data.network

import java.util.concurrent.CopyOnWriteArrayList
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class XtreamClientTest {
  private fun client(replies: (Request) -> Pair<Int, String>) = XtreamClient(
    OkHttpClient.Builder().addInterceptor { chain ->
      val (code, body) = replies(chain.request())
      Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1)
        .code(code).message("fixture").body(body.toResponseBody()).build()
    }.build(), Json,
  )

  @Test
  fun acceptsProviderLinksAndKeepsReverseProxyPrefix() {
    val address = XtreamServerAddress.parse("https://example.test:8443/panel/get.php?username=a%2Bb&password=p%26ss&type=m3u_plus")
    assertEquals("https://example.test:8443/panel", address.serverUrl)
    assertEquals("a+b", address.username)
    assertEquals("p&ss", address.password)
    assertFalse(address.toString().contains("p&ss"))
    assertEquals("http://192.168.1.5:8080", XtreamServerAddress.parse("192.168.1.5:8080/").serverUrl)
    assertEquals("https://example.test/panel", XtreamServerAddress.parse("https://example.test/panel/player_api.php/").serverUrl)
    assertTrue(runCatching { XtreamServerAddress.parse("ftp://example.test") }.isFailure)
  }

  @Test
  fun apiFallbackImportsLiveVodAndEpisodesWithEncodedCredentials() = runBlocking {
    val requests = CopyOnWriteArrayList<Request>()
    val client = client { request ->
      requests += request
      if (request.url.encodedPath.endsWith("get.php")) 403 to "Export disabled" else 200 to when (request.url.queryParameter("action")) {
        null -> """{"user_info":{"auth":"1","status":"Active","allowed_output_formats":["m3u8"]}}"""
        "get_live_streams" -> """[{"stream_id":12,"name":"News","category_id":"1"}]"""
        "get_live_categories" -> """[{"category_id":"1","category_name":"Local"}]"""
        "get_vod_streams" -> """[{"stream_id":"13","name":"Film","container_extension":"mkv"}]"""
        "get_vod_categories" -> "[]"
        "get_series" -> """[{"series_id":14,"name":"Show"}]"""
        "get_series_info" -> """{"episodes":{"1":[{"id":"15","title":"Pilot","container_extension":"mp4"}]}}"""
        else -> error("Unexpected request")
      }
    }
    val catalog = client.loadCatalog("https://example.test/panel/player_api.php", "a+b", "p/ss&?").getOrThrow()
    assertEquals(3, catalog.playlist.items.size)
    assertEquals("Local", catalog.playlist.items[0].groupTitle)
    assertEquals(listOf("panel", "live", "a+b", "p/ss&?", "12.m3u8"), catalog.playlist.items[0].url.toHttpUrlOrNull()!!.pathSegments)
    assertTrue(catalog.playlist.items[1].url.endsWith("13.mkv"))
    assertTrue(catalog.playlist.items[2].url.endsWith("15.mp4"))
    assertEquals("m3u8", requests.first { it.url.encodedPath.endsWith("get.php") }.url.queryParameter("output"))
    assertTrue(requests.all { it.header("User-Agent") == requests[0].header("User-Agent") })
  }

  @Test
  fun failedAuthenticationDoesNotFetchCatalog() = runBlocking {
    var requests = 0
    val result = client { requests++; 200 to """{"user_info":{"auth":0}}""" }
      .loadCatalog("https://example.test", "user", "secret")
    assertTrue(result.isFailure)
    assertEquals(1, requests)
    assertFalse(result.exceptionOrNull()!!.message.orEmpty().contains("secret"))
  }

  @Test
  fun catalogFailureNeverReturnsPartialRefresh() = runBlocking {
    val result = client { request ->
      when {
        request.url.encodedPath.endsWith("get.php") -> 404 to "No export"
        request.url.queryParameter("action") == null -> 200 to """{"user_info":{"auth":true}}"""
        request.url.queryParameter("action") == "get_live_streams" -> 200 to """[{"stream_id":12,"name":"News"}]"""
        request.url.queryParameter("action") == "get_live_categories" -> 200 to "[]"
        else -> 500 to "server error"
      }
    }.loadCatalog("https://example.test", "user", "secret")
    assertTrue(result.isFailure)
  }
}
