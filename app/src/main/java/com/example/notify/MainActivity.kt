package com.example.notify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var viewModel: NotesViewModel

class MainActivity : AppCompatActivity(), INotesRvAdapter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this)
        recyclerView.adapter = adapter

        val database = NotesDatabase.getDatabase(this).notesDao()
        val repository = Repository(database)
        viewModel = ViewModelProvider(this, NotesViewModelFactory(repository)).get(NotesViewModel::class.java)

        viewModel.allNotes.observe(this, Observer { list ->
            list?.let{
                adapter.getNotes(list)
            }
        })

    }

    override fun onitemClicked(note: Notes) {
        viewModel.delete(note)
    }

    fun add(view: android.view.View) {
        val editText = findViewById<EditText>(R.id.editText)
        val noteText = editText.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insert(Notes(noteText))
            editText.text = null
        }
    }
}