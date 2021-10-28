package com.dokapegroup.dokapebackend.controllers

import com.dokapegroup.dokapebackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api/v1/users")
class UserController @Autowired constructor(
    private val userService: UserService
) {
    @GetMapping
    fun index() = userService.getUsers()

    @GetMapping("/date")
    fun date() = LocalDate.now()
}
