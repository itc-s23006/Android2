package jp.ac.it_college.std.s23006.pokequiz.data.impl

import jp.ac.it_college.std.s23006.pokequiz.data.dao.GenerationDao
import jp.ac.it_college.std.s23006.pokequiz.data.entity.GenerationEntity
import jp.ac.it_college.std.s23006.pokequiz.data.repository.GenerationsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GenerationsRepositoryImpl @Inject constructor(
    private val dao: GenerationDao
) : GenerationsRepository {
    override fun getAllGenerationsStream(): Flow<List<GenerationEntity>> = dao.getAllGenerations()

    override fun getGenerationStream(id: Int): Flow<GenerationEntity?> = dao.getGeneration(id)

    override suspend fun upsertGeneration(generation: GenerationEntity) = dao.upsert(generation)

}