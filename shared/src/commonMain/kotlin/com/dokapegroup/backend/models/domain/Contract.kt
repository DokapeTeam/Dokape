package com.dokapegroup.backend.models.domain

data class Contract(
    val id: Int,
    val adoptUser: User,
    val abandonUser: User,
    val expired: Int,
    val createdAt: Int,
    val pet: Pet,
    val success: Boolean
)
