package com.example.myapplication.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.example.timeapp.Database.DBDesign;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "EventDetail")
public class Event implements Serializable {

    @NonNull
    @ColumnInfo(name = "Title")
    private String title;

    @NonNull
    @ColumnInfo(name = "EvDate")
    private Date evDate;

    @NonNull
    @ColumnInfo(name = "Place")
    private String place;

    @NonNull
    @ColumnInfo(name = "Email")
    private String email;

    @NonNull
    @ColumnInfo(name = "Room")
    private String room;

    @NonNull
    @ColumnInfo(name = "Price")
    private int price;

    @NonNull
    @ColumnInfo(name = "People")
    private int people;

    @NonNull
    @ColumnInfo(name = "Description")
    private String description;

    public Event(@NonNull String title, @NonNull Date evDate, @NonNull String place, @NonNull String email, @NonNull String room, int price, int people, @NonNull String description){
        this.title = title;
        this.evDate = evDate;
        this.place = place;
        this.email = email;
        this.room = room;
        this.price = price;
        this.people = people;
        this.description = description;
    }


    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public Date getEvDate() {
        return evDate;
    }

    public void setEvDate(@NonNull Date evDate) {
        this.evDate = evDate;
    }

    @NonNull
    public String getPlace() {
        return place;
    }

    public void setPlace(@NonNull String place) {
        this.place = place;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getRoom() {
        return room;
    }

    public void setRoom(@NonNull String room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}