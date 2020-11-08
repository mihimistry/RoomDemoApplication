package com.maxgen.roomdemoapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxgen.roomdemoapplication.adapter.NotesAdapter
import com.maxgen.roomdemoapplication.databinding.ActivityMainBinding
import com.maxgen.roomdemoapplication.viewmodel.RoomViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter: NotesAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory=ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        val viewModel:RoomViewModel = ViewModelProvider(this,factory).get(RoomViewModel::class.java)
        val notesList = viewModel.notesList

        notesList.observe(this, Observer {
            adapter = NotesAdapter(it)
            binding.rv.adapter = adapter
        })

        binding.rv.layoutManager=LinearLayoutManager(this)

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(this,AddNoteActivity::class.java))
        }
    }
}