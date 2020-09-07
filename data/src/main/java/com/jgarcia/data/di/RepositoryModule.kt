package com.jgarcia.data.di

import com.jgarcia.data.datasource.ProductRemoteDataSource
import com.jgarcia.data.datasource.impl.ProductRemoteDataSourceImpl
import com.jgarcia.data.mappers.ProductDetailMapper
import com.jgarcia.data.mappers.ProductPreviewMapper
import com.jgarcia.data.repositories.ProductRepository
import com.jgarcia.data.repositories.impl.ProductRepositoryImpl
import com.jgarcia.remotedata.api.ProductApi
import org.koin.dsl.module

val repositoryModule = module {
    // mappers
    factory { ProductPreviewMapper() }
    factory { ProductDetailMapper() }
    // dataSources
    single { getProductRemoteDataSource(get(), get(), get()) }
    // repo
    single { getProductRepository(get()) }
}

private fun getProductRepository(productRemoteDataSource: ProductRemoteDataSource): ProductRepository {
    return ProductRepositoryImpl(productRemoteDataSource)
}

private fun getProductRemoteDataSource(productApi: ProductApi, productPreviewMapper: ProductPreviewMapper, productDetailMapper: ProductDetailMapper): ProductRemoteDataSource {
    return ProductRemoteDataSourceImpl(productApi, productPreviewMapper, productDetailMapper)
}