package com.example.notify

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query("SELECT * FROM NOTES_TABLE ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Notes>>
}