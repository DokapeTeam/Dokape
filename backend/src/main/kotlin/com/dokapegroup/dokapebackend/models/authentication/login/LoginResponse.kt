package com.dokapegroup.dokapebackend.models.authentication.login

data class LoginResponse(
    val accessToken: String,
    val tokenType: String = "Bearer"
)
