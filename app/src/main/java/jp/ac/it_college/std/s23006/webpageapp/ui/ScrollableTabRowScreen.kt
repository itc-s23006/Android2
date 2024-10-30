package jp.ac.it_college.std.s23006.webpageapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScrollableTabRowScreen(modifier: Modifier = Modifier) {
    var tabIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            ScrollableTabRowView(
                tabIndex = tabIndex,
                onTabChange = { tabIndex = it }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tab $tabIndex",
                modifier = Modifier.padding(16.dp),
                fontSize = 60.sp
            )
        }
    }
}
@Preview
@Composable
private fun ScrollableTabRowScreenPreview() {
    ScrollableTabRowScreen()
}