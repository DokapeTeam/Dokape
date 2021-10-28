package com.dokapegroup.backend.models.domain

data class Short(
    override val id: Int,
    val videoUrl: String,
    override val reaction: Reaction,
    val comment: Comment,
    val user: User
) : Reactable
