package com.jgarcia.data.repositories

import com.jgarcia.domain.model.ProductDetail
import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.domain.util.Result

interface ProductRepository {
    suspend fun getProductsByQuery(term: String): Result<List<ProductPreview>>
    suspend fun getProductsByCategoryId(categoryId: String): Result<List<ProductPreview>>
    suspend fun getProductDetail(productId: String): Result<ProductDetail>
}