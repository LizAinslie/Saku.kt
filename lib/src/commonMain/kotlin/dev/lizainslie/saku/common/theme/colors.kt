package dev.lizainslie.saku.common.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class SakuColors(
    primary: Color = colorPink100,
    secondary: Color = colorPurple200,
    background: Color = colorDark,
    foreground: Color = colorLight,
    danger: Color = colorRed130
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

// Blackest purple
val colorDark = Color(0xff180029)
// Lightest purple - close to white
val colorLight = Color(0xffc9c4e1)

// Primary pink
val colorPink100 = Color(0xffb464df)
val colorPink110 = Color(0xffad56dc)
val colorPink200 = Color(0xff491566)

// Dark secondary purple
val colorPurple200 = Color(0xff3a1d5d)
val colorPurple210 = Color(0xff30184e)

// Red
val colorRed130 = Color(0xffb94860)
val colorRed140 = Color(0xffb1435b)
val colorRed200 = Color(0xff59222e)

// Yellow
val colorYellow90 = Color(0xffffcd5c)
val colorYellow100 = Color(0xffffc847)
val colorYellow190 = Color(0xff8f6400)

// Green
val colorGreen120 = Color(0xff5fbaaf)
val colorGreen130 = Color(0xff54b6aa)
val colorGreen200 = Color(0xff255650)

// Blue
val colorBlue100 = Color(0xff4d79f2)
val colorBlue110 = Color(0xff4170f1)
val colorBlue200 = Color(0xff092572)

fun colors(
    primary: Color = colorPink100,
    secondary: Color = colorPurple200,
    background: Color = colorDark,
    foreground: Color = colorLight,
    danger: Color = colorRed130
) = SakuColors(
    primary, secondary, background, foreground, danger
)

internal val LocalColors = staticCompositionLocalOf { colors() }

