package dev.lizainslie.saku.examples.editor.windows

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
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
import ro.dragossusi.navigation.rememberNavController

@Composable
fun ApplicationScope.EditorWindow() = Window(
    onCloseRequest = ::exitApplication,
    transparent = true,
    undecorated = true,
    state = rememberWindowState(),
) {
    val navController = rememberNavController()

    val navItemTheme = ClickableItemTheme(
        Color.Transparent,
        SakuTheme.colors.primary.copy(alpha = .3f),
        SakuTheme.colors.primary,
        SakuTheme.colors.primary,
        SakuTheme.colors.foreground,
    )

    SakuTheme {
        SakuColorScaffold(
            modifier = Modifier.fillMaxSize(),
            corners = Corners.Both,
            border = SakuTheme.colors.primary
        ) {
            Column(
                modifier = Modifier
                    .matchParentSize()
                    .height(IntrinsicSize.Max),
            ) {
                WindowDraggableArea {
                    Row(
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
                            "Editing: user:lizzy:/code/file.js",
                            style = SakuTheme.typography.body.copy(
                                fontSize = 16.sp,
                                color = SakuTheme.colors.foreground.copy(alpha = .8f)
                            ),
                            lineHeight = 16.sp,
                            overflow = TextOverflow.Ellipsis
                        )

                        SakuButton(
                            onClick = {
                                // todo: prompt
                                exitApplication()
                            },
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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(SakuTheme.dimensions.basePaddingMedium)
                        ) {
                            // todo: file tree
                        }

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