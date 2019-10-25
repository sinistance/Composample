package io.github.sinistance.composample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.ExpandedHeight
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.tooling.preview.Preview

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Preview("Content preview")
@Composable
fun AppContent() {
    MyApp {
        MyScreenContent()
    }
}

@Composable
fun MyApp(child: @Composable() () -> Unit) {
    CustomTheme {
        Surface(color = Color.Yellow) {
            child()
        }
    }
}

@Composable
fun MyScreenContent(appState: AppState = AppState()) {
    Column(crossAxisAlignment = CrossAxisAlignment.Center, modifier = ExpandedHeight) {
        Column(crossAxisAlignment = CrossAxisAlignment.Center, modifier = Flexible(1f)) {
            Greeting(name = "Android")
            Divider(color = Color.Black)
            Greeting(name = "there")
        }
        Counter(state = appState.counterState)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name",
        modifier = Spacing(24.dp),
        style = +themeTextStyle { h1 }
    )
}

@Composable
fun Counter(state: CounterState) {
    Button(
        text = "I've been clicked ${state.count} times",
        onClick = {
            state.count++
        }
    )
}

class AppState(val counterState: CounterState = CounterState())

@Model
class CounterState(var count: Int = 0)