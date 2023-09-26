package com.genzo.myhome.ui.sections.cameras

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.genzo.myhome.ui.sections.cameras.components.CameraItem
import com.genzo.myhome.ui.sections.cameras.viewModel.CamerasViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun CamerasSection(
    viewModel: CamerasViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.viewState.observeAsState()
    val cameras = uiState.value?.standaloneCameras ?: emptyList()
    val camerasLoading = uiState.value?.camerasLoading ?: false

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = camerasLoading)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = viewModel::getCameras,
        modifier = modifier
    ) {
        LazyColumn {

            items(cameras) { camera ->
                CameraItem(
                    camera = camera,
                    modifier = Modifier
                        .height(280.dp)
                        .fillMaxWidth()
                        .padding(vertical = 11.dp),
                    onToFavoritesClicked = viewModel::updateCameraFavoriteField
                )
            }

        }
    }
}
