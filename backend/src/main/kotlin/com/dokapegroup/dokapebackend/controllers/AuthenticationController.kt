package com.dokapegroup.dokapebackend.controllers

import com.dokapegroup.dokapebackend.jwt.JwtTokenProvider
import com.dokapegroup.dokapebackend.models.DBUser
import com.dokapegroup.dokapebackend.models.Gender
import com.dokapegroup.dokapebackend.models.authentication.login.LoginRequest
import com.dokapegroup.dokapebackend.models.authentication.login.LoginResponse
import com.dokapegroup.dokapebackend.models.authentication.register.RegisterRequest
import com.dokapegroup.dokapebackend.services.UserService
import com.dokapegroup.dokapebackend.user.DokapeUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/auth")
class AuthenticationController @Autowired constructor(
    private val authenticationManager: AuthenticationManager,
    private val tokenProvider: JwtTokenProvider,
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder
) {
    @PostMapping("/login")
    fun login(@Valid @RequestBody loginRequest: LoginRequest): LoginResponse {
        val usernamePasswordAuthenticationToken =
            UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        val authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken)

        val jwt = tokenProvider.generateToken(authentication.principal as DokapeUserDetails)
        return LoginResponse(jwt)
    }

    @PostMapping("/register")
    fun register(@Valid @RequestBody registerRequest: RegisterRequest): LoginResponse {
        if (userService.isUserRegistered(registerRequest.username)) {
            println("GGGGGG")
            throw ResponseStatusException(HttpStatus.FORBIDDEN)
        }
        val user = with(registerRequest) {
            DBUser(
                username = username,
                hashedPassword = passwordEncoder.encode(password),
                firstName = firstName,
                lastName = lastName,
                gender = Gender.from(gender),
                dateOfBirth = LocalDate.parse(dateOfBirth),
                email = email
            )
        }
        userService.registerUser(user)
        val usernamePasswordAuthenticationToken =
            UsernamePasswordAuthenticationToken(registerRequest.username, registerRequest.password)
        val authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken)

        val jwt = tokenProvider.generateToken(authentication.principal as DokapeUserDetails)
        return LoginResponse(jwt)
    }
}
