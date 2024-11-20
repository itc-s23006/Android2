package jp.ac.it_college.std.s23006.pokequiz.ui.generation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@Composable
fun GenerationScreen(
    modifier: Modifier = Modifier,
    onGenerationSelected: (Int) -> Unit = {},
    viewModel: GenerationViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val uiState by viewModel.uiState.collectAsState()
    val generations by uiState.generations.collectAsState(initial = emptyList())
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "せだいせんたく")
        Button(
            onClick = {
//                onGenerationSelected(1)
                scope.launch {
                    // viewModel.generationTest()
                }
            }
        ) {
            Text(text = "ランダムでせだいを追加")
        }
        LazyColumn {
            items(generations) { item ->
                Text(text = "${item.name} - ${item.region}")
            }
        }
    }
}

@Preview
@Composable
private fun GenerationScreenPreview() {
    GenerationScreen()
}