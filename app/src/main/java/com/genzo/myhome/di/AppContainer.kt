package com.genzo.myhome.di

import com.genzo.myhome.data.entities.repositories.FakeCamerasRepository
import com.genzo.myhome.di.factories.CamerasViewModelFactory

class AppContainer {
    val camerasRepository = FakeCamerasRepository()

    val camerasViewModelFactory = CamerasViewModelFactory(camerasRepository)
}
