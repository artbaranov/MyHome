package com.genzo.myhome.ui.sections.cameras.viewModel

import com.genzo.myhome.data.datasources.entities.Camera

data class CamerasUiState(
    val standaloneCameras: List<Camera> = emptyList(),
    val camerasLoading: Boolean = false,
)
