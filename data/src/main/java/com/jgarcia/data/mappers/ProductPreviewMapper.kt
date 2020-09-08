package com.jgarcia.data.mappers

import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.remotedata.models.ProductResponse
import javax.inject.Inject

class ProductPreviewMapper @Inject constructor() {
    operator fun invoke(productResponse: ProductResponse): ProductPreview {
        return ProductPreview(title = "")
    }
}