package com.dokapegroup.dokapebackend.extensions

import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.writeBytes

fun MultipartFile.copyToUploadAndGetPath(uploadFolder: String): Path? =
    if (isEmpty) null else Paths.get(uploadFolder + originalFilename).apply { writeBytes(bytes) }
