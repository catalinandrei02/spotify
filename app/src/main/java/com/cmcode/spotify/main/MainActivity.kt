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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmcode.spotify.main.presentation.EmailScreen
import com.cmcode.spotify.main.presentation.GenderScreen
import com.cmcode.spotify.main.presentation.NameScreen
import com.cmcode.spotify.main.presentation.PasswordScreen
import com.cmcode.spotify.main.presentation.WelcomeScreen
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
                AppNavigation()
            }
        }
    }

    private fun hideAndroidUI() {
        window.insetsController?.apply {
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
        }
    }

    /**
     * AppNavigation defines the navigation graph with two routes:
     * - "welcome_screen" (the start destination)
     * - "email_screen" etc
     *
     * When the green button in WelcomeScreen is clicked, the [onSignUpClick] callback
     * navigates to the "email_screen".
     */
    @Composable
    private fun AppNavigation() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Routes.WELCOME) {
            composable(Routes.WELCOME) {
                WelcomeScreen(
                    onSignUpClick = { navController.navigate(Routes.EMAIL) },
                    onGoogleClick = { /* Handle Google sign in */ },
                    onFacebookClick = { /* Handle Facebook sign in */ },
                    onAppleClick = { /* Handle Apple sign in */ },
                    onLoginClick = { /* Handle Login click */ },
                )
            }
            composable(Routes.EMAIL) {
                EmailScreen(
                    onBackClick = { navController.popBackStack() },
                    onNextClick = { navController.navigate(Routes.PASSWORD) },
                )
            }
            composable(Routes.PASSWORD) {
                PasswordScreen(
                    onBackClick = { navController.popBackStack() },
                    onNextClick = { navController.navigate(Routes.GENDER) },
                )
            }
            composable(Routes.GENDER) {
                GenderScreen(
                    onBackClick = { navController.popBackStack() },
                    onNextClick = { navController.navigate(Routes.NAME) },
                )
            }
            composable(Routes.NAME) {
                NameScreen(
                    onBackClick = { navController.popBackStack() },
                    onCreateClick = { /* implement logic */ },
                )
            }
        }
    }

    /** Companion object to store all navigation routes */
    private object Routes {
        const val WELCOME = "welcome_screen"
        const val EMAIL = "email_screen"
        const val PASSWORD = "password_screen"
        const val GENDER = "gender_screen"
        const val NAME = "name_screen"
    }

    @Preview(showBackground = true)
    @Composable
    private fun MainActivityPreview() {
        SpotifyTheme {
            Surface {
                AppNavigation()
            }
        }
    }
}
