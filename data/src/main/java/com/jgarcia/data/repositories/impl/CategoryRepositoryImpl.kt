package com.jgarcia.data.repositories.impl

import com.jgarcia.data.datasource.CategoryRemoteDataSource
import com.jgarcia.data.repositories.CategoryRepository
import com.jgarcia.domain.model.Category
import com.jgarcia.domain.util.ErrorType
import com.jgarcia.domain.util.Result
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val categoryRemoteDataSource: CategoryRemoteDataSource) : CategoryRepository {
    override suspend fun getCategories(): Result<List<Category>> {
        return try {
            val currentCategories = categoryRemoteDataSource.getCurrentCategories()
            Result.Success(currentCategories)
        } catch (exception: IOException) {
            Result.Error(ErrorType.NetworkError)
        } catch (exception: Exception) {
            Result.Error(ErrorType.UnknownError)
        }
    }
}