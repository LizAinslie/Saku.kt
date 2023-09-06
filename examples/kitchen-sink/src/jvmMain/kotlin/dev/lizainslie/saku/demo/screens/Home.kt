package dev.lizainslie.saku.demo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.*
import dev.lizainslie.saku.common.components.*
import dev.lizainslie.saku.common.components.menu.SakuContextMenuWrapper
import dev.lizainslie.saku.common.components.menu.SakuMenu
import dev.lizainslie.saku.common.components.menu.SakuMenuItem
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.Corners

@Composable
fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(SakuTheme.dimensions.basePaddingLarge),
    ) {
        SakuText("Saku.kt Demo", style = SakuTheme.typography.headingH1)

        Row(horizontalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingMedium * 2)) {
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
                    modifier = Modifier.width(200.dp),
                    image = {
                        SakuImage(
                            painter = painterResource("img/lizzy.png"),
                            contentScale = ContentScale.FillWidth,
                            corners = Corners.TopRight,
                        )
                    },
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingMedium * .75f)) {
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
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingLarge)
            ) {
                SakuPanel(
                    padding = PaddingValues(SakuTheme.dimensions.basePaddingMedium),
                    corner = SakuTheme.dimensions.cornerMedium,
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingSmall)) {
                        SakuText(
                            "Buttons",
                            style = SakuTheme.typography.headingH2.copy(
                                fontSize = 24.sp,
                                color = SakuTheme.colors.foreground
                            ),
                            modifier = Modifier.padding(),
                            lineHeight = 16.sp,
                            overflow = TextOverflow.Ellipsis
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 2),
                                theme = SakuButtonTheme.Primary,
                                corners = Corners.BottomLeft,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.Box,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Pink")
                            }
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 1),
                                theme = SakuButtonTheme.PrimaryTonal,
                                corners = Corners.TopRight,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.Box,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Pink Tonal")
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 4),
                                theme = SakuButtonTheme.Blue,
                                corners = Corners.BottomLeft,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.Info,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Info")
                            }
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 3),
                                theme = SakuButtonTheme.Green,
                                corners = Corners.None,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Success")
                            }
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 2),
                                theme = SakuButtonTheme.Yellow,
                                corners = Corners.None,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.AlertCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Warning")
                            }
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(),
                                theme = SakuButtonTheme.Red,
                                corners = Corners.TopRight,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.XCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Error")
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 4),
                                theme = SakuButtonTheme.BlueTonal,
                                corners = Corners.BottomLeft,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.Info,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Info")
                            }
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 3),
                                theme = SakuButtonTheme.GreenTonal,
                                corners = Corners.None,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Success")
                            }
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(1f / 2),
                                theme = SakuButtonTheme.YellowTonal,
                                corners = Corners.None,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.AlertCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Warning")
                            }
                            SakuButton(
                                modifier = Modifier.fillMaxWidth(),
                                theme = SakuButtonTheme.RedTonal,
                                corners = Corners.TopRight,
                            ) {
                                SakuIcon(
                                    imageVector = FeatherIcons.XCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                )
                                SakuText("Error")
                            }
                        }
                    }
                }
                SakuPanel(
                    padding = PaddingValues(SakuTheme.dimensions.basePaddingMedium),
                    corner = SakuTheme.dimensions.cornerMedium
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingSmall)) {
                        SakuText(
                            "Troughs",
                            style = SakuTheme.typography.headingH2.copy(
                                fontSize = 24.sp,
                                color = SakuTheme.colors.foreground
                            ),
                            modifier = Modifier.padding(),
                            lineHeight = 16.sp,
                            overflow = TextOverflow.Ellipsis
                        )

                        for (theme in listOf(TroughTheme.Blue, TroughTheme.Red, TroughTheme.Yellow, TroughTheme.Green)) {
                            Row(horizontalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingSmall)) {
                                Column {
                                    Box(modifier = Modifier.width(100.dp).height(100.dp)) {
                                        SakuTrough(
                                            TroughDirection.DOWN,
                                            50f,
                                            100f,
                                            modifier = Modifier.height(100.dp).width(25.dp),
                                            theme = theme,
                                        ) {
                                            SakuIcon(
                                                FeatherIcons.ArrowDownCircle,
                                                contentDescription = null,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    }
                                }
                                Column {
                                    Box(modifier = Modifier.width(100.dp).height(100.dp)) {
                                        SakuTrough(
                                            TroughDirection.UP,
                                            50f,
                                            100f,
                                            modifier = Modifier.height(100.dp).width(25.dp),
                                            theme = theme,
                                        ) {
                                            SakuIcon(
                                                FeatherIcons.ArrowUpCircle,
                                                contentDescription = null,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    }
                                }
                                Column {
                                    Box(modifier = Modifier.width(100.dp).height(100.dp)) {
                                        SakuTrough(
                                            TroughDirection.LEFT,
                                            50f,
                                            100f,
                                            modifier = Modifier.height(25.dp).width(100.dp),
                                            theme = theme,
                                        ) {
                                            SakuIcon(
                                                FeatherIcons.ArrowLeftCircle,
                                                contentDescription = null,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    }
                                }
                                Column {
                                    Box(modifier = Modifier.width(100.dp).height(100.dp)) {
                                        SakuTrough(
                                            TroughDirection.RIGHT,
                                            50f,
                                            100f,
                                            modifier = Modifier.height(25.dp).width(100.dp),
                                            theme = theme,
                                        ) {
                                            SakuIcon(
                                                FeatherIcons.ArrowRightCircle,
                                                contentDescription = null,
                                                modifier = Modifier.size(16.dp)
                                            )
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
}