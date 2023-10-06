package dev.lizainslie.saku.common.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

private val cache: MutableMap<String, Font> = mutableMapOf()

@OptIn(ExperimentalResourceApi::class)
internal fun font(res: String, weight: FontWeight, style: FontStyle): Font {
    return cache.getOrPut(res) {
        val byteArray = runBlocking {
            try {
                resource("$res.ttf").readBytes()
            } catch (e: Exception) {
                resource("$res.otf").readBytes()
            }
        }
        Font(res, byteArray, weight, style)
    }
}

actual val bellotaText = FontFamily(
    font( "font/bellota_text_regular.ttf", FontWeight.Normal, FontStyle.Normal),
    font( "font/bellota_text_italic.ttf", FontWeight.Normal, FontStyle.Italic),
    font( "font/bellota_text_bold.ttf", FontWeight.Bold, FontStyle.Normal),
    font( "font/bellota_text_bold_italic.ttf", FontWeight.Bold, FontStyle.Italic),
    font( "font/bellota_text_light.ttf", FontWeight.Light, FontStyle.Normal),
    font( "font/bellota_text_light_italic.ttf", FontWeight.Light, FontStyle.Italic),
)

actual val bellota = FontFamily(
    font( "font/bellota_regular.ttf", FontWeight.Normal, FontStyle.Normal),
    font( "font/bellota_italic.ttf", FontWeight.Normal, FontStyle.Italic),
    font( "font/bellota_bold.ttf", FontWeight.Bold, FontStyle.Normal),
    font( "font/bellota_bold_italic.ttf", FontWeight.Bold, FontStyle.Italic),
    font( "font/bellota_light.ttf", FontWeight.Light, FontStyle.Normal),
    font( "font/bellota_light_italic.ttf", FontWeight.Light, FontStyle.Italic),
)