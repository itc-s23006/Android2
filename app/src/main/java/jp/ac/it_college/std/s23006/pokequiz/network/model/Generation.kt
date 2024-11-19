package jp.ac.it_college.std.s23006.pokequiz.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Generation(
    val id: Int,
    val name: String,
    @SerialName("main_region")
    val mainRegion: NamedApiResource,
    val names: List<Name>,
    @SerialName("pokemon_species")
    val pokemonSpecies: List<NamedApiResource>
)
