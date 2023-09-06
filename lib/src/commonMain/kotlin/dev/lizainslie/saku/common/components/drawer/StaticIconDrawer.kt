package dev.lizainslie.saku.common.components.drawer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import dev.lizainslie.saku.common.components.SakuButton
import dev.lizainslie.saku.common.components.SakuButtonTheme
import dev.lizainslie.saku.common.components.SakuPanel
import dev.lizainslie.saku.common.theme.*
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.Extrude

@Composable
fun StaticIconDrawer(
    modifier: Modifier = Modifier,
    corner: Dp = SakuTheme.dimensions.cornerMedium,
    padding: PaddingValues = PaddingValues(SakuTheme.dimensions.basePaddingMedium),
    corners: Corners = Corners.Both,
    extrude: Extrude = Extrude.None,
    content: @Composable () -> Unit
) {
    SakuPanel(
        modifier = modifier,
        padding = padding,
        corner = corner,
        corners = corners,
        extrude = extrude,
    ) {
        content()
    }
}


object StaticIconDrawer {

    internal fun SakuButtonTheme.toClickableItemTheme(activeForeground: Color) = ClickableItemTheme(this.background, this.hoverBackground, this.foreground, this.foreground, activeForeground)

    data class ClickableItemTheme(
        val background: Color,
        val hoverBackground: Color,
        val activeBackground: Color,
        val foreground: Color,
        val activeForeground: Color,
    ) {
        companion object {
            val Primary = SakuButtonTheme.PrimaryTonal.toClickableItemTheme(colorLight)
            val Danger = SakuButtonTheme.RedTonal.toClickableItemTheme(colorLight)
        }
    }

    @Composable
    fun ClickableItem(
        onClick: () -> Unit,
        active: Boolean = false,
        theme: ClickableItemTheme = ClickableItemTheme.Primary,
        corners: Corners = Corners.Both,
        modifier: Modifier = Modifier,
        padding: PaddingValues = PaddingValues(SakuTheme.dimensions.basePaddingMedium),
        content: @Composable RowScope.() -> Unit,
    ) {
        val hoverBackground = if (active) theme.activeBackground else theme.hoverBackground
        val background = if (active) theme.activeBackground else theme.background
        val foreground = if (active) theme.activeForeground else theme.foreground

        SakuButton(
            onClick = onClick,
            background = background,
            hoverBackground = hoverBackground,
            foreground = foreground,
            modifier = modifier,
            padding = padding,
            corners = corners,
            content = content
        )
    }
}