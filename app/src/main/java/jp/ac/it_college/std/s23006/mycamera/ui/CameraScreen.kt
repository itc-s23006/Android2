package jp.ac.it_college.std.s23006.mycamera.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import jp.ac.it_college.std.s23006.mycamera.R

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(modifier: Modifier = Modifier) {
    val cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )
    val cameraState = rememberCameraState()

    if (cameraPermissionState.status.isGranted) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            PreviewCamera { ctx ->
                cameraState.startCamera(ctx)
            }
            TakePhoto(modifier = Modifier.padding(16.dp)) {
                cameraState.takePhoto()
            }
        }
    } else {
        Column(modifier = modifier) {
            Text(text = stringResource(id = R.string.camera_permission_denied))

            Button(onClick = {
                cameraPermissionState.launchPermissionRequest()
            }) {
                Text(text = stringResource(id = R.string.request_camera_permission))
            }
        }
    }
}