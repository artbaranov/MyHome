package com.genzo.myhome.di

import com.genzo.myhome.data.datasources.CamerasRemoteDataSource
import com.genzo.myhome.data.datasources.DoorsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://cars.cprogroup.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideCamerasRemoteDataSource(retrofit: Retrofit): CamerasRemoteDataSource {
        return retrofit.create(CamerasRemoteDataSource::class.java)
    }

    @Singleton
    @Provides
    fun provideDoorsRemoteDatSource(retrofit: Retrofit): DoorsRemoteDataSource {
        return retrofit.create(DoorsRemoteDataSource::class.java)
    }
}
