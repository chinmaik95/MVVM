package com.example.b2mvvm.di;

import java.util.Date;

class MyExampleImpl implements MyExample {//drink

    private long mDate;
    
    MyExampleImpl() {
        mDate = new Date().getTime();
    }
    
    public long getDate() {
        return mDate;
    }
    
}