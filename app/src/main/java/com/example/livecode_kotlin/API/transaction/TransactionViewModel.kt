package com.example.livecode_kotlin.API.transaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livecode_kotlin.config.RetrofitBuilder

class TransactionViewModel : ViewModel() {
    val transactionRepository: TransactionRepository

    init {
        val transactionAPI = RetrofitBuilder.createRetrofit().create(TransactionAPI::class.java)
        transactionRepository = TransactionRepository(transactionAPI)
    }

    val transaction: MutableLiveData<List<Transaction>> = transactionRepository.transaction

    fun getTransaction() {
        transactionRepository.getTransaction()
    }
    fun saveTransaction(transaction: Transaction){
        transactionRepository.saveTransaction(transaction)
    }
}