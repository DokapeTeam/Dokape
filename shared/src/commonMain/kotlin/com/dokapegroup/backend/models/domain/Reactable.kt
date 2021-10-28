package com.dokapegroup.backend.models.domain

sealed interface Reactable {
    val id: Int
    val reaction: Reaction
}
