package com.dokapegroup.dokapebackend.repositories

import com.dokapegroup.dokapebackend.models.DBUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<DBUser, Long> {
    fun findByUsername(username: String): DBUser?
    fun existsByUsername(username: String): Boolean
}
