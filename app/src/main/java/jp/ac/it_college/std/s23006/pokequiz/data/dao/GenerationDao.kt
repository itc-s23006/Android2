package jp.ac.it_college.std.s23006.pokequiz.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import jp.ac.it_college.std.s23006.pokequiz.data.entity.GenerationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GenerationDao {
    @Upsert
    suspend fun upsert(generation: GenerationEntity)

    @Query("SELECT * FROM generations WHERE id = :id")
    fun getGeneration(id: Int): Flow<GenerationEntity>

    @Query("SELECT * FROM generations")
    fun getAllGenerations(): Flow<List<GenerationEntity>>

    @Query("SELECT COUNT(*) FROM generations")
    fun getGenerationCount(): Flow<Int>
}