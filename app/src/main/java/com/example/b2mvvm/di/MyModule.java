package com.example.b2mvvm.di;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {    //fathermodule

    @Provides  //father who'll provide drink for lunch
    @Singleton
    static MyExample provideMyExample() {
        return new MyExampleImpl();
    }

    //MyExampleImpl = drink
    
}