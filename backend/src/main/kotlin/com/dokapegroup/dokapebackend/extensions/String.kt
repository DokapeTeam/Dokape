@file:Suppress("NOTHING_TO_INLINE")

package com.dokapegroup.dokapebackend.extensions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

inline fun String?.removeBearer() = this?.removePrefix("Bearer ") ?: throw ResponseStatusException(HttpStatus.FORBIDDEN)
