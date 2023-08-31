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
    foreground: Color = colorLight
) {
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var background by mutableStateOf(background)
        private set
    var foreground by mutableStateOf(foreground)
        private set

    fun copy(
        darkPurple: Color = this.secondary,
        lightPurple: Color = this.primary,
        blackPurple: Color = this.background,
        whitePurple: Color = this.foreground,
    ): SakuColors = SakuColors(
        darkPurple, lightPurple, blackPurple, whitePurple,
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
val colorDark = Color(0xff06000a)
// Lightest purple - close to white
val colorLight = Color(0xffc9c4e1)

// Dark secondary purple
val colorMutedPurple = Color(0xff2f184c)

fun colors(
    primary: Color = colorPink,
    secondary: Color = colorMutedPurple,
    background: Color = colorDark,
    foreground: Color = colorLight,
) = SakuColors(
    primary, secondary, background, foreground
)

internal val LocalColors = staticCompositionLocalOf { colors() }

