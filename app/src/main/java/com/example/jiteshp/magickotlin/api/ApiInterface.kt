package com.example.jiteshp.magickotlin.api

import com.example.jiteshp.magickotlin.bean.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("movie/top_rated?")
    fun getTopRatedMovies(@Query("api_key") apiKey: String) : Call<MovieResponse>

}