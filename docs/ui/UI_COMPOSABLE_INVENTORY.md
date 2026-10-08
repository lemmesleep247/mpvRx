# Composable inventory

Generated from the starting checkout for completeness tracking. Entries are function declarations annotated @Composable, including overloads, nested Content methods and composition helpers. Private declarations and previews remain in the inventory. Every file is read for static triage; contextual and device review status is tracked in UI_MIGRATION.md.

| Phase | File | Function | Annotation line at initial inventory | Review |
| --- | --- | --- | ---: | --- |
| 2 Navigation | `MainActivity.kt` | `Navigator` | 539 | Pending |
| Support: nonvisual or shared host | `preferences/AppearancePreferences.kt` | `MultiChoiceSegmentedButton` | 235 | Pending |
| Support: nonvisual or shared host | `preferences/PlayerButton.kt` | `getPlayerButtonLabel` | 73 | Pending |
| Support: nonvisual or shared host | `preferences/preference/Preference.kt` | `collectAsState` | 51 | Pending |
| Support: nonvisual or shared host | `presentation/Screen.kt` | `Content` | 16 | Pending |
| 1 Shared components | `presentation/components/AppPickerSheet.kt` | `AppPickerSheet` | 60 | Pending |
| 1 Shared components | `presentation/components/ConfirmDialog.kt` | `ConfirmDialog` | 43 | Source migrated; NoVulkan APK built; visual checks pending |
| 1 Shared components | `presentation/components/ExpandableCard.kt` | `ExpandableCard` | 45 | Pending |
| 1 Shared components | `presentation/components/ExpandableCard.kt` | `PreviewExpandableCard` | 111 | Pending |
| 1 Shared components | `presentation/components/ExposedTextDropDownMenu.kt` | `ExposedTextDropDownMenu` | 33 | Pending |
| 1 Shared components | `presentation/components/LiquidGlassSurface.kt` | `rememberLiquidGlassBackdrop` | 39 | Pending |
| 1 Shared components | `presentation/components/LiquidGlassSurface.kt` | `ProvideLiquidGlassBackdrop` | 47 | Pending |
| 1 Shared components | `presentation/components/LiquidGlassSurface.kt` | `LiquidGlassSurface` | 65 | Pending |
| 1 Shared components | `presentation/components/OutlinedNumericChooser.kt` | `OutlinedNumericChooser` | 36 | Pending |
| 1 Shared components | `presentation/components/OutlinedNumericChooser.kt` | `OutlinedNumericChooser` | 103 | Pending |
| 1 Shared components | `presentation/components/OvalBox.kt` | `PreviewRightSideOvalBox` | 78 | Pending |
| 1 Shared components | `presentation/components/OvalBox.kt` | `PreviewLeftSideOvalBox` | 90 | Pending |
| 1 Shared components | `presentation/components/PlayerSheet.kt` | `PlayerSheet` | 105 | Pending |
| 1 Shared components | `presentation/components/PlayerSheet.kt` | `PlayerSheetDragHandle` | 349 | Pending |
| 1 Shared components | `presentation/components/PlayerSheet.kt` | `PlayerSheetHeader` | 359 | Pending |
| 1 Shared components | `presentation/components/PlayerSheet.kt` | `PlayerSheetSectionHeader` | 363 | Pending |
| 1 Shared components | `presentation/components/PlayerSheet.kt` | `PlayerSheetAction` | 391 | Pending |
| 1 Shared components | `presentation/components/PlayerSheetSearchField.kt` | `PlayerSheetSearchField` | 38 | Source migrated; NoVulkan APK built; visual checks pending |
| 1 Shared components | `presentation/components/RemoteImage.kt` | `RemoteImage` | 47 | Pending |
| 1 Shared components | `presentation/components/RepeatingIconButton.kt` | `RepeatingIconButton` | 32 | Pending |
| 1 Shared components | `presentation/components/SliderItem.kt` | `SliderItem` | 38 | Pending |
| 1 Shared components | `presentation/components/SliderItem.kt` | `SliderItem` | 107 | Pending |
| 1 Shared components | `presentation/components/SliderItem.kt` | `VerticalSliderItem` | 175 | Pending |
| 1 Shared components | `presentation/components/SliderItem.kt` | `VerticalSlider` | 222 | Pending |
| 1 Shared components | `presentation/components/SliderItem.kt` | `PreviewVerticalSliderItem` | 259 | Pending |
| 1 Shared components | `presentation/components/TintedSliderItem.kt` | `TintedSliderItem` | 37 | Pending |
| 1 Shared components | `presentation/components/TintedSliderItem.kt` | `TintedSlider` | 102 | Pending |
| 1 Shared components | `presentation/components/TintedSliderItem.kt` | `PreviewTintedSliderRed` | 133 | Pending |
| 1 Shared components | `presentation/components/TintedSliderItem.kt` | `PreviewTintedSliderItemRed` | 143 | Pending |
| 1 Shared components | `presentation/components/pullrefresh/PullRefreshBox.kt` | `PullRefreshBox` | 62 | Pending |
| 8 Remaining screens | `presentation/crash/CrashActivity.kt` | `CrashScreen` | 244 | Pending |
| 8 Remaining screens | `presentation/crash/CrashActivity.kt` | `CrashDetails` | 439 | Pending |
| 8 Remaining screens | `presentation/crash/DebugLogsScreen.kt` | `DebugLogsScreen` | 96 | Pending |
| 8 Remaining screens | `presentation/crash/DebugLogsScreen.kt` | `DebugLogMessageState` | 502 | Pending |
| 8 Remaining screens | `presentation/crash/DebugLogsScreen.kt` | `DebugLogEntryCard` | 532 | Pending |
| 8 Remaining screens | `presentation/crash/DebugLogsScreen.kt` | `DebugLogLevelBadge` | 609 | Pending |
| 8 Remaining screens | `presentation/crash/DebugLogsScreen.kt` | `debugLogLevelColor` | 631 | Pending |
| 2 Navigation | `ui/browser/MainScreen.kt` | `Content` | 198 | Pending |
| 2 Navigation | `ui/browser/MainScreen.kt` | `ExpressivePillNavigationBar` | 757 | Pending |
| 2 Navigation | `ui/browser/MainScreen.kt` | `MainTabIcon` | 1018 | Pending |
| 2 Navigation | `ui/browser/NavigationBarSelectionEffect.kt` | `NavigationBarSelectionEffect` | 13 | Pending |
| 2 Navigation | `ui/browser/NavigationGlassSurface.kt` | `NavigationGlassSurface` | 32 | Pending |
| 2 Navigation | `ui/browser/NavigationGlassSurface.kt` | `RefractedNavigationGlass` | 90 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AddAudiobookshelfServerDialog.kt` | `AddAudiobookshelfServerDialog` | 35 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AddAudiobookshelfServerDialog.kt` | `ManageAudiobookshelfServersDialog` | 110 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `Content` | 138 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookLibraryContent` | 145 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookDetailsBottomSheet` | 882 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookEditDialog` | 960 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookOnlineSearchDialog` | 1096 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookArtwork` | 1263 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookIconButton` | 1326 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookIconButton` | 1350 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookGridCard` | 1366 | Pending |
| 5 Network and other tabs | `ui/browser/audiobooks/AudiobookLibraryScreen.kt` | `AudiobookListRow` | 1452 | Pending |
| 3 Home and video browser | `ui/browser/cards/FolderCard.kt` | `rememberFolderCardUiConfig` | 89 | Pending |
| 3 Home and video browser | `ui/browser/cards/FolderCard.kt` | `FolderCard` | 138 | Pending |
| 3 Home and video browser | `ui/browser/cards/FolderCard.kt` | `PinnedFolderBadge` | 215 | Pending |
| 3 Home and video browser | `ui/browser/cards/M3UVideoCard.kt` | `PlaylistBookmarkButton` | 71 | Pending |
| 3 Home and video browser | `ui/browser/cards/M3UVideoCard.kt` | `M3UVideoCard` | 92 | Pending |
| 3 Home and video browser | `ui/browser/cards/M3UVideoCard.kt` | `M3UMetadataChip` | 454 | Pending |
| 5 Network and other tabs | `ui/browser/cards/NetworkConnectionCard.kt` | `NetworkConnectionCard` | 46 | Pending |
| 5 Network and other tabs | `ui/browser/cards/NetworkFolderCard.kt` | `NetworkFolderCard` | 53 | Pending |
| 5 Network and other tabs | `ui/browser/cards/NetworkImageCard.kt` | `NetworkImageCard` | 70 | Pending |
| 5 Network and other tabs | `ui/browser/cards/NetworkImageCard.kt` | `NetworkImageCardGridLayout` | 159 | Pending |
| 5 Network and other tabs | `ui/browser/cards/NetworkImageCard.kt` | `NetworkImageCardListLayout` | 264 | Pending |
| 5 Network and other tabs | `ui/browser/cards/NetworkImageCard.kt` | `ThumbnailImage` | 362 | Pending |
| 5 Network and other tabs | `ui/browser/cards/NetworkVideoCard.kt` | `NetworkVideoCard` | 67 | Pending |
| 5 Network and other tabs | `ui/browser/cards/PlaylistCard.kt` | `PlaylistCard` | 89 | Pending |
| 5 Network and other tabs | `ui/browser/cards/PlaylistCard.kt` | `YouTubePlaylistGridCard` | 419 | Pending |
| 3 Home and video browser | `ui/browser/cards/SelectionIndicator.kt` | `animatedSelectionColor` | 23 | Pending |
| 3 Home and video browser | `ui/browser/cards/SelectionIndicator.kt` | `SelectionIndicator` | 37 | Pending |
| 3 Home and video browser | `ui/browser/cards/SourceChip.kt` | `SourceChip` | 31 | Pending |
| 3 Home and video browser | `ui/browser/cards/VideoCard.kt` | `rememberVideoCardUiConfig` | 99 | Pending |
| 3 Home and video browser | `ui/browser/cards/VideoCard.kt` | `VideoTopStartBadges` | 160 | Pending |
| 3 Home and video browser | `ui/browser/cards/VideoCard.kt` | `VideoCard` | 204 | Pending |
| 3 Home and video browser | `ui/browser/cards/VideoCard.kt` | `CodecSupportIndicator` | 985 | Pending |
| 3 Home and video browser | `ui/browser/cards/VideoSwipeSurface.kt` | `containerColor` | 98 | Pending |
| 3 Home and video browser | `ui/browser/cards/VideoSwipeSurface.kt` | `contentColor` | 108 | Pending |
| 3 Home and video browser | `ui/browser/cards/VideoSwipeSurface.kt` | `VideoSwipeSurface` | 118 | Pending |
| 4 Music | `ui/browser/components/AudioMiniPlayer.kt` | `AudioMiniPlayer` | 57 | Pending |
| 2 Navigation | `ui/browser/components/BrowserTopBar.kt` | `BrowserTopBar` | 89 | Pending |
| 2 Navigation | `ui/browser/components/BrowserTopBar.kt` | `NormalTopBar` | 208 | Pending |
| 2 Navigation | `ui/browser/components/BrowserTopBar.kt` | `SelectionTopBar` | 455 | Pending |
| 3 Home and video browser | `ui/browser/components/ExpressiveScrollBar.kt` | `ExpressiveScrollBar` | 239 | Pending |
| 2 Navigation | `ui/browser/components/FloatingBottomBar.kt` | `rememberBrowserBottomBarBackdrop` | 57 | Pending |
| 2 Navigation | `ui/browser/components/FloatingBottomBar.kt` | `BrowserBottomBar` | 83 | Pending |
| 2 Navigation | `ui/browser/components/FloatingBottomBar.kt` | `BrowserBottomBarButton` | 407 | Pending |
| 3 Home and video browser | `ui/browser/components/MediaTypeBadge.kt` | `MediaTypeBadge` | 34 | Pending |
| 4 Music | `ui/browser/components/MiniPlayer.kt` | `MiniPlayer` | 112 | Pending |
| 4 Music | `ui/browser/components/MiniPlayer.kt` | `MiniPlayerContent` | 173 | Pending |
| 4 Music | `ui/browser/components/MiniPlayer.kt` | `rememberMiniPlayerCoverArt` | 618 | Pending |
| 3 Home and video browser | `ui/browser/components/VideoSwipeActions.kt` | `rememberSwipePlaybackInfo` | 68 | Pending |
| 3 Home and video browser | `ui/browser/components/VideoSwipeActions.kt` | `rememberVideoSwipeActions` | 96 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/AddToPlaylistDialog.kt` | `AddToPlaylistDialog` | 70 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/AddToPlaylistDialog.kt` | `PlaylistItemCard` | 263 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/AddToPlaylistDialog.kt` | `EmptyPlaylistsMessage` | 322 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/AddToPlaylistDialog.kt` | `CreatePlaylistDialog` | 365 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/AddXtreamPlaylistDialog.kt` | `AddXtreamPlaylistDialog` | 56 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `PlaylistSortDialog` | 36 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `coverArtSizeSelector` | 192 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `RecentSortDialog` | 206 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `FolderSortDialog` | 330 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `VideoSortDialog` | 681 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `FileSystemSortDialog` | 1063 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `NetworkSortDialog` | 1368 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `MusicSortDialog` | 1567 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `JellyfinSortDialog` | 1665 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BrowserSortDialogs.kt` | `AudiobookSortDialog` | 1748 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/BulkAiRenameDialog.kt` | `BulkAiRenameDialog` | 70 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/ConnectionEditorSheet.kt` | `ConnectionEditorSheet` | 70 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/ConnectionEditorSheet.kt` | `FieldLabel` | 336 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/ConnectionEditorSheet.kt` | `ConnectionToggle` | 345 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/ConnectionSheets.kt` | `AddConnectionSheet` | 20 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/ConnectionSheets.kt` | `EditConnectionSheet` | 48 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/CopyPasteDialog.kt` | `FileOperationProgressDialog` | 40 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/CopyPasteDialog.kt` | `LoadingDialog` | 207 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/CopyPasteDialog.kt` | `StatusCard` | 243 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/CopyPasteDialog.kt` | `ProgressSection` | 267 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/CopyPasteDialog.kt` | `SummaryRow` | 310 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/DeleteConfirmationDialog.kt` | `DeleteConfirmationDialog` | 41 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FilePickerDialog.kt` | `FilePickerDialog` | 59 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FilePickerDialog.kt` | `StorageVolumeItem` | 301 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FilePickerDialog.kt` | `FolderItem` | 359 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FilePickerDialog.kt` | `FileItem` | 396 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FilePickerDialog.kt` | `NavigationButtons` | 434 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FolderPickerDialog.kt` | `FolderPickerDialog` | 60 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FolderPickerDialog.kt` | `StorageVolumeItem` | 328 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FolderPickerDialog.kt` | `FolderItem` | 386 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/FolderPickerDialog.kt` | `CreateFolderDialog` | 418 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/RenameDialog.kt` | `RenameDialog` | 52 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/SharedServerDialogs.kt` | `SharedAddServerDialog` | 76 | Pending |
| 5 Network and other tabs | `ui/browser/dialogs/SharedServerDialogs.kt` | `SharedManageServersDialog` | 459 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | `SortDialog` | 83 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | `SortTypeSelector` | 362 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | `SortOrderSelector` | 449 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | `DialogSectionTitle` | 496 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | `ToggleChipRow` | 506 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | `GridColumnsNextSection` | 534 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/SortDialog.kt` | `RoundedCheckbox` | 652 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `VideoCompressorOverlay` | 135 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorConfigSurface` | 387 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorDestinationCard` | 608 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorBottomBar` | 677 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorInfoCard` | 724 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorPresetsTab` | 831 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorVideoTab` | 955 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorAudioTab` | 1145 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorProgressSurface` | 1247 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorResultSurface` | 1383 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorIssueSurface` | 1565 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorSettingsSheet` | 1691 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `QualityPresetConfigEditor` | 1989 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `TargetSizePresetEditor` | 2072 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `DefaultVideoConfigEditor` | 2128 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `DefaultAudioConfigEditor` | 2222 | Pending |
| 3 Home and video browser | `ui/browser/dialogs/VideoCompressorOverlay.kt` | `CompressorInfoDialog` | 2306 | Pending |
| 2 Navigation | `ui/browser/fab/FabScrollHelper.kt` | `FabScrim` | 52 | Pending |
| 2 Navigation | `ui/browser/fab/FabScrollHelper.kt` | `trackScrollForFabVisibility` | 85 | Pending |
| 2 Navigation | `ui/browser/fab/QuickPlayFab.kt` | `QuickPlayFab` | 61 | Pending |
| 3 Home and video browser | `ui/browser/filesystem/BreadcrumbNavigation.kt` | `BreadcrumbNavigation` | 31 | Pending |
| 3 Home and video browser | `ui/browser/filesystem/FileSystemBrowserScreen.kt` | `Content` | 151 | Pending |
| 3 Home and video browser | `ui/browser/filesystem/FileSystemBrowserScreen.kt` | `Content` | 165 | Pending |
| 3 Home and video browser | `ui/browser/filesystem/FileSystemBrowserScreen.kt` | `FileSystemBrowserScreen` | 176 | Pending |
| 3 Home and video browser | `ui/browser/filesystem/FileSystemBrowserScreen.kt` | `FileSystemBrowserContent` | 1231 | Pending |
| 3 Home and video browser | `ui/browser/filesystem/FileSystemBrowserScreen.kt` | `FileSystemSearchContent` | 1688 | Pending |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | `Content` | 166 | Pending |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | `MediaStoreFolderListContent` | 179 | Pending |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | `FoldersPane` | 594 | Pending |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | `FolderListContent` | 1261 | Pending |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | `GridContent` | 1372 | Pending |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | `ListContent` | 1478 | Pending |
| 3 Home and video browser | `ui/browser/folderlist/FolderListScreen.kt` | `SearchResultsContent` | 1598 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/AddJellyfinServerDialog.kt` | `AddJellyfinServerDialog` | 30 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/AddJellyfinServerDialog.kt` | `ManageJellyfinServersDialog` | 106 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `WatchProgressOverlayBar` | 116 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinHeroBanner` | 171 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `SlidingWormDotsIndicator` | 531 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinSectionHeader` | 593 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinHorizontalSection` | 650 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinResumeCard` | 705 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinPosterCard` | 907 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinMusicCard` | 1125 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinLibraryChipRow` | 1249 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinGenreChipRow` | 1314 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinLibraryCard` | 1365 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinEpisodeCard` | 1491 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `HotstarDownloadProgressCircle` | 1702 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `DownloadedBadge` | 1794 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinCards.kt` | `JellyfinListItemCard` | 1818 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinContent.kt` | `JellyfinContent` | 133 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinContent.kt` | `EmptyServersView` | 1459 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinContent.kt` | `ErrorView` | 1509 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinDetailSheet.kt` | `JellyfinDetailSheet` | 115 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinDetailSheet.kt` | `GhostBlock` | 1329 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinDetailSheet.kt` | `GhostEpisodeRows` | 1352 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinDetailSheet.kt` | `GhostDetailSections` | 1378 | Pending |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | `JellyfinMusicView` | 82 | Pending |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | `JellyfinMusicHomeContent` | 486 | Pending |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | `JellyfinCompactTrackGridSection` | 553 | Pending |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | `JellyfinPlaylistsRowSection` | 585 | Pending |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | `JellyfinMusicAlbumRowSection` | 622 | Pending |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | `JellyfinArtistsRowSection` | 655 | Pending |
| 4 Music | `ui/browser/jellyfin/JellyfinMusicView.kt` | `JellyfinMusicCard` | 691 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/JellyfinPersonSheet.kt` | `JellyfinPersonSheet` | 79 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrCards.kt` | `SeerrMediaCard` | 67 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrCards.kt` | `SeerrStatusChip` | 190 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrCards.kt` | `SeerrRequestStatusChip` | 249 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrCards.kt` | `SeerrRequestCard` | 298 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrCards.kt` | `SeerrSectionHeader` | 526 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrCards.kt` | `SeerrSliderRow` | 562 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrConnectionDialog.kt` | `SeerrConnectionDialog` | 85 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrContent.kt` | `SeerrContent` | 80 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrDetailSheet.kt` | `SeerrDetailSheet` | 96 | Pending |
| 5 Network and other tabs | `ui/browser/jellyfin/seerr/SeerrDetailSheet.kt` | `ResolutionProfileDropdown` | 888 | Pending |
| 3 Home and video browser | `ui/browser/medialibrary/MediaLibraryContent.kt` | `MediaLibraryContent` | 127 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `MusicLibraryContent` | 203 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `LocalAlbumArtImage` | 1262 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `ArtistAvatarImage` | 1339 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `MusicTabScrollBar` | 1378 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `SongsTabContent` | 1406 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `SongGridCard` | 1499 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `SongListItem` | 1603 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `AlbumsTabContent` | 1631 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `AlbumGridCard` | 1698 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `AlbumListCard` | 1777 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `ArtistsTabContent` | 1847 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `ArtistGridCard` | 1914 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `ArtistListCard` | 1975 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `PlaylistArtCollage` | 2033 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `MusicPlaylistCard` | 2215 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `PlaylistsTabContent` | 2326 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `AlbumDetailSheet` | 2435 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `ArtistDetailSheet` | 2533 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `CreatePlaylistDialog` | 2616 | Pending |
| 4 Music | `ui/browser/music/MusicLibraryContent.kt` | `EmptyMusicState` | 2651 | Pending |
| 4 Music | `ui/browser/music/MusicSourceDropdown.kt` | `MusicSourceDropdown` | 50 | Pending |
| 4 Music | `ui/browser/music/SharedMusicComponents.kt` | `SharedMusicTrackListItem` | 78 | Pending |
| 4 Music | `ui/browser/music/SharedMusicComponents.kt` | `SharedMusicGridCard` | 262 | Pending |
| 4 Music | `ui/browser/music/SharedMusicComponents.kt` | `SharedMusicSectionHeader` | 414 | Pending |
| 4 Music | `ui/browser/music/SharedMusicComponents.kt` | `SharedCompactTrackGridSection` | 446 | Pending |
| 4 Music | `ui/browser/music/SharedMusicComponents.kt` | `SharedMusicCarouselSection` | 539 | Pending |
| 4 Music | `ui/browser/music/SharedMusicComponents.kt` | `SharedMusicDetailHeader` | 581 | Pending |
| 4 Music | `ui/browser/navidrome/AddNavidromeServerDialog.kt` | `AddNavidromeServerDialog` | 36 | Pending |
| 4 Music | `ui/browser/navidrome/AddNavidromeServerDialog.kt` | `ManageNavidromeServersDialog` | 113 | Pending |
| 4 Music | `ui/browser/navidrome/NavidromeContent.kt` | `NavidromeContent` | 91 | Pending |
| 4 Music | `ui/browser/navidrome/NavidromeDetailSheet.kt` | `NavidromeDetailSheet` | 76 | Pending |
| 4 Music | `ui/browser/navidrome/NavidromeMusicView.kt` | `NavidromeMusicView` | 65 | Pending |
| 4 Music | `ui/browser/navidrome/NavidromeMusicView.kt` | `NavidromeHomeContent` | 365 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBookmarksScreen.kt` | `NetworkBookmarkSection` | 73 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBookmarksScreen.kt` | `BookmarkQuickCard` | 115 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBookmarksScreen.kt` | `Content` | 160 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBookmarksScreen.kt` | `BookmarkManageCard` | 223 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBrowserScreen.kt` | `Content` | 123 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBrowserScreen.kt` | `BrowserSectionHeader` | 474 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBrowserScreen.kt` | `browserSection` | 489 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkBrowserScreen.kt` | `NetworkBrowserContent` | 537 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | `Content` | 144 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | `AddMediaDialog` | 692 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | `LocalNetworkContent` | 766 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | `SyncPlayContent` | 844 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | `MediaContent` | 849 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | `EmptyStateCard` | 1012 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/NetworkStreamingScreen.kt` | `StreamLinkSection` | 1057 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/SyncplayPanel.kt` | `SyncplayPanel` | 49 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentCards.kt` | `TorrentHeroBanner` | 80 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentCards.kt` | `TorrentSectionHeader` | 389 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentCards.kt` | `TorrentResumeCard` | 447 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentCards.kt` | `TorrentPosterCard` | 604 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentCards.kt` | `TorrentHorizontalSection` | 764 | Pending |
| 5 Network and other tabs | `ui/browser/networkstreaming/TorrentDetailSheet.kt` | `TorrentDetailSheet` | 98 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistAddVideosScreen.kt` | `Content` | 115 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistAddVideosScreen.kt` | `SourceTabRow` | 466 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistAddVideosScreen.kt` | `NetworkConnectionList` | 495 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistAddVideosScreen.kt` | `NetworkConnectionPickerRow` | 539 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistDetailScreen.kt` | `Content` | 142 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistDetailScreen.kt` | `PlaylistVideoListContent` | 855 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistDetailScreen.kt` | `M3UPlaylistFilterRow` | 1198 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistDetailScreen.kt` | `StreamUrlDialog` | 1262 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistDetailScreen.kt` | `RemoveFromPlaylistDialog` | 1312 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistScreen.kt` | `Content` | 134 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistScreen.kt` | `PlaylistNameDialog` | 503 | Pending |
| 5 Network and other tabs | `ui/browser/playlist/PlaylistScreen.kt` | `PlaylistListContent` | 537 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `Content` | 174 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `ProfileAvatar` | 578 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `rememberProfileAvatar` | 620 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `ProfileOverviewCard` | 635 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `ProfileShortcutTile` | 825 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `SectionHeader` | 892 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `ShelfEmptyCard` | 947 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `ShelfCard` | 988 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `RecentVideoCard` | 1043 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `SnapshotShelfCard` | 1128 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `FrameBadge` | 1144 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `RecentVideoActionsSheet` | 1164 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `SheetAction` | 1196 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `ProfileEditDialog` | 1219 | Pending |
| 8 Remaining screens | `ui/browser/profile/ProfileScreen.kt` | `ProfileAvatarCropDialog` | 1347 | Pending |
| 3 Home and video browser | `ui/browser/recentlyplayed/RecentlyPlayedScreen.kt` | `Content` | 130 | Pending |
| 3 Home and video browser | `ui/browser/recentlyplayed/RecentlyPlayedScreen.kt` | `RecentItemsContent` | 662 | Pending |
| 3 Home and video browser | `ui/browser/selection/SelectionManager.kt` | `rememberSelectionManager` | 307 | Pending |
| 5 Network and other tabs | `ui/browser/sheets/PlayLinkSheet.kt` | `PlayLinkSheet` | 63 | Pending |
| 5 Network and other tabs | `ui/browser/sheets/PlayLinkSheet.kt` | `ValidationIcon` | 311 | Pending |
| 5 Network and other tabs | `ui/browser/sheets/PlaylistActionSheet.kt` | `PlaylistActionSheet` | 61 | Pending |
| 3 Home and video browser | `ui/browser/states/EmptyState.kt` | `EmptyState` | 42 | Pending |
| 3 Home and video browser | `ui/browser/states/LoadingState.kt` | `LoadingState` | 43 | Pending |
| 3 Home and video browser | `ui/browser/states/PermissionDeniedState.kt` | `PermissionDeniedState` | 157 | Pending |
| 3 Home and video browser | `ui/browser/states/PermissionDeniedState.kt` | `PermissionSectionCard` | 850 | Pending |
| 3 Home and video browser | `ui/browser/states/PermissionDeniedState.kt` | `PillBadge` | 994 | Pending |
| 3 Home and video browser | `ui/browser/states/PermissionDeniedState.kt` | `StoragePermissionPrompt` | 1014 | Pending |
| 3 Home and video browser | `ui/browser/videolist/VideoListScreen.kt` | `Content` | 139 | Pending |
| 3 Home and video browser | `ui/browser/videolist/VideoListScreen.kt` | `VideoListContent` | 809 | Pending |
| 6 Player presentation | `ui/cast/CastPlayerButton.kt` | `CastPlayerButton` | 41 | Pending |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | `CastRemoteControllerScreen` | 65 | Pending |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | `CastSeekBar` | 172 | Pending |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | `CastPlaybackControls` | 215 | Pending |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | `CastOptionsRow` | 278 | Pending |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | `CastOptionButton` | 299 | Pending |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | `CastVolumeSlider` | 318 | Pending |
| 6 Player presentation | `ui/cast/CastRemoteControllerScreen.kt` | `CastSpeedDialog` | 374 | Pending |
| 1 Shared components | `ui/components/IconSwitch.kt` | `IconSwitch` | 83 | Pending |
| 1 Shared components | `ui/components/InlineSearchBar.kt` | `InlineSearchBar` | 34 | Pending |
| 1 Shared components | `ui/components/ThemedSegmentedButtonColors.kt` | `themedSegmentedButtonColors` | 32 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `Content` | 94 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `SectionHeader` | 282 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `DownloadLocationCard` | 293 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `DownloadThumbnail` | 348 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `DownloadMediaRow` | 391 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `ActiveDownloadRow` | 448 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `YtdlpJobRow` | 476 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `CompletedRow` | 510 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `downloadStatusLine` | 539 | Pending |
| 5 Network and other tabs | `ui/downloads/DownloadsScreen.kt` | `ytdlpStatusLine` | 564 | Pending |
| 8 Remaining screens | `ui/editor/ExternalTextEditorActivity.kt` | `ExternalTextEditorScreen` | 119 | Pending |
| 8 Remaining screens | `ui/editor/MpvHelpScreen.kt` | `Content` | 80 | Pending |
| 8 Remaining screens | `ui/editor/MpvHelpScreen.kt` | `CategoryHeader` | 338 | Pending |
| 8 Remaining screens | `ui/editor/MpvHelpScreen.kt` | `HelpEntryCard` | 355 | Pending |
| 8 Remaining screens | `ui/editor/MpvHelpScreen.kt` | `KindBadge` | 455 | Pending |
| 8 Remaining screens | `ui/editor/MpvHelpScreen.kt` | `filterChipColors` | 490 | Pending |
| 8 Remaining screens | `ui/editor/MpvScriptEditor.kt` | `MpvScriptEditor` | 77 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotDetailScreen.kt` | `Content` | 77 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotDetailScreen.kt` | `SnapshotDetailOverlay` | 261 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotDetailScreen.kt` | `sourceCaption` | 414 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotFolderScreen.kt` | `Content` | 86 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotItems.kt` | `rememberSnapshotThumbnail` | 211 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotItems.kt` | `SnapshotGridItem` | 258 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotItems.kt` | `SnapshotFolderGridItem` | 312 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotItems.kt` | `SnapshotFolderListItem` | 364 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotItems.kt` | `SnapshotListItem` | 410 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotScreen.kt` | `Content` | 94 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotScreen.kt` | `SnapshotLibraryContent` | 482 | Pending |
| 8 Remaining screens | `ui/framecapture/SnapshotScreen.kt` | `SectionHeader` | 609 | Pending |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotFolderDialogs.kt` | `SnapshotFolderNameDialog` | 52 | Pending |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotFolderDialogs.kt` | `SnapshotDeleteFolderDialog` | 89 | Pending |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotFolderDialogs.kt` | `SnapshotDeleteConfirmDialog` | 132 | Pending |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotFolderDialogs.kt` | `SnapshotMoveTargetDialog` | 168 | Pending |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotFolderDialogs.kt` | `MoveTargetRow` | 235 | Pending |
| 8 Remaining screens | `ui/framecapture/dialogs/SnapshotSortDialog.kt` | `SnapshotSortDialog` | 39 | Pending |
| 1 Shared components | `ui/icons/AppIcon.kt` | `Icon` | 42 | Pending |
| 8 Remaining screens | `ui/imageviewer/ImageViewerOverlay.kt` | `ImageViewerOverlay` | 40 | Pending |
| 8 Remaining screens | `ui/imageviewer/ImageViewerScreen.kt` | `Content` | 52 | Pending |
| 8 Remaining screens | `ui/imageviewer/ZoomableImage.kt` | `ZoomableImage` | 52 | Pending |
| 6 Player presentation | `ui/liquidglass/AdaptiveControlsButton.kt` | `AdaptiveControlsButton` | 45 | Pending |
| 6 Player presentation | `ui/liquidglass/AdaptiveControlsButton.kt` | `AdaptiveControlsContainer` | 162 | Pending |
| 6 Player presentation | `ui/liquidglass/LiquidButton.kt` | `LiquidButton` | 46 | Pending |
| 6 Player presentation | `ui/liquidglass/LiquidGlassUtils.kt` | `rememberLiquidGlassSettings` | 99 | Pending |
| 6 Player presentation | `ui/liquidglass/LiquidToggle.kt` | `LiquidToggle` | 46 | Pending |
| 6 Player presentation | `ui/liquidglass/PlayerLiquidControls.kt` | `LiquidIconButton` | 56 | Pending |
| 6 Player presentation | `ui/liquidglass/PlayerLiquidControls.kt` | `LiquidPillButton` | 98 | Pending |
| 6 Player presentation | `ui/liquidglass/PlayerLiquidControls.kt` | `LiquidActionRow` | 152 | Pending |
| Support: nonvisual or shared host | `ui/lua/LuaScriptsUi.kt` | `rememberLuaScriptsCatalog` | 57 | Pending |
| Support: nonvisual or shared host | `ui/lua/LuaScriptsUi.kt` | `LuaRuntimeStatusCard` | 124 | Pending |
| Support: nonvisual or shared host | `ui/lua/LuaScriptsUi.kt` | `LuaScriptsLoadingState` | 229 | Pending |
| Support: nonvisual or shared host | `ui/lua/LuaScriptsUi.kt` | `LuaScriptsEmptyState` | 243 | Pending |
| Support: nonvisual or shared host | `ui/lua/LuaScriptsUi.kt` | `LuaScriptToggleCard` | 295 | Pending |
| Support: nonvisual or shared host | `ui/lua/LuaScriptsUi.kt` | `LuaSelectionFootnote` | 405 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `MediaInfoScreen` | 140 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `LoadingContent` | 345 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `ErrorContent` | 372 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `MediaInfoContent` | 412 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `GlassmorphicCard` | 617 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `QuickStatCard` | 622 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `HeroChipRow` | 685 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `OverviewTabContent` | 713 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `TrackSummaryItem` | 1055 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `StreamCard` | 1084 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `StatTile` | 1202 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `StreamTabContent` | 1241 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `ChaptersTabContent` | 1303 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `PropertyRow` | 1451 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `ValueDetailDialog` | 1492 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `OtherTabContent` | 1538 | Pending |
| Support: nonvisual or shared host | `ui/mediainfo/MediaInfoActivity.kt` | `RawTabContent` | 1588 | Pending |
| 6 Player presentation | `ui/player/AnimationStyles.kt` | `VideoOpenAnimationOverlay` | 347 | Pending |
| 6 Player presentation | `ui/player/PlayerArtworkTransition.kt` | `playerArtworkAnchor` | 142 | Pending |
| 6 Player presentation | `ui/player/PlayerArtworkTransition.kt` | `PlayerArtworkTransitionOverlay` | 180 | Pending |
| 6 Player presentation | `ui/player/PlayerArtworkTransition.kt` | `swipeDownToMiniPlayer` | 242 | Pending |
| 6 Player presentation | `ui/player/clip/ClipOverlayView.kt` | `EditorPanel` | 192 | Pending |
| 6 Player presentation | `ui/player/clip/ClipOverlayView.kt` | `ClipEditorPanel` | 624 | Pending |
| 6 Player presentation | `ui/player/clip/ClipOverlayView.kt` | `ClipEditorPanelContent` | 690 | Pending |
| 6 Player presentation | `ui/player/clip/ClipOverlayView.kt` | `ClipTimeField` | 865 | Pending |
| 6 Player presentation | `ui/player/clip/ClipOverlayView.kt` | `ClipMetadata` | 968 | Pending |
| 6 Player presentation | `ui/player/clip/ClipOverlayView.kt` | `ClipCropControls` | 995 | Pending |
| 6 Player presentation | `ui/player/components/VideoAmbientBackground.kt` | `rememberVideoAmbientFrame` | 124 | Pending |
| 6 Player presentation | `ui/player/components/VideoAmbientBackground.kt` | `VideoAmbientBackground` | 597 | Pending |
| 6 Player presentation | `ui/player/components/expressive/SectionHeader.kt` | `SectionHeader` | 33 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `rememberAudioPresentationMetadata` | 339 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `rememberAudioAlbumArt` | 359 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `audioPlaybackGestures` | 434 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `AudioVisualizerViewport` | 458 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `AudioSpectrumCaptureEffect` | 537 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `CoverArtCardImage` | 582 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `AudioPlayerControls` | 640 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `DualPaneSidePanel` | 2696 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `UpNextPlaylistContent` | 2761 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `UpNextPlaylistItemRow` | 3001 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `AudioSeekButton` | 3154 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `ReactiveIconButton` | 3187 | Pending |
| 6 Player presentation | `ui/player/controls/AudioPlayerControls.kt` | `ReactiveSurfaceButton` | 3249 | Pending |
| 6 Player presentation | `ui/player/controls/GestureHandler.kt` | `GestureHandler` | 117 | Pending |
| 6 Player presentation | `ui/player/controls/GestureHandler.kt` | `DoubleTapToSeekOvals` | 1506 | Pending |
| 6 Player presentation | `ui/player/controls/GestureHandler.kt` | `CombiningChevronsAnimation` | 1633 | Pending |
| 6 Player presentation | `ui/player/controls/GestureHandler.kt` | `MovingChevron` | 1676 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerButtonTheme.kt` | `PlayerButtonTheme` | 26 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerButtonTheme.kt` | `PlayerControlsContentTheme` | 29 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerButtonTheme.kt` | `PlayerButtonContentTheme` | 56 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlDrawer.kt` | `PlayerControlDrawer` | 76 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlDrawer.kt` | `PlayerControlEdgeHandle` | 134 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlDrawer.kt` | `PlayerControlPanel` | 225 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlDrawer.kt` | `PlayerControlPanelHeader` | 260 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlDrawer.kt` | `PlayerControlPanelContent` | 289 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlDrawer.kt` | `PlayerControlTile` | 327 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControls.kt` | `PlayerControls` | 209 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControls.kt` | `CustomStatsPageSixOverlay` | 2377 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControls.kt` | `OutlinedText` | 2792 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControls.kt` | `OutlinedLabeled` | 2850 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsLandscape.kt` | `TopLeftPlayerControlsLandscape` | 61 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsLandscape.kt` | `TopRightPlayerControlsLandscape` | 263 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsLandscape.kt` | `BottomRightPlayerControlsLandscape` | 311 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsLandscape.kt` | `BottomLeftPlayerControlsLandscape` | 368 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsPortrait.kt` | `TopPlayerControlsPortrait` | 60 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsPortrait.kt` | `BottomPlayerControlsPortrait` | 254 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsShared.kt` | `RenderPlayerButton` | 116 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerControlsShared.kt` | `rememberTimeAndNetworkStat` | 1879 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerPanels.kt` | `PlayerPanels` | 44 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerSheets.kt` | `PlayerSheets` | 68 | Pending |
| 6 Player presentation | `ui/player/controls/PlayerSheets.kt` | `rememberQualityDownloadAction` | 732 | Pending |
| 6 Player presentation | `ui/player/controls/components/AudioWavySeekBar.kt` | `SeekbarWavyVisualizerOverlay` | 94 | Pending |
| 6 Player presentation | `ui/player/controls/components/AudioWavySeekBar.kt` | `AudioWavySeekBar` | 455 | Pending |
| 6 Player presentation | `ui/player/controls/components/BufferingState.kt` | `rememberBufferingState` | 51 | Pending |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | `playerButtonColorScheme` | 52 | Pending |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | `playerButtonContainerColor` | 59 | Pending |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | `playerButtonContentColor` | 62 | Pending |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | `playerButtonBorderColor` | 65 | Pending |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | `ControlsButton` | 70 | Pending |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | `ControlsGroup` | 148 | Pending |
| 6 Player presentation | `ui/player/controls/components/ControlsButton.kt` | `PreviewControlsButton` | 166 | Pending |
| 6 Player presentation | `ui/player/controls/components/CurrentChapter.kt` | `CurrentChapter` | 53 | Pending |
| 6 Player presentation | `ui/player/controls/components/CustomPlayerIcons.kt` | `AnimatedPlayPauseIcon` | 42 | Pending |
| 6 Player presentation | `ui/player/controls/components/CustomPlayerIcons.kt` | `AbLoopIcon` | 177 | Pending |
| 6 Player presentation | `ui/player/controls/components/DoubleTapSeekSecondsView.kt` | `DoubleTapSeekTriangles` | 34 | Pending |
| 6 Player presentation | `ui/player/controls/components/DoubleTapSeekSecondsView.kt` | `DoubleTapArrow` | 74 | Pending |
| 6 Player presentation | `ui/player/controls/components/LyricsProviderPicker.kt` | `LyricsProviderPicker` | 39 | Pending |
| 6 Player presentation | `ui/player/controls/components/LyricsProviderPicker.kt` | `LyricsSourceLine` | 81 | Pending |
| 6 Player presentation | `ui/player/controls/components/LyricsView.kt` | `LyricsView` | 116 | Pending |
| 6 Player presentation | `ui/player/controls/components/LyricsView.kt` | `SyncOffsetButton` | 735 | Pending |
| 6 Player presentation | `ui/player/controls/components/LyricsView.kt` | `rememberSmoothedPositionMs` | 765 | Pending |
| 6 Player presentation | `ui/player/controls/components/LyricsView.kt` | `AnimatedLyricWord` | 835 | Pending |
| 6 Player presentation | `ui/player/controls/components/MediaScopesOverlay.kt` | `MediaScopesOverlay` | 101 | Pending |
| 6 Player presentation | `ui/player/controls/components/MediaScopesOverlay.kt` | `AudioWaveformScope` | 338 | Pending |
| 6 Player presentation | `ui/player/controls/components/MediaScopesOverlay.kt` | `VideoScope` | 497 | Pending |
| 6 Player presentation | `ui/player/controls/components/MediaScopesOverlay.kt` | `ScopeGraticule` | 586 | Pending |
| 6 Player presentation | `ui/player/controls/components/MiniAudioVisualizer.kt` | `MiniAudioVisualizer` | 28 | Pending |
| 6 Player presentation | `ui/player/controls/components/MpvConfigOwnedNotice.kt` | `MpvConfigOwnedSheet` | 35 | Pending |
| 6 Player presentation | `ui/player/controls/components/MpvConfigOwnedNotice.kt` | `MpvConfigOwnedPanel` | 53 | Pending |
| 6 Player presentation | `ui/player/controls/components/MpvConfigOwnedNotice.kt` | `MpvConfigOwnedContent` | 86 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `rememberPlayerUpdateOffset` | 69 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `PlayerUpdate` | 103 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `TextPlayerUpdate` | 135 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `MultipleSpeedPlayerUpdate` | 152 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `CompactSpeedIndicator` | 160 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `ResumeAvailablePlayerUpdate` | 222 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `ResumedFromPlayerUpdate` | 262 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `PreviewMultipleSpeedPlayerUpdate` | 313 | Pending |
| 6 Player presentation | `ui/player/controls/components/PlayerUpdates.kt` | `SeekPlayerUpdate` | 326 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `rememberSeekbarTrackAlphas` | 159 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `SeekbarWithTimers` | 330 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `SeekbarContent` | 515 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `ClipRangeSelection` | 900 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `NormalSeekbar` | 973 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `SquigglySeekbar` | 1118 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `SlimSeekbar` | 1523 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `LiquidSeekbar` | 1635 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `SeekbarStylePreview` | 1856 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `SeekbarStyleLivePreview` | 2037 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `VideoTimer` | 2221 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `StandardSeekbar` | 2249 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `StandardSeekbar` | 2276 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `PreviewSeekBarWavy` | 2422 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `PreviewSeekBarSlim` | 2441 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `PreviewSeekBarSlimScrubbing` | 2460 | Pending |
| 6 Player presentation | `ui/player/controls/components/Seekbar.kt` | `PreviewSeekbarStyles` | 2479 | Pending |
| 6 Player presentation | `ui/player/controls/components/TvFocus.kt` | `rememberTvInitialFocusRequester` | 74 | Pending |
| 6 Player presentation | `ui/player/controls/components/VerticalSliders.kt` | `VerticalSlider` | 60 | Pending |
| 6 Player presentation | `ui/player/controls/components/VerticalSliders.kt` | `VerticalSlider` | 109 | Pending |
| 6 Player presentation | `ui/player/controls/components/VerticalSliders.kt` | `BrightnessSlider` | 158 | Pending |
| 6 Player presentation | `ui/player/controls/components/VerticalSliders.kt` | `VolumeSlider` | 235 | Pending |
| 6 Player presentation | `ui/player/controls/components/VerticalSliders.kt` | `getVolumeSliderText` | 319 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/AudioDelayPanel.kt` | `AudioDelayPanel` | 42 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/AudioDelayPanel.kt` | `DelayCard` | 72 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/AudioDelayPanel.kt` | `AudioDelayCardTitle` | 89 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/DraggablePanel.kt` | `DraggablePanel` | 63 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/HdrScreenOutputPanel.kt` | `HdrScreenOutputPanel` | 46 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/HdrScreenOutputPanel.kt` | `HdrPipelineUnavailableStatus` | 102 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/HdrScreenOutputPanel.kt` | `HdrModeOption` | 159 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/LuaScriptsPanel.kt` | `LuaScriptsPanel` | 46 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleDelayPanel.kt` | `SubtitleDelayPanel` | 55 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleDelayPanel.kt` | `SubtitleDelayCardContent` | 115 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleDelayPanel.kt` | `DelayCardContent` | 152 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleDelayPanel.kt` | `QuickSyncOffsets` | 287 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleDelayPanel.kt` | `SubtitleDelayTitle` | 316 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsColorsCard.kt` | `SubtitleSettingsColorsCard` | 65 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsColorsCard.kt` | `SubtitlesColorPicker` | 210 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsColorsCard.kt` | `AssOverrideWarningBanner` | 260 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsMiscellaneousCard.kt` | `SubtitlesMiscellaneousCard` | 51 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsPanel.kt` | `SubtitleSettingsPanel` | 34 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/SubtitleSettingsTypographyCard.kt` | `SubtitleSettingsTypographyCard` | 76 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsDebandCard.kt` | `VideoSettingsDebandCard` | 53 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsFilterPresetsCard.kt` | `VideoSettingsFilterPresetsCard` | 114 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsFilterPresetsCard.kt` | `FilterPresetNameDialog` | 381 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsFiltersCard.kt` | `VideoSettingsFiltersCard` | 46 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/VideoSettingsPanel.kt` | `VideoSettingsPanel` | 33 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/YtdlpPanel.kt` | `YtdlpPanel` | 42 | Pending |
| 6 Player presentation | `ui/player/controls/components/panels/components/MultiCardPanel.kt` | `MultiCardPanel` | 54 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AmbientSheet.kt` | `AmbientSheet` | 63 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AmbientSheet.kt` | `ExpressivePresetButton` | 451 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AspectRatioSheet.kt` | `AspectRatioSheet` | 58 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AspectRatioSheet.kt` | `AddCustomRatioRow` | 175 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AudioPropertiesSheet.kt` | `AudioPropertiesSheet` | 40 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AudioTracksSheet.kt` | `AudioTracksSheet` | 66 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AudioTracksSheet.kt` | `AudioTrackCard` | 205 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AudioTracksSheet.kt` | `AudioTrackRow` | 271 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AudioTracksSheet.kt` | `audioTrackBadges` | 341 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AudiobookSheet.kt` | `AudiobookSheet` | 28 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/AudiobookSheet.kt` | `BookSettingOption` | 80 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/ChaptersSheet.kt` | `ChaptersSheet` | 57 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/ChaptersSheet.kt` | `ChapterTrack` | 101 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/ChaptersSheet.kt` | `PlaybackBookmarkEditor` | 139 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/DecodersSheet.kt` | `DecodersSheet` | 27 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/EqualizerSheet.kt` | `EqualizerSheet` | 146 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/EqualizerSheet.kt` | `ManualEqualizerContent` | 324 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/EqualizerSheet.kt` | `DynamicEqualizerContent` | 373 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/EqualizerSheet.kt` | `TonePad` | 430 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/EqualizerSheet.kt` | `PresetChip` | 527 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/EqualizerSheet.kt` | `BandColumn` | 573 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/FrameNavigationSheet.kt` | `FrameNavigationSheet` | 102 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/FrameNavigationSheet.kt` | `FrameReviewOverlay` | 438 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/FrameNavigationSheet.kt` | `frameReviewButtonColors` | 750 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/FrameNavigationSheet.kt` | `FrameInfoDisplay` | 775 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/FrameNavigationSheet.kt` | `ControlButtons` | 853 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/FrameNavigationSheet.kt` | `IncludeSubsToggle` | 957 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/LyricsProviderSheet.kt` | `LyricsProviderSheet` | 51 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/LyricsProviderSheet.kt` | `ProviderStatusChip` | 137 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/LyricsSheet.kt` | `LyricsSheet` | 61 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/LyricsTranslateDialog.kt` | `LyricsTranslateDialog` | 61 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/MoreSheet.kt` | `MoreSheet` | 69 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/MoreSheet.kt` | `TimePickerDialog` | 317 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/MoreSheet.kt` | `SectionHeaderWithInfo` | 436 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/OnlineSubtitleSearchSheet.kt` | `OnlineSubtitleSearchSheet` | 69 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/OnlineSubtitleSearchSheet.kt` | `OnlineSubtitleRow` | 418 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/OnlineSubtitleSearchSheet.kt` | `SubdlEpisodeDropdown` | 613 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/OnlineSubtitleSearchSheet.kt` | `TmdbMediaCard` | 668 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/OnlineSubtitleSearchSheet.kt` | `TmdbResultRow` | 764 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/OnlineSubtitleSearchSheet.kt` | `SeriesSelectionControls` | 863 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaybackSpeedSheet.kt` | `PlaybackSpeedSheet` | 56 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaylistSheet.kt` | `PlaylistThumbnail` | 141 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaylistSheet.kt` | `PlaylistSheet` | 254 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaylistSheet.kt` | `DragHandle` | 530 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaylistSheet.kt` | `PlaylistTrackListItem` | 573 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaylistSheet.kt` | `PlaylistTrackGridItem` | 803 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PlaylistSheet.kt` | `LoadingChip` | 1051 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `PostProcessingSheet` | 59 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `CollapsibleSection` | 205 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `NaturalColorsSection` | 246 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `LevelsSection` | 271 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `SharpenSection` | 320 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `BloomSection` | 337 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `DenoiseSection` | 362 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `DebandSection` | 395 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `CelShadingSection` | 428 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `CartoonSoftSection` | 493 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `FilmicCurveSection` | 542 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `SplitToningSection` | 583 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `FilmGrainSection` | 632 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `VignetteSection` | 657 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `BlurSection` | 682 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `ChromaticAberrationSection` | 723 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `CrtSection` | 748 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `ScanlinesSection` | 781 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/PostProcessingSheet.kt` | `WhiteBalanceSection` | 814 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/ScopesSheet.kt` | `ScopesSheet` | 56 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/ScopesSheet.kt` | `ScopeOptionRow` | 219 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/SubtitleTracksSheet.kt` | `SubtitlesSheet` | 86 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/SubtitleTracksSheet.kt` | `SubtitleTrackRow` | 573 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/SubtitleTracksSheet.kt` | `subtitleTrackBadges` | 661 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/TrackSheetRows.kt` | `TrackBadgeFlow` | 45 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/TrackSheetRows.kt` | `AddTrackRow` | 86 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/TrackSheetRows.kt` | `getTrackTitle` | 122 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/VideoQualitySheet.kt` | `VideoQualitySheet` | 39 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/VideoZoomSheet.kt` | `VideoZoomSheet` | 53 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/VideoZoomSheet.kt` | `ZoomVideoSheet` | 103 | Pending |
| 6 Player presentation | `ui/player/controls/components/sheets/VisualizerStyleSheet.kt` | `VisualizerStyleSheet` | 24 | Pending |
| 6 Player presentation | `ui/player/visualizer/BlobComposable.kt` | `BlobOverlay` | 28 | Pending |
| 6 Player presentation | `ui/player/visualizer/BlobComposable.kt` | `GalaxyOverlay` | 42 | Pending |
| 6 Player presentation | `ui/player/visualizer/BlobComposable.kt` | `ParticleOverlay` | 56 | Pending |
| 6 Player presentation | `ui/player/visualizer/BlobComposable.kt` | `VisualizerOverlay` | 74 | Pending |
| 6 Player presentation | `ui/player/visualizer/BlobComposable.kt` | `rememberAudioVisualizerFeatures` | 108 | Pending |
| 6 Player presentation | `ui/player/visualizer/CuboidComposable.kt` | `CuboidOverlay` | 196 | Pending |
| 6 Player presentation | `ui/player/visualizer/OneUiWaveVisualizer.kt` | `WaveVisualizerOverlay` | 68 | Pending |
| 6 Player presentation | `ui/player/ytdlp/YtdlpInstallProgressDialog.kt` | `YtdlpInstallProgressDialog` | 44 | Pending |
| 6 Player presentation | `ui/player/ytdlp/YtdlpInstallPromptDialog.kt` | `YtdlpInstallPromptDialog` | 41 | Pending |
| 6 Player presentation | `ui/player/ytdlp/YtdlpInstallationStatus.kt` | `YtdlpInstallationStatus` | 26 | Pending |
| 8 Remaining screens | `ui/preferences/AboutScreen.kt` | `Content` | 101 | Pending |
| 8 Remaining screens | `ui/preferences/AboutScreen.kt` | `SystemStatRow` | 643 | Pending |
| 8 Remaining screens | `ui/preferences/AboutScreen.kt` | `Content` | 747 | Pending |
| 7 Settings | `ui/preferences/AdvancedPreferencesScreen.kt` | `Content` | 130 | Pending |
| 7 Settings | `ui/preferences/AiIntegrationScreen.kt` | `Content` | 142 | Pending |
| 7 Settings | `ui/preferences/AiIntegrationScreen.kt` | `SttModelSelector` | 1221 | Pending |
| 7 Settings | `ui/preferences/AiIntegrationScreen.kt` | `AutoTranslateLanguageConfig` | 1351 | Pending |
| 7 Settings | `ui/preferences/AppearancePreferencesScreen.kt` | `Content` | 91 | Pending |
| 7 Settings | `ui/preferences/AudioPreferencesScreen.kt` | `Content` | 87 | Pending |
| 7 Settings | `ui/preferences/CardPreferences.kt` | `PreferenceCard` | 37 | Pending |
| 7 Settings | `ui/preferences/CardPreferences.kt` | `PreferenceDivider` | 69 | Pending |
| 7 Settings | `ui/preferences/CardPreferences.kt` | `PreferenceSectionHeader` | 80 | Pending |
| 7 Settings | `ui/preferences/CodecCapabilitiesScreen.kt` | `Content` | 533 | Pending |
| 7 Settings | `ui/preferences/CodecCapabilitiesScreen.kt` | `StatCounterChip` | 927 | Pending |
| 7 Settings | `ui/preferences/CodecCapabilitiesScreen.kt` | `KeyCodecStatusCard` | 975 | Pending |
| 7 Settings | `ui/preferences/CodecCapabilitiesScreen.kt` | `borderStrokeForHw` | 1099 | Pending |
| 7 Settings | `ui/preferences/CodecCapabilitiesScreen.kt` | `CodecDetailCard` | 1113 | Pending |
| 8 Remaining screens | `ui/preferences/ConfigEditorScreen.kt` | `Content` | 75 | Pending |
| 8 Remaining screens | `ui/preferences/ControlLayoutEditorScreen.kt` | `Content` | 71 | Pending |
| 8 Remaining screens | `ui/preferences/ControlLayoutEditorScreen.kt` | `IconsLegend` | 444 | Pending |
| 7 Settings | `ui/preferences/CustomButtonScreen.kt` | `Content` | 139 | Pending |
| 7 Settings | `ui/preferences/CustomButtonScreen.kt` | `ButtonSlotCard` | 491 | Pending |
| 7 Settings | `ui/preferences/CustomButtonScreen.kt` | `ButtonExpandedContent` | 822 | Pending |
| 7 Settings | `ui/preferences/CustomButtonScreen.kt` | `HorizontalDividerWithLabel` | 965 | Pending |
| 7 Settings | `ui/preferences/CustomButtonScreen.kt` | `LuaEditorEntryCard` | 992 | Pending |
| 7 Settings | `ui/preferences/CustomButtonScreen.kt` | `ImportSelectionScreen` | 1102 | Pending |
| 8 Remaining screens | `ui/preferences/CustomThemeEditorScreen.kt` | `Content` | 76 | Pending |
| 8 Remaining screens | `ui/preferences/CustomThemeEditorScreen.kt` | `ThemeColorEditor` | 365 | Pending |
| 8 Remaining screens | `ui/preferences/CustomThemeEditorScreen.kt` | `ColorChannelSlider` | 429 | Pending |
| 7 Settings | `ui/preferences/DecoderPreferencesScreen.kt` | `Content` | 75 | Pending |
| 7 Settings | `ui/preferences/FoldersPreferencesScreen.kt` | `Content` | 89 | Pending |
| 7 Settings | `ui/preferences/FoldersPreferencesScreen.kt` | `NoMediaPreferenceCard` | 336 | Pending |
| 7 Settings | `ui/preferences/FoldersPreferencesScreen.kt` | `BlacklistedFolderItem` | 487 | Pending |
| 7 Settings | `ui/preferences/FoldersPreferencesScreen.kt` | `AddFolderDialog` | 572 | Pending |
| 7 Settings | `ui/preferences/FoldersPreferencesScreen.kt` | `StorageRootPickerCard` | 729 | Pending |
| 7 Settings | `ui/preferences/GesturePreferencesScreen.kt` | `Content` | 67 | Pending |
| 8 Remaining screens | `ui/preferences/GoogleFontsSheet.kt` | `GoogleFontsSheet` | 61 | Pending |
| 8 Remaining screens | `ui/preferences/GoogleFontsSheet.kt` | `FontSectionLabel` | 309 | Pending |
| 8 Remaining screens | `ui/preferences/GoogleFontsSheet.kt` | `AppFontRow` | 320 | Pending |
| 8 Remaining screens | `ui/preferences/HallOfFameScreen.kt` | `Content` | 86 | Pending |
| 8 Remaining screens | `ui/preferences/HallOfFameScreen.kt` | `HallOfFameTopThree` | 426 | Pending |
| 8 Remaining screens | `ui/preferences/HallOfFameScreen.kt` | `communityDetails` | 444 | Pending |
| 8 Remaining screens | `ui/preferences/HallOfFameScreen.kt` | `HallOfFamePerson` | 454 | Pending |
| 8 Remaining screens | `ui/preferences/HallOfFameScreen.kt` | `HallOfFameAvatar` | 536 | Pending |
| 7 Settings | `ui/preferences/LiquidGlassPreferencesScreen.kt` | `Content` | 71 | Pending |
| 7 Settings | `ui/preferences/LiquidGlassPreferencesScreen.kt` | `LiquidGlassPreview` | 154 | Pending |
| 8 Remaining screens | `ui/preferences/LuaScriptEditorScreen.kt` | `Content` | 73 | Pending |
| 8 Remaining screens | `ui/preferences/LuaScriptEditorScreen.kt` | `ScriptExtensionChip` | 585 | Pending |
| 7 Settings | `ui/preferences/LuaScriptsScreen.kt` | `Content` | 61 | Pending |
| 7 Settings | `ui/preferences/MediaServersPreferencesScreen.kt` | `Content` | 82 | Pending |
| 7 Settings | `ui/preferences/MediaServersPreferencesScreen.kt` | `AudiobookshelfServerAvatar` | 944 | Pending |
| 7 Settings | `ui/preferences/MediaServersPreferencesScreen.kt` | `NavidromeServerAvatar` | 968 | Pending |
| 7 Settings | `ui/preferences/MediaServersPreferencesScreen.kt` | `JellyfinServerAvatar` | 992 | Pending |
| 7 Settings | `ui/preferences/MediaServersPreferencesScreen.kt` | `SeerrServerAvatar` | 1058 | Pending |
| 7 Settings | `ui/preferences/MediaServersPreferencesScreen.kt` | `ServerPreferenceItem` | 1112 | Pending |
| 8 Remaining screens | `ui/preferences/ModelSearchDialog.kt` | `ModelSearchDialog` | 44 | Pending |
| 8 Remaining screens | `ui/preferences/ModelSearchDialog.kt` | `ModelSearchItem` | 127 | Pending |
| 8 Remaining screens | `ui/preferences/ModelSearchDialog.kt` | `FreeTag` | 179 | Pending |
| 7 Settings | `ui/preferences/MpvConfOwnershipScreen.kt` | `Content` | 73 | Pending |
| 7 Settings | `ui/preferences/MpvConfOwnershipScreen.kt` | `OwnershipSummaryCard` | 138 | Pending |
| 7 Settings | `ui/preferences/MpvConfOwnershipScreen.kt` | `OwnershipGroupCard` | 218 | Pending |
| 7 Settings | `ui/preferences/MpvConfigOverridePreference.kt` | `MpvConfigOverridePreference` | 28 | Pending |
| 7 Settings | `ui/preferences/NetworkConfigurationPreferencesScreen.kt` | `Content` | 45 | Pending |
| 7 Settings | `ui/preferences/PlayerControlsPreferencesScreen.kt` | `Content` | 87 | Pending |
| 7 Settings | `ui/preferences/PlayerControlsPreferencesScreen.kt` | `PreferenceCategoryWithEditButton` | 455 | Pending |
| 7 Settings | `ui/preferences/PlayerControlsPreferencesScreen.kt` | `PreferenceIconSummary` | 489 | Pending |
| 7 Settings | `ui/preferences/PlayerPreferencesScreen.kt` | `Content` | 83 | Pending |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | `Content` | 91 | Pending |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | `SettingsPane` | 149 | Pending |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | `settingsSections` | 211 | Pending |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | `SettingsSearchEntry` | 400 | Pending |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | `SettingsSectionBlock` | 449 | Pending |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | `SettingsDestinationGroup` | 484 | Pending |
| 7 Settings | `ui/preferences/PreferencesScreen.kt` | `SettingsDestinationRow` | 513 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchNavigation.kt` | `highlightBackground` | 299 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchNavigation.kt` | `rememberSettingsSearchList` | 336 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchNavigation.kt` | `rememberSettingsSearchHighlight` | 360 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchNavigation.kt` | `rememberSettingsSearchHighlight` | 383 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchNavigation.kt` | `rememberSettingsSearchHighlight` | 399 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchScreen.kt` | `Content` | 75 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchScreen.kt` | `SearchResultItem` | 385 | Pending |
| 7 Settings | `ui/preferences/SettingsSearchScreen.kt` | `localizedSearchCategory` | 496 | Pending |
| 7 Settings | `ui/preferences/SubtitlesPreferencesScreen.kt` | `Content` | 111 | Pending |
| 7 Settings | `ui/preferences/SubtitlesPreferencesScreen.kt` | `MultiChoicePreference` | 1237 | Pending |
| 7 Settings | `ui/preferences/SubtitlesPreferencesScreen.kt` | `SubtitleApiKeyPreference` | 1371 | Pending |
| 7 Settings | `ui/preferences/VideoSwipePreferencesScreen.kt` | `Content` | 82 | Pending |
| 7 Settings | `ui/preferences/VideoSwipePreferencesScreen.kt` | `SwipeDirectionPreference` | 175 | Pending |
| 7 Settings | `ui/preferences/VideoSwipePreferencesScreen.kt` | `SwipeActionPreview` | 243 | Pending |
| 8 Remaining screens | `ui/preferences/WallpaperEditorScreen.kt` | `Content` | 113 | Pending |
| 8 Remaining screens | `ui/preferences/WallpaperEditorScreen.kt` | `WallpaperSlider` | 651 | Pending |
| 8 Remaining screens | `ui/preferences/WallpaperEditorScreen.kt` | `WallpaperScaleModeToggle` | 698 | Pending |
| 8 Remaining screens | `ui/preferences/WallpaperHomePreview.kt` | `WallpaperHomePreviewDialog` | 75 | Pending |
| 8 Remaining screens | `ui/preferences/WallpaperPreferenceCard.kt` | `WallpaperPreferenceCard` | 54 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `ProfileWatchStatistics` | 78 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `BentoCard` | 172 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `WatchTimeBentoCard` | 178 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `WatchSplitBentoCard` | 259 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `WeeklyActivityBentoCard` | 428 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `TopMediaLeaderboardBentoCard` | 583 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `LeaderboardMediaRow` | 673 | Pending |
| 7 Settings | `ui/preferences/WatchStatsScreen.kt` | `WatchMediaArtwork` | 759 | Pending |
| 7 Settings | `ui/preferences/YtdlpSettingsScreen.kt` | `Content` | 49 | Pending |
| 7 Settings | `ui/preferences/components/LiquidGlassPreferences.kt` | `LiquidGlassSwitch` | 170 | Pending |
| 7 Settings | `ui/preferences/components/LiquidGlassPreferences.kt` | `LiquidGlassSlider` | 186 | Pending |
| 7 Settings | `ui/preferences/components/OptionsDialog.kt` | `OptionsDialog` | 36 | Pending |
| 7 Settings | `ui/preferences/components/PlayerButtonChip.kt` | `PlayerButtonChip` | 42 | Pending |
| 7 Settings | `ui/preferences/components/RestartRequiredDialog.kt` | `RestartRequiredDialog` | 10 | Pending |
| 7 Settings | `ui/preferences/components/SettingsComponents.kt` | `SettingsClickableItem` | 39 | Pending |
| 7 Settings | `ui/preferences/components/SettingsComponents.kt` | `SettingsSectionHeader` | 117 | Pending |
| 7 Settings | `ui/preferences/components/SettingsComponents.kt` | `SettingsSwitchItem` | 130 | Pending |
| 7 Settings | `ui/preferences/components/SettingsComponents.kt` | `SettingsDivider` | 161 | Pending |
| 7 Settings | `ui/preferences/components/SwitchPreference.kt` | `SwitchPreference` | 30 | Pending |
| 8 Remaining screens | `ui/preferences/components/ThemePicker.kt` | `ThemePicker` | 56 | Pending |
| 8 Remaining screens | `ui/preferences/components/ThemePicker.kt` | `AddCustomThemeCard` | 153 | Pending |
| 8 Remaining screens | `ui/preferences/components/ThemePicker.kt` | `ThemeCardAction` | 190 | Pending |
| 8 Remaining screens | `ui/preferences/components/ThemePreviewCard.kt` | `ThemePreviewCard` | 61 | Pending |
| 8 Remaining screens | `ui/preferences/components/WallpaperPresetCard.kt` | `WallpaperPresetCard` | 49 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureConfirmDialog.kt` | `SecureConfirmDialog` | 45 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderAccountDialogs.kt` | `ChangePinDialog` | 46 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderAccountDialogs.kt` | `ChangeSecurityQuestionDialog` | 166 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderAddFilesScreen.kt` | `Content` | 76 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | `Content` | 122 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | `EnterPinContent` | 273 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | `PinDots` | 451 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | `SetupContent` | 485 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | `ChoosePinContent` | 624 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | `SecurityQuestionAnswerContent` | 742 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderGateScreen.kt` | `PinField` | 854 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderProgressDialog.kt` | `SecureFolderProgressDialog` | 44 | Pending |
| 8 Remaining screens | `ui/securefolder/SecureFolderScreen.kt` | `Content` | 95 | Pending |
| 0 Foundation | `ui/theme/AppWallpaper.kt` | `onWallpaper` | 56 | Pending |
| 0 Foundation | `ui/theme/AppWallpaper.kt` | `AppWallpaperHost` | 68 | Pending |
| 0 Foundation | `ui/theme/AppWallpaper.kt` | `wallpaperAwareBackgroundColor` | 152 | Pending |
| 0 Foundation | `ui/theme/AppWallpaper.kt` | `WallpaperImage` | 156 | Pending |
| 0 Foundation | `ui/theme/AppWallpaper.kt` | `rememberWallpaperScrimColor` | 230 | Pending |
| 0 Foundation | `ui/theme/AppWallpaper.kt` | `rememberLightTextOnWallpaper` | 368 | Pending |
| 0 Foundation | `ui/theme/Motion.kt` | `rememberMotionPolicy` | 46 | Pending |
| 0 Foundation | `ui/theme/Motion.kt` | `policy` | 60 | Pending |
| 0 Foundation | `ui/theme/Motion.kt` | `spatial` | 63 | Pending |
| 0 Foundation | `ui/theme/Motion.kt` | `shouldReduceMotion` | 69 | Pending |
| 0 Foundation | `ui/theme/Motion.kt` | `playerReducedMotion` | 72 | Pending |
| 0 Foundation | `ui/theme/SplashContent.kt` | `SplashContent` | 52 | Pending |
| 0 Foundation | `ui/theme/Theme.kt` | `rememberThemeTransitionState` | 149 | Pending |
| 0 Foundation | `ui/theme/Theme.kt` | `ThemeTransitionOverlay` | 157 | Pending |
| 0 Foundation | `ui/theme/Theme.kt` | `ThemeTransitionContent` | 259 | Pending |
| 0 Foundation | `ui/theme/Theme.kt` | `MpvrxTheme` | 278 | Pending |
| 0 Foundation | `ui/theme/Type.kt` | `fontFamilyForText` | 142 | Pending |
| 5 Network and other tabs | `ui/torrent/TorrentSelectionScreen.kt` | `TorrentSelectionScreen` | 65 | Pending |
| 5 Network and other tabs | `ui/torrent/TorrentSelectionScreen.kt` | `TorrentReadyScreen` | 79 | Pending |
| 5 Network and other tabs | `ui/torrent/TorrentSelectionScreen.kt` | `TorrentHeroBanner` | 341 | Pending |
| 5 Network and other tabs | `ui/torrent/TorrentSelectionScreen.kt` | `TorrentFileRow` | 488 | Pending |
| 5 Network and other tabs | `ui/torrent/TorrentSelectionScreen.kt` | `TorrentLoadingScreen` | 589 | Pending |
| 5 Network and other tabs | `ui/torrent/TorrentSelectionScreen.kt` | `TorrentErrorScreen` | 626 | Pending |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | `UpdateSheet` | 59 | Pending |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | `SheetHeader` | 165 | Pending |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | `VersionTransitionRow` | 205 | Pending |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | `VersionChip` | 225 | Pending |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | `ReleaseMetaRow` | 253 | Pending |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | `MetaItem` | 270 | Pending |
| 8 Remaining screens | `ui/update/UpdateSheet.kt` | `DownloadProgressSection` | 289 | Pending |
| 2 Navigation | `ui/utils/AppHaptics.kt` | `ProvideAppHaptics` | 30 | Pending |
| 2 Navigation | `ui/utils/AppHaptics.kt` | `rememberKmpHapticFeedback` | 45 | Pending |
| 2 Navigation | `ui/utils/AppHaptics.kt` | `rememberAppHaptics` | 137 | Pending |
| 2 Navigation | `ui/utils/AppHaptics.kt` | `rememberAdjustmentHaptics` | 178 | Pending |
| 2 Navigation | `ui/utils/MpvConfigOverrideState.kt` | `isOwnedByMpvConf` | 21 | Pending |
| 2 Navigation | `ui/utils/MpvConfigOverrideState.kt` | `isMpvOptionOwnedByConfig` | 27 | Pending |
| 2 Navigation | `ui/utils/MpvConfigOverrideState.kt` | `isAnyMpvOptionOwnedByConfig` | 30 | Pending |
| 2 Navigation | `ui/utils/MpvConfigOverrideState.kt` | `currentMpvConfigOverrideOptions` | 36 | Pending |
| 2 Navigation | `ui/utils/NavigationPager.kt` | `NavigationBackHandler` | 49 | Pending |
| 2 Navigation | `ui/utils/NavigationPager.kt` | `NavigationPager` | 58 | Pending |
| 2 Navigation | `ui/utils/NavigationPager.kt` | `rememberTabNavigation` | 107 | Pending |
| 2 Navigation | `ui/utils/NavigationPager.kt` | `BrowserTabPage` | 137 | Pending |
| 2 Navigation | `ui/utils/ReorderFeedback.kt` | `rememberReorderFeedback` | 43 | Pending |
| 2 Navigation | `ui/utils/ReorderFeedback.kt` | `dragElevation` | 59 | Pending |
| 2 Navigation | `ui/utils/ResponsiveGridUtils.kt` | `calculateResponsiveGridSpans` | 37 | Pending |
| 2 Navigation | `ui/utils/ScreenNavigation.kt` | `ScreenNavDisplay` | 87 | Pending |
| Support: nonvisual or shared host | `utils/permission/PermissionUtils.kt` | `rememberStoragePermissionState` | 158 | Pending |
| Support: nonvisual or shared host | `utils/permission/PermissionUtils.kt` | `handleStoragePermission` | 170 | Pending |

Lines describe the initial inventory, not permanent anchors. Re-inventory after changes and resolve each entry before declaring the overhaul complete.
