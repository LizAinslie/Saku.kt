package dev.lizainslie.saku.common.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

fun Path.generateCornerBoxPath(
    size: Size,
    corner: Dp,
    layoutDirection: LayoutDirection = LayoutDirection.Ltr, // default to LTR layout
    padding: PaddingValues = PaddingValues() // zero padding default
) {
    moveTo(
        0f - padding.calculateLeftPadding(layoutDirection).value,
        0f - padding.calculateTopPadding().value
    )
    lineTo(
        (size.width + padding.calculateRightPadding(layoutDirection).value) - corner.value,
        0f - padding.calculateTopPadding().value
    )
    lineTo(
        size.width + padding.calculateRightPadding(layoutDirection).value,
        corner.value - padding.calculateTopPadding().value
    )
    lineTo(
        size.width + padding.calculateRightPadding(layoutDirection).value,
        size.height + padding.calculateBottomPadding().value
    )
    lineTo(
        corner.value - padding.calculateLeftPadding(layoutDirection).value,
        size.height + padding.calculateBottomPadding().value
    )
    lineTo(
        0f - padding.calculateLeftPadding(layoutDirection).value,
        (size.height + padding.calculateBottomPadding().value) - corner.value
    )
    lineTo(
        0f - padding.calculateLeftPadding(layoutDirection).value,
        0f - padding.calculateTopPadding().value
    )
    close()
}