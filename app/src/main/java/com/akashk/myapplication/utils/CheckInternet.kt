package com.akashk.myapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CheckInternet  {

    companion object{

        fun checkInternet(context: Context):Boolean{

            val cm=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

           return cm.activeNetworkInfo!=null && cm.activeNetworkInfo.isConnected

        }
    }
}
