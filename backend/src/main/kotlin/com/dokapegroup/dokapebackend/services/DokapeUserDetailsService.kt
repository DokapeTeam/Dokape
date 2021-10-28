package com.dokapegroup.dokapebackend.services

import com.dokapegroup.dokapebackend.repositories.UserRepository
import com.dokapegroup.dokapebackend.user.DokapeUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class DokapeUserDetailsService : UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String): DokapeUserDetails {
        return DokapeUserDetails(
            userRepository.findByUsername(username)
                ?: throw UsernameNotFoundException("User not found with username: $username")
        )
    }

    @Transactional
    fun loadUserById(id: Long): DokapeUserDetails {
        val user = userRepository.findByIdOrNull(id)
            ?: throw UsernameNotFoundException("User not found with id: $id")
        return DokapeUserDetails(user)
    }
}
