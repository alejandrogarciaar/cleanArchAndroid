package com.jgarcia.data.repositories

import com.jgarcia.domain.model.Category
import com.jgarcia.domain.util.Result

interface CategoryRepository {
    suspend fun getCategories(): Result<List<Category>>
}