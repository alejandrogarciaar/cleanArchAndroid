package com.jgarcia.remotedata.api

import com.jgarcia.remotedata.models.FeaturesAndDescriptionResponse
import com.jgarcia.remotedata.models.ProductsQueryResponse
import com.jgarcia.remotedata.models.SpecificProductResponse
import com.jgarcia.remotedata.util.Url
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    @GET(Url.SEARCH_PATH)
    suspend fun getProductsByQuery(
        @Path("siteId") siteId: String = Url.DEFAULT_SITE,
        @Query("q") query: String
    ): ProductsQueryResponse

    @GET(Url.SEARCH_PATH)
    suspend fun getProductsByCategory(
        @Path("siteId") siteId: String = Url.DEFAULT_SITE,
        @Query("category") categoryId: String
    ): List<ProductsQueryResponse>

    @GET(Url.GET_SPECIFIC_PRODUCT_PATH)
    suspend fun getSpecificProduct(
        @Path("productId") productId: String
    ): SpecificProductResponse

    @GET(Url.GET_FEATURES_PATH)
    suspend fun getFeaturesAndDescriptions(
        @Path("catalogProductId") catalogProductId: String
    ): FeaturesAndDescriptionResponse

}