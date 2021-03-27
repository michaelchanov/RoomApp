package com.example.roomapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}