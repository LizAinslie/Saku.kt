package dev.lizainslie.saku.common.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class SakuColors(
    primary: Color = colorPink,
    secondary: Color = colorMutedPurple,
    background: Color = colorDark,
    foreground: Color = colorLight,
    danger: Color = colorRedBackground
) {
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var background by mutableStateOf(background)
        private set
    var foreground by mutableStateOf(foreground)
        private set
    var danger by mutableStateOf(danger)
        private set

    fun copy(
        primary: Color = this.primary,
        secondary: Color = this.secondary,
        background: Color = this.background,
        foreground: Color = this.foreground,
        danger: Color = this.danger,
    ): SakuColors = SakuColors(
        primary, secondary, background, foreground, danger
    )
    fun updateColorsFrom(other: SakuColors) {
        secondary = other.secondary
        primary = other.primary
        background = other.background
        foreground = other.foreground
    }
}

////////// BASE COLORS /////////

// Primary pink
val colorPink = Color(0xffb464df)
// Blackest purple
val colorDark = Color(0xff180029) // Color(0xff06000a)
// Lightest purple - close to white
val colorLight = Color(0xffc9c4e1)
// Dark secondary purple
val colorMutedPurple = Color(0xff3a1d5d)
// Red
val colorRedBackground = Color(0xffb94860)

fun colors(
    primary: Color = colorPink,
    secondary: Color = colorMutedPurple,
    background: Color = colorDark,
    foreground: Color = colorLight,
    danger: Color = colorRedBackground
) = SakuColors(
    primary, secondary, background, foreground, danger
)

internal val LocalColors = staticCompositionLocalOf { colors() }

