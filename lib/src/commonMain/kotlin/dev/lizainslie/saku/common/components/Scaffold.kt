package dev.lizainslie.saku.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Scaffold(content: @Composable BoxScope.() -> Unit) {
    Box(modifier = Modifier.fillMaxSize().paint(
        painterResource("img/background.jpg"),
        contentScale = ContentScale.Crop,
    ), content = content)
}