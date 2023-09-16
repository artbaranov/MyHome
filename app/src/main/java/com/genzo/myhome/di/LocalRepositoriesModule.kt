package com.genzo.myhome.di

import com.genzo.myhome.data.repositories.CamerasLocalRepository
import com.genzo.myhome.data.repositories.CamerasLocalRepositoryImpl
import com.genzo.myhome.data.repositories.DoorsLocalRepository
import com.genzo.myhome.data.repositories.DoorsLocalRepositoryImpl
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

    @Singleton
    @Provides
    fun provideDoorsLocalRepository(doorsLocalRepository: DoorsLocalRepositoryImpl): DoorsLocalRepository {
        return doorsLocalRepository
    }
}
