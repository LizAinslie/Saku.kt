package dev.lizainslie.saku.demo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import dev.lizainslie.saku.common.util.Extrude
import dev.lizainslie.saku.demo.components.ExampleTable
import dev.lizainslie.saku.demo.components.ExampleTextField

@Composable
fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(SakuTheme.dimensions.basePaddingLarge),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            SakuText(
                "Saku.kt // Kitchen Sink",
                style = SakuTheme.typography.headingH1.copy(fontSize = 72.sp, fontWeight = FontWeight.Bold)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingLarge)) {

                SakuContextMenuWrapper(menu = {
                    SakuMenu {
                        SakuButton(modifier = Modifier.fillMaxWidth(), onClick = {}, corners = Corners.TopRight, theme = SakuButtonTheme.RedTonal) {
                            SakuText("Block User")
                        }
                        SakuMenuItem(modifier = Modifier.fillMaxWidth(), onClick = {}, corners = Corners.BottomLeft) {
                            SakuText("Message")
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

                            SakuTrough(
                                value = 90f,
                                maxValue = 100f,
                                modifier = Modifier.fillMaxWidth(),
                                theme = TroughTheme.Primary,
                            ) {
                                SakuText(
                                    "Level 420"
                                )
                            }

                            SakuText(
                                "Meow mrrp nya~ meow meow meow mrrrrrrrrp",
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 4,
                            )
                        }
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingMedium)
                ) {
                    SakuPanel(
                        padding = PaddingValues(SakuTheme.dimensions.basePaddingMedium),
                        corner = SakuTheme.dimensions.cornerMedium,
//                        extrude = Extrude.TopLeft,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Column {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth().width(IntrinsicSize.Max)
                            ) {
                                SakuText(
                                    "Example Table",
                                    style = SakuTheme.typography.headingH2.copy(
                                        fontSize = 24.sp,
                                        color = SakuTheme.colors.foreground
                                    ),
                                    modifier = Modifier.padding(),
                                    lineHeight = 16.sp,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Row (
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingSmall, Alignment.End)
                                ) {
                                    SakuButton(theme = SakuButtonTheme.GreenTonal, padding = PaddingValues(SakuTheme.dimensions.basePaddingSmall * 1.5f)) {
                                        SakuIcon(
                                            imageVector = FeatherIcons.Plus,
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                    ExampleTextField(placeholder = "Filter Table")
                                }

                                // todo: fix the fucking table
//                                ExampleTable()
                            }
                        }
                    }
                }
            }
        }
    }
}