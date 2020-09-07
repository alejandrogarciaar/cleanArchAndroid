package com.jgarcia.data.datasource

import com.jgarcia.domain.model.ProductDetail
import com.jgarcia.domain.model.ProductPreview

interface ProductRemoteDataSource {
    suspend fun getProductsByQuery(term: String): List<ProductPreview>
    suspend fun getProductsByCategory(categoryId: String): List<ProductPreview>
    suspend fun getProductDetail(productId: String): ProductDetail
}