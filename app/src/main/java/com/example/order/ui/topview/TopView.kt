package com.example.order.ui.topview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.s23006.ui.theme.Lime600
import com.example.s23006.ui.theme.Orange900

@Composable
fun TopView(modifier: Modifier = Modifier, onTapButton: () -> Unit = {}) {
    Column(
        modifier = modifier.background(Color.Yellow)
    ) {
        Box {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Orange900)) {
                        append(stringResource(id = R.string.shop_name_first))
                    }
                    append(stringResource(id = R.string.shop_name_second))
                },
                modifier = Modifier.padding(top = 72.dp),
                color = Lime600,
                fontSize = 50.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, blurRadius = 10f, offset = Offset(10f, 10f)
                    )
                )
                )
        }

        Row {  }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 100)
@Composable
private fun TopViewPreview() {
    TopView(onTapButton = {})
}