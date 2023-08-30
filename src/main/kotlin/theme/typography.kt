package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

private val bellota = FontFamily(
    Font("font/Bellota/Bellota-Regular.ttf", FontWeight.Normal, FontStyle.Normal),
    Font("font/Bellota/Bellota-Italic", FontWeight.Normal, FontStyle.Italic),
    Font("font/Bellota/Bellota-Bold", FontWeight.Bold, FontStyle.Normal),
    Font("font/Bellota/Bellota-BoldItalic", FontWeight.Bold, FontStyle.Italic),
    Font("font/Bellota/Bellota-Light", FontWeight.Light, FontStyle.Normal),
    Font("font/Bellota/Bellota-LightItalic", FontWeight.Light, FontStyle.Italic),
)

private val bellotaText = FontFamily(
    Font("font/Bellota_Text/BellotaText-Regular.ttf", FontWeight.Normal, FontStyle.Normal),
    Font("font/Bellota_Text/BellotaText-Italic", FontWeight.Normal, FontStyle.Italic),
    Font("font/Bellota_Text/BellotaText-Bold", FontWeight.Bold, FontStyle.Normal),
    Font("font/Bellota_Text/BellotaText-BoldItalic", FontWeight.Bold, FontStyle.Italic),
    Font("font/Bellota_Text/BellotaText-Light", FontWeight.Light, FontStyle.Normal),
    Font("font/Bellota_Text/BellotaText-LightItalic", FontWeight.Light, FontStyle.Italic),
)

data class AppTypography(
    val headingH1: TextStyle = TextStyle(
        fontFamily = bellota,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        color = colorWhitePurple,
    ),
    val headingH2: TextStyle = TextStyle(
        fontFamily = bellota,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        color = colorWhitePurple,
    ),
    val body: TextStyle = TextStyle(
        fontFamily = bellotaText,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = colorWhitePurple,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = bellota,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = colorWhitePurple,
    ),
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }