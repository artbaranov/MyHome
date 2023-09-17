package com.genzo.myhome.ui.sections.cameras.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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

enum class DragAnchors {
    Start,
    Center,
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CameraItem(
    camera: Camera,
    modifier: Modifier = Modifier,
    onToFavoritesClicked: (Camera) -> Unit,
) {
    val state = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors.Center,
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { 50f },
            animationSpec = tween(),
        ).apply {
            updateAnchors(
                DraggableAnchors {
                    DragAnchors.Start at -150f
                    DragAnchors.Center at 0f
                }
            )
        }
    }
    Box(modifier = modifier) {
        val interactionSource = remember { MutableInteractionSource() }

        Icon(
            painter = if (camera.favorites) {
                painterResource(id = R.drawable.icon_favorite_filled_button)
            } else {
                painterResource(id = R.drawable.icon_favorite_unfilled_button)
            },
            contentDescription = null,
            tint = MyHomeTheme.colors.onSurface,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable(
                    indication = null,
                    enabled = true, interactionSource = interactionSource
                ) {
                    onToFavoritesClicked(camera)
                },
        )

        Card(
            modifier = Modifier
                .offset {
                    IntOffset(
                        x = state
                            .requireOffset()
                            .roundToInt(),
                        y = 0,
                    )
                }
                .anchoredDraggable(state, Orientation.Horizontal)
        ) {
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

                if (camera.recording) {
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
                        .padding(end = 28.dp),
                    tint = MyHomeTheme.colors.onSurfaceVariant3,
                )
            }
        }
    }
}
