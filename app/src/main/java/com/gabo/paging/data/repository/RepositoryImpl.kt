package com.gabo.paging.data.repository

import com.gabo.paging.api.UsersApi
import com.gabo.paging.model.PageModel
import retrofit2.Response

class RepositoryImpl(private val api: UsersApi) : Repository{
    override suspend fun getUsers(page: Int): Response<PageModel> {
        return api.getUsers(page)
    }



}