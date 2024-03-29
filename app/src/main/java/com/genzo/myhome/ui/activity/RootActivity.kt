package com.genzo.myhome.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.genzo.myhome.ui.activity.components.TopBar
import com.genzo.myhome.ui.navigation.Screen
import com.genzo.myhome.ui.navigation.navGraph
import com.genzo.myhome.ui.theme.MyHomeTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent()
    }

    private fun setContent() {
        setContent {
            MyHomeTheme {
                val navController = rememberNavController()

                val navigationItems = listOf(
                    Screen.CAMERAS,
                    Screen.DOORS,
                )

                Scaffold(topBar = {
                    TopBar(
                        navController = navController,
                        navigationItems = navigationItems
                    )
                }, content = {
                    NavHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        startDestination = Screen.CAMERAS.route
                    ) {
                        navGraph()
                    }
                })
            }
        }
    }
}
