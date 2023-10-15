package dev.lizainslie.saku.common.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.theme.SakuTheme

@Preview
@Composable
fun ButtonPreview() {
    SakuTheme {
        SakuImageScaffold {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(SakuTheme.dimensions.basePaddingMedium)
            ) {
                SakuPanel(corner = SakuTheme.dimensions.cornerMedium) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        SakuButton(theme = SakuButtonTheme.PrimaryTonal) {
                            SakuText("Fuck")
                        }
                    }
                }
            }
        }
    }
}