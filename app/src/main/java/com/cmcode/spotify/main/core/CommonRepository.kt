package com.cmcode.spotify.main.core

import androidx.lifecycle.LiveData
import com.cmcode.spotify.main.domain.User
import com.facebook.AccessToken
import com.google.firebase.auth.FirebaseUser

/** Repository responsible for login and registration of users. */
interface CommonRepository {

    suspend fun signInWithGoogle(idToken: String): Boolean

    suspend fun signInWithFacebook(token: AccessToken): Boolean

    suspend fun signInWithApple(idToken: String): Boolean

    /** Sign in using email and password */
    suspend fun loginWithEmailAndPassword(email: String, password: String): Boolean

    /** Register new user */
    suspend fun registerWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        gender: String
    ): String

    /** Return current user */
    fun getCurrentUser(): FirebaseUser?

    /** Return current user ID */
    fun getUserId(): String?

    /** Return current user data */
    fun getCurrentUserData(): LiveData<User?>

    /** Update current user data */
    suspend fun updateCurrentUserData(newSold: Int)

    /** Reset user password */
    suspend fun resetPassword(email: String): String

    /** Sign user out */
    suspend fun signOutUser()
}
