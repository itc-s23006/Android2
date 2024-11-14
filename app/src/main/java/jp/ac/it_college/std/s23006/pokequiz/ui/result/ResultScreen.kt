package jp.ac.it_college.std.s23006.pokequiz.ui.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit = {},
    onGenerationClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "けっかがめん")
        Button(
            onClick = onGenerationClick
        ) {
            Text(text = "せだいせんたくにもどる")
        }
    }
}
@Preview
@Composable
private fun ResultScreenPreview() {
    ResultScreen()
}