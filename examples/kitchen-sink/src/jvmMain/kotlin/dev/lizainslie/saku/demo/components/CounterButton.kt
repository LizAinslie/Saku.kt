package dev.lizainslie.saku.demo.components

import androidx.compose.runtime.*
import dev.lizainslie.saku.common.components.SakuButton
import dev.lizainslie.saku.common.components.SakuText
import dev.lizainslie.saku.common.util.Corners

@Composable
fun CounterButton(corners: Corners = Corners()) {
    var clicks by remember { mutableStateOf(0) }

    SakuButton(
        {
            ++clicks
        },
        corners = corners
    ) {
        SakuText("Button ($clicks clicks)")
    }
}