package com.maxgen.roomdemoapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.maxgen.roomdemoapplication.data.NotesDao;

public class RoomWorker extends Worker {
    NotesDao notesDao;
    public RoomWorker(@NonNull Context context, @NonNull WorkerParameters workerParams, NotesDao notesDao) {
        super(context, workerParams);
        this.notesDao=notesDao;

    }

    @NonNull
    @Override
    public Result doWork() {

        return Result.success();
    }
}
