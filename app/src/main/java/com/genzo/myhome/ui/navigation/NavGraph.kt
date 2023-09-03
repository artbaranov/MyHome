package com.genzo.myhome.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.navGraph(
    navController: NavController
) {
    composable(Screen.CAMERAS.route) {
        CamerasScreen()
    }

    composable(Screen.DOORS.route) {
        DoorsScreen()
    }
}

@Composable
fun CamerasScreen() {
    Text("This is camera screen")
}

@Composable
fun DoorsScreen() {
    Text("This is doors screen")
}

