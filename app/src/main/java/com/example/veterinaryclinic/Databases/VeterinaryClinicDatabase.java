package com.example.veterinaryclinic.Databases;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.veterinaryclinic.DataAccessObjects.AccountDao;
import com.example.veterinaryclinic.DataAccessObjects.AnimalDao;
import com.example.veterinaryclinic.DataAccessObjects.OwnerDao;
import com.example.veterinaryclinic.DataAccessObjects.VeterinaryDoctorDao;
import com.example.veterinaryclinic.Models.Account;
import com.example.veterinaryclinic.Models.Animal;
import com.example.veterinaryclinic.Models.Owner;
import com.example.veterinaryclinic.Models.VeterinaryDoctor;

@Database(entities = {Animal.class, Account.class, Owner.class, VeterinaryDoctor.class}, version = 4)
public abstract class VeterinaryClinicDatabase extends RoomDatabase {

    private static VeterinaryClinicDatabase instance;

    public abstract AnimalDao animalDao();
    public abstract AccountDao accountDao();
    public abstract OwnerDao ownerDao();
    public abstract VeterinaryDoctorDao veterinaryDoctorDao();

    public static synchronized VeterinaryClinicDatabase getInstance(Context context){

        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    VeterinaryClinicDatabase.class, "veterinary_clinic_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabaseAsyncTask(instance).execute();
        }
    };

    private static class PopulateDatabaseAsyncTask extends AsyncTask<Void,Void,Void>{

        private AnimalDao animalDao;
        private AccountDao accountDao;
        private OwnerDao ownerDao;
        private VeterinaryDoctorDao veterinaryDoctorDao;

        private PopulateDatabaseAsyncTask(VeterinaryClinicDatabase database){
            animalDao = database.animalDao();
            accountDao = database.accountDao();
            ownerDao = database.ownerDao();
            veterinaryDoctorDao = database.veterinaryDoctorDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
