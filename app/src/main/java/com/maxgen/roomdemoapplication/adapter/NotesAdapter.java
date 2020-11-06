package com.maxgen.roomdemoapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxgen.roomdemoapplication.Note;
import com.maxgen.roomdemoapplication.databinding.NotesListViewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    List<Note> noteList;

    public NotesAdapter(@NotNull List<Note> it) {
        this.noteList = it;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(NotesListViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.setData(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        NotesListViewBinding binding;
        public NotesViewHolder(@NonNull NotesListViewBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }

        public void setData(Note note) {
            binding.setNote(note);
        }
    }
}
