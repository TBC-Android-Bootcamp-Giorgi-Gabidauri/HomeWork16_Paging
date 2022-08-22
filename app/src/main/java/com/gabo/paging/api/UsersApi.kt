package com.gabo.paging.api

import com.gabo.paging.model.PageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {
    @GET("api/users")
    suspend fun getUsers(
        @Query("page") pageNumber: Int = 1
    ): Response<PageModel>
}

