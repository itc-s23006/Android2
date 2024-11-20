package jp.ac.it_college.std.s23006.pokequiz.ui.generation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.ac.it_college.std.s23006.pokequiz.data.entity.GenerationEntity
import jp.ac.it_college.std.s23006.pokequiz.data.repository.GenerationsRepository
import jp.ac.it_college.std.s23006.pokequiz.network.PokeApiService
import jp.ac.it_college.std.s23006.pokequiz.network.model.Name
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

data class GenerationUiState(
    var isLoading: Boolean = false,
    var generations: Flow<List<GenerationEntity>>
)

@HiltViewModel
class GenerationViewModel @Inject constructor(
    private val repository: GenerationsRepository,
    private val pokeApiService: PokeApiService
) : ViewModel() {
  private val _uiState = MutableStateFlow(
      GenerationUiState(generations = repository.getAllGenerationsStream())
  )
    val uiState: StateFlow<GenerationUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            // データベース内の世代データが無ければ PokeAPI から取ってくる。
            if (repository.getGenerationCount().first() == 0) {
                // API からデータ取ってきてデータベースに保存する処理
                retrieveAndCacheGenerations()
            }
        }
    }

    suspend fun insert(generation: GenerationEntity) =
        repository.upsertGeneration(generation)

    private suspend fun retrieveAndCacheGenerations() {
        pokeApiService.getGenerations().results.forEach { result ->
            // 世代情報の詳細を取ってくる
            val gen = pokeApiService.getGeneration(result.name)
            // 地域情報を取ってくる
            val region = pokeApiService.getRegion(gen.mainRegion.name)
            // gen と region をまとめてデータベースに登録する
            repository.upsertGeneration(
                GenerationEntity(
                    // 数値のID
                    id = gen.id,
                    // 世代名の日本語
                    name = gen.names.firstOrNull(Name::isJa)?.name ?: "??",
                    // 地域名の日本語
                    region = region.names.firstOrNull(Name::isJaHrkt)?.name ?: "??"
                )
            )
        }
    }

    suspend fun generationTest() {
        pokeApiService.getGenerations().results.forEach { result ->
            Log.d("GenerationVM", "result: $result")
        }
    }
}