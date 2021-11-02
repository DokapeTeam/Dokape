package com.dokapegroup.dokapebackend.models.request

import java.time.LocalDate

data class UpdateUserRequest(
    val firstName: String? = null,
    val lastName: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val gender: Int? = null,
    var dateOfBirth: LocalDate? = null,
    var email: String? = null,
    var phone: String? = null,
)
