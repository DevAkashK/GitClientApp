package com.akashk.myapplication.model

sealed class ResultData<out T> {

    data class Success<out T>(val data: T?) : ResultData<T>()
    data class Loading(val nothing: Nothing? = null) : ResultData<Nothing>()
    data class Exception(val exception: kotlin.Exception? = null): ResultData<Nothing>()
}