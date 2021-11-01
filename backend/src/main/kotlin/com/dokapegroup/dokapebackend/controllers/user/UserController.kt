package com.dokapegroup.dokapebackend.controllers.user

import com.dokapegroup.dokapebackend.extensions.copyToUploadAndGetPath
import com.dokapegroup.dokapebackend.extensions.removeBearer
import com.dokapegroup.dokapebackend.jwt.JwtTokenProvider
import com.dokapegroup.dokapebackend.models.DBUser
import com.dokapegroup.dokapebackend.models.Gender
import com.dokapegroup.dokapebackend.models.request.UpdateUserRequest
import com.dokapegroup.dokapebackend.models.user.response.UploadedImageResponse
import com.dokapegroup.dokapebackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import java.io.IOException
import javax.validation.Valid
import kotlin.io.path.pathString

@RestController
@RequestMapping("/api/v1/users")
class UserController @Autowired constructor(
    private val userService: UserService,
    private val tokenProvider: JwtTokenProvider,
) {
    @Value("\${file.upload-dir}")
    lateinit var uploadFolder: String

    @GetMapping
    fun getUsers() = userService.getUsers()

    @GetMapping("/me")
    fun getUser(@RequestHeader("Authorization") token: String): DBUser {
        val id = tokenProvider.getUserIdFromJWT(token.removeBearer())
        return userService.getUserById(id) ?: throw ResponseStatusException(HttpStatus.FORBIDDEN, "User not found")
    }

    @PutMapping("/me")
    fun updateUser(
        @RequestHeader("Authorization") token: String,
        @Valid @RequestBody updateUserRequest: UpdateUserRequest
    ): DBUser {
        require(updateUserRequest.latitude != null && updateUserRequest.longitude != null) {
            ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
        val userId = tokenProvider.getUserIdFromJWT(token.removeBearer())
        val user = userService.getUserById(userId) ?: throw ResponseStatusException(HttpStatus.FORBIDDEN)

        with(updateUserRequest) {
            firstName?.let { user.firstName = it }
            lastName?.let { user.lastName = it }
            dateOfBirth?.let { user.dateOfBirth = it }
            email?.let { user.email = it }
            gender?.let { user.gender = Gender.from(it) }
            if (latitude != null && longitude != null) {
                user.latitude = latitude
                user.longitude = longitude
            }
            phone?.let { user.phone = it }
        }

        return userService.updateUser(user)
    }

    @PutMapping("/me/avatar")
    fun uploadAvatar(
        @RequestHeader("Authorization") token: String,
        @RequestParam("avatar") avatar: MultipartFile,
    ): UploadedImageResponse {
        val userId = tokenProvider.getUserIdFromJWT(token.removeBearer())
        require(!avatar.isEmpty) {
            ResponseStatusException(HttpStatus.BAD_REQUEST, "Avatar must be specified!")
        }
        return saveImageToStorageAndResponse(userId, avatar, isAvatar = true)
    }

    @PutMapping("/me/cover-photo")
    fun uploadCoverPhoto(
        @RequestHeader("Authorization") token: String,
        @RequestParam("coverPhoto") coverPhoto: MultipartFile
    ): UploadedImageResponse {
        val userId = tokenProvider.getUserIdFromJWT(token.removeBearer())
        require(!coverPhoto.isEmpty) {
            ResponseStatusException(HttpStatus.BAD_REQUEST, "Cover photo must be specified!")
        }
        return saveImageToStorageAndResponse(userId, coverPhoto, isAvatar = false)
    }

    private fun saveImageToStorageAndResponse(
        userId: Long,
        avatarOrCoverPhoto: MultipartFile,
        isAvatar: Boolean
    ): UploadedImageResponse {
        return try {
            val user = userService.getUserById(userId) ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Not found user with id: $userId"
            )
            val path = avatarOrCoverPhoto.copyToUploadAndGetPath(uploadFolder)?.also {
                if (isAvatar) {
                    user.avatar = it.pathString
                } else {
                    user.coverPhoto = it.pathString
                }
            }
            userService.updateUser(user)
            UploadedImageResponse(path?.pathString)
        } catch (ioe: IOException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ioe.message, ioe)
        }
    }
}
