package com.example.veterinaryclinic.Models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "veterinarian_table", foreignKeys = @ForeignKey(entity = Account.class,
        parentColumns = "idAccount",
        childColumns = "veterinaryDoctorId",
        onDelete = ForeignKey.CASCADE))
public class VeterinaryDoctor {

    @PrimaryKey(autoGenerate = true)
    private int veterinaryDoctorId;

    private String firstName;

    private String lastName;

    private String specialisation;

    private String emailAddress;

    private String phoneNumber;

    private int idAccount;

    private String registrationDate;

    public VeterinaryDoctor(String firstName, String lastName, String specialisation, String emailAddress, String phoneNumber, int idAccount, String registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialisation = specialisation;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.idAccount = idAccount;
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialisation() {
        return specialisation;
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setVeterinaryDoctorId(int veterinaryDoctorId) {
        this.veterinaryDoctorId = veterinaryDoctorId;
    }
}
