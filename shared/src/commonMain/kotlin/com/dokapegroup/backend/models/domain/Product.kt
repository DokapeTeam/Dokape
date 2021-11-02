package com.dokapegroup.backend.models.domain

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val sold: Int,
    val inStock: Int,
    val isDraft: Boolean,
    val createdAt: Int,
    val updatedAt: Int,
    val shop: Shop
)
