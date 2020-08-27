package com.example.veterinaryclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private static final String EMPTY_STRING = "";

    TextView emptyUserNameTextView;
    TextView emptyPasswordTextView;
    TextView incorrectTextView;
    TextView tryAgainTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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