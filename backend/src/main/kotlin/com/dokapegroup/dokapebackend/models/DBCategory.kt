package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "category")
class DBCategory(
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
    )
    override var id: Long? = null,
    var name: String?,
    var description: String?,
    var image: String,
    @OneToMany(mappedBy = "category")
    var subcategories: MutableList<DBSubcategory>,
    override var createdAt: LocalDateTime = LocalDateTime.now(),
    override var updatedAt: LocalDateTime = LocalDateTime.now(),
) : BaseEntity()
