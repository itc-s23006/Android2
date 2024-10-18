package jp.ac.it_college.std.s23006.postmystory.model

import androidx.compose.runtime.Stable

@Stable
data class Message(
    val caption: String,
    val image: String,
    val nice: Int
)
