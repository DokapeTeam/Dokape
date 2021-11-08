package com.dokapegroup.dokapebackend.repositories

import com.dokapegroup.dokapebackend.models.DBPet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<DBPet, Long> {
    fun findTopByOrderByCreatedAt(): List<DBPet>
    fun findTopByUserTrustedOwnerTrueAndIsAdoptedFalseOrderByAge(): List<DBPet>
}
