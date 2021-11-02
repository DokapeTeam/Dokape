package com.dokapegroup.backend.models.domain

data class Shop(
    val id: Int,
    val name: String,
    val description: String,
    val totalProducts: Int,
    val numberOfFollowers: Int,
    val user: User
)
