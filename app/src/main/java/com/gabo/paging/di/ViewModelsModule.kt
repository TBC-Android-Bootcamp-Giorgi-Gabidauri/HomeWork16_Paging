package com.gabo.paging.di

import com.gabo.paging.ui.MainVM
import org.koin.dsl.module

val viewModelsModule = module {
    factory {
        MainVM(get())
    }
}