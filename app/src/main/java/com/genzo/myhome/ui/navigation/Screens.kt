package com.genzo.myhome.ui.navigation

import androidx.annotation.StringRes
import com.genzo.myhome.R

sealed class Screen(val route: String, @StringRes val title: Int) {
    data object CAMERAS : Screen(CAMERAS_ROUTE, R.string.Home_NavigationItem_Cameras)
    data object DOORS : Screen(DOORS_ROUTE, R.string.Home_NavigationItem_Doors)
}

const val CAMERAS_ROUTE = "CAMERAS"
const val DOORS_ROUTE = "DOORS"
