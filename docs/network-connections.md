# Network connection improvements

## Server selection

Network connection forms keep an editable address field and offer saved servers,
the device's Wi-Fi/Ethernet addresses, and loopback. Saved and discovered entries
show their protocol and port. Device/loopback addresses say "Address only": their
presence does not establish that any server is running there.

"Find nearby servers" starts a 12-second Android DNS-SD search for advertised SMB,
FTP, SFTP and WebDAV services. Discovery stops when the form leaves the foreground
or closes. Servers that do not advertise still require a saved entry or manual
address. The app does not sweep the local subnet. Discovery carries no credentials.

Xtream has a saved-server dropdown. Syncplay has the saved endpoint and official
8995–8999 endpoints; choosing a different port is explicit because it changes the
server/room that friends must join.

## Connection changes

- Normalize host:port, protocol URLs, IPv6 and SMB UNC paths. Do not put credentials
  in server suggestions. Changing an edited server's destination cannot silently
  reuse its stored password.
- SMB separates `/Share` from `/Share/Subfolder`, accepts `DOMAIN\username`, tries
  guest after anonymous rejection only when guest access is selected, and retains
  the session's cached share after connection validation. Authentication errors
  no longer trigger transport retries.
- Xtream accepts provider `get.php` / `player_api.php` links, keeps reverse-proxy
  prefixes and explicit HTTPS, and respects allowed TS/HLS formats. If M3U export
  is unavailable, the Player API imports live streams, movies and series episodes.
  A failed section does not return a partial catalog for a destructive refresh.
- Issue #832: Syncplay resolves by name first, alternates resolved address families,
  and uses syncplay-mobile's official-server address fallback only on DNS failure.
  Custom servers are never redirected. "Connected" requires a valid server Hello.
  Login timeout, refusal, DNS, protocol and closed-connection errors are distinct.
  Cancellation closes pending sockets, and an old reader cannot close a new session.
- The shared Compose IME workaround disables out-of-frame text-input dispatch before
  UI creation. This batches focus transfers across all forms, including bottom sheets,
  instead of briefly hiding and showing the keyboard between fields.

## Research references

- [Android NSD](https://developer.android.com/develop/connectivity/wifi/use-nsd) and
  [NsdManager](https://developer.android.com/reference/android/net/nsd/NsdManager).
- [Android local-network permission guidance](https://developer.android.com/privacy-and-security/local-network-permission).
  This app targets API 36; the API 37 permission transition must be revisited when
  the target SDK changes.
- [SMBJ usage and authentication](https://github.com/hierynomus/smbj).
- [Xtream Player API](https://iptv-admin.xtream-masters.com/player_api.html).
- [AndroidX focus-transfer fix, b/530704636](https://android.googlesource.com/platform/frameworks/support/+/f3d1e1632c81ceeec2a0cd5f14a3ef985d0f8f80).
  Material3 1.5.0-alpha29 brings Compose UI 1.13.0-alpha01, where the affected flag
  is enabled again; review the workaround on the next Compose update.
- [Issue #832](https://github.com/Riteshp2001/mpvRx/issues/832),
  [Syncplay protocol](https://github.com/Syncplay/syncplay/blob/master/syncplay/protocols.py),
  [official server list](https://syncplay.pl/guide/server/), and
  [syncplay-mobile endpoint handling](https://github.com/yuroyami/syncplay-mobile/blob/a7770b10a0d8769cce01e0b144b5957ba57d68c2/shared/src/commonMain/kotlin/app/protocol/ServerEndpoint.kt).

## Verification status

Reviewed statically. Compilation and test execution were stopped at the user's
request. Added regression tests cover address normalization, SMB path/domain
handling, Xtream API fallback and incomplete refreshes, and Syncplay DNS fallback,
alternate addresses, protocol exchange and disconnect behavior. These tests have
not been run in this session.

Device checks remain: tap and IME-Next through multiple bottom-sheet fields;
discover an advertised server and leave/reopen the form; browse and seek from a
password-protected SMB subfolder and an explicit guest share; import and refresh
Xtream with M3U export enabled/disabled; join the same Syncplay endpoint and room on
two devices, then pause, seek, cancel a connection and reconnect. Reproduce #832
on the affected phone/network to confirm its original failure is resolved.
