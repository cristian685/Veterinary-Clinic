package com.example.veterinaryclinic.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.veterinaryclinic.Adapters.SpinnerAdapter;
import com.example.veterinaryclinic.Dialogs.NoInternetConnectionDialog;
import com.example.veterinaryclinic.R;
import com.example.veterinaryclinic.SignUpActivity;
import com.example.veterinaryclinic.Utilities.Utility;
import com.example.veterinaryclinic.Utilities.Validator;

import java.util.ArrayList;


public class OwnerSignUpFragment extends Fragment {

    // Adapters options
    private static final String VETERINARIAN_STRING = "Medic veterinar";
    private static final String OWNER_STRING = "Stăpân";


    private ArrayList<String> accountTypes;

    // Adapter for choosing between Owner and Veterinarian
    private SpinnerAdapter spinnerAdapter;

    // Edit texts
    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText confirmedPasswordEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;

    // Button
    private Button registerButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_sign_up, container, false);

        initialiseList();

        Spinner spinner = view.findViewById(R.id.spinner);
        spinnerAdapter = new SpinnerAdapter(getContext(), accountTypes);
        spinner.setAdapter(spinnerAdapter);

        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Creating the spinner that changes between fragments
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);

                if (clickedItem.equals(VETERINARIAN_STRING)) {
                    Fragment fragment = new VeterinarianSignUpFragment();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Edit texts
        nameEditText = view.findViewById(R.id.surnameEditText);
        surnameEditText = view.findViewById(R.id.nameEditText);
        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        confirmedPasswordEditText = view.findViewById(R.id.confirmedPasswordEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        phoneNumberEditText = view.findViewById(R.id.phoneNumberEditText);

        // Button edit text
        registerButton = view.findViewById(R.id.createOwnerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createOwner();
            }
        });

        return view;
    }


    private void createOwner() {

        // Getting the data
        String name = nameEditText.getText().toString().trim();
        String surname = surnameEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmedPassword = confirmedPasswordEditText.getText().toString().trim();
        String emailAddress = emailEditText.getText().toString().trim();
        String phoneNumber = phoneNumberEditText.getText().toString().trim();

        // Verifying the data received from the user
        if (!Validator.verifyName(name)){
            nameEditText.setError(Validator.EMPTY_NAME_ERROR);
            return;
        }

        if (!Validator.verifySurname(surname)){
            surnameEditText.setError(Validator.EMPTY_SURNAME_ERROR);
            return;
        }

        if (!Validator.verifyUsername(username)){
            usernameEditText.setError(Validator.EMPTY_USERNAME_ERROR);
            return;
        }

        if (!Validator.isPasswordEmpty(password)){
            passwordEditText.setError(Validator.EMPTY_PASSWORD_ERROR);
            return;
        }

        if (!Validator.isPasswordTooShort(password)){
            passwordEditText.setError(Validator.SHORT_PASSWORD_ERROR);
            return;
        }

        if (!Validator.verifyConfirmedPassword(password, confirmedPassword)){
            confirmedPasswordEditText.setError(Validator.PASSWORD_NOT_EQUALS_ERROR);
            return;
        }

        if (!Validator.verifyEmailAddress(emailAddress)){
            emailEditText.setError(Validator.EMPTY_EMAIL_ADDRESS_ERROR);
            return;
        }

        if (!Validator.validateEmail(emailAddress)){
            emailEditText.setError(Validator.INVALID_EMAIL_ADDRESS_ERROR);
            return;
        }

        if (!Validator.verifyPhoneNumber(phoneNumber)){
            phoneNumberEditText.setError(Validator.EMPTY_PHONE_NUMBER_ERROR);
            return;
        }

        if (!Validator.validatePhoneNumber(phoneNumber)){
            phoneNumberEditText.setError(Validator.INVALID_PHONE_NUMBER_ERROR);
            return;
        }


        if (!Utility.isNetworkConnected(getActivity().getApplicationContext())) {
            NoInternetConnectionDialog noInternetConnectionDialog = new NoInternetConnectionDialog();
            noInternetConnectionDialog.show(getActivity().getSupportFragmentManager(), Utility.DIALOG);
            return;
        }
    }

    // Functions to initialise the spinner list
    private void initialiseList() {
        accountTypes = new ArrayList<>();
        accountTypes.add(OWNER_STRING);
        accountTypes.add(VETERINARIAN_STRING);
    }

}