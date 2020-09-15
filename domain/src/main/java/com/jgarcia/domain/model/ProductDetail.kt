package com.jgarcia.domain.model

data class ProductDetail(
    val title: String,
    val price: Float,
    val images: List<String>,
    val warranty: String?,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val tags: List<String>,
    val description: String?,
    val features: List<Feature>?
) {
    data class Feature(
        val text: String?,
        val type: String?
    )
}