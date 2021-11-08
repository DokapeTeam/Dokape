package com.dokapegroup.dokapebackend.controllers.shop

import com.dokapegroup.dokapebackend.models.DBProduct
import com.dokapegroup.dokapebackend.repositories.ShopService
import com.dokapegroup.dokapebackend.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/shops")
class ShopController @Autowired constructor(
    private val productService: ProductService,
    private val shopService: ShopService
) {
    @GetMapping("/{shopId}")
    fun getShopById(@PathVariable shopId: Long) = shopService.getShopById(shopId)

    @GetMapping("/{shopId}/products")
    fun getProductsByShopId(@PathVariable shopId: Long): List<DBProduct> =
        productService.getProductsByShop(shopId)
}
