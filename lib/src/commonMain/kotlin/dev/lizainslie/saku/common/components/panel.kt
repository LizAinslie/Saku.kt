package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.LocalCornerSize
import dev.lizainslie.saku.common.theme.LocalCorners
import dev.lizainslie.saku.common.theme.LocalExtrudeOpts
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.Extrude

/**
 * A stylized Sakura-cyberpunk panel
 *
 * @param modifier A Compose modifier for this panel
 * @param corner The corner radius of this panel
 * @param background The background color of this panel
 * @param foreground The foreground color of this panel
 * @param padding Padding for the contents of this panel
 * @param corners Optional definition of which corners to cut
 * @param content The children of this panel
 *
 * @author Elizabeth Hazel Ainslie
 */
@Composable
fun SakuPanel(
    modifier: Modifier = Modifier,
    corner: Dp = LocalCornerSize.current,
    background: Color = SakuTheme.colors.background,
    foreground: Color = SakuTheme.colors.foreground,
    border: Color = Color.Unspecified,
    padding: PaddingValues = PaddingValues(),
    corners: Corners = LocalCorners.current,
    extrude: Extrude = LocalExtrudeOpts.current,
    content: @Composable BoxScope.() -> Unit,
) {
    val panelShape = CornerBoxShape(padding, corner, corners, extrude)

    ProvideTextStyle(SakuTheme.typography.body.copy(foreground)) {
        ProvideIconColor(foreground) {
            Box(
                modifier = modifier
                    .padding(padding)
                    .background(
                        color = background,
                        shape = panelShape
                    )
                    .shadow(
                        elevation = 16.dp,
                        shape = panelShape,
                        ambientColor = background,
                        spotColor = background,
                    ).let {
                        if (border != Color.Unspecified) it.border(1.dp, border, panelShape)
                        else it
                    },
                content = content
            )
        }
    }
}