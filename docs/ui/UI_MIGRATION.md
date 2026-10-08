# Material 3 Expressive migration checklist

Starting branch: `master`. Starting commit: `4e6d493866bc22e5cc2be0efff63e5acda10e53d`.

Scope: presentation only. Preserve all destinations, preferences and stored values, custom fonts, dynamic/custom/AMOLED themes, and both Kyaant and Haze paths. Playback lifecycle, decoding, gestures, seeking rules, synchronization, scanning, artwork loading, network/database operations, torrent and YouTube logic are outside this migration.

## Evidence and status

The source inventory reads all Kotlin files and records 265 files containing composable annotations and 805 annotated function declarations, including overloads, private helpers, nested Content implementations, hosts and nonvisual composition helpers. XML layouts are inventoried separately. Inventory and heuristic triage are complete; this does **not** certify a runtime or visual audit.

Each file remains pending until a contextual source review is recorded. A retained component needs a concrete rationale. A migrated component needs compilation evidence and visual checks. Do not mark a whole screen complete solely because it inherits MaterialTheme.

Repository AGENTS.md requests Graft context first. The checkout contains neither a graft/ graph nor a graft executable, so source inventory uses rg and direct reads as the unindexed fallback.

## References

- [hamen/material-3-skill](https://github.com/hamen/material-3-skill/tree/14385f2bf3804d8779f8b4db2604211f1e70b4c1/skills/material-3): primary token/layout/accessibility guidance. Compose guidance takes precedence over web examples; 4dp optical spacing and 8dp layout rhythm.
- [meticha/material-3-expressive-catalog](https://github.com/meticha/material-3-expressive-catalog/tree/393a2bac8bd77dea39f98d0262e07aeeee43c850): implementation reference for expressive buttons, connected groups, loading/progress, floating toolbars, navigation rails and tonal theme pairing. Adapt components individually; do not import the catalog.
- [Material 3](https://m3.material.io/) and [AndroidX Material3 API/release notes](https://developer.android.com/jetpack/androidx/releases/compose-material3): verify actual signatures against the pinned material3 1.5.0-alpha29, Compose BOM 2026.09.00 and Kotlin 2.4.20. No dependency upgrade is planned.

## Already present

- MpvrxTheme uses MaterialExpressiveTheme, MotionScheme.expressive, custom/downloaded/system fonts, locale fallback and dynamic/custom/AMOLED color schemes.
- AppShapes and AppShapeScale already cover expressive radii; LocalSpacing and LocalEmphasizedTypography already exist.
- AppMotion observes system animator availability and player reduced-motion preferences; navigation supports RTL and predictive back.
- AppPickerSheet/PlayerSheet centralize many hidden dialogs and player pickers, including insets, focus and constrained widths.
- Existing glass navigation and player buttons must remain. Shared SliderItem/TintedSliderItem and many standalone sliders currently import Material3 Slider directly; custom player seekbar styling must be reviewed in place and preserved rather than assuming a new app-wide slider wrapper exists.

## Initial findings

| Finding | Evidence | Action |
| --- | --- | --- |
| Native emphasized Material typography does not follow the selected custom font | Type.kt copies only the baseline slots while app emphasis is a separate scale | Populate native emphasis slots and have the app adapter read them |
| Duplicated shape values | Shapes.kt repeats radii in AppShapes and AppShapeScale | Reuse one token source, retain existing values |
| Search actions smaller than 48dp and a fixed 46dp field | PlayerSheetSearchField.kt | Source migrated to native text/icon controls with flexible height; NoVulkan APK built; visual checks pending |
| Settings feedback suppressed | SettingsComponents.kt indication=null | Clipped ripple and accessible grouped row presentation |
| Folder press feedback suppressed | NetworkFolderCard.kt indication=null | Restore a bounded state layer while retaining click/long-press actions |
| Perpetual empty-state animation ignores reduced motion | EmptyState.kt unconditional infinite transition | Remove idle motion or respect policy; constrain readable content and allow scrolling |
| Shared music heading/action can overflow and uses hardcoded labels | SharedMusicComponents.kt | Flexible title/action row, existing localized labels and native actions |
| Some app-specific source badges use brand colors | SourceChip.kt | Preserve identity, check contrasting foreground (source colors are intentional) |
| Runtime and screenshots unavailable at audit start | No Android SDK/device/emulator initially installed | Bootstrap tooling, compile every variant and record actual device limitations |

## Sequential workstreams

| Phase | Files in inventory | Checklist | Status |
| --- | ---: | --- | --- |
| 0 Foundation | 6 | Typography, colors, shapes, spacing, elevation, state and motion tokens, font fallback | Native typography and shared shapes compiled; NoVulkan debug APK built; full matrix and visual checks pending |
| 1 Shared components | 18 | Buttons/icon buttons/groups, chips, switch/checkbox/radio, sliders/progress, menus/tooltips, cards/lists, dialogs/snackbars/text fields | Search field source migrated and built; remaining controls and runtime checks pending |
| 2 Navigation | 14 | Main/floating bar, top/search bars, contextual actions, FABs, tabs, large-screen shell, transitions, all customizable destinations | Pending |
| 3 Home/browser | 29 | Folder/tree/list/grid/recent, cards/thumbnails, sort/filter, actions, empty/loading/permission states, compressor | Pending |
| 4 Music | 10 | Local songs/albums/artists/playlists, Navidrome/Jellyfin music, shared rows/cards, artwork, mini-player, details | Pending |
| 5 Network/other tabs | 33 | SMB/FTP/SFTP/WebDAV, streaming/syncplay, bookmarks, playlists, Jellyfin/Seerr, audiobooks, downloads/torrents | Pending |
| 6 Player | 81 | Control/sheet/panel chrome, seekbars, overlays, every advanced picker, cast, YT installation UI; preserve rendering and timing | Pending |
| 7 Settings | 31 | Every settings category/subpage, search, toggles/options, slider groups, ownership notices; retain every preference | Pending |
| 8 Remaining | 36 | Profile, themes/wallpapers/fonts, editors/help/about, snapshots/image viewer, secure folder, diagnostics, updates, permissions | Pending |
| 9 Motion | Cross-cutting | Springs, shape morphing, system/player reduced motion, selected/focus/press, RTL navigation; avoid perpetual decoration | Pending |
| 10 Final audit | All | Clipping/overflow/insets, theme pairing, orientation/font scale/RTL/TalkBack, state/thumbnail stability, first-frame/navigation checks | Pending |

## Validation contract

Run relevant Kotlin compilation, all distribution variants (Standard, NoVulkan, FongMi), available tests and focused lint. On 2026-10-08 the user requested immediate pushing once one variant builds successfully: a full APK build is the minimum publication gate, with the remaining matrix tracked explicitly and completed before declaring a phase finished. Do not change build dependencies or skip hooks to obtain a pass. Check worktree and stage explicit paths. Push only ordinary fast-forward commits to master; do not rewrite published history. Recheck master before each push.

Canonical initial checks:

```sh
./gradlew :app:compileStandardDebugKotlin :app:compileNoVulkanDebugKotlin :app:compileFongmiDebugKotlin
./gradlew :app:compileStandardReleaseKotlin :app:compileNoVulkanReleaseKotlin :app:compileFongmiReleaseKotlin
./gradlew :app:testStandardDebugUnitTest :app:testNoVulkanDebugUnitTest :app:testFongmiDebugUnitTest
```

At inventory time there are no app/src/test or app/src/androidTest sources. Gradle test-task outcomes must still be reported accurately; NO-SOURCE is not a passing test suite. The ktlint plugin is configured, but its baseline must be established before treating formatter output as in scope.

| Device/visual check | Required combinations | Current evidence |
| --- | --- | --- |
| Themes | Light, dark, dynamic, custom, AMOLED; glass on/off | Pending runtime checks |
| Layout | Portrait/landscape, compact/medium/expanded, IME/cutout/navigation bars | Pending runtime checks |
| Accessibility | 1.0x/1.3x/2.0x fonts, Arabic RTL, TalkBack, disabled/selected/focus, reduced motion | Pending runtime checks |
| Behavior | Tab customization/state, artwork/scroll stability, overlays and horizontal seeking with controls shown/hidden | Pending runtime checks |
| Playback | First-frame timing, visible video, audio/subtitles, music mini/full-player transitions | Pending runtime checks |

Baseline GitHub CI run 37729709630 on the starting SHA completed successfully for Standard, NoVulkan and FongMi release APKs. It validates the original code only. Local wrapper bootstrap initially failed with network unreachable; downloads through the environment proxy subsequently succeeded. This is not validation of any migration changes.

## Commit log

### 686d2529ca19981d624b9c22bb38dadb4a6d96c9 — refactor(ui): establish expressive design tokens

- Native Material3 emphasized typography now inherits the selected font, sizes, line heights and tracking. Existing app emphasis reads those same native slots, preserving its weight choices. Theme.kt already remembers typography by font/locale selection, so this does not add per-frame typography work.
- AppShapes reuses AppShapeScale; all eight corner values are retained. Spacing and emphasized typography are immutable Compose values.
- Added the exhaustive source inventory and migration checklist. The inventory does not claim a completed contextual or visual audit.
- Local `:app:assembleNoVulkanDebug` completed successfully, including Kotlin/Java compilation, resources, all configured native ABIs, dexing, signing and packaging. `:app:testNoVulkanDebugUnitTest` completed as **NO-SOURCE**. `git diff --check` passed.
- The first multi-variant run was interrupted after a JVM heap warning; a second assembly attempt lost its daemon to the workspace memory limit. Serial validation with one worker and a 4 GB heap succeeded. These are local validation settings, with no repository build changes.
- GitHub CI [37733809827](https://github.com/Riteshp2001/mpvRx/actions/runs/37733809827) subsequently completed release APK builds successfully for **Standard, NoVulkan and FongMi**. Standard/FongMi debug compilation remains pending.
- The initial ktlint attempt was blocked by a concurrent Gradle cache lock. The retry ran and failed on widespread existing style violations; all 21 Type.kt findings concern unchanged font constants/definitions and formatting. Shapes.kt and Spacing.kt had no findings. No full-app lint pass is claimed.
- Runtime theme/orientation/font-scaling/RTL/glass checks remain pending. A software-only emulator was stopped to free build resources; no device or playback performance result is claimed.

Commit SHA is recorded in the subsequent progress entry once published; Git history is the authoritative commit list.

### feat(ui): modernize shared sheet search fields

- Replaced the hand-drawn, fixed-height field with native Material3 TextField, the shared extra-large shape and surfaceContainerHigh. Native field measurement can grow with font scaling rather than clipping a 46 dp row.
- Search and clear actions use native expressive IconButton shapes, 48 dp bounds and existing translated descriptions. Decorative search icons remain outside the action semantics when no submit callback exists.
- The eleven caller locations include file/folder/playlist pickers, audiobook selection, font/model searches, subtitle-language choices and lyric translation. Their query/filter state, submit/clear callbacks, focus clearing and Search IME action are unchanged. No Liquid Glass implementation was replaced.
- Local `:app:assembleNoVulkanDebug` succeeded and `:app:testNoVulkanDebugUnitTest` reported **NO-SOURCE**; `git diff --check` passed. A combined assembly/lint run completed APK assembly but ended with existing ktlint violations, so assembly was rerun separately to establish a successful build result.
- The updated file has only its existing uppercase composable-name lint finding (the original had that finding plus a chain-formatting finding); no lint pass is claimed. Remaining variant CI and device visual checks are pending.

## Complete file checklist

Paths below are relative to app/src/main/java/app/gyrolet/mpvrx. Function-level entries appear in UI_COMPOSABLE_INVENTORY.md. Signal counts are triage hints, **not confirmed defects**; transparent player scrims, artwork overlay colors and custom geometry may be intentional.

| Phase | File | Existing building blocks | Triage signals | Disposition / verification |
| --- | --- | --- | --- | --- |
| 2 Navigation | `MainActivity.kt` | LiquidGlass | None detected | Pending contextual review and visual validation |
| Support: nonvisual or shared host | `preferences/AppearancePreferences.kt` | MaterialTheme, LiquidGlass | None detected | Pending contextual review and visual validation |
| Support: nonvisual or shared host | `preferences/PlayerButton.kt` | Host/support | None detected | Pending contextual review and visual validation |
| Support: nonvisual or shared host | `preferences/preference/Preference.kt` | Host/support | None detected | Pending contextual review and visual validation |
| Support: nonvisual or shared host | `presentation/Screen.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/AppPickerSheet.kt` | MaterialTheme, AppMotion, AppPickerSheet, PlayerSheet | fixed text/action height: 2 | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/ConfirmDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/ExpandableCard.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/ExposedTextDropDownMenu.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/LiquidGlassSurface.kt` | MaterialTheme, AppMotion, LiquidGlass | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/OutlinedNumericChooser.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/OvalBox.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/PlayerSheet.kt` | MaterialTheme, AppMotion, PlayerSheet, heading() | local radii: 1, suppressed indication: 2 | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/PlayerSheetSearchField.kt` | Native TextField, expressive IconButton, MaterialTheme | Initial fixed-height/radius/surface findings addressed | Source migrated; NoVulkan debug APK built; remaining variants and visual validation pending |
| 1 Shared components | `presentation/components/RemoteImage.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/RepeatingIconButton.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/SliderItem.kt` | MaterialTheme | local radii: 3, fixed text/action height: 1 | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/TintedSliderItem.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 1 Shared components | `presentation/components/pullrefresh/PullRefreshBox.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `presentation/crash/CrashActivity.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `presentation/crash/DebugLogsScreen.kt` | MaterialTheme | local radii: 4, fixed text/action height: 1 | Pending contextual review and visual validation |
| 2 Navigation | `ui/browser/MainScreen.kt` | MaterialTheme, AppMotion, LiquidGlass | local radii: 3, suppressed indication: 1 | Pending contextual review and visual validation |
| 2 Navigation | `ui/browser/NavigationBarSelectionEffect.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/browser/NavigationGlassSurface.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/audiobooks/AddAudiobookshelfServerDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | local radii: 11, fixed text/action height: 6 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/cards/FolderCard.kt` | MaterialTheme, AppShapeScale | raw colors: 2, fixed text/action height: 3 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/cards/M3UVideoCard.kt` | MaterialTheme, AppShapeScale | local radii: 2, raw colors: 1 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/cards/NetworkConnectionCard.kt` | MaterialTheme, AppShapeScale, AppMotion | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/cards/NetworkFolderCard.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 1, suppressed indication: 1 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/cards/NetworkImageCard.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 3 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/cards/NetworkVideoCard.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 3 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/cards/PlaylistCard.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 2 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/cards/SelectionIndicator.kt` | MaterialTheme, AppMotion | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/cards/SourceChip.kt` | MaterialTheme, AppShapeScale | raw colors: 6 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/cards/VideoCard.kt` | MaterialTheme, AppShapeScale | raw colors: 1, fixed text/action height: 3 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/cards/VideoSwipeSurface.kt` | MaterialTheme, AppMotion | None detected | Pending contextual review and visual validation |
| 4 Music | `ui/browser/components/AudioMiniPlayer.kt` | MaterialTheme, LiquidGlass | local radii: 1, legacy surface role: 1 | Pending contextual review and visual validation |
| 2 Navigation | `ui/browser/components/BrowserTopBar.kt` | MaterialTheme, AppMotion | local radii: 3 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/components/ExpressiveScrollBar.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/browser/components/FloatingBottomBar.kt` | MaterialTheme, AppMotion, LiquidGlass | local radii: 1 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/components/MediaTypeBadge.kt` | MaterialTheme, AppShapeScale | raw colors: 1 | Pending contextual review and visual validation |
| 4 Music | `ui/browser/components/MiniPlayer.kt` | MaterialTheme, LiquidGlass | local radii: 3, fixed text/action height: 1, legacy surface role: 1 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/components/VideoSwipeActions.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/AddToPlaylistDialog.kt` | MaterialTheme, AppShapeScale, AppPickerSheet, PlayerSheet | fixed text/action height: 3, legacy surface role: 2 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/dialogs/AddXtreamPlaylistDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/BulkAiRenameDialog.kt` | MaterialTheme | fixed text/action height: 2 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/dialogs/ConnectionEditorSheet.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/dialogs/ConnectionSheets.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/CopyPasteDialog.kt` | MaterialTheme | legacy surface role: 1 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/DeleteConfirmationDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/FilePickerDialog.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | local radii: 3 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/FolderPickerDialog.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | local radii: 1 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/RenameDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/dialogs/SharedServerDialogs.kt` | MaterialTheme | local radii: 15, fixed text/action height: 4 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | MaterialTheme, AppShapeScale, AppMotion, AppPickerSheet | local radii: 6, fixed text/action height: 2 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 5 | Pending contextual review and visual validation |
| 2 Navigation | `ui/browser/fab/FabScrollHelper.kt` | AppMotion | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/browser/fab/QuickPlayFab.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/filesystem/BreadcrumbNavigation.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/filesystem/FileSystemBrowserScreen.kt` | MaterialTheme, AppMotion, LiquidGlass | local radii: 1 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | MaterialTheme, AppMotion, LiquidGlass | local radii: 2 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/AddJellyfinServerDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | MaterialTheme | local radii: 39, raw colors: 1, local type sizes: 3, fixed text/action height: 2, infinite motion: 4 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinContent.kt` | MaterialTheme | local radii: 2, fixed text/action height: 6 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinDetailSheet.kt` | MaterialTheme, heading() | local radii: 23, raw colors: 1, fixed text/action height: 8, infinite motion: 4 | Pending contextual review and visual validation |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinPersonSheet.kt` | MaterialTheme | local radii: 5, fixed text/action height: 3 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrCards.kt` | MaterialTheme | local radii: 8, raw colors: 22, local type sizes: 4, fixed text/action height: 2, legacy surface role: 1 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrConnectionDialog.kt` | MaterialTheme | local radii: 12, fixed text/action height: 11 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrContent.kt` | MaterialTheme | local radii: 3 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrDetailSheet.kt` | MaterialTheme | local radii: 14, raw colors: 2, local type sizes: 1, fixed text/action height: 11, legacy surface role: 2 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/medialibrary/MediaLibraryContent.kt` | LiquidGlass | None detected | Pending contextual review and visual validation |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | MaterialTheme, AppShapeScale, LiquidGlass | local radii: 1, fixed text/action height: 9, legacy surface role: 7 | Pending contextual review and visual validation |
| 4 Music | `ui/browser/music/MusicSourceDropdown.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 4 Music | `ui/browser/music/SharedMusicComponents.kt` | MaterialTheme, AppShapeScale | local radii: 6, legacy surface role: 3 | Pending contextual review and visual validation |
| 4 Music | `ui/browser/navidrome/AddNavidromeServerDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 4 Music | `ui/browser/navidrome/NavidromeContent.kt` | MaterialTheme | local radii: 2 | Pending contextual review and visual validation |
| 4 Music | `ui/browser/navidrome/NavidromeDetailSheet.kt` | MaterialTheme | local radii: 1, fixed text/action height: 2 | Pending contextual review and visual validation |
| 4 Music | `ui/browser/navidrome/NavidromeMusicView.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBookmarksScreen.kt` | MaterialTheme | local radii: 3 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBrowserScreen.kt` | MaterialTheme, AppMotion | local radii: 1 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | MaterialTheme | local radii: 6, fixed text/action height: 2 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/networkstreaming/SyncplayPanel.kt` | MaterialTheme | fixed text/action height: 3 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentCards.kt` | MaterialTheme | local radii: 23, local type sizes: 2, fixed text/action height: 3 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentDetailSheet.kt` | MaterialTheme | local radii: 16, fixed text/action height: 2 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistAddVideosScreen.kt` | MaterialTheme, AppShapeScale | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistDetailScreen.kt` | MaterialTheme, AppMotion, LiquidGlass | local radii: 1 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistScreen.kt` | MaterialTheme, AppMotion | local radii: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | MaterialTheme, AppShapeScale | local radii: 6, local type sizes: 1, fixed text/action height: 1 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/recentlyplayed/RecentlyPlayedScreen.kt` | MaterialTheme, AppMotion | None detected | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/selection/SelectionManager.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/sheets/PlayLinkSheet.kt` | MaterialTheme | fixed text/action height: 2 | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/browser/sheets/PlaylistActionSheet.kt` | MaterialTheme | fixed text/action height: 2, legacy surface role: 5 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/states/EmptyState.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 2, infinite motion: 4 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/states/LoadingState.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 2, infinite motion: 4 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/states/PermissionDeniedState.kt` | MaterialTheme, AppShapeScale | local radii: 3, raw colors: 1, local type sizes: 1, fixed text/action height: 14, legacy surface role: 1 | Pending contextual review and visual validation |
| 3 Home and video browser | `ui/browser/videolist/VideoListScreen.kt` | MaterialTheme, AppMotion, LiquidGlass | local radii: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/cast/CastPlayerButton.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | MaterialTheme, AppPickerSheet | local radii: 1, local type sizes: 4, fixed text/action height: 5, suppressed indication: 1 | Pending contextual review and visual validation |
| 1 Shared components | `ui/components/IconSwitch.kt` | MaterialTheme, AppMotion, minimumInteractiveComponentSize | suppressed indication: 1 | Pending contextual review and visual validation |
| 1 Shared components | `ui/components/InlineSearchBar.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 1 Shared components | `ui/components/ThemedSegmentedButtonColors.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | MaterialTheme | local radii: 3 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/editor/ExternalTextEditorActivity.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/editor/MpvHelpScreen.kt` | MaterialTheme | local radii: 2, fixed text/action height: 4, legacy surface role: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/editor/MpvScriptEditor.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/framecapture/SnapshotDetailScreen.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/framecapture/SnapshotFolderScreen.kt` | Host/support | local radii: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/framecapture/SnapshotItems.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/framecapture/SnapshotScreen.kt` | MaterialTheme | local radii: 1, fixed text/action height: 2 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotFolderDialogs.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotSortDialog.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 1 Shared components | `ui/icons/AppIcon.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/imageviewer/ImageViewerOverlay.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/imageviewer/ImageViewerScreen.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/imageviewer/ZoomableImage.kt` | MaterialTheme | fixed text/action height: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/liquidglass/AdaptiveControlsButton.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/liquidglass/LiquidButton.kt` | LiquidGlass | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/liquidglass/LiquidGlassUtils.kt` | LiquidGlass | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/liquidglass/LiquidToggle.kt` | MaterialTheme, LiquidGlass | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/liquidglass/PlayerLiquidControls.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| Support: nonvisual or shared host | `ui/lua/LuaScriptsUi.kt` | MaterialTheme | legacy surface role: 1 | Pending contextual review and visual validation |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | MaterialTheme | local radii: 14, raw colors: 4, fixed text/action height: 2, legacy surface role: 5 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/AnimationStyles.kt` | AppMotion | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/PlayerArtworkTransition.kt` | AppMotion | local radii: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/clip/ClipOverlayView.kt` | MaterialTheme | fixed text/action height: 8 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/components/VideoAmbientBackground.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/components/expressive/SectionHeader.kt` | MaterialTheme, AppMotion | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | MaterialTheme, AppMotion | local radii: 11, local type sizes: 7, fixed text/action height: 22, suppressed indication: 2, legacy surface role: 4 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/GestureHandler.kt` | MaterialTheme, AppMotion | local type sizes: 3 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerButtonTheme.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerControlDrawer.kt` | MaterialTheme | local radii: 3, fixed text/action height: 2, suppressed indication: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerControls.kt` | MaterialTheme, LiquidGlass, PlayerSheet | local radii: 2, local type sizes: 2, fixed text/action height: 7 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerControlsLandscape.kt` | MaterialTheme, LiquidGlass | fixed text/action height: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerControlsPortrait.kt` | MaterialTheme, LiquidGlass | fixed text/action height: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerControlsShared.kt` | MaterialTheme, LiquidGlass | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerPanels.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/PlayerSheets.kt` | PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/AudioWavySeekBar.kt` | MaterialTheme, AppMotion | fixed text/action height: 2 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/BufferingState.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | MaterialTheme, LiquidGlass | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/CurrentChapter.kt` | MaterialTheme, AppShapeScale, LiquidGlass | fixed text/action height: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/CustomPlayerIcons.kt` | AppMotion | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/DoubleTapSeekSecondsView.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/LyricsProviderPicker.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/LyricsView.kt` | MaterialTheme | local radii: 7, local type sizes: 1, fixed text/action height: 7, suppressed indication: 1, legacy surface role: 3 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/MediaScopesOverlay.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/MiniAudioVisualizer.kt` | MaterialTheme | infinite motion: 7 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/MpvConfigOwnedNotice.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | MaterialTheme | local radii: 5, local type sizes: 4 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | MaterialTheme, AppMotion, LiquidGlass | local radii: 2, raw colors: 5, fixed text/action height: 9, legacy surface role: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/TvFocus.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/VerticalSliders.kt` | MaterialTheme, AppShapeScale, LiquidGlass | fixed text/action height: 2 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/AudioDelayPanel.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/DraggablePanel.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/HdrScreenOutputPanel.kt` | MaterialTheme, AppShapeScale | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/LuaScriptsPanel.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleDelayPanel.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsColorsCard.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsMiscellaneousCard.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsPanel.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsTypographyCard.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsDebandCard.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsFilterPresetsCard.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsFiltersCard.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsPanel.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/YtdlpPanel.kt` | MaterialTheme | local radii: 3 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/panels/components/MultiCardPanel.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/AmbientSheet.kt` | MaterialTheme, AppMotion, PlayerSheet | fixed text/action height: 2 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/AspectRatioSheet.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/AudioPropertiesSheet.kt` | MaterialTheme, PlayerSheet | fixed text/action height: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/AudioTracksSheet.kt` | MaterialTheme, AppMotion, PlayerSheet | local radii: 2 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/AudiobookSheet.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/ChaptersSheet.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/DecodersSheet.kt` | PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/EqualizerSheet.kt` | MaterialTheme, PlayerSheet | local radii: 5, fixed text/action height: 6 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/FrameNavigationSheet.kt` | MaterialTheme | raw colors: 4 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/LyricsProviderSheet.kt` | MaterialTheme, PlayerSheet | local radii: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/LyricsSheet.kt` | MaterialTheme | local radii: 3, local type sizes: 1, fixed text/action height: 10 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/LyricsTranslateDialog.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | local radii: 3, local type sizes: 2, fixed text/action height: 4, legacy surface role: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/MoreSheet.kt` | MaterialTheme, AppShapeScale, PlayerSheet | fixed text/action height: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/OnlineSubtitleSearchSheet.kt` | MaterialTheme, PlayerSheet | local radii: 14, local type sizes: 2, fixed text/action height: 13, legacy surface role: 4 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaybackSpeedSheet.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaylistSheet.kt` | MaterialTheme, AppMotion, PlayerSheet | local radii: 17, local type sizes: 7, fixed text/action height: 3, infinite motion: 4 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | MaterialTheme, AppMotion, PlayerSheet | fixed text/action height: 2 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/ScopesSheet.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/SubtitleTracksSheet.kt` | MaterialTheme, AppMotion, AppPickerSheet, PlayerSheet | local radii: 2, fixed text/action height: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/TrackSheetRows.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/VideoQualitySheet.kt` | MaterialTheme, AppMotion, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/VideoZoomSheet.kt` | MaterialTheme, PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/controls/components/sheets/VisualizerStyleSheet.kt` | PlayerSheet | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/visualizer/BlobComposable.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/visualizer/CuboidComposable.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/visualizer/OneUiWaveVisualizer.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/ytdlp/YtdlpInstallProgressDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/ytdlp/YtdlpInstallPromptDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 6 Player presentation | `ui/player/ytdlp/YtdlpInstallationStatus.kt` | MaterialTheme | local radii: 1, fixed text/action height: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/AboutScreen.kt` | MaterialTheme, LiquidGlass | local radii: 9, fixed text/action height: 17, infinite motion: 4, legacy surface role: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/AdvancedPreferencesScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/AiIntegrationScreen.kt` | MaterialTheme | local radii: 4, fixed text/action height: 4, legacy surface role: 3 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/AppearancePreferencesScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/AudioPreferencesScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/CardPreferences.kt` | MaterialTheme, LocalEmphasizedTypography | fixed text/action height: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/CodecCapabilitiesScreen.kt` | MaterialTheme | local radii: 17, local type sizes: 2, fixed text/action height: 19 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/ConfigEditorScreen.kt` | MaterialTheme | local radii: 1, legacy surface role: 2 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/ControlLayoutEditorScreen.kt` | MaterialTheme | local radii: 4, raw colors: 1, fixed text/action height: 3 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/CustomButtonScreen.kt` | MaterialTheme | local radii: 12, local type sizes: 3, fixed text/action height: 6, legacy surface role: 2 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/CustomThemeEditorScreen.kt` | MaterialTheme | local radii: 1, raw colors: 8 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/DecoderPreferencesScreen.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/FoldersPreferencesScreen.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | fixed text/action height: 7, legacy surface role: 3 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/GesturePreferencesScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/GoogleFontsSheet.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | local radii: 1, fixed text/action height: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/HallOfFameScreen.kt` | MaterialTheme, heading() | local radii: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/LiquidGlassPreferencesScreen.kt` | MaterialTheme, LiquidGlass | fixed text/action height: 3 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/LuaScriptEditorScreen.kt` | MaterialTheme | local radii: 4, legacy surface role: 4 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/LuaScriptsScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/MediaServersPreferencesScreen.kt` | MaterialTheme | local radii: 4 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/ModelSearchDialog.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | local radii: 2 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/MpvConfOwnershipScreen.kt` | MaterialTheme | local radii: 1, legacy surface role: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/MpvConfigOverridePreference.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/NetworkConfigurationPreferencesScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/PlayerControlsPreferencesScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/PlayerPreferencesScreen.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | MaterialTheme, LocalEmphasizedTypography, LiquidGlass | fixed text/action height: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/SettingsSearchNavigation.kt` | MaterialTheme, LiquidGlass | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/SettingsSearchScreen.kt` | MaterialTheme, LocalEmphasizedTypography | fixed text/action height: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/SubtitlesPreferencesScreen.kt` | MaterialTheme, AppPickerSheet, PlayerSheet | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/VideoSwipePreferencesScreen.kt` | MaterialTheme, AppMotion, AppPickerSheet | local radii: 2, fixed text/action height: 5 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/WallpaperEditorScreen.kt` | MaterialTheme | local radii: 6, fixed text/action height: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/WallpaperHomePreview.kt` | MaterialTheme | suppressed indication: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/WallpaperPreferenceCard.kt` | MaterialTheme | local radii: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | MaterialTheme, AppShapeScale | local radii: 4, raw colors: 7, fixed text/action height: 4 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/YtdlpSettingsScreen.kt` | MaterialTheme | local radii: 2 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/components/LiquidGlassPreferences.kt` | MaterialTheme, LiquidGlass | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/components/OptionsDialog.kt` | MaterialTheme, AppPickerSheet | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/components/PlayerButtonChip.kt` | MaterialTheme | local type sizes: 2, legacy surface role: 2 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/components/RestartRequiredDialog.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/components/SettingsComponents.kt` | MaterialTheme | local radii: 1, suppressed indication: 1 | Pending contextual review and visual validation |
| 7 Settings | `ui/preferences/components/SwitchPreference.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/components/ThemePicker.kt` | MaterialTheme | local radii: 3, fixed text/action height: 2 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/components/ThemePreviewCard.kt` | MaterialTheme | local radii: 9, local type sizes: 1, fixed text/action height: 4, legacy surface role: 3 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/preferences/components/WallpaperPresetCard.kt` | MaterialTheme | local radii: 2, local type sizes: 1, fixed text/action height: 1 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/securefolder/SecureConfirmDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/securefolder/SecureFolderAccountDialogs.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/securefolder/SecureFolderAddFilesScreen.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | MaterialTheme, AppShapeScale | fixed text/action height: 27 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/securefolder/SecureFolderProgressDialog.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/securefolder/SecureFolderScreen.kt` | MaterialTheme, AppMotion | None detected | Pending contextual review and visual validation |
| 0 Foundation | `ui/theme/AppWallpaper.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 0 Foundation | `ui/theme/Motion.kt` | AppMotion | None detected | Source reviewed: retain existing spring tokens and system/player motion policy; runtime checks pending |
| 0 Foundation | `ui/theme/Spacing.kt` | MaterialTheme | None detected | Migrated: immutable tokens; NoVulkan debug APK built; runtime checks pending |
| 0 Foundation | `ui/theme/SplashContent.kt` | MaterialTheme | None detected | Pending contextual review and visual validation |
| 0 Foundation | `ui/theme/Theme.kt` | MaterialExpressiveTheme, MaterialTheme, LocalEmphasizedTypography | raw colors: 3 | Source reviewed: retain dynamic/custom/AMOLED schemes, cached fonts, locale fallback and reduced-motion reveal; runtime checks pending |
| 0 Foundation | `ui/theme/Type.kt` | LocalEmphasizedTypography | None detected | Migrated: native emphasized slots share chosen fonts and scale; NoVulkan debug APK built; runtime checks pending |
| 5 Network and other tabs | `ui/torrent/TorrentSelectionScreen.kt` | MaterialTheme | local radii: 6, fixed text/action height: 7 | Pending contextual review and visual validation |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | MaterialTheme | local radii: 1, fixed text/action height: 6, legacy surface role: 2 | Pending contextual review and visual validation |
| 2 Navigation | `ui/utils/AppHaptics.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/utils/MpvConfigOverrideState.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/utils/NavigationPager.kt` | AppMotion | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/utils/ReorderFeedback.kt` | AppMotion | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/utils/ResponsiveGridUtils.kt` | Host/support | None detected | Pending contextual review and visual validation |
| 2 Navigation | `ui/utils/ScreenNavigation.kt` | MaterialTheme, AppMotion | None detected | Pending contextual review and visual validation |
| Support: nonvisual or shared host | `utils/permission/PermissionUtils.kt` | Host/support | None detected | Pending contextual review and visual validation |

Additional foundation file: ui/theme/Shapes.kt (no composable annotations), draft centralizes existing radii; compilation pending.

## View/XML checklist

| File | Review |
| --- | --- |
| `app/src/main/res/layout/media_player_pill_widget.xml` | Pending; preserve player video surface and widget click actions |
| `app/src/main/res/layout/media_player_widget.xml` | Pending; preserve player video surface and widget click actions |
| `app/src/main/res/layout/media_player_widget_wide.xml` | Pending; preserve player video surface and widget click actions |
| `app/src/main/res/layout/player_layout.xml` | Pending; preserve player video surface and widget click actions |

Also inspect MainActivity/PlayerActivity/TorrentSelectionActivity/Cast/Crash/DebugLogs/launcher activity themes and system-inset application, AndroidManifest activities/permission entry points, styles in values/themes.xml and values-night, widget drawable assets, and permission flows. No onboarding module was found in the current source tree; the storage-permission and secure-folder setup surfaces are tracked above.
