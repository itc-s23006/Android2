package jp.ac.it_college.std.s23006.pokequiz.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "generations")
data class GenerationEntity(
    @PrimaryKey val id: Int = 0,
    val name: String,
    val region: String
)
