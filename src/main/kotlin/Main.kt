import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import theme.AppTheme
import theme.components.SakuButton
import theme.components.SakuText

@Composable
@Preview
fun App() {
    AppTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.blackPurple)
        ) {
            SakuText("Test Header", style = AppTheme.typography.headingH1)
            SakuButton({ }) {
                SakuText("hehe")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
