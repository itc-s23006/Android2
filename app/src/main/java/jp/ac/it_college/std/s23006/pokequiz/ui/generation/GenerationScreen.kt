package jp.ac.it_college.std.s23006.pokequiz.ui.generation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GenerationScreen(
    modifier: Modifier = Modifier,
    onGenerationSelected: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "せだいせんたく")
        Button(
            onClick = {
                onGenerationSelected(1)
            }
        ) {
            Text(text = "だい１せだい")
        }
    }
}
@Preview
@Composable
private fun GenerationScreenPreview() {
    GenerationScreen()
}