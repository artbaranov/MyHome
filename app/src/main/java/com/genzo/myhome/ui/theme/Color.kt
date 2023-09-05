package com.genzo.myhome.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

val Color.Companion.Gray20: Color
    get() = Color(red = 51, green = 51, blue = 51)

val Color.Companion.Mustard: Color
    get() = Color(0xFFE0BE35)

val Color.Companion.DeepCarminePink: Color
    get() = Color(0xFFFA3030)

class MyHomeColors(
    onPrimary: Color,
    onSurface: Color,
    onSurfaceVariant1: Color,
    onSurfaceVariant2: Color,
    lightThemeEnabled: Boolean
) {
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        internal set

    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set

    var onSurfaceVariant1 by mutableStateOf(onSurfaceVariant1, structuralEqualityPolicy())
        internal set

    var onSurfaceVariant2 by mutableStateOf(onSurfaceVariant2, structuralEqualityPolicy())
        internal set

    var lightThemeEnabled by mutableStateOf(lightThemeEnabled, structuralEqualityPolicy())
        internal set

    fun copy(
        onPrimary: Color = this.onPrimary,
        onSurface: Color = this.onSurface,
        onSurfaceVariant1: Color = this.onSurfaceVariant1,
        onSurfaceVariant2: Color = this.onSurfaceVariant2,
        lightThemeEnabled: Boolean = this.lightThemeEnabled,
    ): MyHomeColors = MyHomeColors(
        onPrimary,
        onSurface,
        onSurfaceVariant1,
        onSurfaceVariant2,
        lightThemeEnabled,
    )
}

internal fun myHomeLightColors(): MyHomeColors = MyHomeColors(
    onPrimary = Color.Gray20,
    onSurface = Color.Mustard,
    onSurfaceVariant1 = Color.White,
    onSurfaceVariant2 = Color.DeepCarminePink,
    lightThemeEnabled = true
)

internal fun myHomeDarkColors(): MyHomeColors = MyHomeColors(
    onPrimary = Color.Gray20,
    onSurface = Color.Mustard,
    onSurfaceVariant1 = Color.White,
    onSurfaceVariant2 = Color.DeepCarminePink,
    lightThemeEnabled = false
)
