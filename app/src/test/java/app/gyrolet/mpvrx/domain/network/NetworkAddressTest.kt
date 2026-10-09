/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */

package app.gyrolet.mpvrx.domain.network

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class NetworkAddressTest {
  @Test
  fun parsesSmbUrlAndWindowsPath() {
    for (input in listOf("smb://nas/Media/Movies", "\\\\nas\\Media\\Movies")) {
      val address = NetworkAddress.parse(input, NetworkProtocol.FTP)
      assertEquals("nas", address.host)
      assertEquals(NetworkProtocol.SMB, address.protocol)
      assertEquals("/Media/Movies", address.path)
    }
  }

  @Test
  fun preservesPortIpv6AndWebDavTls() {
    val address = NetworkAddress.parse("https://[2001:db8::1]:8443/dav/Movies%20HD", NetworkProtocol.SMB)
    assertEquals("2001:db8::1", address.host)
    assertEquals(8443, address.port)
    assertEquals("/dav/Movies HD", address.path)
    assertTrue(address.useHttps)
    assertEquals("::1", NetworkAddress.parse("::1", NetworkProtocol.FTP).host)
    assertEquals(2121, NetworkAddress.parse("127.0.0.1:2121", NetworkProtocol.FTP).port)
    assertEquals("home_nas", NetworkAddress.parse("smb://home_nas:1445/Media", NetworkProtocol.SMB).host)
    assertEquals(1445, NetworkAddress.parse("smb://home_nas:1445/Media", NetworkProtocol.SMB).port)
  }

  @Test
  fun rejectsCredentialsInvalidPortsAndTraversal() {
    for (input in listOf("smb://user:secret@nas/Media", "smb://nas:99999/Media", "smb://nas/Media/../private", "smb://nas/Media/%2e%2e/private", "ftp://nas:abc")) {
      assertTrue(input, runCatching { NetworkAddress.parse(input, NetworkProtocol.SMB) }.isFailure)
    }
  }

  @Test
  fun shareSubfolderIsAppliedExactlyOnce() {
    val share = SmbSharePath("\\Media\\Movies")
    assertEquals("Media", share.shareName)
    assertEquals("Movies", share.directory.relative)
    assertEquals("/Movies/Title/file.mkv", share.resolve(NetworkPath.from("/Title/file.mkv")).value)
    assertEquals("/Title/file.mkv", share.fromShareRelative(NetworkPath.from("/Movies/Title/file.mkv")).value)
    assertTrue(runCatching { share.fromShareRelative(NetworkPath.from("/Private/file.mkv")) }.isFailure)
    assertTrue(runCatching { SmbSharePath("/") }.isFailure)
    assertEquals("100% complete.mkv", SmbSharePath("/Media").resolve(NetworkPath.from("/100% complete.mkv")).relative)
  }

  @Test
  fun splitsDomainButPreservesUpn() {
    assertEquals(SmbUsername("alex", "OFFICE"), SmbUsername.parse("OFFICE\\alex"))
    assertEquals(SmbUsername("alex@example.com", null), SmbUsername.parse("alex@example.com"))
    assertTrue(runCatching { SmbUsername.parse("OFFICE\\") }.isFailure)
  }

  @Test
  fun normalizesOldSavedUrlWithoutChangingCredentials() {
    val saved = NetworkConnection(name = "NAS", protocol = NetworkProtocol.SMB, host = "smb://nas:1445/Media/Movies", port = 445, username = "alex", password = "secret")
    val actual = saved.normalizedAddress()
    assertEquals("nas", actual.host)
    assertEquals(1445, actual.port)
    assertEquals("/Media/Movies", actual.path)
    assertEquals(saved.password, actual.password)
  }
}
