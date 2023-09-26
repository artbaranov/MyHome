package com.genzo.myhome.ui.activity.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.genzo.myhome.R
import com.genzo.myhome.ui.extensions.bottomBorder
import com.genzo.myhome.ui.navigation.Screen
import com.genzo.myhome.ui.theme.MyHomeTheme

@Composable
fun TopBar(
    navController: NavController,
    navigationItems: List<Screen>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Title(
            title = stringResource(id = R.string.Home_Title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )

        NavigationBar(navController = navController, navigationItems = navigationItems)
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
        textAlign = TextAlign.Center,
        color = MyHomeTheme.colors.onPrimary,
    )
}

@Composable
private fun NavigationBar(
    navController: NavController,
    navigationItems: List<Screen>,
    modifier: Modifier = Modifier
) {
    NavigationItemsRow(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        navigationItems.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

            NavigationItem(
                modifier = Modifier.weight(1f),
                label = stringResource(screen.title),
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
private fun NavigationItemsRow(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceAround,
            content = content
        )
    }
}

@Composable
private fun NavigationItem(
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val bottomBorderModifier = if (selected) {
        modifier.bottomBorder(1.dp, Color.Blue)
    } else {
        modifier.bottomBorder(1.dp, Color.Gray.copy(0.1f))
    }

    Text(
        modifier = bottomBorderModifier
            .selectable(
                selected = selected,
                onClick = onClick,
                indication = null,
                interactionSource = interactionSource,
            )
            .padding(vertical = 10.dp),
        text = label,
        style = MyHomeTheme.typography.titleMedium,
        textAlign = TextAlign.Center,
        color = MyHomeTheme.colors.onPrimary,
    )
}
