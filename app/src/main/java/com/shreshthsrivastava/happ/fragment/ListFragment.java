package com.shreshthsrivastava.happ.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shreshthsrivastava.happ.R;
import com.shreshthsrivastava.happ.activity.AddNoteActivity;
import com.shreshthsrivastava.happ.activity.DetailActivity;
import com.shreshthsrivastava.happ.activity.ListActivity;
import com.shreshthsrivastava.happ.adapter.NoteAdapter;
import com.shreshthsrivastava.happ.database.model.Note;
import com.shreshthsrivastava.happ.viewmodel.NoteViewModel;
import com.shreshthsrivastava.happ.viewmodel.ShareDataViewModel;

import java.util.List;

public class ListFragment extends Fragment implements NoteAdapter.NoteItemClickListener{

    private boolean mTwoPane;
    public static final int ADD_NOTE_REQUEST=1;
    private ShareDataViewModel shareDataViewModel;
    private RecyclerView notesListRecyclerView;
    private NoteViewModel noteViewModel;
    private NoteAdapter noteAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton addNoteFloatingActionButton;
    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTwoPane=getResources().getBoolean(R.bool.isTablet);
        if(mTwoPane)
            Toast.makeText(getActivity(),"It Is Tablet",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getActivity(),"It Is A Phone",Toast.LENGTH_LONG).show();
        shareDataViewModel=new ViewModelProvider(requireActivity()).get(ShareDataViewModel.class);
        noteAdapter=new NoteAdapter(this);
        layoutManager=new LinearLayoutManager(getActivity());
        notesListRecyclerView=view.findViewById(R.id.notes_list_recycler_view);
        addNoteFloatingActionButton=view.findViewById(R.id.add_note_btn);
        notesListRecyclerView.setLayoutManager(layoutManager);
        notesListRecyclerView.setHasFixedSize(true);
        notesListRecyclerView.setAdapter(noteAdapter);
        noteViewModel=new ViewModelProvider(requireActivity(),ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()))
                .get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(requireActivity(), notes -> noteAdapter.updateData(notes));
        addNoteFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addNoteIntent=new Intent(requireActivity(), AddNoteActivity.class);
                startActivityForResult(addNoteIntent,ADD_NOTE_REQUEST);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== ListFragment.ADD_NOTE_REQUEST && resultCode==getActivity().RESULT_OK)
        {
            Note note=data.getParcelableExtra("Note Object");
            noteViewModel.insert(note);
        }
    }

    @Override
    public void clickListener(Note note) {
        shareDataViewModel.select(note);
        if(!mTwoPane) {
            Intent detailFragmentIntent = new Intent(requireContext(), DetailActivity.class);
            detailFragmentIntent.putExtra("Shared Note",note);
            startActivity(detailFragmentIntent);
        }
    }

}