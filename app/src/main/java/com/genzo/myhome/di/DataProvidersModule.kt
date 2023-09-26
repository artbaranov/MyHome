package com.genzo.myhome.di

import com.genzo.myhome.data.repositories.CamerasRepository
import com.genzo.myhome.data.repositories.CamerasRepositoryImpl
import com.genzo.myhome.data.repositories.DoorsRepository
import com.genzo.myhome.data.repositories.DoorsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataProvidersModule {
    @Binds
    @Singleton
    abstract fun bindCameraProvider(camerasProviderImpl: CamerasRepositoryImpl): CamerasRepository

    @Binds
    @Singleton
    abstract fun bindDoorsProvider(doorsProviderImpl: DoorsRepositoryImpl): DoorsRepository
}
