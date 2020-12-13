package com.akashk.myapplication.network

import com.akashk.myapplication.model.GithubDataModel
import com.akashk.myapplication.utils.Constants
import retrofit2.http.GET

interface ApiInterface {

    @GET(Constants.GET_REPOSITORIES)
    suspend fun getData(): GithubDataModel
}