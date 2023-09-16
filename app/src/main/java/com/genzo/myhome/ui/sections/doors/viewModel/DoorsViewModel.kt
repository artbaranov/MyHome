package com.genzo.myhome.ui.sections.doors.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genzo.myhome.data.providers.DoorsProvider
import com.genzo.myhome.di.IoDispatcher
import com.genzo.myhome.di.MainDispatcher
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

    private fun getDoors() {
        viewModelScope.launch(ioDispatcher) {
            val doors = doorsProvider.provideDoors()

            viewModelScope.launch(uiDispatcher) {
                _uiState.postValue(DoorsUiState(standaloneDoors = doors))
            }
        }
    }
}
