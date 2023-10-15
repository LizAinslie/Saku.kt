package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.Extrude
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SakuImageScaffold(
    modifier: Modifier = Modifier,
    background: Painter = painterResource("background.jpg"),
    corner: Dp = SakuTheme.dimensions.cornerLarge,
    corners: Corners = Corners.None,
    content: @Composable BoxScope.() -> Unit
) {
    val shape = CornerBoxShape(PaddingValues(), corner, corners, Extrude.None)

    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                background,
                contentScale = ContentScale.Crop,
            )
            .clip(shape),
        content = content
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SakuColorScaffold(
    modifier: Modifier = Modifier,
    background: Color = SakuTheme.colors.background,
    border: Color = Color.Unspecified,
    corner: Dp = SakuTheme.dimensions.cornerMedium,
    corners: Corners = Corners.None,
    content: @Composable BoxScope.() -> Unit
) {
    val shape = CornerBoxShape(PaddingValues(), corner, corners, Extrude.None)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(background, shape)
            .border(1.dp, border, shape)
        ,
        content = content
    )
}