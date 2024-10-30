package jp.ac.it_college.std.s23006.webpageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import jp.ac.it_college.std.s23006.webpageapp.ui.SecondaryTabRowScreen
import jp.ac.it_college.std.s23006.webpageapp.ui.theme.WebPageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebPageAppTheme {
                SecondaryTabRowScreen()
            }
        }
    }
}
