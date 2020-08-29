package com.example.veterinaryclinic.DataAccessObjects;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.veterinaryclinic.Models.Account;
import com.example.veterinaryclinic.Models.Animal;

import java.util.List;

@Dao
public interface AccountDao {

    @Insert
    void insert(Account account);

    @Update
    void update(Account account);

    @Delete
    void delete(Account account);

    @Query("DELETE FROM account_table")
    void deleteAllAccounts();

    @Query("SELECT * FROM account_table")
    LiveData<List<Account>> getAllAccounts();
}
