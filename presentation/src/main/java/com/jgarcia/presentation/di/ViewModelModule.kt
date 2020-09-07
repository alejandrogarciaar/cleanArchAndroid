package com.jgarcia.presentation.di

import com.jgarcia.presentation.viewModel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
}