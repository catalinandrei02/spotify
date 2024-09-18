/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main

import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cmcode.spotify.main.presentation.WelcomeComposable
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme
import dagger.hilt.android.AndroidEntryPoint

/** Activity class used for displaying the screens of the Spotify main menu. */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideAndroidUI()

        setContent {
            WelcomeComposable()
        }
    }

    private fun hideAndroidUI() {
        window.insetsController?.apply {
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
        }
    }

    @Composable
    private fun MainScreen() {
        WelcomeComposable()
    }

    @Preview(showBackground = true)
    @Composable
    private fun Preview() {
        SpotifyTheme {
            Surface {
                MainScreen()
            }
        }
    }
}
