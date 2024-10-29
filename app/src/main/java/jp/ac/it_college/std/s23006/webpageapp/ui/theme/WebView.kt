package jp.ac.it_college.std.s23006.webpageapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebView(
    modifier: Modifier = Modifier,
    url: String
) {
    AndroidView(
        factory = { context ->
            android.webkit.WebView(context).apply {
                webChromeClient = android.webkit.WebChromeClient()
                webViewClient = android.webkit.WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(url)
            }
        }
    )
}