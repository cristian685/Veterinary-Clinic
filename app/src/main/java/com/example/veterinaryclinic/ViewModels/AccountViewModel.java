package com.example.veterinaryclinic.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DatabaseRepositories.AccountRepository;
import com.example.veterinaryclinic.Models.Account;

import java.util.List;

public class AccountViewModel extends AndroidViewModel {

    private AccountRepository repository;
    private LiveData<List<Account>> allAccounts;

    public AccountViewModel(@NonNull Application application) {
        super(application);
        repository = new AccountRepository(application);
        allAccounts = repository.getAllAccounts();
    }

    public void insert(Account account) {
        repository.insert(account);
    }

    public void update(Account account) {
        repository.update(account);
    }

    public void delete(Account account) {
        repository.delete(account);
    }

    public void deleteAllAccounts(Account account) {
        repository.deleteAllAccounts();
    }

    public LiveData<List<Account>> getAllAccounts(){
        return allAccounts;
    }
}
