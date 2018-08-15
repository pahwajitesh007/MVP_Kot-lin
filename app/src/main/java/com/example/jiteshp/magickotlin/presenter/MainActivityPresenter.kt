package com.example.jiteshp.magickotlin.presenter


import com.example.jiteshp.magickotlin.R
import com.example.jiteshp.magickotlin.bean.Movies
import com.example.jiteshp.magickotlin.interactor.MainActivityInteractor
import com.example.jiteshp.magickotlin.interactor.MainActivityPresenterInteractor
import com.example.jiteshp.magickotlin.model.MainActivityModel
import com.example.jiteshp.magickotlin.utils.NetWorkConection


class MainActivityPresenter(var mMainActivityInteractor: MainActivityInteractor) : MainActivityPresenterInteractor {

    private lateinit var mMainActivityModel: MainActivityModel
    override fun getSuccessFromService(list: List<Movies>) {
        mMainActivityInteractor.getMoviesList(list)
    }

    override fun getError(str: String) {
        mMainActivityInteractor.getError(str)
    }


    fun callAPIForMovies() {

        if(NetWorkConection.isNetWorkConnected(mMainActivityInteractor.getContext())) {
            mMainActivityModel = MainActivityModel(this)
            mMainActivityModel.callAPI()
        }else
        {
            mMainActivityInteractor.setNetworkError(mMainActivityInteractor.getContext().getString(R.string.internet_not_connect))
        }

    }
}