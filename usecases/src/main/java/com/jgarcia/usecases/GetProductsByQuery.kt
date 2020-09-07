package com.jgarcia.usecases

import com.jgarcia.data.repositories.ProductRepository

class GetProductsByQuery(private val productRepository: ProductRepository) {
    suspend operator fun invoke(query: String) = productRepository.getProductsByQuery(query)
}