package dev.lizainslie.saku.demo

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.lizainslie.saku.common.components.SakuButton
import dev.lizainslie.saku.common.components.SakuPanel
import dev.lizainslie.saku.common.components.SakuText
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.demo.components.CounterButton

@Composable
@Preview
fun App() {
    SakuTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            SakuText("Test Header", style = SakuTheme.typography.headingH1)
            SakuPanel(
                padding = PaddingValues(10.dp),
                corner = 12.5.dp
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    SakuText("Some Testing Text", modifier = Modifier.padding(5.dp, 0.dp))
                    CounterButton()
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
