package com.shreshthsrivastava.happ.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shreshthsrivastava.happ.R;
import com.shreshthsrivastava.happ.database.model.Note;
import com.shreshthsrivastava.happ.viewmodel.ShareDataViewModel;

public class DetailFragment extends Fragment {

    private TextView detailTitleTextView;
    private TextView detailDescriptionTextView;
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
        detailTitleTextView=view.findViewById(R.id.detail_title_text_view);
        detailDescriptionTextView=view.findViewById(R.id.detail_description_text_view);
        ShareDataViewModel shareDataViewModel=new ViewModelProvider(requireActivity()).get(ShareDataViewModel.class);
        shareDataViewModel.getSelected().observe(getViewLifecycleOwner(), note -> {
            Toast.makeText(getActivity(), "Trying "+note.getTitle(), Toast.LENGTH_SHORT).show();
            detailTitleTextView.setText(note.getTitle());
            detailDescriptionTextView.setText(note.getDescription());
        });
        Intent sharedNoteIntent=getActivity().getIntent();
        if(!getResources().getBoolean(R.bool.isTablet)&&sharedNoteIntent!=null)
        {
            Note sharedNote=sharedNoteIntent.getParcelableExtra("Shared Note");
            detailTitleTextView.setText(sharedNote.getTitle());
            detailDescriptionTextView.setText(sharedNote.getDescription());
        }
    }
}