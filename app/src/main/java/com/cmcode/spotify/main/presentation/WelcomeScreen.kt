/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmcode.spotify.R
import com.cmcode.spotify.main.domain.AnimationLoader
import com.cmcode.spotify.main.domain.ClickableText
import com.cmcode.spotify.main.domain.GreenButton
import com.cmcode.spotify.main.domain.HeadlineLargeText
import com.cmcode.spotify.main.domain.OutlinedIconButton
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme

@Composable
fun WelcomeScreen(
    onSignUpClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
) {
    SpotifyTheme {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = SpotifyTheme.spacing.medium)
                    .statusBarsPadding(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            AnimationLoader(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .align(Alignment.CenterHorizontally),
            )

            HeadlineLargeText(
                textRes = R.string.headline,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            AuthButtonsSection(
                onSignUpClick = onSignUpClick,
                onGoogleClick = onGoogleClick,
                onFacebookClick = onFacebookClick,
                onAppleClick = onAppleClick,
                onLoginClick = onLoginClick,
            )
        }
    }
}

@Composable
private fun AuthButtonsSection(
    onSignUpClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onAppleClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = SpotifyTheme.spacing.extraLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(SpotifyTheme.spacing.medium),
    ) {
        GreenButton(
            text = stringResource(R.string.sign_up),
            onClick = onSignUpClick,
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedIconButton(
            iconResId = R.drawable.google,
            text = stringResource(R.string.continue_google),
            onClick = onGoogleClick,
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedIconButton(
            iconResId = R.drawable.facebook,
            text = stringResource(R.string.continue_facebook),
            onClick = onFacebookClick,
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedIconButton(
            iconResId = R.drawable.apple,
            text = stringResource(R.string.continue_apple),
            onClick = onAppleClick,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.size(SpotifyTheme.spacing.medium))

        ClickableText(
            text = stringResource(R.string.login),
            onClick = onLoginClick,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {
    SpotifyTheme {
        WelcomeScreen()
    }
}
