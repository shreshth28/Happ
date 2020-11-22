package com.shreshthsrivastava.happ.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.shreshthsrivastava.happ.database.NoteAPI;
import com.shreshthsrivastava.happ.database.model.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteAPI noteAPI;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteAPI=new NoteAPI(application);
        allNotes=noteAPI.getAllNotes();
    }

    public void insert(Note note)
    {
        noteAPI.insert(note);
    }
    public void update(Note note)
    {
        noteAPI.update(note);
    }

    public void delete(Note note)
    {
        noteAPI.delete(note);
    }

    public LiveData<List<Note>> getAllNotes()
    {
        return(noteAPI.getAllNotes());
    }
}
