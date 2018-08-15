package com.example.jiteshp.magickotlin.interactor

import android.content.Context
import com.example.jiteshp.magickotlin.bean.Movies

interface MainActivityInteractor {

    fun getMoviesList(list: List<Movies>)
    fun getError(str: String)
    fun getContext() :Context
    fun setNetworkError(str :String)


}