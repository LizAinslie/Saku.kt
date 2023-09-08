package dev.lizainslie.saku.demo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FeatherIcons
import compose.icons.feathericons.Search
import dev.lizainslie.saku.common.components.SakuTextField
import dev.lizainslie.saku.common.util.Corners

@Composable
fun ExampleTextField(
    icon: ImageVector = FeatherIcons.Search,
    placeholder: String = "Search",
    corners: Corners = Corners.Both,
    modifier: Modifier = Modifier,
) {
    var value by remember { mutableStateOf("") }

    SakuTextField(
        value,
        {value = it},
        icon = icon,
        placeholder = placeholder,
        corners = corners,
        modifier = modifier
    )
}