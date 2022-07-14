package com.fuad.suitmediaintern.ui.listuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.fuad.suitmediaintern.local.UsersRemoteMediator
import com.fuad.suitmediaintern.local.entity.Users
import com.fuad.suitmediaintern.local.room.UsersDatabase
import com.fuad.suitmediaintern.retrofit.ApiService

class ListUserViewModel (private val apiService: ApiService, private val usersDatabase: UsersDatabase): ViewModel() {

    fun getUsers(): LiveData<PagingData<Users>>{
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
                config = PagingConfig(
                    pageSize = 5
                ),
                remoteMediator = UsersRemoteMediator(usersDatabase, apiService),
                pagingSourceFactory = {
                    usersDatabase.userDao().getAllUsers()
                }
            ).liveData
    }

    companion object {
        private const val TAG = "ListUserViewModel"
    }
}