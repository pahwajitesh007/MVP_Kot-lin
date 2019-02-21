package com.example.jiteshp.magickotlin.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
//this is

    companion object {
        val baseUrl: String = "https://api.themoviedb.org/3/"
        var retrofit: Retrofit? = null


        fun getClinet(): Retrofit? {
            if (retrofit == null) {
                val httpClient = OkHttpClient.Builder()
                httpClient.retryOnConnectionFailure(true)
                httpClient.readTimeout(100, TimeUnit.SECONDS)
                httpClient.connectTimeout(100, TimeUnit.SECONDS)
                retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build()
            }
            return retrofit
        }


    }
}