package com.maxgen.roomdemoapplication.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.work.WorkManager;

import com.maxgen.roomdemoapplication.model.Note;
import com.maxgen.roomdemoapplication.data.NoteDatabase;
import com.maxgen.roomdemoapplication.data.NotesDao;

import java.util.List;

public class Repository {

    private NotesDao notesDao;
    private LiveData<List<Note>> noteList;

    public Repository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        notesDao = database.notesDao();
        noteList = notesDao.getNotes();
    }

    public void insert(Note note) {
        new InsertNote(notesDao).execute(note);
    }

    public void delete(Note note) {
        notesDao.delete(note);
    }

    public void update(Note note) {
        notesDao.update(note);
    }

    public LiveData<List<Note>> getNoteList() {
        return noteList;
    }

    public void deleteAllNotes() {
        notesDao.deleteAllNotes();
    }


    public class InsertNote extends AsyncTask<Note, Void, Void> {

        NotesDao notesDao;

        public InsertNote(NotesDao notesDao) {
            this.notesDao = notesDao;
        }

        @Override
        protected Void doInBackground(Note... note) {
            notesDao.insert(note[0]);
            return null;
        }
    }
}

