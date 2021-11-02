package com.dokapegroup.backend.models.domain

data class GroupMembership(
    val id: Int,
    val user: User,
    val group: Group
)
