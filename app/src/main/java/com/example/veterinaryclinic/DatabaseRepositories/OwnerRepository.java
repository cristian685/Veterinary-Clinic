package com.example.veterinaryclinic.DatabaseRepositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DataAccessObjects.OwnerDao;
import com.example.veterinaryclinic.Databases.VeterinaryClinicDatabase;
import com.example.veterinaryclinic.Models.Owner;

import java.util.List;

public class OwnerRepository {

    private OwnerDao ownerDao;
    private LiveData<List<Owner>> allOwners;

    public OwnerRepository(Application application){
        VeterinaryClinicDatabase veterinaryClinicDatabase  = VeterinaryClinicDatabase.getInstance(application);
        ownerDao = veterinaryClinicDatabase.ownerDao();
        allOwners = ownerDao.getAllOwners();
    }

    public void insert(Owner owner){
        new OwnerRepository.InsertOwnerAsyncTask(ownerDao).execute(owner);
    }

    public void update(Owner owner){
        new OwnerRepository.UpdateOwnerAsyncTask(ownerDao).execute(owner);
    }

    public void delete(Owner owner){
        new OwnerRepository.DeleteOwnerAsyncTask(ownerDao).execute(owner);
    }

    public void deleteAllOwners() {
        new OwnerRepository.DeleteAllOwnersAsyncTask(ownerDao).execute();
    }

    public LiveData<List<Owner>> getAllAccounts(){
        return allOwners;
    }

    // insert owner async task
    private static class InsertOwnerAsyncTask extends AsyncTask<Owner,Void,Void>{

        private OwnerDao ownerDao;

        private InsertOwnerAsyncTask(OwnerDao ownerDao){
            this.ownerDao = ownerDao;
        }

        @Override
        protected Void doInBackground(Owner... owners) {
            ownerDao.insert(owners[0]);
            return null;
        }
    }


    // update owner async task
    private static class UpdateOwnerAsyncTask extends AsyncTask<Owner,Void,Void>{

        private OwnerDao ownerDao;

        private UpdateOwnerAsyncTask(OwnerDao ownerDao){
            this.ownerDao = ownerDao;
        }

        @Override
        protected Void doInBackground(Owner... owners) {
            ownerDao.update(owners[0]);
            return null;
        }
    }
    // delete owner async task
    private static class DeleteOwnerAsyncTask extends AsyncTask<Owner,Void,Void>{

        private OwnerDao ownerDao;

        private DeleteOwnerAsyncTask(OwnerDao ownerDao){
            this.ownerDao = ownerDao;
        }

        @Override
        protected Void doInBackground(Owner... owners) {
            ownerDao.delete(owners[0]);
            return null;
        }
    }


    // delete all owners async task
    private static class DeleteAllOwnersAsyncTask extends AsyncTask<Void,Void,Void> {

        private OwnerDao ownerDao;

        private DeleteAllOwnersAsyncTask(OwnerDao ownerDao){
            this.ownerDao = ownerDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ownerDao.deleteAllOwners();
            return null;
        }
    }
}
