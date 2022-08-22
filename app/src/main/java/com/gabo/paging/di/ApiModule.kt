package com.gabo.paging.di

import com.gabo.paging.api.UsersApi
import com.gabo.paging.constants.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    factory {
        provideRetrofit()
    }
    factory {
        provideNetworkApi(get())
    }

}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideNetworkApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)

