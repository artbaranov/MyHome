package com.genzo.myhome.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf


private val DarkColorPalette = myHomeDarkColors()

private val LightColorPalette = myHomeLightColors()

internal val LocalReplacementColors = staticCompositionLocalOf {
    LightColorPalette
}

object MyHomeTheme {

    val colors: MyHomeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalReplacementColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MyHomeTypography

}

@Composable
fun MyHomeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(
        LocalReplacementColors provides colors
    ) {
        MaterialTheme(
            content = content
        )
    }
}
