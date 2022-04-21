package com.example.notify

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: Repository) : ViewModel() {

    val allNotes : LiveData<List<Notes>> = repository.allNotes

    fun insert(note: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(note)
        }
    }

    fun delete(note: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }
}