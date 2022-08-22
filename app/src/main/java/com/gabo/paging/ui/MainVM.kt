package com.gabo.paging.ui

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gabo.paging.data.UserRemotePagingSource
import com.gabo.paging.data.repository.Repository
import com.gabo.paging.model.UserModel
import kotlinx.coroutines.flow.Flow

class MainVM(private val repository: Repository) : ViewModel() {

    fun getUsers(): Flow<PagingData<UserModel>>{
        return Pager(
            config = PagingConfig(
                pageSize = 6,
                enablePlaceholders = false,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                UserRemotePagingSource(repository)
            }
        ).flow
    }
//    fun getUsers(): Flow<PagingData<UserModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 6,
//                enablePlaceholders = false,
//                prefetchDistance = 2
//            ),
//            pagingSourceFactory = {
//                UserRemotePagingSource(repository)
//            }
//        ).flow
//    }
}