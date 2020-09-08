package com.jgarcia.domain.model

data class ProductPreview(
    val id: String? = null,
    val title: String? = null,
    val price: Double? = null,
    val thumbnailUrl: String? = null,
    val currency: String? = null,
    val hasFreeShipping: Boolean? = null
)