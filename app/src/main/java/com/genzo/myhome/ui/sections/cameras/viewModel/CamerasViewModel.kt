package com.genzo.myhome.ui.sections.cameras.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.datasources.CamerasRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class CamerasViewModel(
    private val camerasRemoteDataSource: CamerasRemoteDataSource,
    private val uiDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState: MutableLiveData<CamerasUiState> = MutableLiveData(CamerasUiState())
    val viewState: LiveData<CamerasUiState> = _uiState

    init {
        getCameras()
    }

    private fun getCameras() {
        viewModelScope.launch(ioDispatcher) {
            val response = camerasRemoteDataSource.sendRequest()

            if (!response.success) return@launch

            viewModelScope.launch(uiDispatcher) {
                _uiState.postValue(CamerasUiState(standaloneCameras = response.data.cameras))
            }
        }
    }
}
