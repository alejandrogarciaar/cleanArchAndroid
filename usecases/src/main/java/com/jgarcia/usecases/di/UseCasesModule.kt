package com.jgarcia.usecases.di

import com.jgarcia.usecases.GetCurrentCategories
import com.jgarcia.usecases.GetProductsByQuery
import com.jgarcia.usecases.GetProductDetail
import com.jgarcia.usecases.GetProductsByCategory
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetProductsByQuery(get()) }
    factory { GetProductsByCategory(get()) }
    factory { GetProductDetail(get()) }
    factory { GetCurrentCategories(get()) }
}