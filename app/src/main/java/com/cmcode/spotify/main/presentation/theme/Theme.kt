/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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

@Composable
fun SpotifyTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
