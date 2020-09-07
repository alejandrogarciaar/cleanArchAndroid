package com.jgarcia.cleanarch

import android.app.Application
import com.jgarcia.data.di.repositoryModule
import com.jgarcia.remotedata.di.networkModule
import com.jgarcia.usecases.di.useCasesModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                arrayListOf(
                    networkModule,
                    repositoryModule,
                    useCasesModule
                )
            )
        }
    }
}