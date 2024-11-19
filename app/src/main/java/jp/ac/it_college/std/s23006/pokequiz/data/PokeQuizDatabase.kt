package jp.ac.it_college.std.s23006.pokequiz.data

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.ac.it_college.std.s23006.pokequiz.data.dao.GenerationDao
import jp.ac.it_college.std.s23006.pokequiz.data.entity.GenerationEntity

@Database(
    entities = [
        GenerationEntity::class
    ],
    version = 1
)
abstract class PokeQuizDatabase : RoomDatabase() {
    abstract fun generationDao(): GenerationDao
}