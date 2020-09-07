package com.jgarcia.data.di

import com.jgarcia.data.datasource.impl.ProductRemoteDataSourceImpl
import com.jgarcia.data.mappers.ProductDetailMapper
import com.jgarcia.data.mappers.ProductPreviewMapper
import com.jgarcia.data.repositories.impl.ProductRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    // mappers
    factory { ProductPreviewMapper() }
    factory { ProductDetailMapper() }
    // dataSources
    factory { ProductRemoteDataSourceImpl(get(), get(), get()) }
    // repo
    factory { ProductRepositoryImpl(get()) }
}