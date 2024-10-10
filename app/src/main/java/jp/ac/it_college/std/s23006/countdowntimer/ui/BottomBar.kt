package jp.ac.it_college.std.s23006.countdowntimer.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.countdowntimer.R

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    iconOnClick: (Int) -> Unit = {}
) {
    BottomAppBar(
        actions = {
            IconButton(onClick = { iconOnClick(60) }) {
                Icon(
                    imageVector = Icons.Default.PlusOne,
                    contentDescription = stringResource(id = R.string.plus_one_description)
                )
            }
        }
    )

}

@Preview
@Composable
fun BottomAppBarPreview() {
    BottomBar(iconOnClick = {})
}