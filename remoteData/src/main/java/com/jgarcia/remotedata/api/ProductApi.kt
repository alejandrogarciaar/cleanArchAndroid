package com.jgarcia.remotedata.api

import com.jgarcia.remotedata.models.ProductDetailResponse
import com.jgarcia.remotedata.models.ProductResponse
import com.jgarcia.remotedata.util.Url
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    @GET(Url.SEARCH_PATH)
    suspend fun getProductsByQuery(
        @Path("siteId") siteId: String = Url.DEFAULT_SITE,
        @Query("q") query: String
    ): List<ProductResponse>

    @GET(Url.SEARCH_PATH)
    suspend fun getProductsByCategory(
        @Path("siteId") siteId: String = Url.DEFAULT_SITE,
        @Query("category") categoryId: String
    ): List<ProductResponse>

    @GET(Url.GET_SPECIFIC_PRODUCT_PATH)
    suspend fun getSpecificProduct(@Path("productId") productId: String): ProductDetailResponse

}