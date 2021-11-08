package com.dokapegroup.dokapebackend.services

import com.dokapegroup.dokapebackend.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService @Autowired constructor(
    private val productRepository: ProductRepository
) {
    fun getProductsByShop(shopId: Long) = productRepository.findAllByShopIdAndDraftIsFalse(shopId)
    fun getProductById(id: Long) =
        productRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
