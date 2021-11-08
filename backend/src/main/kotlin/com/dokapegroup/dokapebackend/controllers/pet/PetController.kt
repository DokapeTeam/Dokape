package com.dokapegroup.dokapebackend.controllers.pet

import com.dokapegroup.dokapebackend.models.DBPet
import com.dokapegroup.dokapebackend.services.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/pets")
class PetController @Autowired constructor(
    private val petService: PetService
) {
    @GetMapping("/{id}")
    fun getPetById(@PathVariable id: Long): DBPet {
        return petService.getPetById(id)
    }
}
