package com.dokapegroup.dokapebackend.controllers.category

import com.dokapegroup.dokapebackend.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController @Autowired constructor(
    private val categoryService: CategoryService
) {
    @GetMapping
    fun getCategories() = categoryService.getCategories()

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long) =
        categoryService.getCategoryById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
