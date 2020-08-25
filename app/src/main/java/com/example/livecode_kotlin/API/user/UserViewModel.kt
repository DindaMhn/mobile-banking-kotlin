package com.example.livecode_kotlin.API.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livecode_kotlin.config.RetrofitBuilder

class UserViewModel : ViewModel() {
    val userRepository: UserRepository

    init {
        val userAPI = RetrofitBuilder.createRetrofit().create(UserAPI::class.java)
        userRepository = UserRepository(userAPI)
    }

    val user: MutableLiveData<List<User>> = userRepository.user
    fun getUser() {
        userRepository.getUser()
    }
}