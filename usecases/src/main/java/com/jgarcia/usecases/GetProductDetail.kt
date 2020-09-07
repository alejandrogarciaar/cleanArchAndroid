package com.jgarcia.usecases

import com.jgarcia.data.repositories.ProductRepository

class GetProductDetail(private val productRepository: ProductRepository) {
    suspend operator fun invoke(productId: String) = productRepository.getProductDetail(productId)
}