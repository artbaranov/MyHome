package com.genzo.myhome.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.genzo.myhome.ui.sections.CamerasSection
import com.genzo.myhome.ui.sections.DoorsSection

fun NavGraphBuilder.navGraph() {
    composable(Screen.CAMERAS.route) {
        CamerasSection(modifier = Modifier.fillMaxSize())
    }

    composable(Screen.DOORS.route) {
        DoorsSection(modifier = Modifier.fillMaxSize())
    }
}
