package com.dokapegroup.dokapebackend.controllers.product

import com.dokapegroup.dokapebackend.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController @Autowired constructor(
    private val productService: ProductService
) {
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long) = productService.getProductById(id)
}
