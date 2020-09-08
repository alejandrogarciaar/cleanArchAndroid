package com.jgarcia.data.datasource

import com.jgarcia.domain.model.Category

interface CategoryRemoteDataSource {
    suspend fun getCurrentCategories(): List<Category>
}