package dev.lizainslie.saku.demo

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
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
import dev.lizainslie.saku.common.components.menu.SakuContextMenuWrapper
import dev.lizainslie.saku.common.components.menu.SakuMenu
import dev.lizainslie.saku.common.components.menu.SakuMenuItem
import dev.lizainslie.saku.common.theme.colorDark
import dev.lizainslie.saku.common.theme.colorLight
import dev.lizainslie.saku.common.theme.colorRed130
import dev.lizainslie.saku.common.util.Extrude

@Composable
@Preview
fun App() {
    SakuTheme {
        SakuScaffold {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                SakuText("Saku.kt Demo", style = SakuTheme.typography.headingH1)

                Row {
                    SakuContextMenuWrapper(menu = {
                        SakuMenu {
                            SakuMenuItem(onClick = {}, corners = Corners.TopRight) {
                                SakuText("Menu Item 1")
                            }
                            SakuMenuItem(onClick = {}, corners = Corners.BottomLeft) {
                                SakuText("Menu Item 1")
                            }
                        }
                    }) {
                        SakuImageCard(
                            corner = 12.5.dp,
                            modifier = Modifier.width(300.dp),
                            image = {
                                SakuImage(
                                    painter = painterResource("img/lizzy.png"),
                                    contentScale = ContentScale.FillWidth,
                                    corners = Corners.TopRight,
                                )
                            },
                        ) {
                            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
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
                                        modifier = Modifier.fillMaxWidth(),
                                        theme = SakuButtonTheme.PrimaryTonal,
                                    ) {
                                        SakuIcon(
                                            imageVector = FeatherIcons.UserPlus,
                                            "follow icon",
                                            modifier = Modifier.size(16.dp),
                                        )
                                        SakuText("Follow")
                                    }
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
