package com.dokapegroup.dokapebackend.controllers.home

import com.dokapegroup.dokapebackend.models.DBPet
import com.dokapegroup.dokapebackend.services.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/home")
class HomeController @Autowired constructor(
    private val petService: PetService
) {
    @GetMapping("/carousel")
    fun getCarouselPets(): List<DBPet> = petService.getCarouselPets()

    @GetMapping("/featured")
    fun getFeaturedPets(): List<DBPet> = petService.getFeaturedPets()
}
