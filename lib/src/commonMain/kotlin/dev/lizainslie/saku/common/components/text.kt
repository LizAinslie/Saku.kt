package dev.lizainslie.saku.common.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

/**
 * A text component that adheres to the Sakura-cyberpunk typographical theme and
 * color scheme
 *
 * @param text The text content
 * @param modifier A compose modifier
 * @param color The foreground color for this text
 * @param fontSize The size of the font used to render this text element
 * @param fontStyle The style of the font used to render this text element
 * @param fontWeight The weight of the font used to render this text element
 * @param fontFamily The font family used to render this text element
 * @param letterSpacing The spacing between individual characters in this text element
 * @param textDecoration An optional decoration for this text
 * @param textAlign Alignment constraints for this text
 * @param lineHeight The line height used to render this text
 * @param overflow Constraints controlling how this text element handles overflowing content
 * @param softWrap Whether this text should automatically soft-wrap to the next line
 * @param maxLines The maximum amount of lines this text element can render
 * @param minLines The minimum amount of lines this text element can render
 * @param style The text style to apply to this text element
 *
 * @author Elizabeth Hazel Ainslie
 */
@Composable
fun SakuText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    style: TextStyle = LocalTextStyle.current,
) {
    val textColor = color.takeOrElse { style.color }

    val mergedStyles = style.merge(
        TextStyle(
            color = textColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
            textAlign = textAlign,
            lineHeight = lineHeight,
            fontFamily = fontFamily,
            fontStyle = fontStyle,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
        )
    )

    return BasicText(
        text, modifier,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        style = mergedStyles,
    )
}

internal val LocalTextStyle = compositionLocalOf(structuralEqualityPolicy()) { TextStyle.Default }

/**
 * A helper context used to pass text styles to child [dev.lizainslie.saku.common.components.SakuText] components
 *
 * @param value The style to apply to children
 * @param content Child content block
 *
 * @author Elizabeth Hazel Ainslie
 */
@Composable
fun ProvideTextStyle(value: TextStyle, content: @Composable () -> Unit) {
    val mergedStyle = LocalTextStyle.current.merge(value)
    CompositionLocalProvider(LocalTextStyle provides mergedStyle, content = content)
}