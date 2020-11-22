package com.shreshthsrivastava.happ.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shreshthsrivastava.happ.R;
import com.shreshthsrivastava.happ.database.model.Note;
import com.shreshthsrivastava.happ.viewmodel.NoteViewModel;

import java.util.List;

public class ListFragment extends Fragment {

    private NoteViewModel noteViewModel;

    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        noteViewModel=new ViewModelProvider(getActivity(),ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()))
                .get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(getActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                // notifyDataSetChanged
            }
        });
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}