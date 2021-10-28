package com.dokapegroup.backend.models.domain

data class Pet(
    val id: Int,
    val name: String,
    val age: Int,
    val description: String,
    val height: Double,
    val weight: Double,
    val hairType: String,
    val health: Int,
    val healthDescription: String,
    val gender: Gender,
    val isAdopted: Boolean,
    val createdAt: Int,
    val updatedAt: Int,
    val tag: String,
    val speciesType: SpeciesType,
    val user: User,
    override val images: List<Image>
) : HasMultipleImage
