package theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    darkPurple: Color = colorDarkPurple,
    lightPurple: Color = colorLightPurple,
    blackPurple: Color = colorBlackPurple,
    whitePurple: Color = colorWhitePurple,
) {
    var darkPurple by mutableStateOf(darkPurple)
        private set
    var lightPurple by mutableStateOf(lightPurple)
        private set
    var blackPurple by mutableStateOf(blackPurple)
        private set
    var whitePurple by mutableStateOf(whitePurple)
        private set

    fun copy(
        darkPurple: Color = this.darkPurple,
        lightPurple: Color = this.lightPurple,
        blackPurple: Color = this.blackPurple,
        whitePurple: Color = this.whitePurple,
    ): AppColors = AppColors(
        darkPurple, lightPurple, blackPurple, whitePurple
    )
    fun updateColorsFrom(other: AppColors) {
        darkPurple = other.darkPurple
        lightPurple = other.lightPurple
        blackPurple = other.blackPurple
        whitePurple = other.whitePurple
    }
}

val colorDarkPurple = Color(0xff2f184c)
val colorLightPurple = Color(0xffb464df)
val colorBlackPurple = Color(0xff06000a)
val colorWhitePurple = Color(0xffc9c4e1)

fun colors(
    darkPurple: Color = colorDarkPurple,
    lightPurple: Color = colorLightPurple,
    blackPurple: Color = colorBlackPurple,
    whitePurple: Color = colorWhitePurple,
) = AppColors(
    darkPurple, lightPurple, blackPurple, whitePurple
)

internal val LocalColors = staticCompositionLocalOf { colors() }

