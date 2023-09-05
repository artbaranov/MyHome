package com.genzo.myhome.ui.sections.cameras.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.repositories.CamerasRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class CamerasViewModel(
    private val camerasRepository: CamerasRepository,
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
            val camerasList = camerasRepository.getCameras()

            viewModelScope.launch(uiDispatcher) {
                _uiState.postValue(CamerasUiState(standaloneCameras = camerasList))
            }
        }
    }
}
