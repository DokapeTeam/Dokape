package com.dokapegroup.dokapebackend.services

import com.dokapegroup.dokapebackend.models.DBUser
import com.dokapegroup.dokapebackend.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun getUsers(): List<DBUser> = userRepository.findAll()
    fun getUserById(id: Long): DBUser? = userRepository.findByIdOrNull(id)
    fun registerUser(user: DBUser) = userRepository.save(user)
    fun isUserRegistered(username: String) = userRepository.existsByUsername(username)
}
