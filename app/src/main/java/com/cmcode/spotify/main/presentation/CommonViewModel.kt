package com.cmcode.spotify.main.presentation

import androidx.lifecycle.ViewModel
import com.cmcode.spotify.main.core.CommonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(
    private val commonRepository: CommonRepository,
) : ViewModel() {

    fun loginWithEmailAndPassword(email: String, password: String) {
        commonRepository.loginWithEmailAndPassword(email, password)
    }

    fun resetPassword(email: String) =
        commonRepository.resetPassword(email)

    fun registerWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        gender: String
    ) = commonRepository.registerWithEmailAndPassword(
        email,
        password,
        name,
        gender
    )

    fun getCurrentUser() = commonRepository.getCurrentUser()

    fun getUserId() = commonRepository.getUserId()
}
