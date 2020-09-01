package com.example.veterinaryclinic.DataAccessObjects;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.veterinaryclinic.Models.Owner;

import java.util.List;

@Dao
public interface OwnerDao {

    @Insert
    void insert(Owner owner);

    @Update
    void update(Owner owner);

    @Delete
    void delete(Owner owner);

    @Query("DELETE FROM owner_table")
    void deleteAllOwners();

    @Query("SELECT * FROM owner_table")
    LiveData<List<Owner>> getAllOwners();
}
