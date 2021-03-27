package com.example.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomapp.data.NoteRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = NoteRepository()

        createNew.setOnClickListener {
            val title = noteTitle.text.toString()
            val text = noteText.text.toString()

            if (title.isNotBlank() && text.isNotBlank()) {
                launch {
                    val id = repo.createNewNote(title, text)
                    Toast.makeText(applicationContext, "Inserted with id $id", Toast.LENGTH_SHORT).show()
                }
            }
        }
        notesList.setOnClickListener {
            launch {
                Toast.makeText(applicationContext, "${repo.getAllNotes().toString()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}