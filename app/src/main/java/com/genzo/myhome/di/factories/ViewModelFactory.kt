package com.genzo.myhome.di.factories

import androidx.lifecycle.ViewModel
import com.genzo.myhome.data.entities.repositories.CamerasRepository
import com.genzo.myhome.ui.screens.home.sections.cameras.CamerasViewModel

interface ViewModelFactory {
    fun create(): ViewModel
}

class CamerasViewModelFactory(private val camerasRepository: CamerasRepository) : ViewModelFactory {
    override fun create(): CamerasViewModel {
        return CamerasViewModel(camerasRepository)
    }
}
