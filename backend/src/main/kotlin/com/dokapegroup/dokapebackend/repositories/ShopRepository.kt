package com.dokapegroup.dokapebackend.repositories

import com.dokapegroup.dokapebackend.models.DBShop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository : JpaRepository<DBShop, Long> {
}
