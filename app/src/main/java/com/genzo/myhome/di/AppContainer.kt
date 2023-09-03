package com.genzo.myhome.di

import com.genzo.myhome.data.repositories.CamerasRepository
import com.genzo.myhome.data.repositories.DoorsRepository
import retrofit2.Retrofit

class AppContainer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://cars.cprogroup.ru")
        .build()

    fun provideCamerasAPI(): CamerasRepository {
        return retrofit.create(CamerasRepository::class.java)
    }

    fun provideDoorsAPI(): DoorsRepository {
        return retrofit.create(DoorsRepository::class.java)
    }
}
