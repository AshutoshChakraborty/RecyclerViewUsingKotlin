package com.example.ashutosh.myapplication.sdk

import com.example.ashutosh.myapplication.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("{path}")
    fun fetchUser(@Path("path") path: String): Call <List<User>>


}