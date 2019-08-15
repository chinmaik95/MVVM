package com.example.b2mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.b2mvvm.data.Note;
import com.example.b2mvvm.data.NoteDao;
import com.example.b2mvvm.data.NoteRoomDatabase;

public class MainActivity extends AppCompatActivity {
    EditText titleEditText, subTitleEditText;
    NoteDao noteDao;
    NoteRoomDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleEditText = findViewById(R.id.editTextTitle);
        subTitleEditText = findViewById(R.id.editTextSubtitle);

        database = NoteRoomDatabase.getDatabase(this);
        noteDao = database.NoteDao();
    }

    public void clickListener(View view) {
        switch (view.getId()) {
        case R.id.buttonput:
            String title = titleEditText.getText().toString();
            String subtitle = subTitleEditText.getText().toString();

            Note note = new Note(title,subtitle);

            InsertAsyncTask insertAsyncTask = new InsertAsyncTask(noteDao);//1
            insertAsyncTask.execute(note);//2
            break;
            case R.id.buttonget:
                TextView resTextView = findViewById(R.id.textViewres);
                GetAsyncTask getAsyncTask = new GetAsyncTask(noteDao,resTextView);//3
                getAsyncTask.execute();//4



            break;
        }
    }
}
