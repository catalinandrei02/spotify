/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cmcode.spotify.R

val avenir_next =
    FontFamily(
        listOf(
            Font(R.font.avenir, weight = FontWeight.Bold),
        ),
    )

// Set of Material typography styles to start with
val Typography =
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
