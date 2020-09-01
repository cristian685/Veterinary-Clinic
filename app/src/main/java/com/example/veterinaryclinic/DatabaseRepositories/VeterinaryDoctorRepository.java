package com.example.veterinaryclinic.DatabaseRepositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DataAccessObjects.VeterinaryDoctorDao;
import com.example.veterinaryclinic.Databases.VeterinaryClinicDatabase;
import com.example.veterinaryclinic.Models.VeterinaryDoctor;

import java.util.List;

public class VeterinaryDoctorRepository {

    private VeterinaryDoctorDao veterinaryDoctorDao;
    private LiveData<List<VeterinaryDoctor>> allVeterinaryDoctors;

    public VeterinaryDoctorRepository(Application application){
        VeterinaryClinicDatabase veterinaryClinicDatabase  = VeterinaryClinicDatabase.getInstance(application);
        veterinaryDoctorDao = veterinaryClinicDatabase.veterinaryDoctorDao();
        allVeterinaryDoctors = veterinaryDoctorDao.getAllVeterinaryDoctors();
    }

    public void insert(VeterinaryDoctor veterinaryDoctor){
        new VeterinaryDoctorRepository.InsertVeterinaryDoctorAsyncTask(veterinaryDoctorDao).execute(veterinaryDoctor);
    }

    public void update(VeterinaryDoctor veterinaryDoctor){
        new VeterinaryDoctorRepository.UpdateVeterinaryDoctorAsyncTask(veterinaryDoctorDao).execute(veterinaryDoctor);
    }

    public void delete(VeterinaryDoctor veterinaryDoctor){
        new VeterinaryDoctorRepository.DeleteVeterinaryDoctorAsyncTask(veterinaryDoctorDao).execute(veterinaryDoctor);
    }

    public void deleteAllVeterinaryDoctors() {
        new VeterinaryDoctorRepository.DeleteAllVeterinaryDoctorsAsyncTask(veterinaryDoctorDao).execute();
    }

    public LiveData<List<VeterinaryDoctor>> getAllVeterinaryDoctors(){
        return allVeterinaryDoctors;
    }

    // insert veterinaryDoctor async task
    private static class InsertVeterinaryDoctorAsyncTask extends AsyncTask<VeterinaryDoctor,Void,Void>{

        private VeterinaryDoctorDao veterinaryDoctorDao;

        private InsertVeterinaryDoctorAsyncTask(VeterinaryDoctorDao veterinaryDoctorDao){
            this.veterinaryDoctorDao = veterinaryDoctorDao;
        }

        @Override
        protected Void doInBackground(VeterinaryDoctor... veterinaryDoctors) {
            veterinaryDoctorDao.insert(veterinaryDoctors[0]);
            return null;
        }
    }

    // update veterinaryDoctor async task
    private static class UpdateVeterinaryDoctorAsyncTask extends AsyncTask<VeterinaryDoctor,Void,Void>{

        private VeterinaryDoctorDao veterinaryDoctorDao;

        private UpdateVeterinaryDoctorAsyncTask(VeterinaryDoctorDao veterinaryDoctorDao){
            this.veterinaryDoctorDao = veterinaryDoctorDao;
        }

        @Override
        protected Void doInBackground(VeterinaryDoctor... veterinaryDoctors) {
            veterinaryDoctorDao.update(veterinaryDoctors[0]);
            return null;
        }
    }

    // delete veterinaryDoctor async task
    private static class DeleteVeterinaryDoctorAsyncTask extends AsyncTask<VeterinaryDoctor,Void,Void>{

        private VeterinaryDoctorDao veterinaryDoctorDao;

        private DeleteVeterinaryDoctorAsyncTask(VeterinaryDoctorDao veterinaryDoctorDao){
            this.veterinaryDoctorDao = veterinaryDoctorDao;
        }

        @Override
        protected Void doInBackground(VeterinaryDoctor... veterinaryDoctors) {
            veterinaryDoctorDao.delete(veterinaryDoctors[0]);
            return null;
        }
    }

    // delete all veterinaryDoctors async task
    private static class DeleteAllVeterinaryDoctorsAsyncTask extends AsyncTask<Void,Void,Void> {

        private VeterinaryDoctorDao veterinaryDoctorDao;

        private DeleteAllVeterinaryDoctorsAsyncTask(VeterinaryDoctorDao veterinaryDoctorDao){
            this.veterinaryDoctorDao = veterinaryDoctorDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            veterinaryDoctorDao.deleteAllVeterinaryDoctors();
            return null;
        }
    }
}
