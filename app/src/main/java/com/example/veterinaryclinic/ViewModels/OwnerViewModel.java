package com.example.veterinaryclinic.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DatabaseRepositories.OwnerRepository;
import com.example.veterinaryclinic.Models.Owner;

import java.util.List;

public class OwnerViewModel extends AndroidViewModel {
    private OwnerRepository repository;
    private LiveData<List<Owner>> allOwners;

    public OwnerViewModel(@NonNull Application application) {
        super(application);
        repository = new OwnerRepository(application);
        allOwners = repository.getAllOwners();
    }

    public void insert(Owner owner) {
        repository.insert(owner);
    }

    public void update(Owner owner) {
        repository.update(owner);
    }

    public void delete(Owner owner) {
        repository.delete(owner);
    }

    public void deleteAllOwners() {
        repository.deleteAllOwners();
    }

    public LiveData<List<Owner>> getAllOwners(){
        return allOwners;
    }
}
