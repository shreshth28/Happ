package com.shreshthsrivastava.happ.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shreshthsrivastava.happ.R;
import com.shreshthsrivastava.happ.database.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notes=new ArrayList<>();

    public NoteAdapter()
    {
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.note_item,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.titleTextView.setText(notes.get(position).getTitle());
        holder.descriptionTextView.setText(notes.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView;
        private TextView descriptionTextView;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.title_text_view);
            descriptionTextView=itemView.findViewById(R.id.description_text_view);
        }
    }

    public void updateData(List<Note> notes)
    {
            this.notes.clear();
            this.notes.addAll(notes);
            notifyDataSetChanged();
    }
}
