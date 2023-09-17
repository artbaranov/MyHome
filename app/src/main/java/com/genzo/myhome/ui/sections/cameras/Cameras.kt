package com.genzo.myhome.ui.sections.cameras

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.genzo.myhome.ui.sections.cameras.components.CameraItem
import com.genzo.myhome.ui.sections.cameras.components.RoomItem
import com.genzo.myhome.ui.sections.cameras.viewModel.CamerasViewModel


@Composable
fun CamerasSection(
    viewModel: CamerasViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.viewState.observeAsState()
    val rooms = uiState.value?.rooms ?: emptyList()
    val cameras = uiState.value?.standaloneCameras ?: emptyList()

    Column(modifier = modifier) {
        LazyColumn {
            items(items = rooms) { room ->
                RoomItem(
                    title = room.title,
                    cameras = room.cameras,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }

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

@Preview
@Composable
private fun CamerasList_Preview_DayMode() {
//    CamerasSection()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CamerasList_Preview_NightMode() {
//    CamerasSection()
}
