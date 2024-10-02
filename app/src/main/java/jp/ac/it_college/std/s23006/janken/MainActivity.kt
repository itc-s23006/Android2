package jp.ac.it_college.std.s23006.janken

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.janken.ui.theme.JankenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JankenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JankenTheme {
        Greeting("Android")
    }
}
@Composable
fun PlayerView(modifier: Modifier = Modifier, hand: Int) {
    if (hand == 0) {
        Image(
            painter = painterResource(id = R.drawable.gu),
            contentDescription = null
        )
    } else if (hand == 1) {
        Image(
            painter = painterResource(id = R.drawable.choki),
            contentDescription = null
        )
    } else if (hand == 2) {
        Image(
            painter = painterResource(id = R.drawable.pa),
            contentDescription = null
        )
    }
}
@Preview
@Composable
private fun PlayerViewPreview0() {
    PlayerView(hand = 0)
}
@Preview
@Composable
private fun PlayerViewPreview1() {
    PlayerView(hand = 1)
}
@Preview
@Composable
private fun PlayerViewPreview2() {
    PlayerView(hand = 2)
}
@Preview(
    showBackground = true,
    backgroundColor = 0xFF00FF00,
    widthDp = 100, heightDp = 200
)
@Composable
private fun PlayerViewPreview() {
    PlayerView(hand = 1)
}
@Composable
fun ComputerView(modifier: Modifier = Modifier, comHand: Int) {
    when (comHand) {
        0 -> Image(
            painter = painterResource(id = R.drawable.com_gu),
            contentDescription = null
        )
        1 -> Image(
            painter = painterResource(id = R.drawable.com_choki),
            contentDescription = null
        )
        2 -> Image(
            painter = painterResource(id = R.drawable.com_pa),
            contentDescription = null
        )
    }
}
@Preview
@Composable
private fun ComputerViewPreview0() {
    ComputerView(comHand = 0)
}
@Preview
@Composable
private fun ComputerViewPreview1() {
    ComputerView(comHand = 1)
}
@Preview
@Composable
private fun ComputerViewPreview2() {
    ComputerView(comHand = 2)
}