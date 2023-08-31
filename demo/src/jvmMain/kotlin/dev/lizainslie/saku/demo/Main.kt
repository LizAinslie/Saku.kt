package dev.lizainslie.saku.demo

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.lizainslie.saku.common.components.*
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.Corners

@Composable
@Preview
fun App() {
    SakuTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            SakuText("Saku.kt Demo", style = SakuTheme.typography.headingH1)
//            SakuPanel(
//                padding = PaddingValues(10.dp),
//                corner = 12.5.dp
//            ) {
//                Row(
//                    horizontalArrangement = Arrangement.spacedBy(5.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                ) {
//                    SakuText("Some Testing Text", modifier = Modifier.padding(5.dp, 0.dp))
//                    CounterButton(Corners(topRight = false))
//                    CounterButton(Corners(bottomLeft = false))
//                }
//            }

            Row {
                SakuPanel(
                    corner = 12.5.dp,
                    modifier = Modifier.width(200.dp)
                ) {
                    Column (modifier = Modifier.width(IntrinsicSize.Max)) {
                        SakuImage(
                            painter = painterResource("img/lizzy.png"),
                            contentScale = ContentScale.FillWidth,
                            corners = Corners(bottomLeft = false),
                            corner = 12.5.dp,
                        )

                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                        ) {
                            SakuText(
                                "Liz Ainslie",
                                style = SakuTheme.typography.headingH2.copy(
                                    fontSize = 24.sp,
                                    color = SakuTheme.colors.foreground
                                ),
                                lineHeight = 24.sp,
                            )

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(5.dp),
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                SakuButton(
                                    modifier = Modifier.fillMaxWidth(.5f),
                                    corners = Corners(topRight = false)
                                ) {
                                    SakuText("Like :3")
                                }

                                SakuButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    corners = Corners(bottomLeft = false),
                                    theme = SakuButtonTheme.Secondary,
                                ) {
                                    SakuText("Dislike")
                                }
                            }
                        }
                    }
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
