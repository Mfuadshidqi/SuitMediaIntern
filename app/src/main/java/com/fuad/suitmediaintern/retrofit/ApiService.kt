package com.fuad.suitmediaintern.retrofit

import com.fuad.suitmediaintern.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{id}")
    fun getUserDetail(
        @Path("id") username: String
    ): UserResponse
}