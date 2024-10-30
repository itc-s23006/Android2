package jp.ac.it_college.std.s23006.webpageapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.webpageapp.R
import jp.ac.it_college.std.s23006.webpageapp.ui.theme.WebView

@Composable
fun TabRowScreen(modifier: Modifier = Modifier) {
    var tabIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomAppBar {
                TabRowView(tabIndex = tabIndex, onTabChange = { tabIndex = it })
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (tabIndex) {
                0 -> Text(text = stringResource(id = R.string.home_tab))
                1 -> WebView(url = "https://developer.android.com")
                2 -> WebView(url = "https://www.google.com")
            }
        }
    }
}
@Preview
@Composable
private fun TabRowScreenPreview() {
    TabRowScreen()
}