package com.genzo.myhome.ui.sections

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DoorsSection(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("This is doors screen")
    }
}

@Preview
@Composable
private fun CamerasList_Preview_DayMode() {
    DoorsSection()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CamerasList_Preview_NightMode() {
    DoorsSection()
}