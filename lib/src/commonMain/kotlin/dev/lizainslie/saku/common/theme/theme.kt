package dev.lizainslie.saku.common.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object SakuTheme {

    val colors: SakuColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: SakuTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: SakuDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SakuTheme(
    colors: SakuColors = SakuTheme.colors,
    typography: SakuTypography = SakuTheme.typography,
    dimensions: SakuDimensions = SakuTheme.dimensions,
    content: @Composable () -> Unit
) {
    // creating a new object for colors to not mutate the initial colors set when updating the values
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography
    ) {
        Box(modifier = Modifier.fillMaxSize().paint(
            painterResource("/img/background.jpg"),
            contentScale = ContentScale.Crop,
        )) { content() }
    }
}