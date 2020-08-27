package com.example.veterinaryclinic.DatabaseRepositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DataAccessObjects.AnimalDao;
import com.example.veterinaryclinic.DatabaseEntities.Animal;
import com.example.veterinaryclinic.Databases.VeterinaryClinicDatabase;

import java.util.List;

public class AnimalRepository {

    private AnimalDao animalDao;
    private LiveData<List<Animal>> allAnimals;

    public AnimalRepository(Application application){
        VeterinaryClinicDatabase veterinaryClinicDatabase  = VeterinaryClinicDatabase.getInstance(application);
        animalDao = veterinaryClinicDatabase.animalDao();
        allAnimals = animalDao.getAllAnimals();
    }

    public void insert(Animal animal){

    }

    public void update(Animal animal){

    }

    public void delete(Animal animal){

    }

    public void deleteAllAnimals() {

    }

    public LiveData<List<Animal>> getAllAnimals(){
        return allAnimals;
    }
}
