package com.genzo.myhome.ui.sections.doors.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.repositories.DoorsRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import com.genzo.myhome.data.entities.CameraServiceResponse

class DoorsViewModel(
    private val doorsRemoteDataSource: DoorsRemoteDataSource,
    private val uiDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _uiState: MutableLiveData<DoorsUiState> = MutableLiveData(DoorsUiState())
    val viewState: LiveData<DoorsUiState> = _uiState

    init {
        getCameras()
    }

    private fun getCameras() {
        viewModelScope.launch(ioDispatcher) {
            val doors = doorsRemoteDataSource.sendRequest()

            if (!doors.success) return@launch

            viewModelScope.launch(uiDispatcher) {
                _uiState.postValue(DoorsUiState(standaloneDoors = doors.data))
            }
        }
    }
}
