package com.maxgen.roomdemoapplication.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.maxgen.roomdemoapplication.model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public static NoteDatabase database;

    public abstract NotesDao notesDao();

    public static NoteDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "NoteDB")
                    .fallbackToDestructiveMigration().build();
        }
        return database;
    }

}
