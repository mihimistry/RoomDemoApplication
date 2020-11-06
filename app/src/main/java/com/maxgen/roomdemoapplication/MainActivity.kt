package com.maxgen.roomdemoapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        val viewModel = ViewModelProviders.of(this).get(RoomViewModel::class.java)

        val notesList = viewModel.notesList

        notesList.observe(this, {
            adapter = NotesAdapter(it)
            binding.rv.adapter = adapter
        })

        binding.rv.layoutManager=LinearLayoutManager(this)

    }
}