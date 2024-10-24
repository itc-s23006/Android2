package jp.ac.it_college.std.s23006.myslideshow.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23006.myslideshow.R

@Composable
fun PagerItem(
    modifier: Modifier = Modifier,
    @DrawableRes imageRes: Int,
    ) {
    Image(
        painter = painterResource(id = imageRes),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier
    )
}

@Preview
@Composable
private fun PagerItemPreview() {
    PagerItem(imageRes = R.drawable.slide00)
}