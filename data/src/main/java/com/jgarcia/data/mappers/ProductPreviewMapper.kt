package com.jgarcia.data.mappers

import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.remotedata.models.ProductResponse

class ProductPreviewMapper {
    operator fun invoke(productResponse: ProductResponse): ProductPreview {
        return ProductPreview().apply {

        }
    }
}