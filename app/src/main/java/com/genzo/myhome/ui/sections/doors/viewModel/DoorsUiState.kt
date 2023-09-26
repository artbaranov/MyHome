package com.genzo.myhome.ui.sections.doors.viewModel

import com.genzo.myhome.data.datasources.entities.Door

data class DoorsUiState(
    val standaloneDoors: List<Door> = emptyList(),
    val editNameDialogVisible: Boolean = false,
    val doorName: String = "",
    val doorsLoading: Boolean = false,
)
