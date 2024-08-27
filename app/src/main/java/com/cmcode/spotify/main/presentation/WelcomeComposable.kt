/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
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
fun WelcomeComposable() {
    SpotifyTheme {
        Column(
            Modifier.fillMaxSize(),
        ) {
            Box {
                AnimationLoader(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.52f)
                            .align(Alignment.Center),
                )
            }

            HeadlineLargeText(R.string.headline, Modifier.align(Alignment.CenterHorizontally))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
            ) {
                GreenButton(
                    text = stringResource(R.string.sign_up),
                    onClick = { /*TODO*/ },
                )
                OutlinedIconButton(
                    iconResId = R.drawable.google,
                    text = stringResource(R.string.continue_google),
                    onClick = { /*TODO*/ },
                )
                OutlinedIconButton(
                    iconResId = R.drawable.facebook,
                    text = stringResource(R.string.continue_facebook),
                    onClick = { /*TODO*/ },
                )
                OutlinedIconButton(
                    iconResId = R.drawable.apple,
                    text = stringResource(R.string.continue_apple),
                    onClick = { /*TODO*/ },
                )

                Spacer(Modifier.size(16.dp))
                ClickableText(stringResource(R.string.login), onClick = { /*TODO*/ })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewWelcome() {
    SpotifyTheme {
        Surface {
            WelcomeComposable()
        }
    }
}
