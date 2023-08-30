package dev.lizainslie.saku.common.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class CornerBoxShape(private val padding: PaddingValues, private val corner: Dp = 5.dp) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density) = with(density) {
        val path = Path().apply {
            moveTo(
                0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                0f - padding.calculateTopPadding().toPx()
            )
            lineTo(
                (size.width + padding.calculateRightPadding(layoutDirection).toPx()) - corner.toPx(),
                0f - padding.calculateTopPadding().toPx()
            )
            lineTo(
                size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                corner.value - padding.calculateTopPadding().toPx()
            )
            lineTo(
                size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                size.height + padding.calculateBottomPadding().toPx()
            )
            lineTo(
                corner.toPx() - padding.calculateLeftPadding(layoutDirection).toPx(),
                size.height + padding.calculateBottomPadding().toPx()
            )
            lineTo(
                0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                (size.height + padding.calculateBottomPadding().toPx()) - corner.toPx()
            )
            lineTo(
                0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                0f - padding.calculateTopPadding().toPx()
            )
            close()
        }
        Outline.Generic(path)
    }
}