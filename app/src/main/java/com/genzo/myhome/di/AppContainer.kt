package com.genzo.myhome.di

import com.genzo.myhome.data.repositories.FakeCamerasRepository
import com.genzo.myhome.data.repositories.FakeDoorsRepository
import com.genzo.myhome.di.factories.CamerasViewModelFactory
import com.genzo.myhome.di.factories.DoorsViewModelFactory
import kotlinx.coroutines.Dispatchers

class AppContainer {
    val camerasRepository = FakeCamerasRepository()
    val doorsRepository = FakeDoorsRepository()

    val uiDispatcher = Dispatchers.Main
    val ioDispatcher = Dispatchers.IO

    val camerasViewModelFactory = CamerasViewModelFactory(
        camerasRepository,
        uiDispatcher,
        ioDispatcher
    )

    val doorsViewModelFactory = DoorsViewModelFactory(
        doorsRepository, uiDispatcher, ioDispatcher
    )
}
