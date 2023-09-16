package com.genzo.myhome.ui.sections.cameras.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.datasources.CamerasRemoteDataSource
import com.genzo.myhome.data.repositories.CamerasLocalRepository
import com.genzo.myhome.di.IoDispatcher
import com.genzo.myhome.di.MainDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val camerasLocalRepository: CamerasLocalRepository,
    private val camerasRemoteDataSource: CamerasRemoteDataSource,
    @MainDispatcher private val uiDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState: MutableLiveData<CamerasUiState> = MutableLiveData(CamerasUiState())
    val viewState: LiveData<CamerasUiState> = _uiState

    init {
        getCameras()
    }

    private fun getCameras() {
        viewModelScope.launch(ioDispatcher) {
            val camerasFromRepository = camerasLocalRepository.getAll()

            if (camerasFromRepository.isEmpty()) {
                val response = camerasRemoteDataSource.sendRequest()

                if (!response.success) return@launch

                viewModelScope.launch(uiDispatcher) {
                    _uiState.postValue(CamerasUiState(standaloneCameras = response.data.cameras))
                }

                camerasLocalRepository.insertAll(response.data.cameras)
            } else {
                viewModelScope.launch(uiDispatcher) {
                    _uiState.postValue(CamerasUiState(standaloneCameras = camerasFromRepository))
                }
            }
        }
    }
}
