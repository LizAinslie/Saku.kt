package dev.lizainslie.saku.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.unit.Dp
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.Extrude

val LocalCornerSize = compositionLocalOf(structuralEqualityPolicy()) { SakuDimensions().cornerSmall }

@Composable
fun ProvideCornerSize(value: Dp, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalCornerSize provides value) {
        content()
    }
}

val LocalExtrudeOpts = compositionLocalOf(structuralEqualityPolicy()) { Extrude.None }

@Composable
fun ProvideExtrudeOpts(value: Extrude, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalExtrudeOpts provides value) {
        content()
    }
}

val LocalCorners = compositionLocalOf(structuralEqualityPolicy()) { Corners.Both }

@Composable
fun ProvideCorners(value: Corners, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalCorners provides value) {
        content()
    }
}
