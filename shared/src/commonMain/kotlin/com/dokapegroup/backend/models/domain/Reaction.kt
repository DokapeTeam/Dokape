package com.dokapegroup.backend.models.domain

data class Reaction(
    val id: Int,
    val like: Int,
    val love: Int,
    val paw: Int,
    val parent: Reactable
)
