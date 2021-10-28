package com.dokapegroup.backend.models.domain

data class Post(
    override val id: Int,
    val title: String,
    val content: String,
    override val reaction: Reaction,
    override val images: List<Image>
) : Reactable, HasMultipleImage
