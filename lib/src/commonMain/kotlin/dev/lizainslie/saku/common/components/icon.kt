package dev.lizainslie.saku.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
@NonRestartableComposable
fun SakuIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    color: Color = LocalIconColor.current
) {
    SakuIcon(
        painter = rememberVectorPainter(imageVector),
        contentDescription = contentDescription,
        modifier = modifier,
        color = color,
    )
}

@Composable
@NonRestartableComposable
fun SakuIcon(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    color: Color = LocalIconColor.current
) {
    val painter = remember(bitmap) { BitmapPainter(bitmap) }
    SakuIcon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        color = color
    )
}

@Composable
fun SakuIcon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    color: Color = LocalIconColor.current
) {
    val colorFilter = if (color == Color.Unspecified) null else ColorFilter.tint(color)
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }
    Box(
        modifier.toolingGraphicsLayer().defaultSizeFor(painter)
            .paint(
                painter,
                colorFilter = colorFilter,
                contentScale = ContentScale.Fit
            )
            .then(semantics)
    )
}

private fun Modifier.defaultSizeFor(painter: Painter) =
    this.then(
        if (painter.intrinsicSize == Size.Unspecified || painter.intrinsicSize.isInfinite()) {
            DefaultIconSizeModifier
        } else {
            Modifier
        }
    )


internal val LocalIconColor = compositionLocalOf(structuralEqualityPolicy()) { Color.Unspecified }

/**
 * A helper context used to pass text styles to child [dev.lizainslie.saku.common.components.SakuIcon] components
 *
 * @param color The icon color to apply to children
 * @param content Child content block
 *
 * @author Elizabeth Hazel Ainslie
 */
@Composable
fun ProvideIconColor(color: Color, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalIconColor provides color, content = content)
}

private fun Size.isInfinite() = width.isInfinite() && height.isInfinite()

// Default icon size, for icons with no intrinsic size information
private val DefaultIconSizeModifier = Modifier.size(16.dp)