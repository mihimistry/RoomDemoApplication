package com.maxgen.roomdemoapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.maxgen.roomdemoapplication.model.Note;
import com.maxgen.roomdemoapplication.adapter.OnAddNoteListener;
import com.maxgen.roomdemoapplication.databinding.ActivityAddNoteBinding;
import com.maxgen.roomdemoapplication.viewmodel.RoomViewModel;

public class AddNoteActivity extends AppCompatActivity implements OnAddNoteListener {
    private ActivityAddNoteBinding binding;
    RoomViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.addNoteListener = this;
    }

    @Override
    public void addNewNote(Note note) {
        viewModel.insert(note);
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        finish();
    }
}