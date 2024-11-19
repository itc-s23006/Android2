package jp.ac.it_college.std.s23006.pokequiz.data.repository

import jp.ac.it_college.std.s23006.pokequiz.data.entity.GenerationEntity
import kotlinx.coroutines.flow.Flow

interface GenerationsRepository {
    fun getAllGenerationsStream(): Flow<List<GenerationEntity>>
    fun getGenerationStream(id: Int): Flow<GenerationEntity?>
    suspend fun upsertGeneration(generation: GenerationEntity)
}