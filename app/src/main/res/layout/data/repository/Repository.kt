package com.gabo.paging3.data.repository

import androidx.paging.PagingData
import com.gabo.paging3.model.PageModel
import com.gabo.paging3.model.UserModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
    suspend fun getUsers(page:Int): Response<PageModel>
}