package com.genzo.myhome.ui.sections.doors.viewModel

import com.genzo.myhome.data.entities.Door
import com.genzo.myhome.data.entities.Room

data class DoorsUiState(
    val rooms: List<Room> = emptyList(),
    val standaloneDoors: List<Door> = emptyList()
)
