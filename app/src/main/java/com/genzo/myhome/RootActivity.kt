package com.genzo.myhome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.genzo.myhome.ui.navigation.Navigation
import com.genzo.myhome.ui.navigation.navGraph
import com.genzo.myhome.ui.theme.MyHomeTheme

class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            MyHomeTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Navigation.HOME.ROOT
                ) {
                    navGraph(
                        navController = navController,
                    )
                }
            }
        }
    }
}
