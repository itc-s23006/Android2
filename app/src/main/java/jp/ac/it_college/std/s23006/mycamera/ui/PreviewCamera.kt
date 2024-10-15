package jp.ac.it_college.std.s23006.mycamera.ui

import android.content.Context
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun PreviewCamera(
    modifier: Modifier = Modifier,
    createPreviewCamera: (Context) -> PreviewView
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { ctx ->
            createPreviewCamera(ctx)
        }
    )
}