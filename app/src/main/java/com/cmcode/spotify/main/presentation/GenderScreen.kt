/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmcode.spotify.R
import com.cmcode.spotify.main.domain.CustomInputBox
import com.cmcode.spotify.main.domain.GreyButton
import com.cmcode.spotify.main.domain.TopBar
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme

@Composable
fun GenderScreen(
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onGenderSelected: (String) -> Unit = {}
) {
    var gender by rememberSaveable { mutableStateOf("") }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .statusBarsPadding(),
    ) {
        TopBar(R.string.create_account) { onBackClick() }
        CustomInputBox(
            R.string.what_gender,
            R.string.empty_string,
            value = gender,
            onValueChange = {
                gender = it
                onGenderSelected(it)
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(50.dp))
        GreyButton(
            text = "Next",
            onClick = onNextClick,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenderScreenPreview() {
    SpotifyTheme {
        Surface {
            GenderScreen()
        }
    }
}
