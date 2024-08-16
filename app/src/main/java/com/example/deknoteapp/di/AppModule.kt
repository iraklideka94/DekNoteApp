package com.example.deknoteapp.di

import android.content.Context
import androidx.room.Room
import com.example.deknoteapp.features.notes.data.LocalDataBase
import com.example.deknoteapp.features.notes.data.NoteRepositoryImpl
import com.example.deknoteapp.features.notes.domain.NoteRepository
import com.example.deknoteapp.features.notes.domain.use_case.DeleteNote
import com.example.deknoteapp.features.notes.domain.use_case.GetAllNotes
import com.example.deknoteapp.features.notes.domain.use_case.GetNoteById
import com.example.deknoteapp.features.notes.domain.use_case.InsertNote
import com.example.deknoteapp.features.notes.domain.use_case.UpdateNote
import com.example.deknoteapp.features.notes.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            LocalDataBase::class.java,
            "local_database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: LocalDataBase): NoteRepository {
        return NoteRepositoryImpl(dao = db.noteDao())
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: NoteRepository): UseCases{
        return UseCases(
            insertNote = InsertNote(repository),
            updateNote = UpdateNote(repository),
            deleteNote = DeleteNote(repository),
            getNoteById = GetNoteById(repository),
            getAllNotes = GetAllNotes(repository)
            )
    }

}