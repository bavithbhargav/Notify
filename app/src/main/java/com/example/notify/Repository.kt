package com.example.notify

import androidx.lifecycle.LiveData

class Repository(private val notesDao: NotesDao) {

    val allNotes: LiveData<List<Notes>> = notesDao.getAllNotes()

    suspend fun insertNote(note: Notes){
        notesDao.insert(note)
    }

    suspend fun deleteNote(note: Notes){
        notesDao.delete(note)
    }
}