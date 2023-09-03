package com.genzo.myhome.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.genzo.myhome.ui.screens.home.CamerasSection
import com.genzo.myhome.ui.screens.home.DoorsSection

fun NavGraphBuilder.navGraph(
    navController: NavController
) {
    composable(Screen.CAMERAS.route) {
        CamerasSection()
    }

    composable(Screen.DOORS.route) {
        DoorsSection()
    }
}
