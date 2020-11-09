package com.maxgen.roomdemoapplication.adapter

import com.maxgen.roomdemoapplication.model.Note

interface OnOptionSelectedListener {
    fun deleteNote(note:Note)
    fun updateNote(note:Note)
}