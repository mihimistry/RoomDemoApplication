package com.maxgen.roomdemoapplication.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxgen.roomdemoapplication.R
import com.maxgen.roomdemoapplication.adapter.NotesAdapter
import com.maxgen.roomdemoapplication.adapter.OnOptionSelectedListener
import com.maxgen.roomdemoapplication.databinding.ActivityMainBinding
import com.maxgen.roomdemoapplication.model.Note
import com.maxgen.roomdemoapplication.viewmodel.RoomViewModel
import kotlinx.android.synthetic.main.update_note_popup.view.*

class MainActivity : AppCompatActivity(), OnOptionSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private var adapter: NotesAdapter? = null
    private var viewModel: RoomViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        viewModel = ViewModelProvider(this, factory).get(RoomViewModel::class.java)
        val notesList = viewModel!!.notesList

        notesList.observe(this, Observer {

            adapter = NotesAdapter(it, this, this)
            binding.rv.adapter = adapter
        })

        binding.rv.layoutManager = LinearLayoutManager(this)

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }

    override fun deleteNote(note: Note) {
        viewModel?.delete(note)
    }

    override fun updateNote(note: Note) {

        val builder = AlertDialog.Builder(this)
        val dialogView: View =
            LayoutInflater.from(this).inflate(R.layout.update_note_popup, null)
        builder.setTitle("Update Note")
        builder.setView(dialogView)
        val dialog = builder.create()
        dialog.show()

        dialogView.editTextTextPersonName.setText(note.title)
        dialogView.editTextTextPersonName2.setText(note.description)

        dialogView.btn_update.setOnClickListener {
            val updateNote = Note()
            updateNote.id = note.id
            updateNote.title = dialogView.editTextTextPersonName.text.toString()
            updateNote.description = dialogView.editTextTextPersonName2.text.toString()
            viewModel?.update(updateNote)
            Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

    }


}