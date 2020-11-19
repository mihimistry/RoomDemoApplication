package com.maxgen.roomdemoapplication.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.maxgen.roomdemoapplication.data.NoteDatabase;
import com.maxgen.roomdemoapplication.data.NotesDao;
import com.maxgen.roomdemoapplication.model.Note;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Repository {

    private NotesDao notesDao;
    private LiveData<List<Note>> noteList;

    public Repository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        notesDao = database.notesDao();
        noteList = notesDao.getNotes();
    }

    public void insert(Note note) {
        Observable.fromRunnable(() -> notesDao.insert(note))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void delete(Note note) {
        Observable.fromRunnable(() -> notesDao.delete(note))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void update(Note note) {
        Observable.fromRunnable(() -> notesDao.update(note))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public LiveData<List<Note>> getNoteList() {
        return noteList;
    }

    public void deleteAllNotes() {
        notesDao.deleteAllNotes();
    }


}

