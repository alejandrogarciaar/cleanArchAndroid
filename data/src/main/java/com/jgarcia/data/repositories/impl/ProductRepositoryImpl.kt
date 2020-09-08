package com.jgarcia.data.repositories.impl

import com.jgarcia.data.datasource.ProductRemoteDataSource
import com.jgarcia.data.repositories.ProductRepository
import com.jgarcia.domain.model.ProductDetail
import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.domain.util.ErrorType
import com.jgarcia.domain.util.Result
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productRemoteDataSource: ProductRemoteDataSource) : ProductRepository {

    override suspend fun getProductsByQuery(term: String): Result<List<ProductPreview>> {
        return try {
            val currentProductsByQuery = productRemoteDataSource.getProductsByQuery(term)
            Result.Success(currentProductsByQuery)
        } catch (exception: IOException) {
            Result.Error(ErrorType.NetworkError)
        } catch (exception: Exception) {
            Result.Error(ErrorType.UnknownError)
        }
    }

    override suspend fun getProductsByCategoryId(categoryId: String): Result<List<ProductPreview>> {
        return try {
            val currentProducts = productRemoteDataSource.getProductsByCategory(categoryId = categoryId)
            Result.Success(currentProducts)
        } catch (exception: IOException) {
            Result.Error(ErrorType.NetworkError)
        } catch (exception: Exception) {
            Result.Error(ErrorType.UnknownError)
        }
    }

    override suspend fun getProductDetail(productId: String): Result<ProductDetail> {
        return try {
            val productDetail = productRemoteDataSource.getProductDetail(productId = productId)
            Result.Success(productDetail)
        } catch (exception: IOException) {
            Result.Error(ErrorType.NetworkError)
        } catch (exception: Exception) {
            Result.Error(ErrorType.UnknownError)
        }
    }
}