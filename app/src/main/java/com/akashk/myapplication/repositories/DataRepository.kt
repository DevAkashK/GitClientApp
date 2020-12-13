package com.akashk.myapplication.repositories

import com.akashk.myapplication.model.GithubDataModel
import com.akashk.myapplication.network.ApiInterface
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getPublicRepostories(): GithubDataModel {
       return apiInterface.getData()
    }
}