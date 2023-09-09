package dev.lizainslie.saku.demo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.Edit
import compose.icons.feathericons.Folder
import compose.icons.feathericons.X
import dev.lizainslie.saku.common.components.*
import dev.lizainslie.saku.common.components.drawer.ClickableItemTheme
import dev.lizainslie.saku.common.components.drawer.SakuStaticIconDrawer
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.util.bottomBorder
import dev.lizainslie.saku.common.util.rightBorder
import dev.lizainslie.saku.common.util.topBorder

@Composable
fun EditorScreen() {
    val navItemTheme = ClickableItemTheme(
        Color.Transparent,
        SakuTheme.colors.primary.copy(alpha = .3f),
        SakuTheme.colors.primary,
        SakuTheme.colors.primary,
        SakuTheme.colors.foreground,
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            SakuText(
                "Saku.kt // Editor UI",
                style = SakuTheme.typography.headingH1.copy(fontSize = 72.sp, fontWeight = FontWeight.Bold)
            )

            SakuColorScaffold(
                modifier = Modifier.width(1600.dp).height(900.dp),
                corners = Corners.Both,
                border = SakuTheme.colors.primary
            ) {
                Column(
                    modifier = Modifier
                        .matchParentSize()
                        .height(IntrinsicSize.Max)
                    ,
                ) {
                    Row (
                        modifier = Modifier
                            .bottomBorder(SakuTheme.colors.secondary, 1.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(
                            modifier = Modifier.padding(SakuTheme.dimensions.buttonPaddingSmall),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(SakuTheme.dimensions.basePaddingSmall)
                        ) {
                            SakuIcon(
                                imageVector = FeatherIcons.Edit,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                color = SakuTheme.colors.primary
                            )
                            SakuText(
                                "Editor Example",
                                style = SakuTheme.typography.headingH2.copy(
                                    fontSize = 20.sp,
                                    color = SakuTheme.colors.foreground
                                ),
                                lineHeight = 16.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        SakuText(
                            "Editing: user:lizzy:code/file.js",
                            style = SakuTheme.typography.body.copy(
                                fontSize = 16.sp,
                                color = SakuTheme.colors.foreground.copy(alpha = .8f)
                            ),
                            lineHeight = 16.sp,
                            overflow = TextOverflow.Ellipsis
                        )

                        SakuButton(
                            theme = SakuButtonTheme.RedTonal,
                            corners = Corners.TopRight,
                            corner = SakuTheme.dimensions.cornerMedium,
                            padding = PaddingValues(SakuTheme.dimensions.basePaddingMedium)
                        ) {
                            SakuIcon(
                                imageVector = FeatherIcons.X,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .rightBorder(SakuTheme.colors.secondary, corner = SakuTheme.dimensions.cornerMedium)
                        ) {
                            SakuStaticIconDrawer {
                                SakuStaticIconDrawer.ClickableItem(
                                    {},
                                    theme = navItemTheme
                                ) {
                                    SakuIcon(
                                        imageVector = FeatherIcons.Folder,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .width(240.dp)
                                .fillMaxHeight()
                                .height(IntrinsicSize.Max)
                                .rightBorder(SakuTheme.colors.secondary, corner = SakuTheme.dimensions.cornerMedium),
                            verticalArrangement = Arrangement.Bottom,
                        ) {
//                            Column(
//                                modifier = Modifier
//                                    .fillMaxHeight()
//                                    .fillMaxWidth()
//                                    .padding(SakuTheme.dimensions.basePaddingMedium)
//                            ) {
//                                // todo: file tree
//                            }

                            Column(
                                modifier = Modifier
                                    .height(320.dp)
                                    .fillMaxWidth()
                                    .topBorder(SakuTheme.colors.secondary, corner = SakuTheme.dimensions.cornerMedium)
                                    .padding(SakuTheme.dimensions.basePaddingMedium)
                            ) {
                            }
                        }
                    }
                }
            }
        }
    }
}