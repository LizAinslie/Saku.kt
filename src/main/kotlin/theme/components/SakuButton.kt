package theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import theme.AppTheme
import theme.colorBlackPurple
import theme.colorLightPurple


@Composable
fun SakuButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    background: Color = colorLightPurple,
    foreground: Color = colorBlackPurple,
    corner: Float = 5f,
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier
            .semantics { role = Role.Button }
            .clickable(enabled, onClick = onClick)
            .padding(8.dp, 4.dp)
            .drawBehind {
                drawPath(
                    Path().apply {
                        moveTo(0f - 8.dp.toPx(), 0f - 4.dp.toPx())
                        lineTo((size.width + 8.dp.toPx()) - corner, 0f - 4.dp.toPx())
                        lineTo(size.width + 8.dp.toPx(), corner - 4.dp.toPx())
                        lineTo(size.width + 8.dp.toPx(), size.height + 4.dp.toPx())
                        lineTo(corner - 8.dp.toPx(), size.height + 4.dp.toPx())
                        lineTo(0f - 8.dp.toPx(), (size.height + 4.dp.toPx()) - corner)
                        lineTo(0f - 8.dp.toPx(), 0f - 4.dp.toPx())
                        close()
                    },
                    background,
                )
            }
    ) {
        ProvideTextStyle(AppTheme.typography.button.copy(foreground)) {
            Row(
                content = content
            )
        }
    }
}