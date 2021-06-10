package com.example.lktsu.ui.login

/**
 * Data validation state of the login form.
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: String? = null,
    val isDataValid: Boolean = false
)