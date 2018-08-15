package com.example.jiteshp.magickotlin.interactor

import com.example.jiteshp.magickotlin.bean.Movies

interface MainActivityPresenterInteractor {

    fun getSuccessFromService(list: List<Movies>)
    fun getError(str: String)
}