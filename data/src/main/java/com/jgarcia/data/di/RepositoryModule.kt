package com.jgarcia.data.di

import com.jgarcia.data.datasource.CategoryRemoteDataSource
import com.jgarcia.data.datasource.ProductRemoteDataSource
import com.jgarcia.data.datasource.impl.CategoryRemoteDataSourceImpl
import com.jgarcia.data.datasource.impl.ProductRemoteDataSourceImpl
import com.jgarcia.data.repositories.CategoryRepository
import com.jgarcia.data.repositories.ProductRepository
import com.jgarcia.data.repositories.impl.CategoryRepositoryImpl
import com.jgarcia.data.repositories.impl.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProductRemoteDataSource(productRemoteDataSourceImpl: ProductRemoteDataSourceImpl): ProductRemoteDataSource

    @Binds
    abstract fun bindProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository

    @Binds
    abstract fun bindCategoryRemoteDataSource(categoryRemoteDataSourceImpl: CategoryRemoteDataSourceImpl): CategoryRemoteDataSource

    @Binds
    abstract fun bindCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository
}