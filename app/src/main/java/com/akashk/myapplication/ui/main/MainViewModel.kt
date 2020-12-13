package com.akashk.myapplication.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akashk.myapplication.model.GithubDataModel
import com.akashk.myapplication.model.ResultData
import com.akashk.myapplication.usecases.DataUseCase

class MainViewModel @ViewModelInject constructor(private val dataUseCase: DataUseCase) :
    ViewModel() {

    fun getRepositoriesList(): LiveData<ResultData<GithubDataModel>> {
        return liveData {
            emit(ResultData.Loading())

            try {
                emit(dataUseCase.getRepoList())
            } catch (e: Exception) {
                emit(ResultData.Exception(e))
            }

        }
    }
}