package com.example.livecode_kotlin.API.transaction

import com.example.livecode_kotlin.API.user.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TransactionAPI {
    @GET("transactions")
    fun getTransaction(): Call<List<Transaction>>
    @POST("transaction")
    fun createTransaction(@Body transaction: Transaction):Call<Transaction>
}