package com.dokapegroup.dokapebackend.repositories

import com.dokapegroup.dokapebackend.models.DBProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<DBProduct, Long> {
    fun findAllByShopIdAndDraftIsFalse(shop_id: Long): List<DBProduct>
}
