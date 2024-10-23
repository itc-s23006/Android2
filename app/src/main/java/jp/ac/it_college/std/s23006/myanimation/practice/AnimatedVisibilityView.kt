package jp.ac.it_college.std.s23006.myanimation.practice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s23006.myanimation.R
import jp.ac.it_college.std.s23006.myanimation.ui.theme.MyAnimationTheme

@Preview(device = "spec:width=100dp,height=150dp,dpi=440", showBackground = true)
@Composable
private fun AnimatedVisibilityView() {
    MyAnimationTheme {
        var show by remember { mutableStateOf(true) }
        Box {
            Column {
                AnimatedVisibility(visible = show) {
                    Text(
                        modifier = Modifier
                            .size(size = 100.dp)
                            .background(color = Color.Magenta),
                        text = "アニメーションします"
                    )
                }
                Button(onClick = {
                    show = !show
                }) {
                    Text(text = if (show) "表示" else "非表示")
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun MultipleAnimatedVisibility() {
    MyAnimationTheme {
        var show by remember { mutableStateOf(false) }
        Column {
            Row(modifier = Modifier.size(100.dp)) {
                AnimatedVisibility(
                    visible = show,
                    enter = slideInHorizontally() + fadeIn(),
                    exit = slideOutHorizontally() + fadeOut(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.slide04),
                        contentDescription = null
                    )
                }
            }
            Button(onClick = {
                show = !show
            }) {
                Text(text = "ANIMATION")
            }
        }
    }
}