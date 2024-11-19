package jp.ac.it_college.std.s23006.pokequiz.network

import jp.ac.it_college.std.s23006.pokequiz.network.model.Generation
import jp.ac.it_college.std.s23006.pokequiz.network.model.Named
import jp.ac.it_college.std.s23006.pokequiz.network.model.Region
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val json = Json {
    ignoreUnknownKeys = true
}

internal val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(
        json.asConverterFactory(
            "application/json; charset=UTF-8".toMediaType()
        )
    )
    .build()

interface PokeApiService {
    @GET("generation")
    suspend fun getGenerations(): Named

    @GET("generation/{id}")
    suspend fun getGeneration(@Path("id") id: Int): Generation

    @GET("generation/{name}")
    suspend fun getGeneration(@Path("name") name: String): Generation

    @GET("region/{name}")
    suspend fun getRegion(@Path("name") name: String): Region
}