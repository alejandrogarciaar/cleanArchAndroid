package com.jgarcia.remotedata.models

import com.google.gson.annotations.SerializedName

data class SpecificProductResponse(
    val title: String,
    @SerializedName("catalog_product_id")
    val catalogProductId: String?,
    val price: Double,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    @SerializedName("sold_quantity")
    val soldQuantity: Int,
    val pictures: List<Picture>,
    val warranty: String?,
    val tags: List<String>
) {
    data class Picture(
        val id: String,
        val url: String
    )
}