package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.theme.colorBlackPurple
import dev.lizainslie.saku.common.theme.colorLightPurple
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners


/**
 * A stylized Sakura-cyberpunk button.
 *
 * @param onClick A handler that is run when the button is clicked
 * @param modifier A Compose modifier for the button
 * @param enabled Whether to allow the user to activate the button
 * @param background The background color of the button
 * @param foreground The foreground color of the button
 * @param corner The corner radius size.
 * @param padding Padding for the contents of this button
 * @param corners Optional definition of which corners to cut
 * @param content The children of this button
 *
 * @author Elizabeth Hazel Ainslie
 */
@Composable
fun SakuButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    background: Color = colorLightPurple,
    foreground: Color = colorBlackPurple,
    corner: Dp = 5.dp,
    padding: PaddingValues = PaddingValues(8.dp, 4.dp),
    corners: Corners = Corners(),
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier
            .semantics { role = Role.Button }
            .clickable(enabled, onClick = onClick)
            .padding(padding)
            .background(
                background,
                CornerBoxShape(padding, corner, corners)
            )
    ) {
        ProvideTextStyle(SakuTheme.typography.button.copy(foreground)) {
            Row(
                content = content
            )
        }
    }
}