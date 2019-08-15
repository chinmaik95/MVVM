package com.example.b2mvvm.di;

import com.example.b2mvvm.DaggerActivity;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = MyModule.class)//maps the producer to consumer
public interface MyComponent {

    void inject(DaggerActivity daggerActivity);

    //producer = Mymodule = father
    //consumer = DaggerActivity = lunch[son]
    
}