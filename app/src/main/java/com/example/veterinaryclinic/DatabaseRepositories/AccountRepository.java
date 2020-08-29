package com.example.veterinaryclinic.DatabaseRepositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.veterinaryclinic.DataAccessObjects.AccountDao;
import com.example.veterinaryclinic.Databases.VeterinaryClinicDatabase;
import com.example.veterinaryclinic.Models.Account;

import java.util.List;

public class AccountRepository {

    private AccountDao accountDao;
    private LiveData<List<Account>> allAccounts;

    public AccountRepository(Application application){
        VeterinaryClinicDatabase veterinaryClinicDatabase  = VeterinaryClinicDatabase.getInstance(application);
        accountDao = veterinaryClinicDatabase.accountDao();
        allAccounts = accountDao.getAllAccounts();
    }

    public void insert(Account account){
        new AccountRepository.InsertAccountAsyncTask(accountDao).execute(account);
    }

    public void update(Account account){
        new AccountRepository.UpdateAccountAsyncTask(accountDao).execute(account);
    }

    public void delete(Account account){
        new AccountRepository.DeleteAccountAsyncTask(accountDao).execute(account);
    }

    public void deleteAllAccounts() {
        new AccountRepository.DeleteAllAccountsAsyncTask(accountDao).execute();
    }

    public LiveData<List<Account>> getAllAccounts(){
        return allAccounts;
    }

    // insert account async task
    private static class InsertAccountAsyncTask extends AsyncTask<Account,Void,Void>{

        private AccountDao accountDao;

        private InsertAccountAsyncTask(AccountDao accountDao){
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.insert(accounts[0]);
            return null;
        }
    }



    // update account async task
    private static class UpdateAccountAsyncTask extends AsyncTask<Account,Void,Void>{

        private AccountDao accountDao;

        private UpdateAccountAsyncTask(AccountDao accountDao){
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.update(accounts[0]);
            return null;
        }
    }

    // delete account async task
    private static class DeleteAccountAsyncTask extends AsyncTask<Account,Void,Void>{

        private AccountDao accountDao;

        private DeleteAccountAsyncTask(AccountDao accountDao){
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.delete(accounts[0]);
            return null;
        }
    }

    // delete all accounts async task
    private static class DeleteAllAccountsAsyncTask extends AsyncTask<Void,Void,Void> {

        private AccountDao accountDao;

        private DeleteAllAccountsAsyncTask(AccountDao accountDao){
            this.accountDao = accountDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            accountDao.deleteAllAccounts();
            return null;
        }
    }
}
