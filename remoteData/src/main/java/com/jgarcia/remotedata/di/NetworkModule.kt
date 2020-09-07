package com.jgarcia.remotedata.di

import com.jgarcia.remotedata.util.Url
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val DEFAULT_TIME_OUT = 20L

val networkModule = module {
    single { getDefaultClient() }
    single { getRetrofitClient(get()) }
}

private fun getDefaultClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        .callTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
        .build()
}

private fun getRetrofitClient(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Url.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}