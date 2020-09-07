package com.jgarcia.usecases

import com.jgarcia.data.repositories.CategoryRepository

class GetCurrentCategories(private val categoryRepository: CategoryRepository) {
    suspend operator fun invoke() = categoryRepository.getCategories()
}