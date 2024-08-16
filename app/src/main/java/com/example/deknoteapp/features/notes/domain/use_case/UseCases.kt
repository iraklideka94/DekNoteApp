package com.example.deknoteapp.features.notes.domain.use_case

data class UseCases(
    val insertNote: InsertNote,
    val updateNote: UpdateNote,
    val deleteNote: DeleteNote,
    val getNoteById: GetNoteById,
    val getAllNotes: GetAllNotes
)
