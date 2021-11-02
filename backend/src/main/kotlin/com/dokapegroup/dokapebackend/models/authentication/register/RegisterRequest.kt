package com.dokapegroup.dokapebackend.models.authentication.register

data class RegisterRequest(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val gender: Int,
    val dateOfBirth: String,
    val email: String,
    val phone: String? = null,
)
