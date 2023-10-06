package dev.lizainslie.saku.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

expect val bellota: FontFamily

expect val bellotaText: FontFamily

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
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = colorDark,
    ),
)

internal val LocalTypography = staticCompositionLocalOf { SakuTypography() }