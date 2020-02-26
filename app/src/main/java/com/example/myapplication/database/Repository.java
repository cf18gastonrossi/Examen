package com.example.myapplication.database;

import android.app.Application;


import com.example.myapplication.Model.Event;
import com.example.fichapp.data.RoomConnection;

import java.util.ArrayList;
import com.example.timeapp.Dao.EventDao;

public class Repository{

    static EventDao eventDao;

    public Repository(Application application) {
        RoomConnection fichappRoomDb = RoomConnection.getDatabase(application.getApplicationContext());
        eventDao = fichappRoomDb.eventRoom();
    }

    public static void registerNewEvent(final Event event) {
            eventDao.insertEvent(event);
    }

    public static ArrayList<Event> getEvents() { return Repository.getEvents();
    }


}
