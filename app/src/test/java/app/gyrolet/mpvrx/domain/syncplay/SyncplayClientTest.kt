/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

package app.gyrolet.mpvrx.domain.syncplay

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.net.ConnectException
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketAddress
import java.net.UnknownHostException

class SyncplayClientTest {
  @Test
  fun acceptsHostPortAndIpv6WithoutChangingTheSelectedRoomServer() {
    assertEquals(SyncplayEndpoint("syncplay.pl", 8997), SyncplayEndpoint.parse(" syncplay.pl:8997 ", 8999))
    assertEquals(SyncplayEndpoint("::1", 8999), SyncplayEndpoint.parse("::1", 8999))
    assertEquals(SyncplayEndpoint("::1", 8996), SyncplayEndpoint.parse("syncplay://[::1]:8996", 8999))
    for (host in listOf("https://syncplay.pl", "host:abc", "host:99999", "user:secret@host", "host/room")) {
      assertTrue(host, runCatching { SyncplayEndpoint.parse(host, 8999) }.isFailure)
    }
  }

  @Test
  fun officialFallbackIsOnlyUsedWhenDnsFails() {
    val local = InetAddress.getByAddress(byteArrayOf(127, 0, 0, 1))
    assertEquals(listOf(local), resolveSyncplayAddresses("syncplay.pl") { listOf(local) })
    val fallback = resolveSyncplayAddresses("SYNCPLAY.PL") { throw UnknownHostException() }
    assertEquals("151.80.32.178", fallback.single().hostAddress)
    assertTrue(runCatching { resolveSyncplayAddresses("private.example") { throw UnknownHostException() } }.isFailure)
  }

  @Test
  fun retriesAnotherResolvedAddressAndExchangesHelloAndState() = runBlocking {
    withTimeout(5000) {
      ServerSocket(0, 1, InetAddress.getByName("127.0.0.1")).use { server ->
        val exchange = async(Dispatchers.IO) {
          server.accept().use { socket ->
            socket.soTimeout = 3000
            val input = socket.getInputStream().bufferedReader()
            val output = socket.getOutputStream().bufferedWriter()
            val hello = input.readLine()
            output.write("{\"Hello\":{\"username\":\"accepted-user\",\"room\":{\"name\":\"TestRoom\"},\"version\":\"1.7.6\"}}\r\n")
            output.flush()
            val state = input.readLine()
            hello to state
          }
        }
        var sockets = 0
        val client = SyncplayClient(
          resolver = { listOf(InetAddress.getByName("::1"), InetAddress.getByName("127.0.0.1")) },
          socketFactory = {
            if (sockets++ == 0) object : Socket() {
              override fun connect(endpoint: SocketAddress?, timeout: Int) { throw ConnectException("IPv6 unavailable") }
            } else Socket()
          },
        )
        try {
          assertTrue(client.connect("test-server", server.localPort).isSuccess)
          assertEquals(2, sockets)
          val accepted = async(start = CoroutineStart.UNDISPATCHED) { client.messages.first { it.hello != null } }
          val listener = launch { client.listen() }
          assertTrue(client.sendMessage(SyncplayMessage(hello = HelloMessage(username = "requested", room = Room("TestRoom"), version = "1.2.255"))))
          assertEquals("accepted-user", accepted.await().hello?.username)
          assertTrue(client.sendMessage(SyncplayMessage(state = StateMessage(playstate = Playstate(position = 30.0, paused = true)))))
          val (hello, state) = exchange.await()
          assertTrue(Json.parseToJsonElement(hello).jsonObject.containsKey("Hello"))
          assertTrue(Json.parseToJsonElement(state).jsonObject.containsKey("State"))
          listener.join()
          assertFalse(client.isConnected())
        } finally { client.disconnect() }
      }
    }
  }

  @Test
  fun preservesConnectionFailureInsteadOfReturningOnlyFalse() = runBlocking {
    val client = SyncplayClient(resolver = { throw UnknownHostException("unresolvable") })
    val result = client.connect("private.example", 8999)
    assertEquals(SyncplayConnectionFailure.NAME_LOOKUP, SyncplayConnectionFailure.from(result.exceptionOrNull()!!))
    assertFalse(client.isConnected())
  }

  @Test
  fun disconnectClosesTheSocketAndUnblocksTheListener() = runBlocking {
    withTimeout(5000) {
      ServerSocket(0, 1, InetAddress.getByName("127.0.0.1")).use { server ->
        val accepted = async(Dispatchers.IO) { server.accept() }
        val client = SyncplayClient()
        assertTrue(client.connect("127.0.0.1", server.localPort).isSuccess)
        accepted.await().use {
          val listener = async(start = CoroutineStart.UNDISPATCHED) { client.listen() }
          client.disconnect()
          assertTrue(listener.await().isFailure)
          assertFalse(client.isConnected())
        }
      }
    }
  }
}
