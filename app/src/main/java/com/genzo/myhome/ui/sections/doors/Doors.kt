package com.genzo.myhome.ui.sections.doors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.genzo.myhome.ui.sections.doors.components.DoorItem
import com.genzo.myhome.ui.sections.doors.components.EditNameDialog
import com.genzo.myhome.ui.sections.doors.viewModel.DoorsViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun DoorsSection(
    viewModel: DoorsViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.viewState.observeAsState()
    val doors = uiState.value?.standaloneDoors ?: emptyList()
    val doorsLoading = uiState.value?.doorsLoading ?: false

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = doorsLoading)

    SwipeRefresh(state = swipeRefreshState, onRefresh = viewModel::getDoors, modifier = modifier) {
        Column {
            LazyColumn {
                items(doors) { door ->
                    DoorItem(
                        door = door,
                        modifier = Modifier
                            .heightIn(72.dp, 289.dp)
                            .fillMaxWidth()
                            .padding(vertical = 11.dp),
                        onToFavoritesClicked = viewModel::updateDoorsFavoriteField,
                        onEditNameClicked = viewModel::editDoor
                    )
                }
            }

            val doorName = uiState.value?.doorName ?: ""

            if (uiState.value?.editNameDialogVisible == true) {
                EditNameDialog(
                    name = doorName,
                    onNameChanged = viewModel::updateDoorName,
                    onDismissRequest = viewModel::hideEditNameDialog,
                    onSaveNewNameRequest = viewModel::saveUpdatedDoor,
                )
            }
        }
    }
}
