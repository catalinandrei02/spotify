/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.domain

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmcode.spotify.R
import com.cmcode.spotify.main.domain.Constants.BUTTON_HEIGHT
import com.cmcode.spotify.main.domain.Constants.BUTTON_WIDTH
import com.cmcode.spotify.main.domain.Constants.CORNER_SHAPE
import com.cmcode.spotify.main.domain.Constants.OUTLINE
import com.cmcode.spotify.main.domain.Constants.SPACER_24
import com.cmcode.spotify.main.domain.Constants.VERTICAL_PADDING
import com.cmcode.spotify.main.presentation.theme.BackgroundGrey
import com.cmcode.spotify.main.presentation.theme.ButtonGrey
import com.cmcode.spotify.main.presentation.theme.ButtonWhite
import com.cmcode.spotify.main.presentation.theme.SpotifyGreen

@Composable
fun OutlinedIconButton(
    iconResId: Int,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedIconButton(
        shape = RoundedCornerShape(CORNER_SHAPE),
        colors = IconButtonDefaults.outlinedIconButtonColors(containerColor = BackgroundGrey),
        border = ButtonDefaults.outlinedButtonBorder.copy(width = OUTLINE),
        onClick = onClick,
        modifier =
            modifier
                .padding(VERTICAL_PADDING)
                .height(BUTTON_HEIGHT)
                .fillMaxWidth(BUTTON_WIDTH),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.size(SPACER_24))
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(SPACER_24),
                tint = Color.Unspecified,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.size(SPACER_24))
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
            )
        }
    }
}

@Composable
fun GreenButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        shape = RoundedCornerShape(CORNER_SHAPE),
        colors = ButtonDefaults.buttonColors(containerColor = SpotifyGreen),
        onClick = onClick,
        modifier =
            modifier
                .padding(8.dp)
                .height(BUTTON_HEIGHT)
                .fillMaxWidth(BUTTON_WIDTH),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = text,
                style =
                    MaterialTheme.typography.labelMedium.copy(
                        color = BackgroundGrey,
                    ),
            )
        }
    }
}

@Composable
fun GreyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        shape = RoundedCornerShape(CORNER_SHAPE),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonGrey),
        onClick = onClick,
        modifier = modifier.padding(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier,
        ) {
            Text(
                text = text,
                style =
                    MaterialTheme.typography.labelMedium.copy(
                        color = Color.Black,
                        fontSize = 15.sp,
                    ),
            )
        }
    }
}

@Composable
fun WhiteButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        shape = RoundedCornerShape(CORNER_SHAPE),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonWhite),
        onClick = onClick,
        modifier = modifier.padding(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier,
        ) {
            Text(
                text = text,
                style =
                    MaterialTheme.typography.labelMedium.copy(
                        color = Color.Black,
                        fontSize = 15.sp,
                    ),
            )
        }
    }
}

@Composable
fun ClickableText(
    text: String,
    onClick: () -> Unit,
) {
    Text(
        color = Color.White,
        text = text,
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Center,
        modifier =
            Modifier
                .clickable { onClick() },
    )
}

@Composable
fun BackButton(onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier,
    ) {
        Icon(
            painter = painterResource(R.drawable.chevronleft),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier =
                Modifier
                    .size(30.dp)
                    .clickable { onClick() },
        )
    }
}
