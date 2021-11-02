package com.dokapegroup.backend.models.domain

sealed interface HasMultipleImage {
    val images: List<Image>
}
