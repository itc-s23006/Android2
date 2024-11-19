package jp.ac.it_college.std.s23006.pokequiz.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NamedApiResource(
    val name: String,
    val url: String
)

@Serializable
data class Name(
    val name: String,
    val language: NamedApiResource
) {
    val isJa: Boolean
        get() = language.name =="ja"
    val isJaHrkt: Boolean
        get() = language.name == "ja_Hrkt"
}

@Serializable
data class Named(
    val count: Int = 0,
    val next: String? = null,
    val previous: String? =  null,
    val results: List<NamedApiResource> = emptyList()
)