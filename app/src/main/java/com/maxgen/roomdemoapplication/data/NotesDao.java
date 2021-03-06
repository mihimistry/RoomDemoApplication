package com.maxgen.roomdemoapplication.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.maxgen.roomdemoapplication.model.Note;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface NotesDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table")
    LiveData<List<Note>> getNotes();
}
