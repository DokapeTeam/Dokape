package com.dokapegroup.dokapebackend.services

import com.dokapegroup.dokapebackend.models.DBPet
import com.dokapegroup.dokapebackend.repositories.PetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PetService @Autowired constructor(
    private val petRepository: PetRepository
) {
    fun getAllPets(): List<DBPet> = petRepository.findAll()
    fun getCarouselPets() =
        petRepository.findTopByOrderByCreatedAt().take(10)

    fun getFeaturedPets() = petRepository.findTopByUserTrustedOwnerTrueAndIsAdoptedFalseOrderByAge()
    fun getPetById(id: Long) = petRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
