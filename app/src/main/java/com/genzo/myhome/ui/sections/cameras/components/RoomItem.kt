package com.genzo.myhome.ui.sections.cameras.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.genzo.myhome.data.entities.Camera
import com.genzo.myhome.ui.sections.cameras.components.CameraItem
import com.genzo.myhome.ui.theme.MyHomeTheme

@Composable
fun RoomItem(
    title: String,
    modifier: Modifier = Modifier,
    cameras: List<Camera>
) {
    Title(title = title, modifier = Modifier.padding(top = 16.dp))

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        for (camera in cameras) {
            CameraItem(
                camera = camera,
                modifier = Modifier
                    .height(280.dp)
                    .fillMaxWidth()
                    .padding(vertical = 11.dp),
            )
        }
    }
}

@Composable
private fun Title(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier = modifier,
        style = MyHomeTheme.typography.titleSmall,
        color = MyHomeTheme.colors.onPrimary
    )
}
