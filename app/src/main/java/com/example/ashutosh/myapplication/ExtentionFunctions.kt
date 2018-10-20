package com.example.ashutosh.myapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

inline fun <T> Call<T>.onEnqueue(
        crossinline onSuccess: (response: Response<T>) -> Unit = { response: Response<T> -> },
        crossinline onFail: (t: Throwable) -> Unit = { throwable: Throwable -> }
): Callback<T> {
    val callback = object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onFail(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            onSuccess(response)
        }
    }
    enqueue(callback)
    return callback
}