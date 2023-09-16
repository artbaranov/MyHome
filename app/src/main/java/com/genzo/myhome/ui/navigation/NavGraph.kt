package com.genzo.myhome.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.genzo.myhome.ui.sections.cameras.CamerasSection
import com.genzo.myhome.ui.sections.doors.DoorsSection

fun NavGraphBuilder.navGraph() {
    composable(Screen.CAMERAS.route) {
        CamerasSection(
            viewModel = hiltViewModel(),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 21.dp),
        )
    }

    composable(Screen.DOORS.route) {
        DoorsSection(
            viewModel = hiltViewModel(),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 21.dp),
        )
    }
}
