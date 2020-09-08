package com.jgarcia.data.datasource.impl

import com.jgarcia.data.datasource.ProductRemoteDataSource
import com.jgarcia.data.mappers.ProductDetailMapper
import com.jgarcia.data.mappers.ProductPreviewMapper
import com.jgarcia.domain.model.ProductDetail
import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.remotedata.api.ProductApi
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val productApi: ProductApi,
    private val productPreviewMapper: ProductPreviewMapper,
    private val productDetailMapper: ProductDetailMapper
) : ProductRemoteDataSource {

    override suspend fun getProductsByQuery(term: String): List<ProductPreview> {
        val productsByQuery = productApi.getProductsByQuery(query = term)
        return productsByQuery.results.map {
            productPreviewMapper.invoke(it)
        }
    }

    override suspend fun getProductsByCategory(categoryId: String): List<ProductPreview> {
        return productApi.getProductsByCategory(categoryId = categoryId).map {
            ProductPreview()
        }
    }

    override suspend fun getProductDetail(productId: String): ProductDetail {
        val productDetailResponse = productApi.getSpecificProduct(productId = productId)
        return productDetailMapper.invoke(productDetailResponse)
    }
}