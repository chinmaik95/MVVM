package com.example.b2mvvm;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.b2mvvm.data.Note;
import com.example.b2mvvm.data.NoteDao;

import java.util.List;

public class GetAsyncTask extends AsyncTask<Void,Void, List<Note>> {
    NoteDao noteDao;
    TextView resTextView;
    public GetAsyncTask(NoteDao noteDao, TextView resTextView) {//3a
        this.noteDao = noteDao;
        this.resTextView = resTextView;
    }

    @Override
    protected List<Note> doInBackground(Void... voids) {//4a
        return noteDao.getAllWords();//4b
    }

    @Override
    protected void onPostExecute(List<Note> notes) {//4d
        super.onPostExecute(notes);
        resTextView.setText(notes.get(0).getTitle());//5
    }
}
