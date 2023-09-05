package dev.lizainslie.saku.demo

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.icons.FeatherIcons
import dev.lizainslie.saku.common.components.*
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.Corners
import compose.icons.feathericons.MessageCircle
import compose.icons.feathericons.UserPlus
import compose.icons.feathericons.UserX
import dev.lizainslie.saku.common.theme.colorDark
import dev.lizainslie.saku.common.theme.colorLight
import dev.lizainslie.saku.common.util.Extrude

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
                    modifier = Modifier.width(300.dp)
                ) {
                    Column (modifier = Modifier.width(IntrinsicSize.Max)) {
                        SakuImage(
                            painter = painterResource("img/lizzy.png"),
                            contentScale = ContentScale.FillWidth,
                            corners = Corners.TopRight,
                            extrude = Extrude.BottomRight,
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
                                modifier = Modifier.padding(),
                                lineHeight = 16.sp,
                                overflow = TextOverflow.Ellipsis
                            )

                            SakuText(
                                """
                                    Meow mrrp nya~ meow meow meow mrrrrrrrrp
                                """.trimIndent(),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 4,
                            )

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(5.dp),
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                SakuButton(
                                    modifier = Modifier.fillMaxWidth(1f / 3),
                                    corners = Corners.BottomLeft
                                ) {
                                    SakuIcon(
                                        imageVector = FeatherIcons.UserPlus,
                                        "follow icon",
                                        color = colorDark,
                                        modifier = Modifier.size(16.dp),
                                    )
                                    SakuText("Follow")
                                }

                                SakuButton(
                                    modifier = Modifier.fillMaxWidth(1f / 2),
                                    corners = Corners.None,
                                    theme = SakuButtonTheme.Secondary,
                                ) {
                                    SakuIcon(
                                        imageVector = FeatherIcons.MessageCircle,
                                        "chat icon",
                                        color = colorLight,
                                        modifier = Modifier.size(16.dp),
                                    )
                                    SakuText("Chat")
                                }


                                SakuButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    corners = Corners.TopRight,
                                    theme = SakuButtonTheme.Danger,
                                ) {
                                    SakuIcon(
                                        imageVector = FeatherIcons.UserX,
                                        "block icon",
                                        color = colorLight,
                                        modifier = Modifier.size(16.dp),
                                    )
                                    SakuText("Block")
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
