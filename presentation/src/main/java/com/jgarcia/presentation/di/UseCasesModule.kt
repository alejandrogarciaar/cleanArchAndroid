package com.jgarcia.presentation.di

import com.jgarcia.data.repositories.CategoryRepository
import com.jgarcia.data.repositories.ProductRepository
import com.jgarcia.usecases.GetCurrentCategories
import com.jgarcia.usecases.GetProductDetail
import com.jgarcia.usecases.GetProductsByCategory
import com.jgarcia.usecases.GetProductsByQuery
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCasesModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetProductsByQuery(productRepository: ProductRepository): GetProductsByQuery {
        return GetProductsByQuery(productRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetProductsByCategory(productRepository: ProductRepository): GetProductsByCategory {
        return GetProductsByCategory(productRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetProductDetail(productRepository: ProductRepository): GetProductDetail {
        return GetProductDetail(productRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetCurrentCategories(categoryRepository: CategoryRepository): GetCurrentCategories {
        return GetCurrentCategories(categoryRepository)
    }
}