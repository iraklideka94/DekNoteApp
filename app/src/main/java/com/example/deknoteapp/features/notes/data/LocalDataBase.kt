package com.example.deknoteapp.features.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deknoteapp.features.notes.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class LocalDataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}