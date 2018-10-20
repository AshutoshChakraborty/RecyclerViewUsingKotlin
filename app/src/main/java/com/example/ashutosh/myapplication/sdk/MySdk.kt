package com.example.ashutosh.myapplication.sdk

import android.content.Context
import com.example.ashutosh.myapplication.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MySdk(private val retrofit: Retrofit) {
    private  var service: Service? = null

    init {
        createService()
    }

    /**
     * Builder for [MySdk]
     */
    class Builder {

        /**
         * Create the [MySdk] to be used.
         *
         * @return [MySdk]
         */

        fun build(context: Context): MySdk {
            val retrofit: Retrofit
            val baseUrl: String = context.resources.getString(R.string.base_url)

            val okHttpClient = InterceptorHTTPClientCreator.okHttpClient
            if (okHttpClient != null) {
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .baseUrl(baseUrl)
                        .build()

                return MySdk(retrofit)
            } else {
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(baseUrl)
                        .build()
            }
            return MySdk(retrofit)
        }
    }

    private fun createService() {
        service = retrofit.create(Service::class.java)
    }

    fun getService(): Service? {
        return service
    }
}



