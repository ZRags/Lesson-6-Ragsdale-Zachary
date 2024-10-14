package com.google.firebase.example.makeitso.ui.signup

import com.google.firebase.example.makeitso.MainViewModel
import com.google.firebase.example.makeitso.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : MainViewModel() {
    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Loading)
    val uiState: StateFlow<SignUpUiState>
        get() = _uiState.asStateFlow()

    fun signUp(email: String, password: String, repeatPassword: String) {
        if (password != repeatPassword) {
            _uiState.value = SignUpUiState.Error("Passwords do not match")
            return
        }

        launchCatching {
            authRepository.signUp(email, password)
        }
    }
}