package com.genzo.myhome.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.genzo.myhome.ui.sections.cameras.CamerasSection
import com.genzo.myhome.ui.sections.cameras.viewModel.CamerasViewModel
import com.genzo.myhome.ui.sections.doors.DoorsSection
import com.genzo.myhome.ui.sections.doors.viewModel.DoorsViewModel

fun NavGraphBuilder.navGraph(
    camerasViewModel: CamerasViewModel,
    doorsViewModel: DoorsViewModel,
) {
    composable(Screen.CAMERAS.route) {
        CamerasSection(
            viewModel = camerasViewModel,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 21.dp),
        )
    }

    composable(Screen.DOORS.route) {
        DoorsSection(
            viewModel = doorsViewModel,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 21.dp),
        )
    }
}
