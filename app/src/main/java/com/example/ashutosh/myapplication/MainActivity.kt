package com.example.ashutosh.myapplication

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.ashutosh.myapplication.sdk.InterceptorHTTPClientCreator
import com.example.ashutosh.myapplication.sdk.MySdk
import com.example.ashutosh.myapplication.sdk.Service
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (InterceptorHTTPClientCreator.isHttpClientNull) {
            InterceptorHTTPClientCreator.createInterceptorHTTPClient()
        }
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val decoration = DividerItemDecoration(applicationContext, VERTICAL)
        recyclerView.addItemDecoration(decoration)

        val service = MySdk.Builder().build(applicationContext).getService()

        //mimicking fake long running network call
        val handler = Handler()
        handler.postDelayed({
            callFetchUser(service)
        }, 5000)


    }

    private fun callFetchUser(service: Service?) {
        progressBar.visibility = View.VISIBLE
        service?.fetchUser("user")?.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                progressBar.visibility = View.GONE

            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val body = response.body()
                    recyclerView.adapter = body?.let { MyCustomRecyclerViewAdapter(this@MainActivity, it) }
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        InterceptorHTTPClientCreator.clearOkHttpClient()
    }

}
