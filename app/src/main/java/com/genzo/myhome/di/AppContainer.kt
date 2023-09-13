package com.genzo.myhome.di

import android.content.Context
import com.genzo.myhome.data.datasources.CamerasRemoteDataSource
import com.genzo.myhome.data.datasources.DoorsRemoteDataSource
import com.genzo.myhome.di.factories.CamerasViewModelFactory
import com.genzo.myhome.di.factories.DoorsViewModelFactory
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(applicationContext: Context) {

    init {
        Realm.init(applicationContext)
    }

    val realmName: String = "My Project"
    val config = RealmConfiguration.Builder().name(realmName).build()
    val backgroundThreadRealm: Realm = Realm.getInstance(config)

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://cars.cprogroup.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val camerasRepository = getCamerasAPI()
    private val doorsRepository = getDoorsApi()

    private val uiDispatcher = Dispatchers.Main
    private val ioDispatcher = Dispatchers.IO

    private fun getCamerasAPI(): CamerasRemoteDataSource {
        return retrofit.create(CamerasRemoteDataSource::class.java)
    }

    private fun getDoorsApi(): DoorsRemoteDataSource {
        return retrofit.create(DoorsRemoteDataSource::class.java)
    }

    val camerasViewModelFactory = CamerasViewModelFactory(
        camerasRepository,
        uiDispatcher,
        ioDispatcher
    )

    val doorsViewModelFactory = DoorsViewModelFactory(
        doorsRepository, uiDispatcher, ioDispatcher
    )
}
