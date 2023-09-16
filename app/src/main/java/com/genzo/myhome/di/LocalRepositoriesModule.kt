package com.genzo.myhome.di

import com.genzo.myhome.data.repositories.CamerasLocalRepository
import com.genzo.myhome.data.repositories.CamerasLocalRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalRepositoriesModule {

    @Singleton
    @Provides
    fun provideCamerasLocalRepository(camerasLocalRepositoryImpl: CamerasLocalRepositoryImpl): CamerasLocalRepository {
        return camerasLocalRepositoryImpl
    }
}
