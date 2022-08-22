package com.gabo.paging.di

import com.gabo.paging.data.repository.Repository
import com.gabo.paging.data.repository.RepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        RepositoryImpl(get())
    } bind Repository::class
}