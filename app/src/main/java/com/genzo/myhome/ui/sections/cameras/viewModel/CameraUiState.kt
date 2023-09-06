package com.genzo.myhome.ui.sections.cameras.viewModel

import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.data.datasources.entities.Room

data class CamerasUiState(
    val rooms: List<Room> = emptyList(),
    val standaloneCameras: List<Camera> = emptyList()
)
