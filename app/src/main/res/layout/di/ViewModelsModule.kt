package com.gabo.paging3.di

import com.gabo.paging3.ui.MainVM
import org.koin.dsl.module

val viewModelsModule = module {
    factory {
        MainVM(get())
    }
}