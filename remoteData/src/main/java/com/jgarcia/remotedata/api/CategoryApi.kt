package com.jgarcia.remotedata.api

import com.jgarcia.remotedata.models.CategoryResponse
import com.jgarcia.remotedata.util.Url
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryApi {

    @GET(Url.GET_CATEGORIES)
    suspend fun getCategories(@Path("siteId") siteId: String = Url.DEFAULT_SITE): List<CategoryResponse>

}