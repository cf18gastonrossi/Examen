package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.Model.Event;
import com.example.timeapp.Dao.EntryDao;
import com.example.timeapp.Dao.UserDao;
import com.example.timeapp.models.Entry;
import com.example.timeapp.models.Users;

@Database(entities = {Event.class}, version = 1)
public abstract class RoomConnection extends RoomDatabase {

    private static RoomConnection INSTANCE;

    public abstract EntryDao entryDao();

    public static RoomConnection getRoomConnection(Context c){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(c,RoomConnection.class,"timeapp.db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyRoomConnection() {
        INSTANCE = null;
    }

}
