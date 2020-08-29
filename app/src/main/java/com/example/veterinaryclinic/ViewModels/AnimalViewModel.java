package com.example.veterinaryclinic.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DatabaseRepositories.AnimalRepository;
import com.example.veterinaryclinic.Models.Animal;

import java.util.List;

public class AnimalViewModel extends AndroidViewModel {
    private AnimalRepository repository;
    private LiveData<List<Animal>> allAnimals;

    public AnimalViewModel(@NonNull Application application) {
        super(application);
        repository = new AnimalRepository(application);
        allAnimals = repository.getAllAnimals();
    }

    public void insert(Animal animal) {
        repository.insert(animal);
    }

    public void update(Animal animal) {
        repository.update(animal);
    }

    public void delete(Animal animal) {
        repository.delete(animal);
    }

    public void deleteAllNotes(Animal animal) {
        repository.deleteAllAnimals();
    }

    public LiveData<List<Animal>> getAllAnimals(){
        return allAnimals;
    }
}
