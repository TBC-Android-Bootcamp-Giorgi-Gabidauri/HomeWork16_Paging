package com.gabo.paging

import android.app.Application
import com.gabo.paging.di.apiModule
import com.gabo.paging.di.repositoryModule
import com.gabo.paging.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(applicationContext)
            modules(provideKoinModules())
        }
    }
    private fun provideKoinModules(): List<Module> {
        return listOf(
            repositoryModule,
            viewModelsModule,
            apiModule,
        )
    }
}