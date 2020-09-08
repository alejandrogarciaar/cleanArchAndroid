package com.jgarcia.data.mappers

import com.jgarcia.domain.model.Category
import com.jgarcia.remotedata.models.CategoryResponse
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    operator fun invoke(categoryResponse: CategoryResponse): Category {
        categoryResponse.apply {
            return Category(id = this.id, name = this.name)
        }
    }
}