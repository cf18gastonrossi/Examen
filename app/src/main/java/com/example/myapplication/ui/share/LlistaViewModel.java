package com.example.myapplication.ui.share;

import android.app.Application;

import com.example.myapplication.Model.Event;
import com.example.myapplication.database.Repository;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlistaViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Event>> mLlistat;
    private MutableLiveData<Event> mEvent;
    public Repository repository;

    public LlistaViewModel(Application application) {
        mLlistat = new MutableLiveData<>();
        mEvent = new MutableLiveData<>();
        aconseguirLlistat();
        repository = new Repository(application);
    }

    private void aconseguirLlistat() {

        //Aqui aconseguim el llistat picant la info, pero normalment vindrà de BBDD
        ArrayList<Event> temporal_list = Repository.getEvents();

        mLlistat.setValue(temporal_list);

    }

    public LiveData<ArrayList<Event>> getLlistat() {
        return mLlistat;
    }

    public LiveData<Event> getUsuari() {
        return mEvent;
    }

    public void getDetallUsuari(int posicio){

        //Se suposa que jo tinc accés aquí a la llista usuari
        //fent crida a BBDD, inclus a un usuari concret fent SELECT WHERE
        mEvent.setValue(mLlistat.getValue().get(posicio));
    }
}