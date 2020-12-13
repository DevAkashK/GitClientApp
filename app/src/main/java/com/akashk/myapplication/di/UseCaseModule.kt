package com.akashk.myapplication.di

import com.akashk.myapplication.repositories.DataRepository
import com.akashk.myapplication.usecases.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun providesUseCase(dataRepostory: DataRepository): DataUseCase {
        return DataUseCase(dataRepostory)
    }
}