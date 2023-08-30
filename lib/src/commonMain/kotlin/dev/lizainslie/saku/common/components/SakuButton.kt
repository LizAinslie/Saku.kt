package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.theme.colorBlackPurple
import dev.lizainslie.saku.common.theme.colorLightPurple
import dev.lizainslie.saku.common.util.generateCornerBoxPath


@Composable
fun SakuButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    background: Color = colorLightPurple,
    foreground: Color = colorBlackPurple,
    corner: Dp = 5.dp,
    padding: PaddingValues = PaddingValues(8.dp, 4.dp),
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier
            .semantics { role = Role.Button }
            .clickable(enabled, onClick = onClick)
            .padding(padding)
            .background(
                background,
                GenericShape { size, layoutDirection ->
                    generateCornerBoxPath(size, corner, layoutDirection, padding)
                },
            )
    ) {
        ProvideTextStyle(SakuTheme.typography.button.copy(foreground)) {
            Row(
                content = content
            )
        }
    }
}