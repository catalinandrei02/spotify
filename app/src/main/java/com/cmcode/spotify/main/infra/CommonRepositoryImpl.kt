package com.cmcode.spotify.main.infra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cmcode.spotify.main.core.CommonRepository
import com.cmcode.spotify.main.domain.Constants.REGISTER_ERROR_MESSAGE
import com.cmcode.spotify.main.domain.Constants.REGISTER_SUCCESS_MESSAGE
import com.cmcode.spotify.main.domain.Constants.RESET_PASSWORD_ERROR_MESSAGE
import com.cmcode.spotify.main.domain.Constants.RESET_PASSWORD_SUCCESS_MESSAGE
import com.cmcode.spotify.main.domain.Constants.USERS_COLLECTION
import com.cmcode.spotify.main.domain.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val databaseReference: FirebaseFirestore,
) : CommonRepository {

    override fun getCurrentUser(): FirebaseUser? = firebaseAuth.currentUser

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

    override fun loginWithEmailAndPassword(
        email: String,
        password: String,
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    override fun registerWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        gender: String
    ): String {

        var message = ""
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { register ->
                message = if (register.isSuccessful) {
                    getCurrentUser()?.let {
                        val userInfo = User(email, name, gender)
                        getUserDatabaseReference()?.set(userInfo)
                    }
                    REGISTER_SUCCESS_MESSAGE
                } else {
                    REGISTER_ERROR_MESSAGE
                }
            }

        return message
    }

    override fun updateCurrentUserData(newSold: Int) {
        val userData = getUserDatabaseReference()
        userData?.get()?.addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                val updatedData = hashMapOf(
                    "sold" to newSold,
                )
                userData.set(updatedData, SetOptions.merge())
            }
        }
    }

    override fun resetPassword(email: String): String {

        var message = ""
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener {
            message = if (it.isSuccessful) {
                RESET_PASSWORD_SUCCESS_MESSAGE
            } else {
                RESET_PASSWORD_ERROR_MESSAGE
            }
        }

        return message
    }

    override fun signOutUser() = firebaseAuth.signOut()

    /** Return current user id */
    override fun getUserId(): String? = getCurrentUser()?.uid

    /** Method used to get current user data base reference. */
    private fun getUserDatabaseReference() = getCurrentUser()?.let { user ->
        databaseReference.collection(USERS_COLLECTION).document(user.uid)
    }
}
