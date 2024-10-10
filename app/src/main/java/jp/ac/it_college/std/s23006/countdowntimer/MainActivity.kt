package jp.ac.it_college.std.s23006.countdowntimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.countdowntimer.ui.theme.CountDownTImerTheme
import jp.ac.it_college.std.s23006.countdowntimer.ui.theme.Pink80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountDownTImerTheme {

            }
        }
    }
}

@Composable
fun AppScaffold(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Text(text = "TopAppBar")},
        bottomBar = {
            Text(text = "BottomAppBar")},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Filled.Timer,
                    contentDescription = "Timer"
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Pink80),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Content")
        }
    }
}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
private fun AppScaffoldPreview() {
    CountDownTImerTheme {
        AppScaffold()
    }
}