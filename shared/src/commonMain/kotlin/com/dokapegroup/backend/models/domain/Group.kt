package com.dokapegroup.backend.models.domain

data class Group(
    val id: Int,
    val name: String,
    val description: String,
    override val image: String,
    val rules: String,
    val createdAt: Int,
    val updatedAt: Int
) : HasImage
