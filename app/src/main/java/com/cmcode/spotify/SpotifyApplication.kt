package com.cmcode.spotify

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/** Main application class of the Spotify app. */
@HiltAndroidApp(Application::class)
class SpotifyApplication : Application()