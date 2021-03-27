package com.example.roomapp.ui

import android.app.Application
import androidx.room.Room
import com.example.roomapp.data.AppDataBase

class NotesApplication : Application() {

    companion object {
        lateinit var db : AppDataBase
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            this,AppDataBase::class.java,
            "main"
        ).build()
    }
}