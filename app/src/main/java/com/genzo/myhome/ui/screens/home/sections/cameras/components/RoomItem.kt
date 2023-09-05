package com.genzo.myhome.ui.screens.home.sections.cameras.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.genzo.myhome.R
import com.genzo.myhome.data.entities.Camera
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
private fun CameraItem(
    camera: Camera,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Box(modifier = Modifier.weight(1f)) {
            AsyncImage(
                model = camera.snapshot,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            Icon(
                painter = painterResource(id = R.drawable.icon_play_button),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center),
                tint = Color.White
            )

            if (camera.favorites) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_star_filled),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 3.dp, end = 3.dp),
                    tint = Color(0xFFE0BE35),

                    )
            }

            if (camera.rec) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_record_indicator),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 8.dp)
                        .align(Alignment.TopStart),
                    tint = Color.Red
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
        ) {
            Text(
                text = camera.name,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp, top = 22.dp, bottom = 20.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.icon_shield),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(vertical = 26.dp)
                    .padding(end = 28.dp)
            )
        }
    }
}

@Composable
private fun Title(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(text = title, modifier = modifier, style = MyHomeTheme.typography.titleMedium)
}
