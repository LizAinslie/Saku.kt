package dev.lizainslie.saku.common.components.menu

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput

actual fun Modifier.contextMenuActivator(handler: (Offset) -> Unit, enabled: Boolean) = this.pointerInput(Unit) {
    detectTapGestures(
        onLongPress = { if (enabled) handler(it) }
    )
}

actual fun Modifier.closeHandler(handler: () -> Unit) = this // no-op on android