package com.gabo.paging3.di

import com.gabo.paging3.data.UserRemotePagingSource
import com.gabo.paging3.data.repository.Repository
import com.gabo.paging3.data.repository.RepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        RepositoryImpl(get())
    } bind Repository::class
}