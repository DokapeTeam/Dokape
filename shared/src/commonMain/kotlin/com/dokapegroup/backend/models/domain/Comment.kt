package com.dokapegroup.backend.models.domain

data class Comment(
    val id: Int,
    val comment: String?,
    val reactionId: Int,
    val parent: Reactable,
    val child: Comment?
)
