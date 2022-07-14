package com.fuad.suitmediaintern.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class Users (
    @PrimaryKey val id: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val avatar: String
) :Parcelable
