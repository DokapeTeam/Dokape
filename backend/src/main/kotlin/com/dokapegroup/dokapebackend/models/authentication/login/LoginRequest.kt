package com.dokapegroup.dokapebackend.models.authentication.login

data class LoginRequest(
    val username: String,
    val password: String
)
