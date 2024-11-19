package jp.ac.it_college.std.s23006.pokequiz.network

object PokeApi {
    val service: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}