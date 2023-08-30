package dev.lizainslie.saku.samples.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import dev.lizainslie.saku.common.components.SakuButton
import dev.lizainslie.saku.common.components.SakuPanel
import dev.lizainslie.saku.common.components.SakuText
import dev.lizainslie.saku.common.util.Corners

class ButtonSamples {
    @Composable
    fun buttonGroupCorners() {
        /**
        * Using `corners` to make multiple buttons flow together nicer.
        */
        SakuPanel {
            Row {
                SakuPanel(
                    padding = PaddingValues(10.dp),
                    corner = 12.5.dp
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        SakuButton({}, corners = Corners(topRight = false)) {
                            SakuText("A Sample Button")
                        }

                        SakuButton({}, corners = Corners(bottomLeft = false)) {
                            SakuText("A Sample Button")
                        }
                    }
                }
            }
        }
    }
}