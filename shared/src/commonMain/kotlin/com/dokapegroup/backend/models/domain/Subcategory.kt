package com.dokapegroup.backend.models.domain

data class Subcategory(
    val id: Int,
    val name: String,
    val description: String,
    override val image: String,
    val category: Category,
    val products: List<Product>
) : HasImage
