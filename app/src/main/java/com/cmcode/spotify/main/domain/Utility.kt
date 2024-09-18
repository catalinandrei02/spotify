/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.domain

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmcode.spotify.R
import com.cmcode.spotify.main.presentation.theme.CheckboxGrey
import com.cmcode.spotify.main.presentation.theme.SpotifyGreen
import com.cmcode.spotify.main.presentation.theme.SpotifyTheme
import com.cmcode.spotify.main.presentation.theme.TextFieldGrey

@Composable
fun TopBar(
    string: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        BackButton(
            onClick = { onClick() },
        )
        TitleText(string, Modifier.align(Alignment.Center))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInputBox(
    title: Int,
    label: Int,
    modifier: Modifier = Modifier,
) {
    Spacer(Modifier.height(20.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        HeadlineSmallText(title, Modifier.align(Alignment.CenterVertically))
    }
    Spacer(Modifier.height(2.dp))
    TextField(
        shape = RoundedCornerShape(5.dp),
        value = "",
        onValueChange = {},
        singleLine = true,
        colors =
            TextFieldDefaults.textFieldColors(
                focusedTextColor = Color.White,
                containerColor = TextFieldGrey,
                errorContainerColor = Color.Red,
            ),
        modifier =
            modifier
                .width(365.dp)
                .height(51.dp),
    )
    Spacer(Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        LabelSmallText(label, Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun customCheckboxes(text: Int): Boolean {
    var isChecked by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxWidth()) {
        LabelMediumText(
            text,
            Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth(0.8F),
        )

        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors =
                CheckboxDefaults.colors(
                    checkedColor = SpotifyGreen,
                    uncheckedColor = CheckboxGrey,
                    checkmarkColor = CheckboxGrey,
                ),
            modifier = Modifier.align(Alignment.BottomEnd),
        )
    }

    return isChecked
}

@Preview(showBackground = true)
@Composable
private fun PreviewCheckBox() {
    SpotifyTheme {
        Surface {
            Column {
                customCheckboxes(R.string.gdpr1)
                customCheckboxes(R.string.gdpr2)
            }
        }
    }
}
