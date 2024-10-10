package jp.ac.it_college.std.s23006.countdowntimer.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material.icons.outlined.Timer3Select
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.countdowntimer.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    iconOnClick: (Int) -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
            text = stringResource(R.string.app_name),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Timer,
                    contentDescription = "Timer"
                )
            }
        },
        actions = {
            IconButton(onClick =  { iconOnClick(3) }) {
                Icon(
                    imageVector = Icons.Outlined.Timer3Select,
                    contentDescription = "Timer3Select"
                )
            }
            IconButton(onClick =  { iconOnClick(10) }) {
                Icon(
                    imageVector = Icons.Outlined.Timer3Select,
                    contentDescription = "Timer3Select"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview
@Composable
fun TopBarPreView() {
    TopBar(iconOnClick = {})
}