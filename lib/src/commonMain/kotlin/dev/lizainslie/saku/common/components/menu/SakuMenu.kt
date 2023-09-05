package dev.lizainslie.saku.common.components.menu

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.components.SakuButton
import dev.lizainslie.saku.common.components.SakuPanel
import dev.lizainslie.saku.common.theme.colorDark
import dev.lizainslie.saku.common.theme.colorLight
import dev.lizainslie.saku.common.theme.colorMutedPurple
import dev.lizainslie.saku.common.theme.colorPink
import dev.lizainslie.saku.common.util.Corners

@Composable
fun SakuMenu(
    border: Color = colorPink,
    corner: Dp = 10.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    SakuPanel(
        border = border,
        corner = corner,
    ) {
        Column(content = content)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SakuMenuItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    corner: Dp = 10.dp,
    padding: PaddingValues = PaddingValues(16.dp, 8.dp),
    corners: Corners = Corners.Both,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable RowScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val color = if (isHovered) colorMutedPurple else colorDark

    SakuButton(
        background = color,
        foreground = colorLight,
        hoverBackground = colorMutedPurple,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        corner = corner,
        padding = padding,
        corners = corners,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
        content = content
    )
}