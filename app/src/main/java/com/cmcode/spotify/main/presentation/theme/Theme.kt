/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmcode.spotify.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// Theme colors
val SpotifyGreen = Color(0xFF1ED760)
val BackgroundGrey = Color(0xFF121212)
val TextFieldGrey = Color(0xFF777777)
val ButtonGrey = Color(0xFF535353)
val ButtonWhite = Color(0xFFF5F5F5)
val CheckboxGrey = Color(0xFF727272)

private val colorScheme =
    lightColorScheme(
        primary = BackgroundGrey,
        secondary = BackgroundGrey,
        background = BackgroundGrey,
        surface = BackgroundGrey,
        onPrimary = Color.White,
        onSecondary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        error = Color.Red,
        onError = Color.White,
    )

private val avenir_next =
    FontFamily(
        listOf(
            Font(R.font.avenir, weight = FontWeight.Bold),
        ),
    )

val appTypography =
    Typography(
        headlineLarge =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            ),
        headlineSmall =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            ),
        titleMedium =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            ),
        titleSmall =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            ),
        labelMedium =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = avenir_next,
                fontWeight = FontWeight.Light,
                fontSize = 8.sp,
            ),
    )

@Immutable
data class Spacing(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val extraExtraLarge: Dp = 48.dp,
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }

@Composable
fun SpotifyTheme(content: @Composable () -> Unit) {
    val spacing = Spacing()
    val systemUiController = rememberSystemUiController()

    MaterialTheme(
        colorScheme = colorScheme,
        typography = appTypography,
    ) {
        val backgroundColor = MaterialTheme.colorScheme.background

        SideEffect {
            systemUiController.setSystemBarsColor(
                color = backgroundColor,
                darkIcons = false,
            )
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            CompositionLocalProvider(
                LocalSpacing provides spacing,
                content = content,
            )
        }
    }
}

object SpotifyTheme {
    val colorScheme
        @Composable
        get() = MaterialTheme.colorScheme

    val spacing: Spacing
        @Composable
        get() = LocalSpacing.current
}
