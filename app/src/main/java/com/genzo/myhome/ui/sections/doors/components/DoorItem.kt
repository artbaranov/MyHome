package com.genzo.myhome.ui.sections.doors.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import com.genzo.myhome.data.datasources.entities.Door
import com.genzo.myhome.ui.theme.MyHomeTheme

@Composable
fun DoorItem(
    door: Door,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
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
