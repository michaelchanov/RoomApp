package com.example.roomapp.data

import com.example.roomapp.ui.NotesApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository {
    private val coroutineContext = Dispatchers.IO

    private val noteDao = NotesApplication.db.getNoteDao()

    suspend fun createNewNote(title: String, text: String) = withContext(coroutineContext) {
        noteDao.insertNote(Note(title, text))
    }

    suspend fun getAllNotes() = withContext(coroutineContext) {
        noteDao.getAllNotes()
    }
}