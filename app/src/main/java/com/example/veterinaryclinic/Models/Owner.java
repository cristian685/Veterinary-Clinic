package com.example.veterinaryclinic.Models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "owner_table", foreignKeys = @ForeignKey(entity = Account.class,
        parentColumns = "idAccount",
        childColumns = "ownerId",
        onDelete = ForeignKey.CASCADE))
public class Owner {

    @PrimaryKey(autoGenerate = true)
    private int ownerId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private int idAccount;

    public Owner(int ownerId, String firstName, String lastName, String emailAddress, String phoneNumber, int idAccount) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.idAccount = idAccount;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
