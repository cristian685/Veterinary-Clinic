package com.example.veterinaryclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText userNameEditText = findViewById(R.id.userNameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        Button connectButton = findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView emptyUserNameTextView = findViewById(R.id.emptyUserNameTextView);
        TextView emptyPasswordTextView = findViewById(R.id.emptyPasswordTextView);
        TextView incorrectTextView = findViewById(R.id.incorrectTextView);
        TextView tryAgainTextView = findViewById(R.id.tryAgainTextView);

        emptyUserNameTextView.setVisibility(View.INVISIBLE);
        emptyPasswordTextView.setVisibility(View.INVISIBLE);
        incorrectTextView.setVisibility(View.INVISIBLE);
        tryAgainTextView.setVisibility(View.INVISIBLE);

    }
    
}