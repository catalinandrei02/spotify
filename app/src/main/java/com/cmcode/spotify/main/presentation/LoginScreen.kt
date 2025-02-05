package com.cmcode.spotify.main.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cmcode.spotify.R
import com.cmcode.spotify.main.domain.CustomInputBox
import com.cmcode.spotify.main.domain.LabelMediumText
import com.cmcode.spotify.main.domain.TopBar
import com.cmcode.spotify.main.domain.WhiteButton
import com.cmcode.spotify.main.presentation.navigation.Routes
import com.cmcode.spotify.main.presentation.theme.SpotifyGreen
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: CommonViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var rememberMe by rememberSaveable { mutableStateOf(false) }
    var isLoading by rememberSaveable { mutableStateOf(false) }

    val loginState by viewModel.loginState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(loginState) {
        loginState?.let { success ->
            if (success) {
                navController.navigate(Routes.HOME) {
                    popUpTo(Routes.WELCOME) { inclusive = true }
                }
                viewModel.resetLoginState()
                isLoading = false
            } else {
                isLoading = false
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding(),
    ) {
        TopBar(R.string.login_title, onClick = onBackClick)

        // Email Input
        CustomInputBox(
            title = R.string.enter_email,
            label = R.string.label_email,
            value = email,
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Input
        CustomInputBox(
            title = R.string.enter_password,
            label = R.string.label_password,
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Forgot Password
        LabelMediumText(
            textRes = R.string.forgot_password,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { onForgotPasswordClick() },
            color = SpotifyGreen
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Remember Me Checkbox
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            LabelMediumText(textRes = R.string.remember_me)
        }

        Spacer(modifier = Modifier.height(40.dp))

        WhiteButton(
            text = if (isLoading) "Logging in..." else "Log In",
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    isLoading = true
                    coroutineScope.launch {
                        viewModel.loginWithEmailAndPassword(email, password)
                    }
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            enabled = !isLoading
        )

        // Show error message if login fails
        if (loginState == false) {
            Spacer(modifier = Modifier.height(16.dp))
            LabelMediumText(
                textRes = R.string.login_failed,
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
