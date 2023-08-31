package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.*
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners

/**
 * A stylized Sakura-cyberpunk button. When clicked, [onClick] will be called.
 *
 * ## Examples
 * ### A basic button
 * ```kt
 * SakuButton({ println("I was clicked!") }) {
 *     SakuText("A Sample Button")
 * }
 * ```
 *
 * @param onClick A handler that is run when this button is clicked
 * @param modifier A Compose modifier for this button
 * @param enabled Whether to allow the user to activate this button
 * @param background The background color of this button
 * @param foreground The foreground color of this button
 * @param corner The corner radius of this button
 * @param padding Padding for the contents of this button
 * @param corners Optional definition of which corners to cut
 * @param content The children of this button
 *
 * @author Elizabeth Hazel Ainslie
 */
@Composable
fun SakuButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    background: Color = SakuTheme.colors.primary,
    foreground: Color = colorDark,
    corner: Dp = 5.dp,
    padding: PaddingValues = PaddingValues(8.dp, 4.dp),
    corners: Corners = Corners(),
    arrangement: Arrangement.Horizontal = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
    content: @Composable RowScope.() -> Unit
) {
    ProvideTextStyle(SakuTheme.typography.button.copy(foreground)) {
        Row(
            modifier = modifier
                .semantics { role = Role.Button }
                .clickable(enabled, onClick = onClick)
                .padding(padding)
                .background(
                    background,
                    CornerBoxShape(padding, corner, corners)
                ),
            horizontalArrangement = arrangement,
            content = content
        )
    }
}

data class SakuButtonTheme(
    val background: Color,
    val foreground: Color
) {
    companion object {
        val Primary = SakuButtonTheme(colorPink, colorDark)
        val Secondary = SakuButtonTheme(colorMutedPurple, colorLight)
    }
}

@Composable
fun SakuButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    theme: SakuButtonTheme = SakuButtonTheme.Primary,
    corner: Dp = 5.dp,
    padding: PaddingValues = PaddingValues(8.dp, 4.dp),
    corners: Corners = Corners(),
    arrangement: Arrangement.Horizontal = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
    content: @Composable RowScope.() -> Unit
) {
    SakuButton(
        onClick,
        modifier,
        enabled,
        theme.background,
        theme.foreground,
        corner,
        padding,
        corners,
        arrangement,
        content
    )
}
