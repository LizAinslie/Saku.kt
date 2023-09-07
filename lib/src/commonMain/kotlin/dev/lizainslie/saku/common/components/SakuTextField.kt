package dev.lizainslie.saku.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.LocalCornerSize
import dev.lizainslie.saku.common.theme.LocalCorners
import dev.lizainslie.saku.common.theme.LocalExtrudeOpts
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.CornerBoxShape
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.Extrude

@Composable
fun SakuTextField(
    value: String,
    valueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    background: Color = SakuTheme.colors.secondary,
    foreground: Color = SakuTheme.colors.foreground,
    focusBackground: Color = SakuTheme.colors.secondary,
    corner: Dp = LocalCornerSize.current,
    padding: PaddingValues = SakuTheme.dimensions.buttonPaddingSmall,
    corners: Corners = LocalCorners.current,
    extrude: Extrude = LocalExtrudeOpts.current,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    icon: ImageVector? = null,
) {
    val inputShape = remember { CornerBoxShape(padding, corner, corners, extrude) }
    val interactionSource = remember { MutableInteractionSource() }
    val focused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        modifier = Modifier.padding(padding),
        value = value,
        onValueChange = valueChanged,
        readOnly = readOnly,
        enabled = enabled,
        interactionSource = interactionSource,
        cursorBrush = SolidColor(foreground),
        textStyle = SakuTheme.typography.body.copy(color = foreground),
        decorationBox = { innerTextField ->
            Row(
                modifier
                    .background(if (focused) focusBackground else background, inputShape)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingMedium),
            ) {
                icon?.let {
                    SakuIcon(
                        modifier = Modifier.size(16.dp),
                        imageVector = it,
                        contentDescription = null,
                        color = foreground,
                    )
                }

                Box {
                    if (value.isEmpty()) {
                        SakuText(
                            placeholder,
                            style = SakuTheme.typography.body.copy(foreground.copy(alpha = .8f))
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}

// tonal buttons -> other ui
internal fun SakuButtonTheme.toTextFieldTheme() = SakuTextFieldTheme(this.background, this.foreground, this.hoverBackground)

data class SakuTextFieldTheme(
    val background: Color,
    val foreground: Color,
    val focusBackground: Color,
) {
    companion object {
        val Primary = SakuButtonTheme.PrimaryTonal.toTextFieldTheme()
    }
}

@Composable
fun SakuTextField(
    value: String,
    valueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    theme: SakuTextFieldTheme = SakuTextFieldTheme.Primary,
    corner: Dp = LocalCornerSize.current,
    padding: PaddingValues = SakuTheme.dimensions.buttonPaddingSmall,
    corners: Corners = LocalCorners.current,
    extrude: Extrude = LocalExtrudeOpts.current,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    icon: ImageVector? = null,
) {
    SakuTextField(
        value,
        valueChanged,
        modifier,
        placeholder,
        theme.background,
        theme.foreground,
        theme.focusBackground,
        corner,
        padding,
        corners,
        extrude,
        readOnly,
        enabled,
        icon,
    )
}