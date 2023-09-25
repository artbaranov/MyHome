package com.genzo.myhome.ui.sections.doors.viewModel

import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.data.datasources.entities.Room

data class DoorsUiState(
    val rooms: List<Room> = emptyList(),
    val standaloneDoors: List<Door> = emptyList(),
    val editNameDialogVisible: Boolean = false,
)
