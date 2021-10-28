package com.dokapegroup.dokapebackend.models

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
    var image: String
)
