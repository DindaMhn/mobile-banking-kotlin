package com.example.livecode_kotlin.API.transaction

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepository(val transactionAPI: TransactionAPI) {
    var transaction: MutableLiveData<List<Transaction>> = MutableLiveData<List<Transaction>>()
    fun getTransaction() {
        transactionAPI.getTransaction().enqueue(object : Callback<List<Transaction>> {
            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<Transaction>>,
                response: Response<List<Transaction>>
            ) {
                val gson = Gson().toJson(response.body())
                val res: List<Transaction> =
                    Gson().fromJson(gson, Array<Transaction>::class.java).toList()
                transaction.value = res
            }
        })
    }

    fun saveTransaction(transaction: Transaction) {
        transactionAPI.createTransaction(transaction).enqueue(object : Callback<Transaction> {
            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                if (response.code() == 200) {
                    println("SUCCESS")
                }
            }
        })
    }
}