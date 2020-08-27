package com.example.veterinaryclinic.Databases;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.veterinaryclinic.DataAccessOperations.AnimalDao;

public abstract class VeterinaryClinicDatabase extends RoomDatabase {

    private static VeterinaryClinicDatabase instance;

    public abstract AnimalDao animalDao();

    public static synchronized VeterinaryClinicDatabase getInstance(Context context){

        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    VeterinaryClinicDatabase.class, "veterinary_clinic_database").
                    fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
