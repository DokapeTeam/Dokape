package com.dokapegroup.dokapebackend.models.abstract

import java.time.LocalDate

abstract class BaseEntity {
    abstract var createdAt: LocalDate

    abstract var updatedAt: LocalDate
}
