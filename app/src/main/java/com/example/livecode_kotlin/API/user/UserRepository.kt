package com.example.livecode_kotlin.API.user

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(val userAPI: UserAPI) {
    var user: MutableLiveData<List<User>> = MutableLiveData<List<User>>()
    fun getUser() {
        userAPI.getUser().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val gson = Gson().toJson(response.body())
                val res: List<User> = Gson().fromJson(gson, Array<User>::class.java).toList()
                user.value = res
            }
        })
    }

}