/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.domain

import androidx.compose.ui.unit.dp

object Constants {

    /* Error Message */
    const val LOGIN_ERROR_MESSAGE = "Login Failed."
    const val REGISTER_ERROR_MESSAGE = "Register Failed."
    const val RESET_PASSWORD_ERROR_MESSAGE = "Password Reset Failed."

    /* Successful Operation Message */
    const val REGISTER_SUCCESS_MESSAGE = "Registered Successfully."
    const val RESET_PASSWORD_SUCCESS_MESSAGE = "Password reset email sent."

    /* Firebase */
    const val USERS_COLLECTION = "users"

    /* Compose */
    const val BUTTON_WIDTH = 0.85f

    val BUTTON_HEIGHT = 55.dp
    val VERTICAL_PADDING = 8.dp
    val SPACER_24 = 24.dp
    val OUTLINE = 2.dp
    val CORNER_SHAPE = 50.dp
}
