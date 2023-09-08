package dev.lizainslie.saku.common.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

data class Corners(
    val topRight: Boolean = true,
    val bottomLeft: Boolean = true,
) {
    companion object {
        val TopRight = Corners(topRight = true, bottomLeft = false)
        val BottomLeft = Corners(topRight = false, bottomLeft = true)
        val Both = Corners(topRight = true, bottomLeft = true)
        val None = Corners(topRight = false, bottomLeft = false)
    }
}

data class Extrude(
    val topLeft: Boolean = false,
    val bottomRight: Boolean = false,
) {
    companion object {
        val TopLeft = Extrude(topLeft = true, bottomRight = false)
        val BottomRight = Extrude(topLeft = false, bottomRight = true)
        val Both = Extrude(topLeft = true, bottomRight = true)
        val None = Extrude(topLeft = false, bottomRight = false)
    }
}

/**
 * A fairly versatile implementation of the required draw code for the stylistic
 * chipped box shape featured in this library. [padding] should correspond to
 * the padding modifier on the element to which this shape is applied. [corner]
 * defines the size of corner cuts and extrusions. [corners] allows you to
 * choose specific corners to apply the style. [extrude] tells the shape whether
 * to add vertical decorative triangles. [insetExtrude] exists for elements like
 * images, where the content needs to be clipped when extruding rather than
 * adding to the total area. When using components that consider this behavior a
 * default, such as [SakuImage][dev.lizainslie.saku.common.components.SakuImage]
 * you must be mindful to adjust the parent layout to avoid leaving a large gap.
 * This is demonstrated in [dev.lizainslie.saku.common.components.SakuImageCard]
 *
 * @author Elizabeth Hazel Ainslie
 */
class CornerBoxShape(
    private val padding: PaddingValues,
    private val corner: Dp = 5.dp,
    private val corners: Corners = Corners.Both,
    private val extrude: Extrude = Extrude.None,
    private val insetExtrude: Boolean = false,
) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density) = with(density) {
        val extrudeOffsetBottom = if (extrude.bottomRight) corner else 0.dp


        // this math gets harder to follow with every proverbial grain of sand this code inserts into my asshole
        val path = Path().apply {
            if (extrude.topLeft) {
                if (insetExtrude) {
                    moveTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        0f - padding.calculateTopPadding().toPx(),
                    )
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx() + corner.toPx(),
                        0f - padding.calculateTopPadding().toPx() + corner.toPx()
                    )
                } else {
                    moveTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        0f - padding.calculateTopPadding().toPx() - corner.toPx(),
                    )
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx() + corner.toPx(),
                        0f - padding.calculateTopPadding().toPx()
                    )
                }
            } else {
                moveTo(
                    0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                    0f - padding.calculateTopPadding().toPx(),
                )
            }

            if (corners.topRight) {
                if (insetExtrude && extrude.topLeft) {
                    lineTo(
                        (size.width + padding.calculateRightPadding(layoutDirection).toPx()) - corner.toPx(),
                        0f - padding.calculateTopPadding().toPx() + corner.toPx()
                    )

                    lineTo(
                        size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                        corner.toPx() - padding.calculateTopPadding().toPx() + corner.toPx()
                    )
                } else {
                    lineTo(
                        (size.width + padding.calculateRightPadding(layoutDirection).toPx()) - corner.toPx(),
                        0f - padding.calculateTopPadding().toPx()
                    )

                    lineTo(
                        size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                        corner.toPx() - padding.calculateTopPadding().toPx()
                    )
                }
            } else {
                if (insetExtrude && extrude.topLeft) {
                    lineTo(
                        (size.width + padding.calculateRightPadding(layoutDirection).toPx()),
                        0f - padding.calculateTopPadding().toPx() + corner.toPx()
                    )
                } else {
                    lineTo(
                        (size.width + padding.calculateRightPadding(layoutDirection).toPx()),
                        0f - padding.calculateTopPadding().toPx()
                    )
                }
            }

            if (extrude.bottomRight) {
                if (insetExtrude) {
                    lineTo(
                        size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                        size.height + padding.calculateBottomPadding().toPx()
                    )

                    lineTo(
                        size.width + padding.calculateRightPadding(layoutDirection).toPx() - corner.toPx(),
                        size.height + padding.calculateBottomPadding().toPx() - corner.toPx()
                    )
                } else {
                    lineTo(
                        size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                        size.height + padding.calculateBottomPadding().toPx() + corner.toPx()
                    )

                    lineTo(
                        size.width + padding.calculateRightPadding(layoutDirection).toPx() - corner.toPx(),
                        size.height + padding.calculateBottomPadding().toPx()
                    )
                }
            } else {
                lineTo(
                    size.width + padding.calculateRightPadding(layoutDirection).toPx(),
                    size.height + padding.calculateBottomPadding().toPx() - extrudeOffsetBottom.toPx()
                )
            }

            if (corners.bottomLeft) {
                if (insetExtrude && extrude.bottomRight) {
                    lineTo(
                        corner.toPx() - padding.calculateLeftPadding(layoutDirection).toPx(),
                        size.height + padding.calculateBottomPadding().toPx() - corner.toPx()
                    )
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        (size.height + padding.calculateBottomPadding()
                            .toPx()) - corner.toPx() - corner.toPx()
                    )
                } else {
                    lineTo(
                        corner.toPx() - padding.calculateLeftPadding(layoutDirection).toPx(),
                        size.height + padding.calculateBottomPadding().toPx()
                    )
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        (size.height + padding.calculateBottomPadding()
                            .toPx()) - corner.toPx()
                    )
                }
            } else {
                if (insetExtrude && extrude.bottomRight) {
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        size.height + padding.calculateBottomPadding().toPx() - corner.toPx()
                    )
                } else {
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        size.height + padding.calculateBottomPadding().toPx()
                    )
                }
            }


            if (extrude.topLeft) {
                if (insetExtrude) {
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        0f - padding.calculateTopPadding().toPx(),
                    )
                } else {
                    lineTo(
                        0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                        0f - padding.calculateTopPadding().toPx() - corner.toPx(),
                    )
                }
            } else {
                lineTo(
                    0f - padding.calculateLeftPadding(layoutDirection).toPx(),
                    0f - padding.calculateTopPadding().toPx(),
                )
            }

            close()
        }
        Outline.Generic(path)
    }
}