package com.genzo.myhome.di

import com.genzo.myhome.data.providers.CamerasProvider
import com.genzo.myhome.data.providers.CamerasProviderImpl
import com.genzo.myhome.data.providers.DoorsProvider
import com.genzo.myhome.data.providers.DoorsProviderImpl
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
    abstract fun bindCameraProvider(camerasProviderImpl: CamerasProviderImpl): CamerasProvider

    @Binds
    @Singleton
    abstract fun bindDoorsProvider(doorsProviderImpl: DoorsProviderImpl): DoorsProvider
}
