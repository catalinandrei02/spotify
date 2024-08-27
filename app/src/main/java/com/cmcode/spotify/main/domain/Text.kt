/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.domain

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun TitleText(
    string: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        color = Color.White,
        style = MaterialTheme.typography.titleMedium,
        text = stringResource(string),
        modifier = modifier,
    )
}

@Composable
fun HeadlineSmallText(
    string: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        color = Color.White,
        style = MaterialTheme.typography.headlineSmall,
        text = stringResource(string),
        modifier = modifier,
    )
}

@Composable
fun HeadlineLargeText(
    string: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        color = Color.White,
        style = MaterialTheme.typography.headlineLarge,
        text = stringResource(string),
        modifier = modifier,
    )
}

@Composable
fun LabelMediumText(
    string: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Text(
        color = color,
        style = MaterialTheme.typography.labelMedium,
        text = stringResource(string),
        modifier = modifier,
    )
}

@Composable
fun LabelSmallText(
    string: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Text(
        color = color,
        style = MaterialTheme.typography.labelSmall,
        text = stringResource(string),
        modifier = modifier,
    )
}
