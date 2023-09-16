package com.genzo.myhome.ui.sections.cameras.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.genzo.myhome.R
import com.genzo.myhome.data.datasources.entities.Camera
import com.genzo.myhome.ui.theme.DeepCarminePink
import com.genzo.myhome.ui.theme.MyHomeTheme
import kotlin.math.roundToInt

@Composable
fun CameraItem(
    camera: Camera,
    modifier: Modifier = Modifier
) {
    var offsetX by remember { mutableFloatStateOf(0f) }

    Box(modifier = modifier) {
        Icon(
            painterResource(id = R.drawable.icon_favorite_button),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterEnd),
            tint = MyHomeTheme.colors.onSurface,
        )

        Card(modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), 0) }
            .draggable(
                onDragStarted = {
                    offsetX = 0f
                },
                onDragStopped = {
                    if (offsetX in -65f..65f) offsetX = 0f
                },
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    Log.i("Delta", delta.toString())
                    if (offsetX in -66f..66f) {
                        offsetX += delta
                    }
                }
            )) {
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
}
