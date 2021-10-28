package com.dokapegroup.dokapebackend.models

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

enum class Gender {
    Male, Female, Other;

    companion object {
        fun from(value: Int) = when (value) {
            0 -> Male
            1 -> Female
            2 -> Other
            else -> throw ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Wrong gender code $value"
            )
        }
    }
}
