package com.example.jiteshp.magickotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

class NetWorkConection {


    companion object {
        @SuppressLint("MissingPermission")
        fun isNetWorkConnected(context: Context) :Boolean
        {
            var connectionManager =context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwrokInfo=connectionManager.activeNetworkInfo
            return activeNetwrokInfo!=null && activeNetwrokInfo.isConnectedOrConnecting
        }
    }
}