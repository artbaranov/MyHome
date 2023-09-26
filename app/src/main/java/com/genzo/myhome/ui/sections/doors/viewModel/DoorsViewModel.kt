package com.genzo.myhome.ui.sections.doors.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.data.repositories.DoorsRepository
import com.genzo.myhome.di.IoDispatcher
import com.genzo.myhome.di.MainDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val doorsRepository: DoorsRepository,
    @MainDispatcher private val uiDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _uiState: MutableLiveData<DoorsUiState> = MutableLiveData(DoorsUiState())
    val viewState: LiveData<DoorsUiState> = _uiState

    private var doorBeingEdited: Door? = null

    init {
        getDoors()
    }

    fun updateDoorsFavoriteField(door: Door) {
        val doors = _uiState.value?.standaloneDoors?.toMutableList()
        val doorBeingUpdated = doors?.find { it.id == door.id } ?: return
        val doorBeingUpdatedIndex = doors.indexOf(doorBeingUpdated)
        val updatedDoor = doorBeingUpdated.copy(favorites = !doorBeingUpdated.favorites)

        doors[doorBeingUpdatedIndex] = updatedDoor

        viewModelScope.launch(ioDispatcher) {
            doorsRepository.updateDoor(updatedDoor)

            updateUiStateWith(doors)
        }
    }

    fun editDoor(door: Door) {
        val updatedUiState = _uiState.value?.copy(editNameDialogVisible = true, doorName = door.name)
        doorBeingEdited = door

        _uiState.value = updatedUiState
    }

    fun hideEditNameDialog() {
        val updatedUiState = _uiState.value?.copy(editNameDialogVisible = false)

        _uiState.value = updatedUiState
    }

    fun updateDoorName(name: String) {
        val updatedUiState = _uiState.value?.copy(doorName = name)

        _uiState.value = updatedUiState
    }

    fun saveUpdatedDoor() {
        val newDoorName = _uiState.value?.doorName ?: return
        val updatedDoor = doorBeingEdited?.copy(name = newDoorName) ?: return

        viewModelScope.launch(ioDispatcher) {
            doorsRepository.updateDoor(updatedDoor)

            viewModelScope.launch(uiDispatcher) {
                updateUiStateWith(updatedDoor)
            }
        }

        hideEditNameDialog()
        doorBeingEdited = null
    }

    private fun updateUiStateWith(door: Door) {
        val doors = _uiState.value?.standaloneDoors?.toMutableList()
        val doorBeingUpdated = doors?.find { it.id == door.id } ?: return
        val doorBeingUpdatedIndex = doors.indexOf(doorBeingUpdated)

        doors[doorBeingUpdatedIndex] = door

        updateUiStateWith(doors)
    }

    private fun getDoors() {
        viewModelScope.launch(ioDispatcher) {
            val doors = doorsRepository.provideDoors()

            updateUiStateWith(doors)
        }
    }

    private fun updateUiStateWith(doors: List<Door>) {
        viewModelScope.launch(uiDispatcher) {
            _uiState.postValue((DoorsUiState(standaloneDoors = doors)))
        }
    }
}
