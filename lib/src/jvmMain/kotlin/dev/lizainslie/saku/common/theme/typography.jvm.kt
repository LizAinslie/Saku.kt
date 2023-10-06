package dev.lizainslie.saku.common.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual val bellotaText = FontFamily(
    Font( "font/bellota_text_regular.ttf", FontWeight.Normal, FontStyle.Normal),
    Font( "font/bellota_text_italic.ttf", FontWeight.Normal, FontStyle.Italic),
    Font( "font/bellota_text_bold.ttf", FontWeight.Bold, FontStyle.Normal),
    Font( "font/bellota_text_bold_italic.ttf", FontWeight.Bold, FontStyle.Italic),
    Font( "font/bellota_text_light.ttf", FontWeight.Light, FontStyle.Normal),
    Font( "font/bellota_text_light_italic.ttf", FontWeight.Light, FontStyle.Italic),
)

actual val bellota = FontFamily(
    Font( "font/bellota_regular.ttf", FontWeight.Normal, FontStyle.Normal),
    Font( "font/bellota_italic.ttf", FontWeight.Normal, FontStyle.Italic),
    Font( "font/bellota_bold.ttf", FontWeight.Bold, FontStyle.Normal),
    Font( "font/bellota_bold_italic.ttf", FontWeight.Bold, FontStyle.Italic),
    Font( "font/bellota_light.ttf", FontWeight.Light, FontStyle.Normal),
    Font( "font/bellota_light_italic.ttf", FontWeight.Light, FontStyle.Italic),
)