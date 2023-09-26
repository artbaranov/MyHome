package com.genzo.myhome.ui.sections.doors.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.genzo.myhome.ui.theme.MyHomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNameDialog(
    name: String,
    onNameChanged: (String) -> Unit,
    onDismissRequest: () -> Unit,
    onSaveNewNameRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        content = {
            Surface(
                color = MyHomeTheme.colors.onSurface,
                modifier = Modifier.padding(16.dp)
            ) {
                Column {
                    TextField(modifier = Modifier.fillMaxWidth(), value = name, onValueChange = onNameChanged)

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        Button(
                            onClick = onDismissRequest,
                        ) {
                            Text("Close")
                        }

                        Button(
                            onClick = onSaveNewNameRequest,
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    )
}
