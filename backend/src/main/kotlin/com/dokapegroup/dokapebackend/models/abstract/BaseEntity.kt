package com.dokapegroup.dokapebackend.models.abstract

import java.time.LocalDateTime

abstract class BaseEntity {
    abstract val id: Long?
    abstract var createdAt: LocalDateTime

    abstract var updatedAt: LocalDateTime
}
