package com.example.veterinaryclinic.DataAccessObjects;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.veterinaryclinic.Models.VeterinaryDoctor;

import java.util.List;

@Dao
public interface VeterinaryDoctorDao {

    @Insert
    void insert(VeterinaryDoctor veterinaryDoctor);

    @Update
    void update(VeterinaryDoctor veterinaryDoctor);

    @Delete
    void delete(VeterinaryDoctor veterinaryDoctor);

    @Query("DELETE FROM veterinarian_table")
    void deleteAllVeterinaryDoctors();

    @Query("SELECT * FROM veterinarian_table")
    LiveData<List<VeterinaryDoctor>> getAllVeterinaryDoctors();

}
