package dev.lizainslie.saku.common.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import dev.lizainslie.saku.common.theme.*
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners

enum class TroughDirection {
    DOWN, UP, LEFT, RIGHT
}

internal fun SakuButtonTheme.toTroughTheme(troughForeground: Color) = TroughTheme(this.hoverBackground, this.foreground, troughForeground)

data class TroughTheme(
    val troughColor: Color,
    val fillColor: Color,
    val foreground: Color,
) {
    companion object {
        val Primary = SakuButtonTheme.PrimaryTonal.toTroughTheme(Color.White)
        val Red = SakuButtonTheme.RedTonal.toTroughTheme(Color.White)
        val Yellow = SakuButtonTheme.YellowTonal.toTroughTheme(Color.Black)
        val Green = SakuButtonTheme.GreenTonal.toTroughTheme(Color.White)
        val Blue = SakuButtonTheme.BlueTonal.toTroughTheme(Color.White)
    }
}

@Composable
fun SakuTrough(
    direction: TroughDirection,
    value: Float,
    maxValue: Float = 100f,
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(SakuTheme.dimensions.basePaddingSmall),
    troughColor: Color = colorPink200.copy(alpha = 0.8f),
    fillColor: Color = SakuTheme.colors.primary,
    foregroundColor: Color = SakuTheme.colors.foreground,
    corner: Dp = LocalCornerSize.current,
    corners: Corners = LocalCorners.current,
    content: @Composable (Float) -> Unit = {},
) {
    val troughShape = CornerBoxShape(PaddingValues(), corner, corners)

    val alignment = when (direction) {
        TroughDirection.DOWN -> Alignment.TopCenter
        TroughDirection.UP -> Alignment.BottomCenter
        TroughDirection.LEFT -> Alignment.CenterEnd
        TroughDirection.RIGHT -> Alignment.CenterStart
    }

    ProvideIconColor(foregroundColor) {
        ProvideTextStyle(SakuTheme.typography.body.copy(foregroundColor)) {
            Box(
                modifier = modifier.background(
                    troughColor,
                    troughShape
                ).let {
                    when (direction) {
                        TroughDirection.UP, TroughDirection.DOWN -> it
                            .width(IntrinsicSize.Min)
                        TroughDirection.LEFT, TroughDirection.RIGHT -> it
                            .height(IntrinsicSize.Min)
                    }
                }
            ) {
                Box(
                    modifier = Modifier
                        .align(alignment)
                        .background(fillColor, troughShape)
                        .animateContentSize(animationSpec = spring(1.95f))
                        .let {
                             when (direction) {
                                 TroughDirection.UP, TroughDirection.DOWN -> it
                                     .fillMaxWidth()
                                     .fillMaxHeight(value / maxValue)
                                 TroughDirection.LEFT, TroughDirection.RIGHT -> it
                                     .fillMaxHeight()
                                     .fillMaxWidth(value / maxValue)
                             }
                        },
                )

                Box(modifier = Modifier.align(Alignment.Center).padding(padding)) {
                    content(value)
                }
            }
        }
    }
}


@Composable
fun SakuTrough(
    direction: TroughDirection,
    value: Float,
    maxValue: Float = 100f,
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(SakuTheme.dimensions.basePaddingSmall),
    theme: TroughTheme = TroughTheme.Primary,
    corner: Dp = LocalCornerSize.current,
    corners: Corners = LocalCorners.current,
    content: @Composable (Float) -> Unit = {},
) {
    SakuTrough(
        direction, value, maxValue, modifier, padding,
        theme.troughColor, theme.fillColor, theme.foreground,
        corner, corners, content
    )
}

//fun SakuEditableTrough() {}