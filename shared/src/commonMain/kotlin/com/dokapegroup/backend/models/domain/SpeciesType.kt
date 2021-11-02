package com.dokapegroup.backend.models.domain

data class SpeciesType(
    val id: Int,
    val name: String,
    val species: Species,
    val image: String
)
