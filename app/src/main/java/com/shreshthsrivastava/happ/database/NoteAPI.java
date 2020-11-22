package com.shreshthsrivastava.happ.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.shreshthsrivastava.happ.database.dao.NoteDao;
import com.shreshthsrivastava.happ.database.model.Note;
import com.shreshthsrivastava.happ.helper.AppExecutors;

import java.util.List;

public class NoteAPI {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteAPI(Application application)
    {
        NoteDatabase database=NoteDatabase.getInstance(application);
        noteDao=database.noteDao();
        allNotes=noteDao.getAllNotes();
    }

    public void insert(Note note)
    {
        AppExecutors.getInstance().diskIO().execute(() -> noteDao.insert(note));
    }

    public void delete(Note note)
    {
        AppExecutors.getInstance().diskIO().execute(() -> noteDao.delete(note));
    }

    public void update(Note note)
    {
        AppExecutors.getInstance().diskIO().execute(() -> noteDao.update(note));
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }



}
