package com.shreshthsrivastava.happ.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shreshthsrivastava.happ.database.model.Note;

public class ShareDataViewModel extends ViewModel {
    private final MutableLiveData<Note> noteMutableLiveData=new MutableLiveData<Note>();
    public void select(Note note)
    {
        noteMutableLiveData.setValue(note);
    }

    public LiveData<Note> getSelected()
    {
        return noteMutableLiveData;
    }
}
