package com.maxgen.roomdemoapplication.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.maxgen.roomdemoapplication.model.Note;
import com.maxgen.roomdemoapplication.adapter.OnAddNoteListener;
import com.maxgen.roomdemoapplication.data.repo.Repository;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {
    Repository repository;
    LiveData<List<Note>> notesList;
    public String title;
    public String description;
    public OnAddNoteListener addNoteListener;



    public RoomViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        notesList = repository.getNoteList();
    }

    public void insert(Note note) {
        repository.insert(note);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getNotesList() {
        return notesList;
    }

    public void onAddNoteClicked(View view) {
        Note note = new Note();
        note.setTitle(title);
        note.setDescription(description);
        addNoteListener.addNewNote(note);
    }
}
