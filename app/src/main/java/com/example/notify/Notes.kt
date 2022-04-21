package com.example.notify

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Notes(@ColumnInfo(name = "note") val note: String){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
