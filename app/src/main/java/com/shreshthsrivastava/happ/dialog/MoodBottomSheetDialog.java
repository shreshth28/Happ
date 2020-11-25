package com.shreshthsrivastava.happ.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.shreshthsrivastava.happ.R;

public class MoodBottomSheetDialog extends BottomSheetDialogFragment {

    private MoodItemClickListener moodItemClickListener;
    private LottieAnimationView happy,sad,joy,proud,embarrassed,angry;


    public MoodBottomSheetDialog(MoodItemClickListener moodItemClickListener) {
        this.moodItemClickListener = moodItemClickListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottom_mood_sheet,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        happy=view.findViewById(R.id.happy_animation_view);
        sad=view.findViewById(R.id.sad_animation_view);
        angry=view.findViewById(R.id.angry_animation_view);
        proud=view.findViewById(R.id.proud_animation_view);
        embarrassed=view.findViewById(R.id.embarrased_animation_view);
        joy=view.findViewById(R.id.joy_animation_view);
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             moodItemClickListener.moodClickListener(3);
            }
        });
        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodItemClickListener.moodClickListener(1);
            }
        });
        embarrassed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodItemClickListener.moodClickListener(2);
            }
        });
        joy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodItemClickListener.moodClickListener(4);
            }
        });
        proud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodItemClickListener.moodClickListener(5);
            }
        });
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodItemClickListener.moodClickListener(6);
            }
        });
    }

    public interface MoodItemClickListener{
        void moodClickListener(int rating);
    }





}
