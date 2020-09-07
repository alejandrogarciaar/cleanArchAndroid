package com.jgarcia.data.mappers

import com.jgarcia.domain.model.ProductDetail
import com.jgarcia.remotedata.models.ProductDetailResponse

class ProductDetailMapper {
    operator fun invoke(productDetailResponse: ProductDetailResponse): ProductDetail {
        return ProductDetail().apply {

        }
    }
}