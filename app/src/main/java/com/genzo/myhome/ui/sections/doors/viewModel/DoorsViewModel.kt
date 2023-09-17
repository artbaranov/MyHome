package com.genzo.myhome.ui.sections.doors.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.data.providers.DoorsProvider
import com.genzo.myhome.di.IoDispatcher
import com.genzo.myhome.di.MainDispatcher
import com.genzo.myhome.ui.sections.cameras.viewModel.CamerasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val doorsProvider: DoorsProvider,
    @MainDispatcher
    private val uiDispatcher: CoroutineDispatcher,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _uiState: MutableLiveData<DoorsUiState> = MutableLiveData(DoorsUiState())
    val viewState: LiveData<DoorsUiState> = _uiState

    init {
        getDoors()
    }

    fun updateDoorsFavoriteField(door: Door) {
        val doors = _uiState.value?.standaloneDoors?.toMutableList()

        val doorBeingUpdated = doors?.find { it == door } ?: return

        val cameraBeingUpdatedIndex = doors.indexOf(doorBeingUpdated)

        val updatedCamera = doorBeingUpdated.copy(favorites = !doorBeingUpdated.favorites)

        doors[cameraBeingUpdatedIndex] = updatedCamera

        viewModelScope.launch(ioDispatcher) {
            doorsProvider.updateDoor(updatedCamera)

            updateUiStateWith(doors)
        }
    }

    private fun getDoors() {
        viewModelScope.launch(ioDispatcher) {
            val doors = doorsProvider.provideDoors()

            updateUiStateWith(doors)
        }
    }

    private fun updateUiStateWith(doors: List<Door>) {
        viewModelScope.launch(uiDispatcher) {
            _uiState.postValue(DoorsUiState(standaloneDoors = doors))
        }
    }
}
