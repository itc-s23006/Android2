package jp.ac.it_college.std.s23006.mytodo.ui.item

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.mytodo.R
import jp.ac.it_college.std.s23006.mytodo.ui.TodoTopAppBar
import jp.ac.it_college.std.s23006.mytodo.ui.navigation.NavigationDestination

object ItemEditDestination : NavigationDestination {
    override val route = "item_edit"
    override val titleRes = R.string.edit_item_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit = {},
    onNavigateUp: () -> Unit = {},
    ) {
    Scaffold(
        topBar = {
            TodoTopAppBar(
                title = stringResource(ItemEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Text(text = "ここに編集画面表示", modifier =
        Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun ItemEditScreenPreview() {
    ItemEditScreen()
}