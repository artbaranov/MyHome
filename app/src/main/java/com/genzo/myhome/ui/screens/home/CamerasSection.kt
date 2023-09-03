package com.genzo.myhome.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CamerasSection(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

    }
}

@Preview
@Composable
private fun CamerasList_Preview_DayMode() {
    CamerasSection()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CamerasList_Preview_NightMode() {
    CamerasSection()
}