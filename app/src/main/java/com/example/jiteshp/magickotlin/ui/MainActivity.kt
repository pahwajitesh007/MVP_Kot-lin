package com.example.jiteshp.magickotlin.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.jiteshp.magickotlin.R

import com.example.jiteshp.magickotlin.adapter.MyCustomAdapter

import com.example.jiteshp.magickotlin.bean.Movies
import com.example.jiteshp.magickotlin.interactor.MainActivityInteractor
import com.example.jiteshp.magickotlin.presenter.MainActivityPresenter
import com.example.jiteshp.magickotlin.utils.ListItemDecorations
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity(), MainActivityInteractor {

    private lateinit var myCustomAdapter: MyCustomAdapter
    private lateinit var context: Context

    private lateinit var mMainActivityPresenter: MainActivityPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        mMainActivityPresenter = MainActivityPresenter(this)
        recyler_view.layoutManager = LinearLayoutManager(this)
        recyler_view.addItemDecoration(ListItemDecorations(20))
        recyler_view.setHasFixedSize(true)
        //call API
        progressBar.visibility = View.VISIBLE
        mMainActivityPresenter.callAPIForMovies();

    }

    override fun getMoviesList(list: List<Movies>) {
        myCustomAdapter = MyCustomAdapter(applicationContext, list)
        recyler_view.setAdapter(myCustomAdapter)
        progressBar.visibility = View.GONE
    }

    override fun getError(str: String) {
        progressBar.visibility = View.GONE
        context.toast("" + str)
        Log.v("", "" + str)
    }

    override fun getContext(): Context {
        return this
    }

    override fun setNetworkError(str: String) {
        toast(str)
    }

}
