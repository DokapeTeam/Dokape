import androidx.compose.runtime.*
import org.jetbrains.compose.common.material.Button
import org.jetbrains.compose.common.ui.ExperimentalComposeWebWidgetsApi
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Body()
    }
}

@OptIn(ExperimentalComposeWebWidgetsApi::class)
@Composable
fun Body() {
    var counter by remember { mutableStateOf(0) }
    Div {
        Text("Clicked: $counter")
    }
    Button(
        attrs = {
            onClick {
                counter++
            }
        }
    ) {
        Text("Click")
    }
    Button(onClick = {}) {
        Text("Test")
    }
}