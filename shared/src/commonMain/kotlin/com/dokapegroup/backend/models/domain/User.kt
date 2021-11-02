package com.dokapegroup.backend.models.domain

data class User(
    val id: Int,
    val username: String,
    val hashedPassword: String,
    val firstName: String,
    val lastName: String,
    val latitude: Double,
    val longitude: Double,
    val gender: Gender,
    val dateOfBirth: Int,
    val email: String,
    val phone: String,
    val createdAt: Int,
    val updatedAt: Int,
    val numberOfPosts: Int,
    val numberOfShorts: Int,
    val numberOfPetsAdopted: Int,
    val trustedOwner: Boolean,
    val shop: Shop,
    override val avatar: String
) : HasAvatar
