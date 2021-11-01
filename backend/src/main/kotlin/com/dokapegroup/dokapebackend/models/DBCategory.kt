package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "category")
class DBCategory(
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
    )
    var id: Long? = null,
    var name: String?,
    var description: String?,
    var image: String,
    override var createdAt: LocalDate = LocalDate.now(),
    override var updatedAt: LocalDate = LocalDate.now()
) : BaseEntity()
