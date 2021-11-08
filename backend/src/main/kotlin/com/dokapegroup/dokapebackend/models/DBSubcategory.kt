package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import lombok.Builder
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table
@Builder
class DBSubcategory(
    @Id
    @SequenceGenerator(
        name = SUBCATEGORY_SEQUENCE,
        sequenceName = SUBCATEGORY_SEQUENCE,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = SUBCATEGORY_SEQUENCE
    )
    override val id: Long? = null,
    var name: String,
    var description: String,
    var image: String,
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    var category: DBCategory,
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "subcategory_product",
        joinColumns = [JoinColumn(name = "subcategory_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var subcategories: MutableList<DBSubcategory>,
    override var createdAt: LocalDateTime = LocalDateTime.now(),
    override var updatedAt: LocalDateTime = LocalDateTime.now()
) : BaseEntity() {
    private companion object {
        private const val SUBCATEGORY_SEQUENCE = "subcategory_sequence"
    }
}
