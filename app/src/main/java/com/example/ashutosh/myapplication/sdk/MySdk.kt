package com.example.ashutosh.myapplication.sdk

import android.content.Context
import com.example.ashutosh.myapplication.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MySdk(private val retrofit: Retrofit) {
    private var service: Service? = null
    init {
        createService()
    }



    /**
     * Builder for [OmlSdk]
     */
    class Builder {

        /**
         * Create the [OmlSdk] to be used.
         *
         * @return [OmlSdk]
         */

        fun build(context: Context): MySdk {
            var retrofit: Retrofit? = null
            var baseUrl: String? = null
            baseUrl = context.resources.getString(R.string.base_url)
            if (InterceptorHTTPClientCreator.okHttpClient != null) {
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(InterceptorHTTPClientCreator.okHttpClient)
                        .baseUrl(baseUrl!!)
                        .build()

                return MySdk(retrofit)
            } else {
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        //                        .client(InterceptorHTTPClientCreator.getOkHttpClient())
                        .baseUrl(baseUrl!!)
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



