package dev.lizainslie.saku.demo

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.icons.FeatherIcons
import compose.icons.feathericons.*
import dev.lizainslie.saku.common.components.*
import dev.lizainslie.saku.common.components.drawer.ClickableItemTheme
import dev.lizainslie.saku.common.theme.SakuTheme
import dev.lizainslie.saku.common.util.Corners
import dev.lizainslie.saku.common.components.drawer.SakuStaticIconDrawer
import dev.lizainslie.saku.demo.screens.EditorScreen
import dev.lizainslie.saku.demo.screens.HomeScreen
import ro.dragossusi.navigation.NavHost
import ro.dragossusi.navigation.rememberNavController
import ro.dragossusi.navigation.route

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    SakuTheme {
        SakuScaffold {
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom) {
                SakuStaticIconDrawer(
                    corners = Corners.TopRight
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            SakuTheme.dimensions.basePaddingMedium,
                            Alignment.Bottom
                        ),
                    ) {
                        this@SakuStaticIconDrawer.ClickableItem(
                            theme = ClickableItemTheme.Blue,
                            onClick = { navController.navigate("editor") },
                            active = navController.navBackstackEntry.value?.route == "editor",
                        ) {
                            SakuIcon(
                                imageVector = FeatherIcons.PenTool,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                            )
                        }

                        this@SakuStaticIconDrawer.ClickableItem(
                            onClick = {navController.navigate("home")},
                            active = navController.navBackstackEntry.value?.route == "home",
                        ) {
                            SakuIcon(
                                imageVector = FeatherIcons.Home,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                            )
                        }
                    }
                }

                NavHost(
                    navController,
                    startRoute = "home") {
                    composable("home") {
                        HomeScreen()
                    }

                    composable("editor") {
                        EditorScreen()
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
