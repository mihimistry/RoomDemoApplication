package com.maxgen.roomdemoapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.maxgen.roomdemoapplication.Note;
import com.maxgen.roomdemoapplication.data.repo.Repository;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {
    Repository repository;
    LiveData<List<Note>> notesList;
    public RoomViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        notesList=repository.getNoteList();
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
}
