package com.cmcode.spotify.main.presentation.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import com.cmcode.spotify.main.presentation.CommonViewModel
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object AuthHandler {

    fun googleSignIn(
        context: Context,
        onLaunch: (Intent) -> Unit
    ) {
        val googleSignInClient = GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(WEB_CLIENT_ID)
                .requestEmail()
                .build()
        )
        val signInIntent = googleSignInClient.signInIntent
        onLaunch(signInIntent)
    }

    fun handleGoogleSignInResult(
        data: Intent?,
        viewModel: CommonViewModel,
        navController: NavController
    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        task.result?.idToken?.let { idToken ->
            viewModel.signInWithGoogle(idToken) { success ->
                if (success) {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.WELCOME) { inclusive = true }
                    }
                }
            }
        }
    }

    fun facebookSignIn(
        context: Context,
        viewModel: CommonViewModel,
        navController: NavController
    ) {
        FacebookSdk.sdkInitialize(context)
        LoginManager.getInstance().logInWithReadPermissions(
            context as Activity,
            listOf("email", "public_profile")
        )
        LoginManager.getInstance().registerCallback(
            CallbackManager.Factory.create(),
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult) {
                    viewModel.signInWithFacebook(result.accessToken) { success ->
                        if (success) {
                            navController.navigate(Routes.HOME) {
                                popUpTo(Routes.WELCOME) { inclusive = true }
                            }
                        }
                    }
                }

                override fun onCancel() {}
                override fun onError(error: FacebookException) {}
            }
        )
    }

    fun appleSignIn(
        context: Context,
        viewModel: CommonViewModel,
        navController: NavController
    ) {
        val provider = OAuthProvider.newBuilder("apple.com")
        val pending = Firebase.auth.pendingAuthResult
        if (pending != null) {
            pending.addOnSuccessListener { authResult ->
                authResult.user?.getIdToken(false)?.addOnSuccessListener { idToken ->
                    viewModel.signInWithApple(idToken.token ?: "") { success ->
                        if (success) {
                            navController.navigate(Routes.HOME) {
                                popUpTo(Routes.WELCOME) { inclusive = true }
                            }
                        }
                    }
                }
            }
        } else {
            FirebaseAuth.getInstance().startActivityForSignInWithProvider(
                context as Activity,
                provider.build()
            ).addOnSuccessListener { authResult ->
                authResult.user?.getIdToken(false)?.addOnSuccessListener { idToken ->
                    viewModel.signInWithApple(idToken.token ?: "") { success ->
                        if (success) {
                            navController.navigate(Routes.HOME) {
                                popUpTo(Routes.WELCOME) { inclusive = true }
                            }
                        }
                    }
                }
            }
        }
    }

    private const val WEB_CLIENT_ID = "877790706501-0dkv292l5bl89emla5n8qevclv10qk8t.apps.googleusercontent.com"
}
