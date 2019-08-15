package com.example.b2mvvm;

import android.app.Application;

import com.example.b2mvvm.di.DaggerMyComponent;
import com.example.b2mvvm.di.MyComponent;
import com.example.b2mvvm.di.MyModule;


public class MyApplication extends Application {
    private MyComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyComponent = createMyComponent();
    }
        
    MyComponent getMyComponent()
    {
        return mMyComponent;
    }
        
    private MyComponent createMyComponent() {
        return DaggerMyComponent
                //daggermycomponent class will be generated when i rebuild my project
                .builder()
                .myModule(new MyModule())
                .build();
   }

}