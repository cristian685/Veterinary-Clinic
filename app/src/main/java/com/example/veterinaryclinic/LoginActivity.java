package com.example.veterinaryclinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veterinaryclinic.Models.Account;
import com.example.veterinaryclinic.Models.Animal;
import com.example.veterinaryclinic.ViewModels.AccountViewModel;
import com.example.veterinaryclinic.ViewModels.AnimalViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    // CONSTANTS
    private static final String EMPTY_STRING = "";

    private TextView emptyUserNameTextView;
    private TextView emptyPasswordTextView;
    private TextView incorrectTextView;
    private TextView tryAgainTextView;

    // view models
    private AnimalViewModel animalViewModel;
    private AccountViewModel accountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // instantiating view model for the current activity
        accountViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(AccountViewModel.class);

        // creating an observable for our list of animals from database
        accountViewModel.getAllAccounts().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(List<Account> accounts) {

            }
        });

        final EditText userNameEditText = findViewById(R.id.userNameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);

        Button connectButton = findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkIfAnyAccountDetailIsEmpty(userNameEditText.getText().toString(),passwordEditText.getText().toString())){

                }
            }
        });

        emptyUserNameTextView = findViewById(R.id.emptyUserNameTextView);
        emptyPasswordTextView = findViewById(R.id.emptyPasswordTextView);
        incorrectTextView = findViewById(R.id.incorrectTextView);
        tryAgainTextView = findViewById(R.id.tryAgainTextView);

        emptyUserNameTextView.setVisibility(View.INVISIBLE);
        emptyPasswordTextView.setVisibility(View.INVISIBLE);
        incorrectTextView.setVisibility(View.INVISIBLE);
        tryAgainTextView.setVisibility(View.INVISIBLE);

    }

    private boolean checkIfAnyAccountDetailIsEmpty(String userName, String password){

        boolean userNameIsEmpty = checkIfUserNameIsEmpty(userName);
        boolean passwordIsEmpty = checkIfPasswordIsEmpty(password);

        if(userNameIsEmpty || passwordIsEmpty){
            return true;
        }

        return false;
    }

    private boolean checkIfUserNameIsEmpty(String userName){
        if(userName.equals(EMPTY_STRING)){
            emptyUserNameTextView.setVisibility(View.VISIBLE);
            return true;
        }

        emptyUserNameTextView.setVisibility(View.INVISIBLE);
        return false;
    }

    private boolean checkIfPasswordIsEmpty(String password){
        if(password.equals(EMPTY_STRING)){
            emptyPasswordTextView.setVisibility(View.VISIBLE);
            return true;
        }

        emptyPasswordTextView.setVisibility(View.INVISIBLE);
        return false;
    }

}