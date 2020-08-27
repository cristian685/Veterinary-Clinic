package com.example.veterinaryclinic.DataAccessObjects;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.veterinaryclinic.DatabaseEntities.Animal;

import java.util.List;

public interface AnimalDao {

    @Insert
    void insert(Animal animal);

    @Update
    void update(Animal animal);

    @Delete
    void delete(Animal animal);

    @Query("DELETE FROM animal_table")
    void deleteAllAnimals();

    @Query("SELECT * FROM animal_table")
    LiveData<List<Animal>> getAllAnimals();
}
