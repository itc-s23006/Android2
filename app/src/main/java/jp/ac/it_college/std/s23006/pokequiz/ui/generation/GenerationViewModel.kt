package jp.ac.it_college.std.s23006.pokequiz.ui.generation

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.ac.it_college.std.s23006.pokequiz.data.entity.GenerationEntity
import jp.ac.it_college.std.s23006.pokequiz.data.repository.GenerationsRepository
import jp.ac.it_college.std.s23006.pokequiz.network.PokeApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GenerationViewModel @Inject constructor(
    private val repository: GenerationsRepository,
    private val pokeApiService: PokeApiService
) : ViewModel() {
    val generations: Flow<List<GenerationEntity>> =
        repository.getAllGenerationsStream()

    suspend fun insert(generation: GenerationEntity) =
        repository.upsertGeneration(generation)

    suspend fun generationTest() {
        pokeApiService.getGenerations().results.forEach { result ->
            Log.d("GenerationVM", "result: $result")
        }
    }
}