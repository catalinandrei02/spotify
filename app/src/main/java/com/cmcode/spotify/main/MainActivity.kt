package com.cmcode.spotify.main

import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cmcode.spotify.main.presentation.navigation.SpotifyNavHost
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideAndroidUI()
        setContent {
            SpotifyTheme {
                SpotifyNavHost()
            }
        }
    }

    private fun hideAndroidUI() {
        window.insetsController?.apply {
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun MainActivityPreview() {
        SpotifyTheme {
            Surface {
                SpotifyNavHost()
            }
        }
    }
}
