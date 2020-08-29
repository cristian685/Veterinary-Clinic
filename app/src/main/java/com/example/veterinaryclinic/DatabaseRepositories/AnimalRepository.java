package com.example.veterinaryclinic.DatabaseRepositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DataAccessObjects.AnimalDao;
import com.example.veterinaryclinic.Models.Animal;
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
        new InsertAnimalAsyncTask(animalDao).execute(animal);
    }

    public void update(Animal animal){
        new UpdateAnimalAsyncTask(animalDao).execute(animal);
    }

    public void delete(Animal animal){
        new DeleteAnimalAsyncTask(animalDao).execute(animal);
    }

    public void deleteAllAnimals() {
        new DeleteAllAnimalsAsyncTask(animalDao).execute();
    }

    public LiveData<List<Animal>> getAllAnimals(){
        return allAnimals;
    }

    // insert animal async task
    private static class InsertAnimalAsyncTask extends AsyncTask<Animal,Void,Void>{

        private AnimalDao animalDao;

        private InsertAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao = animalDao;
        }

        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.insert(animals[0]);
            return null;
        }
    }

    // update animal async task
    private static class UpdateAnimalAsyncTask extends AsyncTask<Animal,Void,Void>{

        private AnimalDao animalDao;

        private UpdateAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao = animalDao;
        }

        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.update(animals[0]);
            return null;
        }
    }

    // delete animal async task
    private static class DeleteAnimalAsyncTask extends AsyncTask<Animal,Void,Void>{

        private AnimalDao animalDao;

        private DeleteAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao = animalDao;
        }

        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.delete(animals[0]);
            return null;
        }
    }

    // delete all animals async task
    private static class DeleteAllAnimalsAsyncTask extends AsyncTask<Void,Void,Void>{

        private AnimalDao animalDao;

        private DeleteAllAnimalsAsyncTask(AnimalDao animalDao){
            this.animalDao = animalDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            animalDao.deleteAllAnimals();
            return null;
        }
    }
}
