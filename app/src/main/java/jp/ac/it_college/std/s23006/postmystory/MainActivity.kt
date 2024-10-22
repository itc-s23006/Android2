package jp.ac.it_college.std.s23006.postmystory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import jp.ac.it_college.std.s23006.postmystory.model.Message
import jp.ac.it_college.std.s23006.postmystory.ui.CaptionScreen
import jp.ac.it_college.std.s23006.postmystory.ui.ListScreen
import jp.ac.it_college.std.s23006.postmystory.ui.PhotoGridScreen
import jp.ac.it_college.std.s23006.postmystory.ui.theme.PostMyStoryTheme
import kotlinx.serialization.Serializable

@Serializable
object ListScene

@Serializable
object PhotosScene

@Serializable
object CaptionScene

class MainActivity : ComponentActivity() {
    enum class Scene {
        LIST, PHOTOS, CAPTION
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val messages = remember { mutableStateListOf<Message>() }
//            var scene by remember { mutableStateOf(Scene.LIST) }
            var selectUrl by remember { mutableStateOf("") }
            var caption by remember { mutableStateOf("") }
            PostMyStoryTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = ListScene
                        ) {
                            composable<ListScene> {
                                ListScreen(messages = messages, onClick = {
                                    navController.navigate(route = PhotosScene)
                                })
                            }

                            composable<PhotosScene> {
                                PhotoGridScreen(onClick = { url ->
                                    selectUrl = url
                                    navController.navigate(route = CaptionScene)
                                })
                            }

                            composable<CaptionScene> {
                                CaptionScreen(
                                    selectUrl = selectUrl,
                                    onClick = {
                                        messages.add(
                                            index = 0, element = Message(
                                                image = selectUrl, caption = caption, nice = 0
                                            )
                                        )
                                        navController.navigate(route = ListScene)
                                    },
                                    onChange = { newText ->
                                        caption = newText
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CoilTest() {
    AsyncImage(
        model = "https://developer.android.com/static/images/brand/android-head_flat.png",
        contentDescription = null
    )
}