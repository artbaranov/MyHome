package com.genzo.myhome.ui.sections.cameras.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.genzo.myhome.ui.theme.DeepCarminePink
import com.genzo.myhome.ui.theme.MyHomeTheme

@Composable
fun CameraItem(
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
                tint = MyHomeTheme.colors.onSurfaceVariant1
            )

            if (camera.favorites) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_star_filled),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 3.dp, end = 3.dp),
                    tint = MyHomeTheme.colors.onSurface,
                )
            }

            if (camera.rec) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_record_indicator),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, start = 8.dp)
                        .align(Alignment.TopStart),
                    tint = Color.DeepCarminePink
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
                    .padding(start = 16.dp, top = 22.dp, bottom = 20.dp),
                color = MyHomeTheme.colors.onPrimary,
                style = MyHomeTheme.typography.bodyMedium
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