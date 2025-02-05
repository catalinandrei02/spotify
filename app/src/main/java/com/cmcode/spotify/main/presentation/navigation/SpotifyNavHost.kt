package com.cmcode.spotify.main.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmcode.spotify.main.presentation.CommonViewModel
import com.cmcode.spotify.main.presentation.EmailScreen
import com.cmcode.spotify.main.presentation.GenderScreen
import com.cmcode.spotify.main.presentation.HomeScreen
import com.cmcode.spotify.main.presentation.LoginScreen
import com.cmcode.spotify.main.presentation.NameScreen
import com.cmcode.spotify.main.presentation.PasswordScreen
import com.cmcode.spotify.main.presentation.WelcomeScreen

@Composable
fun SpotifyNavHost(
    viewModel: CommonViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }

    NavHost(navController = navController, startDestination = Routes.WELCOME) {
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onSignUpClick = { navController.navigate(Routes.EMAIL) },
                onGoogleClick = { /* Handle Google sign in */ },
                onFacebookClick = { /* Handle Facebook sign in */ },
                onAppleClick = { /* Handle Apple sign in */ },
                onLoginClick = { navController.navigate(Routes.LOGIN) },
            )
        }
        composable(Routes.EMAIL) {
            EmailScreen(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate(Routes.PASSWORD) },
                onEmailEntered = { email = it }
            )
        }
        composable(Routes.PASSWORD) {
            PasswordScreen(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate(Routes.GENDER) },
                onPasswordEntered = { password = it }
            )
        }
        composable(Routes.GENDER) {
            GenderScreen(
                onBackClick = { navController.popBackStack() },
                onNextClick = { navController.navigate(Routes.NAME) },
                onGenderSelected = { gender = it }
            )
        }
        composable(Routes.NAME) {
            NameScreen(
                onBackClick = { navController.popBackStack() },
                onCreateClick = {
                    viewModel.registerWithEmailAndPassword(email, password, name, gender)
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.WELCOME) { inclusive = true }
                    }
                },
                onNameEntered = { name = it }
            )
        }
        composable(Routes.HOME) {
            HomeScreen(
                onLogoutClick = {
                    viewModel.signOutUser()
                    navController.navigate(Routes.WELCOME) {
                        popUpTo(Routes.WELCOME) { inclusive = true }
                    }
                },
                onExploreClick = { /* Navigate to Explore Features */ }
            )
        }
        composable(Routes.LOGIN) {
            LoginScreen(
                navController = navController,
                onBackClick = { navController.popBackStack() },
                onForgotPasswordClick = { navController.navigate(Routes.FORGOT_PASSWORD) }
            )
        }
    }
}
