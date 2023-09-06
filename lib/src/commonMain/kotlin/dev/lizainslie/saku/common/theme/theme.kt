package dev.lizainslie.saku.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

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
        content()
    }
}