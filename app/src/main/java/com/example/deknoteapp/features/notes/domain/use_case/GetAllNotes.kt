package com.example.deknoteapp.features.notes.domain.use_case

import com.example.deknoteapp.features.notes.domain.NoteRepository
import com.example.deknoteapp.features.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotes @Inject constructor(
    private val repository: NoteRepository
) {

    operator fun invoke(): Flow<List<Note>> {
        return repository.getAllNotes()
    }
}