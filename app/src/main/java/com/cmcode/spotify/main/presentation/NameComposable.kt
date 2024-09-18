/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmcode.spotify.R
import com.cmcode.spotify.main.domain.CustomInputBox
import com.cmcode.spotify.main.domain.LabelMediumText
import com.cmcode.spotify.main.domain.TopBar
import com.cmcode.spotify.main.domain.WhiteButton
import com.cmcode.spotify.main.domain.customCheckboxes
import com.cmcode.spotify.main.presentation.theme.SpotifyGreen
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme

@Composable
fun NameComposable() {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        TopBar(R.string.create_account) { /*TODO*/ }
        CustomInputBox(R.string.what_name, R.string.label_name)

        Spacer(Modifier.height(20.dp))
        LabelMediumText(R.string.disclaimer_one, Modifier.align(Alignment.Start))

        Spacer(Modifier.height(20.dp))
        LabelMediumText(
            R.string.terms_of_use,
            Modifier.align(Alignment.Start),
            color = SpotifyGreen,
        )

        Spacer(Modifier.height(20.dp))
        LabelMediumText(R.string.disclaimer_two, Modifier.align(Alignment.Start))

        Spacer(Modifier.height(20.dp))
        LabelMediumText(
            R.string.privacy_policy,
            Modifier.align(Alignment.Start),
            color = SpotifyGreen,
        )

        customCheckboxes(R.string.gdpr1)
        customCheckboxes(R.string.gdpr2)

        Spacer(Modifier.height(50.dp))
        WhiteButton(
            "Create an account",
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewName() {
    SpotifyTheme {
        Surface {
            NameComposable()
        }
    }
}
