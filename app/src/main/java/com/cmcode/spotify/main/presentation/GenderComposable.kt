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
import com.cmcode.spotify.main.domain.GreyButton
import com.cmcode.spotify.main.domain.TopBar
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme

@Composable
fun GenderComposable() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        TopBar(R.string.create_account) { /*TODO*/ }
        CustomInputBox(R.string.what_gender, R.string.empty_string)
        Spacer(Modifier.height(50.dp))
        GreyButton(
            "Next",
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGender() {
    SpotifyTheme {
        Surface {
            GenderComposable()
        }
    }
}
