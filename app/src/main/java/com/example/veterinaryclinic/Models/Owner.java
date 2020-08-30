package com.example.veterinaryclinic.Models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Account.class,
parentColumns = "idAccount",
childColumns = "ownerId",
onDelete = ForeignKey.CASCADE))
public class Owner {

    @PrimaryKey (autoGenerate = true)
    private int ownerId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private int idAccount;

}
