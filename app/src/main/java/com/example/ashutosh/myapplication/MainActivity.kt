package com.example.ashutosh.myapplication

import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.ashutosh.myapplication.sdk.InterceptorHTTPClientCreator
import com.example.ashutosh.myapplication.sdk.MySdk
import com.example.ashutosh.myapplication.sdk.Service
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (InterceptorHTTPClientCreator.isHttpClientNull)
            InterceptorHTTPClientCreator.createInterceptorHTTPClient()

        val service = MySdk.Builder().build(applicationContext).getService()

        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))
        }


        //mimicking fake long running network call
        val handler = Handler()
        handler.postDelayed(delayInMillis = 5000) {
            callFetchUser(service)
        }


    }

    private fun callFetchUser(service: Service?) {
        progressBar.visibility = VISIBLE

        service?.fetchUser("user")?.onEnqueue(
                onSuccess = {
                    doOnSuccess(it)
                },
                onFail = {
                    doOnFail(it)
                }
        )
    }

    private fun doOnFail(t: Throwable) {
        progressBar.visibility = GONE
        t.printStackTrace()
    }

    private fun doOnSuccess(response: Response<List<User>>) {
        progressBar.visibility = GONE
        if (response.isSuccessful) {
            val body = response.body()
            recyclerView.adapter = body?.let {
                MyCustomRecyclerViewAdapter(this@MainActivity, it)
            }
        }
    }


}

