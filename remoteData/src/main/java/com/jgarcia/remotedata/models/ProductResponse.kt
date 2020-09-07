package com.jgarcia.remotedata.models

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    val query: String,
    val results: List<ProductViewResponse>
) {
    data class ProductViewResponse(
        val id: String,
        @SerializedName("catalog_product_id")
        val catalogProductId: String,
        val title: String,
        val price: Double,
        @SerializedName("currency_id")
        val currencyId: String,
        val condition: String,
        val thumbnail: String,
        val shipping: Shipping
    ) {
        data class Shipping(
            @SerializedName("free_shipping")
            val freeShipping: Boolean
        )
    }
}
