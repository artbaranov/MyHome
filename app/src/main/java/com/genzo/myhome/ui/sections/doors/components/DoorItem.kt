package com.genzo.myhome.ui.sections.doors.components

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.ui.theme.MyHomeTheme
import kotlin.math.roundToInt

enum class DragAnchors {
    Start,
    Center,
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DoorItem(
    door: Door,
    modifier: Modifier = Modifier,
    onToFavoritesClicked: (Door) -> Unit,
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
                    DragAnchors.Start at -250f
                    DragAnchors.Center at 0f
                }
            )
        }
    }

    Box(modifier = modifier) {
        val interactionSource = remember { MutableInteractionSource() }

        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                painter = painterResource(id = R.drawable.icon_edit_button),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(9.dp))
            Icon(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        enabled = true, interactionSource = interactionSource
                    ) {
                        onToFavoritesClicked(door)
                    },
                painter = if (door.favorites) {
                    painterResource(id = R.drawable.icon_favorite_filled_button)
                } else {
                    painterResource(id = R.drawable.icon_favorite_unfilled_button)
                },
                contentDescription = null,
                tint = MyHomeTheme.colors.onSurface,
            )
        }
        Card(modifier = Modifier
            .offset {
                IntOffset(
                    x = state
                        .requireOffset()
                        .roundToInt(),
                    y = 0,
                )
            }
            .anchoredDraggable(state, Orientation.Horizontal)) {

            Box(modifier = Modifier.weight(1f)) {

                if (!door.snapshot.isNullOrEmpty()) {
                    AsyncImage(
                        model = door.snapshot,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp)
                            .aspectRatio(1f)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.icon_play_button),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center),
                        tint = MyHomeTheme.colors.onSurfaceVariant1
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = door.name,
                        color = MyHomeTheme.colors.onPrimary,
                        style = MyHomeTheme.typography.bodyMedium
                    )
                    if (door.favorites) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_star_filled),
                            contentDescription = null,
                            tint = MyHomeTheme.colors.onSurface,
                        )
                    }
                }

                Icon(
                    painter = painterResource(id = R.drawable.icon_lock),
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
