package com.cmcode.spotify.main.infra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cmcode.spotify.main.core.CommonRepository
import com.cmcode.spotify.main.domain.User
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val databaseReference: FirebaseFirestore
) : CommonRepository {

    override fun getCurrentUser(): FirebaseUser? = firebaseAuth.currentUser

    override fun getUserId(): String? = getCurrentUser()?.uid

    override fun getCurrentUserData(): LiveData<User?> {
        val userData = MutableLiveData<User?>()
        getUserDatabaseReference()?.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                userData.postValue(User("ERROR", "ERROR", "ERROR"))
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val userInfo = snapshot.toObject(User::class.java)
                userData.postValue(userInfo)
            }
        }
        return userData
    }

    override suspend fun signInWithGoogle(idToken: String): Boolean {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            authResult.user != null
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun signInWithFacebook(token: AccessToken): Boolean {
        return try {
            val credential = FacebookAuthProvider.getCredential(token.token)
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            authResult.user != null
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun signInWithApple(idToken: String): Boolean {
        return try {
            val credential = OAuthProvider.newCredentialBuilder("apple.com").setIdToken(idToken).build()
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            authResult.user != null
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun loginWithEmailAndPassword(email: String, password: String): Boolean {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            authResult.user != null
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun registerWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        gender: String
    ): String {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = authResult.user

            if (user != null) {
                val userInfo = User(email, name, gender)
                val userRef = databaseReference.collection(USERS_COLLECTION).document(user.uid)

                userRef.set(userInfo).await()
                REGISTER_SUCCESS_MESSAGE
            } else {
                REGISTER_ERROR_MESSAGE
            }
        } catch (e: Exception) {
            REGISTER_ERROR_MESSAGE
        }
    }

    override suspend fun updateCurrentUserData(newSold: Int) {
        try {
            val userData = getUserDatabaseReference()
            userData?.get()?.await()?.let { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val updatedData = hashMapOf("sold" to newSold)
                    userData.set(updatedData, SetOptions.merge()).await()
                }
            }
        } catch (e: Exception) {
            // Handle error if needed
        }
    }

    override suspend fun resetPassword(email: String): String {
        return try {
            firebaseAuth.sendPasswordResetEmail(email).await()
            RESET_PASSWORD_SUCCESS_MESSAGE
        } catch (e: Exception) {
            RESET_PASSWORD_ERROR_MESSAGE
        }
    }

    override suspend fun signOutUser() {
        firebaseAuth.signOut()
    }

    /** Method used to get current user database reference. */
    private fun getUserDatabaseReference() =
        getCurrentUser()?.let { user ->
            databaseReference.collection(USERS_COLLECTION).document(user.uid)
        }

    companion object {
        private const val REGISTER_SUCCESS_MESSAGE = "User registered successfully"
        private const val REGISTER_ERROR_MESSAGE = "Failed to register user"
        private const val RESET_PASSWORD_SUCCESS_MESSAGE = "Password reset email sent"
        private const val RESET_PASSWORD_ERROR_MESSAGE = "Failed to send password reset email"
        private const val USERS_COLLECTION = "users"
    }
}
