package com.jgarcia.usecases

import com.jgarcia.data.repositories.ProductRepository

class GetProductsByCategory(private val productRepository: ProductRepository) {
    suspend operator fun invoke(categoryId: String) = productRepository.getProductsByCategoryId(categoryId)
}