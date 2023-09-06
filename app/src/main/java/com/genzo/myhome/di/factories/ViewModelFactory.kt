package com.genzo.myhome.di.factories

import androidx.lifecycle.ViewModel
import com.genzo.myhome.data.datasources.CamerasRemoteDataSource
import com.genzo.myhome.data.datasources.DoorsRemoteDataSource
import com.genzo.myhome.ui.sections.cameras.viewModel.CamerasViewModel
import com.genzo.myhome.ui.sections.doors.viewModel.DoorsViewModel
import kotlinx.coroutines.CoroutineDispatcher

interface ViewModelFactory {
    fun create(): ViewModel
}

class CamerasViewModelFactory(
    private val camerasRemoteDataSource: CamerasRemoteDataSource,
    private val uiDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModelFactory {
    override fun create(): CamerasViewModel {
        return CamerasViewModel(
            camerasRemoteDataSource,
            uiDispatcher,
            ioDispatcher
        )
    }
}

class DoorsViewModelFactory(
    private val doorsRemoteDataSource: DoorsRemoteDataSource,
    private val uiDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModelFactory {
    override fun create(): DoorsViewModel {
        return DoorsViewModel(
            doorsRemoteDataSource,
            uiDispatcher,
            ioDispatcher
        )
    }
}
