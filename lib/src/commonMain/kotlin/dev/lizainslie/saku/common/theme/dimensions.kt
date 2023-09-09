package dev.lizainslie.saku.common.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SakuDimensions(
    val dimensionBase: Dp = 4.dp,

    val basePaddingSmall: Dp = dimensionBase,
    val basePaddingMedium: Dp = basePaddingSmall * 2,
    val basePaddingLarge: Dp = basePaddingMedium * 2,

    val buttonPaddingSmall: PaddingValues = PaddingValues(basePaddingSmall * 2, basePaddingSmall),

    val cornerSmall: Dp = dimensionBase,
    val cornerMedium: Dp = cornerSmall * 2.5f,
    val cornerLarge: Dp = cornerMedium * 2.5f
)

internal val LocalDimensions = staticCompositionLocalOf { SakuDimensions() }
