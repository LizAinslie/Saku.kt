package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
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
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners

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
    corner: Dp = 5.dp,
    background: Color = SakuTheme.colors.background,
    foreground: Color = SakuTheme.colors.foreground,
    padding: PaddingValues = PaddingValues(),
    corners: Corners = Corners(),
    content: @Composable BoxScope.() -> Unit,
) {
    val panelShape = CornerBoxShape(padding, corner, corners)

    ProvideTextStyle(SakuTheme.typography.body.copy(foreground)) {
        Box(
            modifier = modifier
                .padding(padding)
                .background(
                    color = background,
                    shape = panelShape
                )
                .shadow(
                    elevation = 10.dp,
                    shape = panelShape,
                    ambientColor = background,
                    spotColor = background,
                ),
            content = content
        )
    }
}