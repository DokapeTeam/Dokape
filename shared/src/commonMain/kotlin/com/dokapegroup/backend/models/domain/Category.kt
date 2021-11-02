package com.dokapegroup.backend.models.domain

data class Category(
    val id: Int,
    val name: String,
    val description: String,
    override val image: String
) : HasImage
