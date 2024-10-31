package jp.ac.it_college.std.s23006.cherryblossoms

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import jp.ac.it_college.std.s23006.cherryblossoms.model.Cherry
import jp.ac.it_college.std.s23006.cherryblossoms.ui.CherryList
import jp.ac.it_college.std.s23006.cherryblossoms.ui.WikipediaView
import jp.ac.it_college.std.s23006.cherryblossoms.ui.theme.CherryBlossomsTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CherryBlossomsTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    val jsonString = getJson(resources)
                    val cherryList = getCherryList(jsonString)
                    val titles = listOf("桜100選", "Wikipedia")
                    val pagerState = rememberPagerState(pageCount = { titles.size})
                    val scope = rememberCoroutineScope()
                    Column {
                        TabRow(
                            selectedTabIndex = pagerState.currentPage
                        ) {
                            titles.forEachIndexed { index, title ->
                                Tab(selected = pagerState.currentPage == index, onClick = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                }, text = { Text(title) })
                            }
                        }
                        HorizontalPager(state = pagerState) { page ->
                            when (page) {
                                0 -> CherryList(
                                    modifier = Modifier.padding(innerPadding),
                                    cherryList = cherryList,
                                    onSelected = { openGoogleMaps(it.latitude, it.longitude) }
                                )
                                1 -> WikipediaView { search ->
                                    val url = "https://ja.wikipedia.org/wiki/${search.title}"
                                    openBrowser(url)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun openGoogleMaps(latitude: String, longitude: String) {
        val gmmIntentUri =
            Uri.parse("geo:$latitude, $longitude")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun getCherryList(str: String): List<Cherry> =
        Json.decodeFromString<List<Cherry>>(str)

    private fun getJson(resources: Resources): String =
        resources.assets.open("100Cherry_List.json").reader().readText()

    private fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
