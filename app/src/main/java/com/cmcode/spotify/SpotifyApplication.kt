/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/** Main application class of the Spotify app. */
@HiltAndroidApp(Application::class)
class SpotifyApplication : Application()
