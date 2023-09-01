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

data class Corners(
    val topRight: Boolean = true,
    val bottomLeft: Boolean = true,
) {
    companion object {
        val TopRight = Corners(topRight = true, bottomLeft = false)
        val BottomLeft = Corners(topRight = false, bottomLeft = true)
        val Both = Corners(topRight = true, bottomLeft = true)
        val None = Corners(topRight = false, bottomLeft = false)
    }
}

data class Extrude(
    val topLeft: Boolean = false,
    val bottomRight: Boolean = false,
) {
    companion object {
        val TopLeft = Extrude(topLeft = true, bottomRight = false)
        val BottomRight = Extrude(topLeft = false, bottomRight = true)
        val Both = Extrude(topLeft = true, bottomRight = true)
        val None = Extrude(topLeft = false, bottomRight = false)
    }
}

class CornerBoxShape(
    private val padding: PaddingValues,
    private val corner: Dp = 5.dp,
    private val corners: Corners = Corners.Both,
    private val extrude: Extrude = Extrude.None,
) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density) = with(density) {
        val extrudeOffsetBottom = if (extrude.bottomRight) corner else 0.dp
        val extrudeOffsetTop = if (extrude.topLeft) corner else 0.dp

        val path = Path().apply {
            moveTo(
                0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                0f - padding.calculateTopPadding().toPx(),
            )

            if (extrude.topLeft) {
                lineTo(
                    0f - padding.calculateLeftPadding(layoutDirection).toPx() + corner.toPx(),
                    0f - padding.calculateTopPadding().toPx() + extrudeOffsetTop.toPx()
                )
            }

            if (corners.topRight) {
                lineTo(
                    (size.width + padding.calculateRightPadding(layoutDirection).toPx()) - corner.toPx(),
                    0f - padding.calculateTopPadding().toPx() + extrudeOffsetTop.toPx()
                )

                lineTo(
                    size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                    corner.toPx() - padding.calculateTopPadding().toPx() + extrudeOffsetTop.toPx()
                )
            } else {
                lineTo(
                    (size.width + padding.calculateRightPadding(layoutDirection).toPx()),
                    0f - padding.calculateTopPadding().toPx() + extrudeOffsetTop.toPx()
                )
            }

            if (extrude.bottomRight) {
                lineTo(
                    size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                    size.height + padding.calculateBottomPadding().toPx()
                )

                lineTo(
                    size.width + padding.calculateRightPadding(layoutDirection).toPx() - corner.toPx(),
                    size.height + padding.calculateBottomPadding().toPx() - extrudeOffsetBottom.toPx()
                )
            } else {
                lineTo(
                    size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                    size.height + padding.calculateBottomPadding().toPx() - extrudeOffsetBottom.toPx()
                )
            }

            if (corners.bottomLeft) {
                lineTo(
                    corner.toPx() - padding.calculateLeftPadding(layoutDirection).toPx(),
                    size.height + padding.calculateBottomPadding().toPx() - extrudeOffsetBottom.toPx()
                )
                lineTo(
                    0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                    (size.height + padding.calculateBottomPadding().toPx()) - corner.toPx() - extrudeOffsetBottom.toPx()
                )
            }

            else {
                lineTo(
                    0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                    size.height + padding.calculateBottomPadding().toPx() - extrudeOffsetBottom.toPx()
                )
            }

            lineTo(
                0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                0f - padding.calculateTopPadding().toPx()
            )

            close()
        }
        Outline.Generic(path)
    }
}