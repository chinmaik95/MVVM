package com.example.b2mvvm;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.b2mvvm.di.MyExample;

import java.util.Date;

import javax.inject.Inject;

public class DaggerActivity extends Activity {//lunch
    // im not instantiating this object
    @Inject MyExample mMyExample;
    //instead i am injecting this object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        TextView dateTextView = findViewById(R.id.tvDate);

        ((MyApplication)getApplicationContext())
                .getMyComponent()
                .inject(DaggerActivity.this);

        dateTextView.setText((new Date(mMyExample.getDate())).toString());


    }
}
