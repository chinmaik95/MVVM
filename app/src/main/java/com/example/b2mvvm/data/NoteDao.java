package com.example.b2mvvm.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
   @Insert  // contentvalues, db.insert(tablename,null,values);
   void insert(Note note);//2c
   @Update
   public void updateWords(Note... words);

    @Query("DELETE FROM note_table")
    public void deleteAll();

    @Query("SELECT * from note_table ORDER BY title ASC")
    public List<Note> getAllWords();//4c

    @Query("SELECT * FROM note_table WHERE title LIKE :note ")
    public List<Note> findWord(String note);

}
