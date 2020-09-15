package com.jgarcia.usecases

import com.jgarcia.data.repositories.ProductRepository
import javax.inject.Inject

class GetProductDetail @Inject constructor(private val productRepository: ProductRepository) {
    suspend operator fun invoke(productId: String) = productRepository.getProductDetail(productId)
}