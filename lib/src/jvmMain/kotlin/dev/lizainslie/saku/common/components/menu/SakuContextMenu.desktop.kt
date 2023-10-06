package dev.lizainslie.saku.common.components.menu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.onClick
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.*

@OptIn(ExperimentalFoundationApi::class)
actual fun Modifier.contextMenuActivator(handler: (Offset) -> Unit, enabled: Boolean) = this.pointerInput(Unit) {
    detectTapGestures(
        PointerMatcher.mouse(PointerButton.Secondary),
        onTap = { if(enabled) handler(it) }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
actual fun Modifier.closeHandler(handler: () -> Unit) = this
    .onPointerEvent(PointerEventType.Exit) {
        handler()
    }