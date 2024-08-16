package com.example.deknoteapp.features.notes.domain.use_case

import com.example.deknoteapp.features.notes.domain.NoteRepository
import com.example.deknoteapp.features.notes.domain.model.Note
import javax.inject.Inject

class GetNoteById @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun  invoke(noteId: Int): Note{
        return repository.getNoteById(noteId)
    }
}