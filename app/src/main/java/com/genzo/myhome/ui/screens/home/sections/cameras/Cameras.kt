package com.genzo.myhome.ui.screens.home.sections.cameras

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.genzo.myhome.data.entities.Room
import com.genzo.myhome.ui.screens.home.sections.cameras.components.RoomItem

@Composable
fun CamerasSection(modifier: Modifier = Modifier, rooms: List<Room>) {
    LazyColumn(modifier = modifier) {
        items(rooms) { room ->
            RoomItem(
                title = room.title,
                cameras = room.cameras,
                modifier = Modifier.fillMaxWidth(),
            )
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
