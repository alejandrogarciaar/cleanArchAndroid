package com.jgarcia.data.repositories

import com.jgarcia.domain.model.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>
}