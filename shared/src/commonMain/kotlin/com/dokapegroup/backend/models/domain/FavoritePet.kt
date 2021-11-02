package com.dokapegroup.backend.models.domain

data class FavoritePet(
    val id: Int,
    val user: User,
    val pet: Pet
)
