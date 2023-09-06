package dev.lizainslie.saku.demo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.components.SakuButton
import dev.lizainslie.saku.common.components.SakuButtonTheme
import dev.lizainslie.saku.common.components.SakuPanel
import dev.lizainslie.saku.common.components.SakuText
import dev.lizainslie.saku.common.theme.SakuTheme

@Composable
fun EditorScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        SakuPanel(
            modifier = Modifier.width(1600.dp).height(900.dp),
            padding = PaddingValues(SakuTheme.dimensions.basePaddingLarge),
            border = SakuTheme.colors.primary,
            corner = SakuTheme.dimensions.cornerSmall * 5
        ) {
            SakuPanel(
                modifier = Modifier.fillMaxSize(),
                padding = PaddingValues(SakuTheme.dimensions.basePaddingMedium),
                border = SakuTheme.colors.secondary,
                corner = SakuTheme.dimensions.cornerSmall * 2.5f
            ) {
                SakuButton(
                    modifier = Modifier.fillMaxWidth(),
                    theme = SakuButtonTheme.PrimaryTonal,
                ) { SakuText("Button") }
            }
        }
    }
}