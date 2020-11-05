package com.maxgen.roomdemoapplication.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.maxgen.roomdemoapplication.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public static NoteDatabase database;

    public abstract NotesDao notesDao();

    public static NoteDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "NoteDB")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            NotesDao notesDao = database.notesDao();
                            Note note = new Note();
                            note.setTitle("Title");
                            note.setDescription("description");
                            notesDao.insert(note);

                        }
                    })
                    .fallbackToDestructiveMigration().build();
        }
        return database;
    }

}
