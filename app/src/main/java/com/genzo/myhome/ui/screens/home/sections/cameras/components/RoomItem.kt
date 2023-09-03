package com.genzo.myhome.ui.screens.home.sections.cameras.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.genzo.myhome.data.entities.Camera

@Composable
fun RoomItem(
    title: String,
    modifier: Modifier = Modifier,
    cameras: List<Camera>
) {
    Column(modifier = modifier) {
        Title(title = title)

        for (camera in cameras) {
            Text(text = camera.name)
        }
    }
}

@Composable
private fun Title(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(text = title, modifier = modifier)
}