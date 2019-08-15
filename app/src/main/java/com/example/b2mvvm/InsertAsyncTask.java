package com.example.b2mvvm;

import android.os.AsyncTask;

import com.example.b2mvvm.data.Note;
import com.example.b2mvvm.data.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note,Void,Void> {
    NoteDao noteDao;
    public InsertAsyncTask(NoteDao noteDao) {//1a
        this.noteDao = noteDao;
    }

    @Override
    protected Void doInBackground(Note... notes) {//2a
        noteDao.insert(notes[0]);//2b
        return null;
    }
}
