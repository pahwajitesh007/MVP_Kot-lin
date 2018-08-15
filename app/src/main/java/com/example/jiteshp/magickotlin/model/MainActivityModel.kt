package com.example.jiteshp.magickotlin.model

import com.example.jiteshp.magickotlin.api.ApiClient
import com.example.jiteshp.magickotlin.api.ApiInterface
import com.example.jiteshp.magickotlin.bean.MovieResponse
import com.example.jiteshp.magickotlin.bean.Movies
import com.example.jiteshp.magickotlin.interactor.MainActivityPresenterInteractor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityModel(var mMainActivityPresenterInteractor: MainActivityPresenterInteractor) {
    val API_KEY: String = "ec44357d71b936de6ee7f5aa7837b6a4"
    fun callAPI() {
        var service = ApiClient.getClinet()?.create(ApiInterface::class.java)
        val call = service?.getTopRatedMovies(API_KEY)
        call?.enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>) {
                val listOfMovie: List<Movies> = response.body()?.results!!
                mMainActivityPresenterInteractor.getSuccessFromService(listOfMovie)
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable) {
                mMainActivityPresenterInteractor.getError(t.toString())

            }


        })
    }
}