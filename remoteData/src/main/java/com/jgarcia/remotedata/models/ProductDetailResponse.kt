package com.jgarcia.remotedata.models

import com.google.gson.annotations.SerializedName

data class ProductDetailResponse(
    val title: String,
    @SerializedName("catalog_product_id")
    val catalogProductId: String?,
    val price: Double,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    val pictures: List<Picture>,
    val warranty: String?,
) {
    data class Picture(
        val id: String,
        val url: String
    )
}