package com.example.livecode_kotlin.API.user

import retrofit2.*
import retrofit2.http.GET

interface UserAPI {
    @GET("users")
    fun getUser(): Call<List<User>>
}