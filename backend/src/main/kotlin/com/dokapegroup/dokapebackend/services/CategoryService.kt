package com.dokapegroup.dokapebackend.services

import com.dokapegroup.dokapebackend.models.DBCategory
import com.dokapegroup.dokapebackend.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CategoryService @Autowired constructor(
    private val categoryRepository: CategoryRepository
) {
    fun getCategories(): List<DBCategory> = categoryRepository.findAll()
    fun getCategoryById(id: Long) = categoryRepository.findByIdOrNull(id)
}
