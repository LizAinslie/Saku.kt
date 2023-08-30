package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.theme.colorBlackPurple
import dev.lizainslie.saku.common.theme.colorWhitePurple
import dev.lizainslie.saku.common.util.generateCornerBoxPath

@Composable
fun SakuPanel(
    modifier: Modifier = Modifier,
    corner: Dp = 5.dp,
    background: Color = colorBlackPurple,
    foreground: Color = colorWhitePurple,
    padding: PaddingValues = PaddingValues(), // default zero
    content: @Composable BoxScope.() -> Unit,
) {
    val panelShape = GenericShape {size, layoutDirection ->
        generateCornerBoxPath(size, corner, layoutDirection, padding)
    }

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