package com.example.veterinaryclinic.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "account_table")
public class Account {

    @PrimaryKey(autoGenerate = true)
    private int idAccount;

    private String userName;

    private String password;

    public Account(int idAccount, String userName, String password) {
        this.idAccount = idAccount;
        this.userName = userName;
        this.password = password;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
}
