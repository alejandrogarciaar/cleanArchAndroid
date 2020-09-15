package com.jgarcia.remotedata.util

object Url {
    const val BASE_URL = "https://api.mercadolibre.com/"
    const val DEFAULT_SITE = "MCO"
    const val SEARCH_PATH = "/sites/{siteId}/search"
    const val GET_SPECIFIC_PRODUCT_PATH = "/items/{productId}"
    const val GET_FEATURES_PATH = "products/{catalogProductId}"
    const val GET_CATEGORIES = "/sites/{siteId}/categories"
}