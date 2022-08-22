package com.gabo.paging.data.repository

import com.gabo.paging.model.PageModel
import retrofit2.Response

interface Repository {
    suspend fun getUsers(page:Int): Response<PageModel>
}