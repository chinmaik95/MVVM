package com.example.b2mvvm.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteRoomDatabase
                      extends RoomDatabase {
   public abstract NoteDao NoteDao();

   private static NoteRoomDatabase INSTANCE; //trying to create a singleton

   public static NoteRoomDatabase getDatabase(final Context context) {
      if (INSTANCE == null) {
         synchronized (NoteRoomDatabase.class) {
            if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                       NoteRoomDatabase.class, "note_database")
                       // Wipes and rebuilds instead of migrating
                       // if no Migration object.
                       // Migration is not part of this practical.
                       .fallbackToDestructiveMigration()
                       .build();
            }
         }
      }
      return INSTANCE;
   }
}
