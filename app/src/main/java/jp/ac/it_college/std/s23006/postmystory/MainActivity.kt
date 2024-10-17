package jp.ac.it_college.std.s23006.postmystory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import jp.ac.it_college.std.s23006.postmystory.ui.theme.PostMyStoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostMyStoryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoilTest()
                }
            }
        }
    }
}
@Preview
@Composable
private fun CoilTest() {
    AsyncImage(
        model = "https://developer.android.com/static/images/brand/android-head_flat.png",
        contentDescription = null
    )
}

