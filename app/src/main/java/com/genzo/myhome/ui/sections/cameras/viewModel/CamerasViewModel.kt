package com.genzo.myhome.ui.sections.cameras.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.data.repositories.CamerasRepository
import com.genzo.myhome.di.IoDispatcher
import com.genzo.myhome.di.MainDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val camerasRepository: CamerasRepository,
    @MainDispatcher private val uiDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState: MutableLiveData<CamerasUiState> = MutableLiveData(CamerasUiState())
    val viewState: LiveData<CamerasUiState> = _uiState

    init {
        getCameras()
    }

    fun updateCameraFavoriteField(camera: Camera) {
        val cameras = _uiState.value?.standaloneCameras?.toMutableList()
        val cameraBeingUpdated = cameras?.find { it == camera } ?: return
        val cameraBeingUpdatedIndex = cameras.indexOf(cameraBeingUpdated)
        val updatedCamera = cameraBeingUpdated.copy(favorite = !cameraBeingUpdated.favorite)

        cameras[cameraBeingUpdatedIndex] = updatedCamera

        viewModelScope.launch(ioDispatcher) {
            camerasRepository.updateCamera(updatedCamera)

            updateUiStateWith(cameras)
        }
    }

    fun getCameras() {
        viewModelScope.launch(ioDispatcher) {
            _uiState.postValue(_uiState.value?.copy(camerasLoading = true))

            val cameras = camerasRepository.provideCameras()

            updateUiStateWith(cameras)
        }
    }

    private fun updateUiStateWith(cameras: List<Camera>) {
        viewModelScope.launch(uiDispatcher) {
            _uiState.postValue(CamerasUiState(standaloneCameras = cameras, camerasLoading = false))

        }
    }
}
