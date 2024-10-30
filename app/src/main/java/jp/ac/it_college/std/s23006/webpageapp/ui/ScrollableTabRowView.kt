package jp.ac.it_college.std.s23006.webpageapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.webpageapp.R

@Composable
fun ScrollableTabRowView(
    modifier: Modifier = Modifier,
    tabIndex: Int,
    onTabChange: (Int) -> Unit = {}
) {
    val tabs = listOf(
        stringResource(id = R.string.home) to Icons.Default.Home,
        stringResource(id = R.string.about) to Icons.Default.Info,
        stringResource(id = R.string.settings) to Icons.Default.Settings,
        stringResource(id = R.string.user) to Icons.Default.Person,
        stringResource(id = R.string.nice) to Icons.Default.ThumbUp,
        stringResource(id = R.string.email) to Icons.Default.Email,
        stringResource(id = R.string.star) to Icons.Default.Star,
        stringResource(id = R.string.menu) to Icons.Default.Menu,
    )
    ScrollableTabRow(modifier = modifier, selectedTabIndex = tabIndex) {
        tabs.forEachIndexed { index, (title, icon) ->
            Tab(
                selected = tabIndex == index,
                onClick = { onTabChange(index) },
                text = { Text(text = title) },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = title
                    )
                }
            )
        }
    }
}
@Preview
@Composable
private fun ScrollableTabRowViewPreview() {
    var index by remember { mutableIntStateOf(0) }
    ScrollableTabRowView(tabIndex = index, onTabChange = { index = it })
}
