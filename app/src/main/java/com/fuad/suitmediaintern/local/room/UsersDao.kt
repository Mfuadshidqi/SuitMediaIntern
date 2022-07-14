package com.fuad.suitmediaintern.local.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fuad.suitmediaintern.local.entity.Users

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(story: List<Users>)

    @Query("SELECT * FROM users")
    fun getAllUsers(): PagingSource<Int, Users>

    @Query("DELETE FROM users")
    fun deleteAll()
}