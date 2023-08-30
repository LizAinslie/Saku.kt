package dev.lizainslie.saku.demo.components

import androidx.compose.runtime.*
import dev.lizainslie.saku.common.components.SakuButton
import dev.lizainslie.saku.common.components.SakuText

@Composable
fun CounterButton() {
    var clicks by remember { mutableStateOf(0) }

    SakuButton({
        ++clicks
    }) {
        SakuText("Button ($clicks clicks)")
    }
}