package com.gabo.paging.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gabo.paging.data.repository.Repository
import com.gabo.paging.model.UserModel
import kotlinx.coroutines.delay

open class UserRemotePagingSource(private val repository: Repository) : PagingSource<Int, UserModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        return try {
            val page = params.key ?: 1
            if (page != 1){
                delay(1500)
            }
            val response = repository.getUsers(page)
            var users :List<UserModel> = emptyList()

            response.body()?.let {
                users = it.data
            }
            return LoadResult.Page(
                data = users,
                prevKey = if (page > 0) page - 1 else null,
                nextKey = if (page < response.body()!!.totalPages) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}