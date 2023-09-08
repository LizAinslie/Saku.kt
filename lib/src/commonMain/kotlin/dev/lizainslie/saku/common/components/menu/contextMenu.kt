package dev.lizainslie.saku.common.components.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

expect fun Modifier.contextMenuActivator(handler: (offset: Offset) -> Unit, enabled: Boolean = true): Modifier
expect fun Modifier.closeHandler(handler: () -> Unit): Modifier

@Composable
fun SakuContextMenuWrapper(
    menu: @Composable BoxScope.() -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    var opened by remember { mutableStateOf(false) }
    var offset by remember { mutableStateOf(Offset.Unspecified) }

    Box {
        Box(modifier = Modifier.contextMenuActivator({
            opened = true // todo: open logic
            offset = it
        }, enabled)) {
            content()
        }

        if (opened) Box(
            content = menu,
            modifier = Modifier
                .offset(offset.x.dp, offset.y.dp)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    layout(placeable.width, placeable.height) {
                        placeable.place(0, 0)
                    }
                }
                .closeHandler {
                    offset = Offset.Unspecified
                    opened = false
                }
        )
    }
}