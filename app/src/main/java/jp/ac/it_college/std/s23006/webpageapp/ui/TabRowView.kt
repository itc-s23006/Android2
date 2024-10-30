package jp.ac.it_college.std.s23006.webpageapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
fun TabRowView(
    modifier: Modifier = Modifier, tabIndex: Int, onTabChange: (Int) -> Unit = {}
) {
    val tabs = listOf(
        stringResource(id = R.string.home) to Icons.Default.Home,
        stringResource(id = R.string.about) to Icons.Default.Info,
        stringResource(id = R.string.settings) to Icons.Default.Settings,
    )
    TabRow(modifier = modifier, selectedTabIndex = tabIndex) {
        tabs.forEachIndexed { index, (label, icon) ->
            Tab(
                selected = tabIndex == index,
                onClick = { onTabChange(index) },
                text = { Text(text = label) },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label
                    )
                }
            )
        }
    }
}
@Preview
@Composable
private fun TabRowViewPreview() {
    var index by remember { mutableIntStateOf(0) }
    TabRowView(tabIndex = index, onTabChange = { index = it })
}