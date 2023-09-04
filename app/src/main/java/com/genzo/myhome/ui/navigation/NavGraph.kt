package com.genzo.myhome.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.genzo.myhome.data.entities.Camera
import com.genzo.myhome.data.entities.Room
import com.genzo.myhome.ui.screens.home.sections.cameras.CamerasSection
import com.genzo.myhome.ui.screens.home.sections.doors.DoorsSection

fun NavGraphBuilder.navGraph() {
    composable(Screen.CAMERAS.route) {
        CamerasSection(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 21.dp),
            rooms = rooms
        )
    }

    composable(Screen.DOORS.route) {
        DoorsSection(modifier = Modifier.fillMaxSize())
    }
}

private val cameras = listOf(
    Camera(
        name = "Camera 1",
        snapshot = "Snapshot 1",
        room = "Room 1",
        id = 1,
        favorites = true,
        rec = true
    ),
    Camera(
        name = "Camera 2",
        snapshot = "Snapshot 2",
        room = "Room 1",
        id = 2,
        favorites = true,
        rec = true
    ),
    Camera(
        name = "Camera 3",
        snapshot = "Snapshot 3",
        room = "Room 1",
        id = 3,
        favorites = true,
        rec = true
    ),
    Camera(
        name = "Camera 4",
        snapshot = "Snapshot 4",
        room = "Room 1",
        id = 4,
        favorites = true,
        rec = true
    )
)

private val rooms = listOf(
    Room(title = "First room", cameras = cameras),
    Room(title = "Second room", cameras = cameras),
    Room(title = "Third room", cameras = cameras),
    Room(title = "Fourth room", cameras = cameras),
    Room(title = "Fifth room", cameras = cameras),
    Room(title = "Sixth room", cameras = cameras),
    Room(title = "Seventh room", cameras = cameras),
)
