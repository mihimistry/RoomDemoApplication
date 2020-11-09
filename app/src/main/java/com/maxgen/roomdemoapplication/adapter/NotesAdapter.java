package com.maxgen.roomdemoapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxgen.roomdemoapplication.R;
import com.maxgen.roomdemoapplication.model.Note;
import com.maxgen.roomdemoapplication.databinding.NotesListViewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    List<Note> noteList;
    Context context;
    OnOptionSelectedListener listener;

    public NotesAdapter(@NotNull List<Note> it, Context context, OnOptionSelectedListener listener) {
        this.noteList = it;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(NotesListViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        PopupMenu popupMenu;

        public NotesViewHolder(@NonNull NotesListViewBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

        public void setData(Note note) {
            binding.setNote(note);

            popupMenu = new PopupMenu(context, binding.imgOption);
            popupMenu.getMenuInflater().inflate(R.menu.item_option_menu, popupMenu.getMenu());
            binding.imgOption.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupMenu.show();
                }
            });
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.action_delete) {
                        listener.deleteNote(note);
                    }
                    if (item.getItemId() == R.id.action_update) {
                        listener.updateNote(note);
                    }
                    return true;
                }
            });
        }
    }
}
