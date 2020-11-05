package com.maxgen.roomdemoapplication.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.maxgen.roomdemoapplication.Note;
import com.maxgen.roomdemoapplication.data.NoteDatabase;
import com.maxgen.roomdemoapplication.data.NotesDao;

import java.util.List;

public class Repository {
    private NotesDao notesDao;
    private LiveData<List<Note>> noteList;

    public Repository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        notesDao = noteDatabase.notesDao();
        noteList = notesDao.getNotes();
    }

    public void insert(Note note) {
        notesDao.insert(note);
    }

    public void update(Note note) {
        notesDao.update(note);
    }

    public void delete(Note note) {
        notesDao.delete(note);
    }

    public void deleteAllNotes() {
        notesDao.deleteAllNotes();
    }

    public LiveData<List<Note>> getNoteList() {
        return noteList;
    }

}
