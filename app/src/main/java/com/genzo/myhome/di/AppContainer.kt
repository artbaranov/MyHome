package com.genzo.myhome.di

import com.genzo.myhome.data.repositories.FakeCamerasRepository
import com.genzo.myhome.di.factories.CamerasViewModelFactory
import kotlinx.coroutines.Dispatchers

class AppContainer {
    val camerasRepository = FakeCamerasRepository()

    val uiDispatcher = Dispatchers.Main
    val ioDispatcher = Dispatchers.IO

    val camerasViewModelFactory = CamerasViewModelFactory(
        camerasRepository,
        uiDispatcher,
        ioDispatcher
    )
}
