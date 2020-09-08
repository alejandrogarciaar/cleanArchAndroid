package com.jgarcia.data.datasource.impl

import com.jgarcia.data.datasource.CategoryRemoteDataSource
import com.jgarcia.data.mappers.CategoryMapper
import com.jgarcia.domain.model.Category
import com.jgarcia.remotedata.api.CategoryApi
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(
    private val categoryApi: CategoryApi,
    private val categoryMapper: CategoryMapper
) : CategoryRemoteDataSource {

    override suspend fun getCurrentCategories(): List<Category> {
        val currentCategories = categoryApi.getCategories()
        return currentCategories.map {
            categoryMapper.invoke(it)
        }
    }
}