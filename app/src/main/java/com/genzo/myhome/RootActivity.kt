package com.genzo.myhome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.genzo.myhome.ui.navigation.Navigation
import com.genzo.myhome.ui.navigation.navGraph
import com.genzo.myhome.ui.theme.MyHomeTheme

@OptIn(ExperimentalMaterial3Api::class)
class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyHomeTheme {
                val navController = rememberNavController()

                Scaffold(topBar = {
                    Title(
                        title = stringResource(id = R.string.Home_Title),
                        modifier = Modifier.fillMaxWidth()
                    )
                }, content = {
                    NavHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        startDestination = Navigation.HOME.ROOT
                    ) {
                        navGraph(
                            navController = navController,
                        )
                    }
                })
            }
        }
    }
}

@Composable
private fun Title(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        text = title,
        modifier = modifier,
        style = MyHomeTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
}
