package dev.lizainslie.saku.common.components.menu

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
import dev.lizainslie.saku.common.theme.*
import dev.lizainslie.saku.common.util.Corners

@Composable
fun SakuMenu(
    border: Color = colorPink100,
    corner: Dp = 10.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    SakuPanel(
        border = border,
        corner = corner,
    ) {
        ProvideCornerSize(corner) {
            Column(content = content)
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SakuMenuItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    corner: Dp = LocalCornerSize.current,
    padding: PaddingValues = SakuButton.DefaultPadding,
    corners: Corners = Corners.Both,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable RowScope.() -> Unit
) {
    SakuButton(
        background = colorDark,
        foreground = colorLight,
        hoverBackground = colorPurple200,
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