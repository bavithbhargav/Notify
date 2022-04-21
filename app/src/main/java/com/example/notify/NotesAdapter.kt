package com.example.notify

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val listener : INotesRvAdapter): RecyclerView.Adapter<NotesViewHolder>() {

    private val allNotes = ArrayList<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.notes_item,
            parent,
            false
        ))
        viewHolder.deleteButton.setOnClickListener {
            listener.onitemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currNote = allNotes[position]
        holder.textView.text = currNote.note
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    public fun getNotes(notesList: List<Notes>){
        allNotes.clear()
        allNotes.addAll(notesList)

        notifyDataSetChanged()
    }

}

interface INotesRvAdapter{
    fun onitemClicked(note : Notes)
}

class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView = itemView.findViewById<TextView>(R.id.itemTv)
    val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)
}