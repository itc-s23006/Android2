package jp.ac.it_college.std.s23006.myslideshow.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s23006.myslideshow.R

val resources = listOf(
    R.drawable.slide00,
    R.drawable.slide01,
    R.drawable.slide02,
    R.drawable.slide03,
    R.drawable.slide04,
    R.drawable.slide05,
    R.drawable.slide06,
    R.drawable.slide07,
    R.drawable.slide08,
    R.drawable.slide09,
)
@Composable
fun Slideshow(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState { resources.size }
    val config = LocalConfiguration.current
    Scaffold(
        topBar = {
            if (config.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                TopBar()
            }
        },
        bottomBar = {
            if (config.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                BottomBar(pagerState = pagerState)
            }
        }
    ) { innerPadding ->
        VerticalPager(
            state = pagerState,
            contentPadding = PaddingValues(
                vertical = if (config.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                    60.dp
                } else {
                    0.dp
                }
            ),
            modifier = modifier.padding(innerPadding)
        ) { page ->
            PagerItem(
                imageRes = resources[page],
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
@Preview
@Composable
private fun SlideshowPreview() {
    Slideshow()
}