/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.domain

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme

@Composable
fun TitleText(
    textRes: Int,
    modifier: Modifier = Modifier,
    color: Color = SpotifyTheme.colorScheme.onBackground,
    textAlign: TextAlign? = null,
    style: TextStyle = MaterialTheme.typography.titleMedium,
) {
    BaseText(
        textRes = textRes,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = style,
    )
}

@Composable
fun HeadlineSmallText(
    textRes: Int,
    modifier: Modifier = Modifier,
    color: Color = SpotifyTheme.colorScheme.onBackground,
    textAlign: TextAlign? = null,
) {
    BaseText(
        textRes = textRes,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = MaterialTheme.typography.headlineSmall,
    )
}

@Composable
fun HeadlineLargeText(
    textRes: Int,
    modifier: Modifier = Modifier,
    color: Color = SpotifyTheme.colorScheme.onBackground,
    textAlign: TextAlign? = null,
) {
    BaseText(
        textRes = textRes,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun LabelMediumText(
    textRes: Int,
    modifier: Modifier = Modifier,
    color: Color = SpotifyTheme.colorScheme.onBackground,
    textAlign: TextAlign? = null,
) {
    BaseText(
        textRes = textRes,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = MaterialTheme.typography.labelMedium,
    )
}

@Composable
fun LabelSmallText(
    textRes: Int,
    modifier: Modifier = Modifier,
    color: Color = SpotifyTheme.colorScheme.onBackground,
    textAlign: TextAlign? = null,
) {
    BaseText(
        textRes = textRes,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = MaterialTheme.typography.labelSmall,
    )
}

@Composable
private fun BaseText(
    textRes: Int,
    modifier: Modifier,
    color: Color,
    textAlign: TextAlign?,
    style: TextStyle,
) {
    Text(
        text = stringResource(id = textRes),
        modifier = modifier,
        color = color,
        style = style,
        textAlign = textAlign,
    )
}
