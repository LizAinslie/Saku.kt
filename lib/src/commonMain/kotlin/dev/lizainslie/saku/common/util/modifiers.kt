package dev.lizainslie.saku.common.util

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.bottomBorder(color: Color, strokeWidth: Dp = 1.dp, corner: Dp = 0.dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerPx = density.run { corner.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height + .5f

            if (corner != 0.dp)
                drawLine(
                    color = color,
                    start = Offset(x = 0f, y = height - cornerPx) ,
                    end = Offset(x = 0f + cornerPx, y = height),
                    strokeWidth = strokeWidthPx
                )

            drawLine(
                color = color,
                start = Offset(x = 0f + cornerPx, y = height),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)

fun Modifier.topBorder(color: Color, strokeWidth: Dp = 1.dp, corner: Dp = 0.dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerPx = density.run { corner.toPx() }

        Modifier.drawBehind {
            val width = size.width

            drawLine(
                color = color,
                start = Offset(x = 0f, y = -.5f),
                end = Offset(x = width - cornerPx , y = -.5f),
                strokeWidth = strokeWidthPx
            )

            if (corner != 0.dp)
                drawLine(
                    color = color,
                    start = Offset(x = width - cornerPx, y = -.5f),
                    end = Offset(x = width, y = cornerPx - .5f),
                    strokeWidth = strokeWidthPx
                )
        }
    }
)

fun Modifier.rightBorder(color: Color, strokeWidth: Dp = 1.dp, corner: Dp = 0.dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerPx = density.run { corner.toPx() }

        Modifier.drawBehind {
            val width = size.width + .5f
            val height = size.height

            if (corner != 0.dp)
                drawLine(
                    color = color,
                    start = Offset(x = width - cornerPx, y = 0f),
                    end = Offset(x = width , y = cornerPx),
                    strokeWidth = strokeWidthPx
                )

            drawLine(
                color = color,
                start = Offset(x = width, y = cornerPx),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)

fun Modifier.leftBorder(color: Color, strokeWidth: Dp = 1.dp, corner: Dp = 0.dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerPx = density.run { corner.toPx() }

        Modifier.drawBehind {
            val height = size.height

            drawLine(
                color = color,
                start = Offset(x = -.5f, y = 0f),
                end = Offset(x = -.5f , y = height - cornerPx),
                strokeWidth = strokeWidthPx
            )

            if (corner != 0.dp)
                drawLine(
                    color = color,
                    start = Offset(x = .5f, y = height - cornerPx),
                    end = Offset(x = cornerPx + .5f , y = height),
                    strokeWidth = strokeWidthPx
                )
        }
    }
)