package com.jgarcia.data.mappers

import com.jgarcia.domain.model.ProductDetail
import com.jgarcia.remotedata.models.ProductDetailResponse
import javax.inject.Inject

class ProductDetailMapper @Inject constructor() {
    operator fun invoke(productDetailResponse: ProductDetailResponse): ProductDetail {
        productDetailResponse.apply {
            return ProductDetail(title = this.title)
        }
    }
}