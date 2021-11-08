package com.dokapegroup.dokapebackend.repositories

import com.dokapegroup.dokapebackend.models.DBCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<DBCategory, Long>
