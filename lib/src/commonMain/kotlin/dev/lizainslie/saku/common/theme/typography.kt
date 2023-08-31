package dev.lizainslie.saku.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

private val bellota = FontFamily(
    Font("font/Bellota/Bellota-Regular.ttf", FontWeight.Normal, FontStyle.Normal),
    Font("font/Bellota/Bellota-Italic.ttf", FontWeight.Normal, FontStyle.Italic),
    Font("font/Bellota/Bellota-Bold.ttf", FontWeight.Bold, FontStyle.Normal),
    Font("font/Bellota/Bellota-BoldItalic.ttf", FontWeight.Bold, FontStyle.Italic),
    Font("font/Bellota/Bellota-Light.ttf", FontWeight.Light, FontStyle.Normal),
    Font("font/Bellota/Bellota-LightItalic.ttf", FontWeight.Light, FontStyle.Italic),
)

private val bellotaText = FontFamily(
    Font("font/Bellota_Text/BellotaText-Regular.ttf", FontWeight.Normal, FontStyle.Normal),
    Font("font/Bellota_Text/BellotaText-Italic.ttf", FontWeight.Normal, FontStyle.Italic),
    Font("font/Bellota_Text/BellotaText-Bold.ttf", FontWeight.Bold, FontStyle.Normal),
    Font("font/Bellota_Text/BellotaText-BoldItalic.ttf", FontWeight.Bold, FontStyle.Italic),
    Font("font/Bellota_Text/BellotaText-Light.ttf", FontWeight.Light, FontStyle.Normal),
    Font("font/Bellota_Text/BellotaText-LightItalic.ttf", FontWeight.Light, FontStyle.Italic),
)

data class SakuTypography(
    val headingH1: TextStyle = TextStyle(
        fontFamily = bellota,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        color = colorDark,
    ),
    val headingH2: TextStyle = TextStyle(
        fontFamily = bellota,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        color = colorDark,
    ),
    val body: TextStyle = TextStyle(
        fontFamily = bellotaText,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = colorDark,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = bellotaText,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = colorDark,
    ),
)

internal val LocalTypography = staticCompositionLocalOf { SakuTypography() }