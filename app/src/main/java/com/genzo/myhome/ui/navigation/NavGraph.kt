package com.genzo.myhome.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.genzo.myhome.ui.screens.home.HomeScreen

fun NavGraphBuilder.navGraph(
    navController: NavController
) {
    composable(Navigation.HOME.ROOT) {
        HomeScreen()
    }
}