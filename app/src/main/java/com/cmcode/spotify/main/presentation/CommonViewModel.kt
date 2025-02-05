/* Copyright (c) 2020-2021 and later Catalin Moldovan Code. */
package com.cmcode.spotify.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmcode.spotify.main.core.CommonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(
    private val commonRepository: CommonRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<Boolean?>(null)
    val loginState: StateFlow<Boolean?> = _loginState

    private val _resetPasswordState = MutableStateFlow<String?>(null)
    val resetPasswordState: StateFlow<String?> = _resetPasswordState

    private val _registerState = MutableStateFlow<String?>(null)
    val registerState: StateFlow<String?> = _registerState

    private val _signOutState = MutableStateFlow<Boolean?>(null)
    val signOutState: StateFlow<Boolean?> = _signOutState

    fun loginWithEmailAndPassword(email: String, password: String) {
        viewModelScope.launch {
            val success = commonRepository.loginWithEmailAndPassword(email, password)
            _loginState.value = success
        }
    }

    fun resetLoginState() {
        _loginState.value = null
    }

    fun resetPassword(email: String) {
        viewModelScope.launch {
            val result = commonRepository.resetPassword(email)
            _resetPasswordState.value = result
        }
    }

    fun registerWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        gender: String
    ) {
        viewModelScope.launch {
            val result =
                commonRepository.registerWithEmailAndPassword(email, password, name, gender)
            _registerState.value = result
        }
    }

    fun signOutUser() {
        viewModelScope.launch {
            commonRepository.signOutUser()
            _signOutState.value = true
        }
    }

    fun getCurrentUser() = commonRepository.getCurrentUser()

    fun getUserId() = commonRepository.getUserId()
}
