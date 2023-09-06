package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import dev.lizainslie.saku.common.util.Extrude

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
 * @param hoverBackground The background color of this button while hovered
 * @param hoverForeground The foreground color of this button while hovered
 * @param corner The corner radius of this button
 * @param padding Padding for the contents of this button
 * @param corners Optional definition of which corners to cut
 * @param extrude Optional definition of which corners to extrude
 * @param horizontalArrangement The horizontal arrangement of this button's content
 * @param verticalAlignment The vertical alignment of this button's content
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
    hoverBackground: Color = background,
    hoverForeground: Color = foreground,
    border: Color = Color.Unspecified,
    corner: Dp = LocalCornerSize.current,
    padding: PaddingValues = SakuButton.DefaultPadding,
    corners: Corners = LocalCorners.current,
    extrude: Extrude = LocalExtrudeOpts.current,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable RowScope.() -> Unit
) {
    val buttonShape = CornerBoxShape(padding, corner, corners, extrude)
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val backgroundColor = if (isHovered) hoverBackground else background
    val foregroundColor = if (isHovered) hoverForeground else foreground

    ProvideTextStyle(SakuTheme.typography.button.copy(foregroundColor)) {
        ProvideIconColor(foregroundColor) {
            Row(
                modifier = modifier
                    .semantics { role = Role.Button }
                    .clickable(enabled, onClick = onClick)
                    .hoverable(interactionSource, enabled)
                    .padding(padding)
                    .background(
                        backgroundColor,
                        buttonShape,
                    )
                    .let {
                        if (border != Color.Unspecified) it.border(1.dp, border, buttonShape)
                        else it
                    },
                horizontalArrangement = horizontalArrangement,
                verticalAlignment = verticalAlignment,
                content = content
            )
        }
    }
}

object SakuButton {
    val IconPadding = PaddingValues(5.dp)
    val DefaultPadding = PaddingValues(15.dp, 5.dp)
}

data class SakuButtonTheme(
    val background: Color,
    val foreground: Color,
    val hoverBackground: Color,
    val hoverForeground: Color = foreground,
    val border: Color = Color.Unspecified,
) {
    companion object {
        val Primary = SakuButtonTheme(colorPink100, colorDark, colorPink110)
        val PrimaryTonal = SakuButtonTheme(colorPink200.copy(alpha = 0.4f), colorPink100, colorPink200.copy(alpha = 0.8f))

        // by default, secondary is a muted, tonal dark purple
        val Secondary = SakuButtonTheme(colorPurple200.copy(alpha = 0.4f), colorLight, colorPurple200.copy(alpha = 0.8f))

        val Danger = SakuButtonTheme(colorRed130, colorLight, colorRed140)
        val DangerTonal = SakuButtonTheme(colorRed200.copy(alpha = 0.2f), colorRed130, colorRed200.copy(alpha = 0.6f))

    }
}

@Composable
fun SakuButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    theme: SakuButtonTheme = SakuButtonTheme.Primary,
    corner: Dp = LocalCornerSize.current,
    padding: PaddingValues = SakuButton.DefaultPadding,
    corners: Corners = LocalCorners.current,
    extrude: Extrude = LocalExtrudeOpts.current,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable RowScope.() -> Unit
) {
    SakuButton(
        onClick,
        modifier,
        enabled,
        theme.background,
        theme.foreground,
        theme.hoverBackground,
        theme.hoverForeground,
        theme.border,
        corner,
        padding,
        corners,
        extrude,
        horizontalArrangement,
        verticalAlignment,
        content
    )
}
