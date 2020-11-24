package com.shreshthsrivastava.happ.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shreshthsrivastava.happ.R;
import com.shreshthsrivastava.happ.database.model.Note;
import com.shreshthsrivastava.happ.viewmodel.ShareDataViewModel;

public class DetailFragment extends Fragment {

    private ShareDataViewModel shareDataViewModel;
    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shareDataViewModel=new ViewModelProvider(requireActivity()).get(ShareDataViewModel.class);
        shareDataViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Note>() {
            @Override
            public void onChanged(Note note) {
                
            }
        });
    }
}