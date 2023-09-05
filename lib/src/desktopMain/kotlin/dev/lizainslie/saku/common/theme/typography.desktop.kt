package dev.lizainslie.saku.common.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

internal actual fun font(
    name: String,
    res: String,
    weight: FontWeight,
    style: FontStyle
) : Font = androidx.compose.ui.text.platform.Font(res, weight, style)