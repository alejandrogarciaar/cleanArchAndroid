package com.jgarcia.data.mappers

import com.jgarcia.domain.model.ProductPreview
import com.jgarcia.remotedata.models.ProductResponse
import javax.inject.Inject

class ProductPreviewMapper @Inject constructor() {
    operator fun invoke(productViewResponse: ProductResponse.ProductViewResponse): ProductPreview {
        productViewResponse.apply {
            return ProductPreview(
                id = this.id,
                title = this.title,
                price = this.price,
                thumbnailUrl = this.thumbnail,
                currency = this.currencyId,
                hasFreeShipping = this.shipping.freeShipping
            )
        }
    }
}