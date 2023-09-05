package com.genzo.myhome.di.factories

import androidx.lifecycle.ViewModel
import com.genzo.myhome.data.repositories.CamerasRepository
import com.genzo.myhome.data.repositories.DoorsRepository
import com.genzo.myhome.ui.sections.cameras.viewModel.CamerasViewModel
import com.genzo.myhome.ui.sections.doors.viewModel.DoorsViewModel
import kotlinx.coroutines.CoroutineDispatcher

interface ViewModelFactory {
    fun create(): ViewModel
}

class CamerasViewModelFactory(
    private val camerasRepository: CamerasRepository,
    private val uiDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModelFactory {
    override fun create(): CamerasViewModel {
        return CamerasViewModel(
            camerasRepository,
            uiDispatcher,
            ioDispatcher
        )
    }
}

class DoorsViewModelFactory(
    private val doorsRepository: DoorsRepository,
    private val uiDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModelFactory {
    override fun create(): DoorsViewModel {
        return DoorsViewModel(
            doorsRepository,
            uiDispatcher,
            ioDispatcher
        )
    }
}