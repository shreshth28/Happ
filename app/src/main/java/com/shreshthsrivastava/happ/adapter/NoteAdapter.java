package com.shreshthsrivastava.happ.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.shreshthsrivastava.happ.R;
import com.shreshthsrivastava.happ.database.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private NoteItemClickListener noteItemTouchListener;
    private List<Note> notes=new ArrayList<>();
    private String animationData[]={"","angry","embarrased","happy","joy","proud","sad"};
    public NoteAdapter(NoteItemClickListener noteItemTouchListener)
    {
        this.noteItemTouchListener=noteItemTouchListener;
    }
    public interface NoteItemClickListener{
        void clickListener(Note note);
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
        holder.lottieAnimationView.setAnimation(animationData[notes.get(position).getRating()]+".json");
        Log.d("Index Check",notes.get(position).getRating()+"");
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView titleTextView;
        private TextView descriptionTextView;
        private LottieAnimationView lottieAnimationView;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.title_text_view);
            descriptionTextView=itemView.findViewById(R.id.description_text_view);
            lottieAnimationView=itemView.findViewById(R.id.animation_view);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int item=getAdapterPosition();
            noteItemTouchListener.clickListener(notes.get(item));
        }
    }

    public void updateData(List<Note> notes)
    {
            this.notes.clear();
            this.notes.addAll(notes);
            notifyDataSetChanged();
    }

}
