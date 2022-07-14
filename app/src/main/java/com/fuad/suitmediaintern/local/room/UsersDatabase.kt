package com.fuad.suitmediaintern.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fuad.suitmediaintern.local.entity.RemoteKeys
import com.fuad.suitmediaintern.local.entity.Users


@Database(
    entities = [Users::class, RemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun userDao(): UsersDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object {
        @Volatile
        private var INSTANCE: UsersDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): UsersDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    UsersDatabase::class.java, "users_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}