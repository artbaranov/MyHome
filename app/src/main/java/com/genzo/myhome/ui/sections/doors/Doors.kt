package com.genzo.myhome.ui.sections.doors

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.genzo.myhome.ui.sections.cameras.components.RoomItem
import com.genzo.myhome.ui.sections.doors.components.DoorItem
import com.genzo.myhome.ui.sections.doors.viewModel.DoorsViewModel

@Composable
fun DoorsSection(
    viewModel: DoorsViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.viewState.observeAsState()
    val rooms = uiState.value?.rooms ?: emptyList()
    val doors = uiState.value?.standaloneDoors ?: emptyList()

    Column(modifier = modifier) {
        LazyColumn {
            items(rooms) { room ->
                RoomItem(
                    title = room.title,
                    cameras = room.cameras,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }

        LazyColumn {
            items(doors) { door ->
                DoorItem(
                    door = door,
                    modifier = Modifier
                        .heightIn(72.dp, 289.dp)
                        .fillMaxWidth()
                        .padding(vertical = 11.dp),
                )
            }
        }
    }
}

@Preview
@Composable
private fun CamerasList_Preview_DayMode() {
//    DoorsSection()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CamerasList_Preview_NightMode() {
//    DoorsSection()
}
