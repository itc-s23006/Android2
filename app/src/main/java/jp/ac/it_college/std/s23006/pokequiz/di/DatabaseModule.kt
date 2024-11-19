package jp.ac.it_college.std.s23006.pokequiz.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.ac.it_college.std.s23006.pokequiz.data.PokeQuizDatabase
import jp.ac.it_college.std.s23006.pokequiz.data.impl.GenerationsRepositoryImpl
import jp.ac.it_college.std.s23006.pokequiz.data.repository.GenerationsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindGenerationsRepository(impl: GenerationsRepositoryImpl): GenerationsRepository
}
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            PokeQuizDatabase::class.java,
            "poke_quiz_database"
        ).build()
    @Singleton
    @Provides
    fun provideGenerationDao(db: PokeQuizDatabase) = db.generationDao()
}