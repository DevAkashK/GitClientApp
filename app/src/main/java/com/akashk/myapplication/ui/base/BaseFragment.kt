package com.akashk.myapplication.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.akashk.myapplication.utils.AuthException
import com.akashk.myapplication.utils.NoInternetException
import java.lang.Exception

open class BaseFragment:Fragment() {

    fun handleAllErrors(exception: Exception){

        when(exception){

            is NoInternetException->{
                Toast.makeText(context,exception.message, Toast.LENGTH_SHORT).show()
            }

            is AuthException->{
                Toast.makeText(context,exception.message, Toast.LENGTH_SHORT).show()
            }
        }

    }
}