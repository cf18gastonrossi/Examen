package com.example.timeapp.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Model.Event;

@Dao
public interface EventDao {

    @Insert
    void insertEvent(Event u);

    @Query("SELECT * FROM EventDetail WHERE title = :title")
    Event getEventRecyclerInfo(String title);

}
