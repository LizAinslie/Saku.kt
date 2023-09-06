package dev.lizainslie.saku.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.*
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.Extrude

@Composable
fun SakuImageCard(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(10.dp), // body only
    corner: Dp = 12.5.dp,
    corners: Corners = LocalCorners.current,
    extrude: Extrude = LocalExtrudeOpts.current,
    image: @Composable () -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) {
    SakuPanel(
        modifier = modifier,
        corner = corner,
        corners = corners,
        extrude = extrude,
        padding = PaddingValues(),
    ) {
        Column {
            ProvideCornerSize(corner) {
                ProvideExtrudeOpts(Extrude.BottomRight) {
                    ProvideCorners(Corners.TopRight) {
                        image()
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(padding)
                    .offset(0.dp, -corner)
                    .layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)

                        layout(placeable.measuredWidth, placeable.measuredHeight - corner.roundToPx()){
                            placeable.placeRelative(0,  0)
                        }
                    },
                content = content
            )
        }
    }
}