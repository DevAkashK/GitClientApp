package com.akashk.myapplication.di

import com.akashk.myapplication.network.ApiInterface
import com.akashk.myapplication.repositories.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun providesDataRepo(apiInterface: ApiInterface): DataRepository {
        return DataRepository(apiInterface)
    }
}