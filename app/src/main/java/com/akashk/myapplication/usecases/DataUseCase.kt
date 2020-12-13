package com.akashk.myapplication.usecases

import com.akashk.myapplication.model.GithubDataModel
import com.akashk.myapplication.model.ResultData
import com.akashk.myapplication.repositories.DataRepository
import javax.inject.Inject

class DataUseCase @Inject constructor(private val dataRepostory: DataRepository) {

    suspend fun getRepoList(): ResultData<GithubDataModel> {

        val publicRepositories = dataRepostory.getPublicRepostories()

        val resultData= if (!publicRepositories.isNullOrEmpty()) {
              ResultData.Success(publicRepositories)
        }
        else{
            ResultData.Exception()
        }

        return resultData
    }
}