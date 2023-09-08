package dev.lizainslie.saku.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import dev.lizainslie.saku.common.theme.LocalCornerSize
import dev.lizainslie.saku.common.theme.LocalCorners
import dev.lizainslie.saku.common.theme.LocalExtrudeOpts
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.Extrude

@Composable
fun SakuImage(
    painter: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.None,
    corner: Dp = LocalCornerSize.current,
    corners: Corners = LocalCorners.current,
    extrude: Extrude = LocalExtrudeOpts.current,
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier.clip(CornerBoxShape(PaddingValues(), corner, corners, extrude, true))
    )
}