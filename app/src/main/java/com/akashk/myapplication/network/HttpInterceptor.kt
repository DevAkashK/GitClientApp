package com.akashk.myapplication.network

import android.content.Context
import com.akashk.myapplication.utils.CheckInternet
import com.akashk.myapplication.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {


        if (!CheckInternet.checkInternet(context)) {
            throw NoInternetException()
        }

        val r = chain?.request()?.newBuilder()


        val response = chain?.proceed(r?.build())

        //returning network errors with Custom exceptions


        return response!!
    }


}