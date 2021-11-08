package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import lombok.Builder
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table
@Builder
class DBProduct(
    @Id
    @SequenceGenerator(
        name = PRODUCT_SEQUENCE,
        sequenceName = PRODUCT_SEQUENCE,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = PRODUCT_SEQUENCE
    )
    override val id: Long?,
    var name: String,
    var description: String,
    var price: Double,
    var sold: Int = 0,
    var inStock: Int = 0,
    var isDraft: Boolean = true,
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    var shop: DBShop,
    @OneToMany(mappedBy = "product")
    var images: MutableList<DBProductImage>,
    @ManyToMany(mappedBy = "subcategories")
    var products: MutableList<DBSubcategory>,
    override var createdAt: LocalDateTime = LocalDateTime.now(),
    override var updatedAt: LocalDateTime = LocalDateTime.now()
) : BaseEntity() {
    private companion object {
        private const val PRODUCT_SEQUENCE = "product_sequence"
    }
}
