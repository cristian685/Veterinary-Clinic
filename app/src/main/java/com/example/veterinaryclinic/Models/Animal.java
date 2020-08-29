package com.example.veterinaryclinic.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "animal_table")
public class Animal {

    @PrimaryKey(autoGenerate = true)
    private int idAnimal;

    private String name;

    private String species;

    private String race;

    private String sex;

    private float height;

    private float weight;

    private String birthDate;

    private byte[] photo;

    public Animal(String name, String species, String race, String sex, float height, float weight, String birthDate, byte[] photo) {
        this.name = name;
        this.species = species;
        this.race = race;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.photo = photo;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getRace() {
        return race;
    }

    public String getSex() {
        return sex;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
}
