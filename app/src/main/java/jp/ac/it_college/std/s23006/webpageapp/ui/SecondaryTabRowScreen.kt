package jp.ac.it_college.std.s23006.webpageapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import jp.ac.it_college.std.s23006.webpageapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryTabRowScreen(modifier: Modifier = Modifier) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        stringResource(id = R.string.recommended),
        stringResource(id = R.string.popular),
        stringResource(id = R.string.category),
        stringResource(id = R.string.new_arrivals),
        stringResource(id = R.string.rankings),
    )
    var secondIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = modifier,
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.secondary_title))
                    }
                )
                PrimaryTabRowView(
                    tabIndex = tabIndex,
                    onTabChange = { tabIndex = it }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            when (tabIndex) {
                0 -> {
                    SecondaryTabRowView(
                        tabs = tabs,
                        tabIndex = secondIndex,
                        onTabChange = { secondIndex = it }
                    )
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = tabs[secondIndex],
                            fontSize = 56.sp
                        )
                    }
                }
                1 -> WebView(url = "https://developer.android.com")
                2 -> WebView(url = "https://www.google.co.jp")
            }
        }
    }
}
@Preview
@Composable
private fun SecondaryTabRowScreenPreview() {
    SecondaryTabRowScreen()
}