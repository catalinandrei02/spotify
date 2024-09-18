package com.cmcode.spotify.main.core

import androidx.lifecycle.LiveData
import com.cmcode.spotify.main.domain.User
import com.google.firebase.auth.FirebaseUser

/** Repository responsible with login and register users. */
interface CommonRepository {

    /** Method used to sign in using email and password */
    fun loginWithEmailAndPassword(email: String, password: String)

    /** Method used to register in using email and password */
    fun registerWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        gender: String
    ): String

    /** Method used to return current user. */
    fun getCurrentUser(): FirebaseUser?

    fun getUserId(): String?

    /** Method used to return current user data. */
    fun getCurrentUserData(): LiveData<User?>

    /** Method used to update current user data. */
    fun updateCurrentUserData(newSold: Int)

    /** Method used to reset user password. */
    fun resetPassword(email: String): String

    /** Method used to sign user out. */
    fun signOutUser()
}
