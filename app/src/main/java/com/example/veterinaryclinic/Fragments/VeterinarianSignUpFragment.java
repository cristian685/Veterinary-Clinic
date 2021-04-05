package com.example.veterinaryclinic.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.veterinaryclinic.Adapters.SpinnerAdapter;
import com.example.veterinaryclinic.R;

import java.util.ArrayList;


public class VeterinarianSignUpFragment extends Fragment {

    // Adapters options
    private static final String VETERINARIAN_STRING = "Medic veterinar";
    private static final String OWNER_STRING = "Stăpân";

    private static final String SURGERY_STRING = "Chirurgie";
    private static final String DERMATOLOGY_STRING = "Dermatologie";
    private static final String INTERNAL_MEDICINE_STRING = "Medicină internă";

    private static final String EMPTY_STRING = "";

    // Error messages
    private static final String EMPTY_NAME_ERROR = "Numele nu poate să lipsească !";
    private static final String EMPTY_SURNAME_ERROR = "Prenumele nu poate să lipsească !";
    private static final String EMPTY_USERNAME_ERROR = "Vă rugăm să introduceți un nume de utilizator !";
    private static final String EMPTY_PASSWORD_ERROR = "Parola nu poate să lipsească !";
    private static final String SHORT_PASSWORD_ERROR = "Parola trebuie să aibă minim 6 caractere !";
    private static final String PASSWORD_NOT_EQUALS_ERROR = "Parolele nu coincid !";
    private static final String EMPTY_EMAIL_ADDRESS_ERROR = "Vă rugăm să introduceți o adresă de email !";
    private static final String EMPTY_PHONE_NUMBER_ERROR = "Vă rugăm să introduceți un număr de telefon !";

    private static final int MINIM_LENGTH = 6;

    private ArrayList<String> accountTypes;
    private ArrayList<String> veterinariansTypes;

    // Adapter for choosing between Owner and Veterinarian
    private SpinnerAdapter spinnerAdapter;
    // Adapter for choosing between veterinarian specialisations
    private SpinnerAdapter specialisationsSpinnerAdapter;


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

    // Warning text view
    private TextView errorTextView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_veterinarian_sign_up,container,false);

        initialiseLists();

        Spinner spinner = view.findViewById(R.id.spinner);
        Spinner specialisationsSpinner = view.findViewById(R.id.specialisationSpinner);

        spinnerAdapter = new SpinnerAdapter(getContext(),accountTypes);
        specialisationsSpinnerAdapter = new SpinnerAdapter(getContext(),veterinariansTypes);

        spinner.setAdapter(spinnerAdapter);
        specialisationsSpinner.setAdapter(specialisationsSpinnerAdapter);

        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Creating the spinner that changes between fragments
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);

                if(clickedItem.equals(OWNER_STRING)){
                    Fragment fragment = new OwnerSignUpFragment();
                    fragmentTransaction.replace(R.id.fragment_container,fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Creating the spinner that changes between specialisations
        specialisationsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);
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
        registerButton = view.findViewById(R.id.createVeterinarianButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createVeterinarian();
            }
        });

        // Warning text view
        errorTextView = view.findViewById(R.id.errorTextView);

        return view;
    }

    private void createVeterinarian() {

        // Getting the data
        String name = nameEditText.getText().toString().trim();
        String surname = surnameEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmedPassword = confirmedPasswordEditText.getText().toString().trim();
        String emailAddress = emailEditText.getText().toString().trim();
        String phoneNumber = phoneNumberEditText.getText().toString().trim();

        // Verifying the data received from the user

        if (!verifyName(name)){
            return;
        }

        if (!verifySurname(surname)){
            return;
        }

        if (!verifyUsername(username)){
            return;
        }

        if (!verifyPassword(password)){
            return;
        }

        if (!verifyConfirmedPassword(password, confirmedPassword)){
            return;
        }

        if (!verifyEmailAddress(emailAddress)){
            return;
        }

        if (!verifyPhoneNumber(phoneNumber)){
            return;
        }


    }

    // Functions to initialise the spinner lists
    private void initialiseLists(){
        accountTypes = new ArrayList<>();
        accountTypes.add(VETERINARIAN_STRING);
        accountTypes.add(OWNER_STRING);

        veterinariansTypes = new ArrayList<>();
        veterinariansTypes.add(SURGERY_STRING);
        veterinariansTypes.add(DERMATOLOGY_STRING);
        veterinariansTypes.add(INTERNAL_MEDICINE_STRING);

    }

    // FUNCTIONS TO VERIFY THE INPUT DATA
    private boolean verifyName(String name) {
        if (name.equals(EMPTY_STRING)){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(EMPTY_NAME_ERROR);

            return false;
        }

        errorTextView.setText(EMPTY_STRING);
        return true;
    }

    private boolean verifySurname(String surname) {
        if (surname.equals(EMPTY_STRING)){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(EMPTY_SURNAME_ERROR);

            return false;
        }
        return true;
    }


    private boolean verifyUsername(String username) {
        if (username.equals(EMPTY_STRING)){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(EMPTY_USERNAME_ERROR);

            return false;
        }

        errorTextView.setText(EMPTY_STRING);
        return true;
    }

    private boolean verifyPassword(String password) {
        if (password.equals(EMPTY_STRING)){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(EMPTY_PASSWORD_ERROR);

            return false;
        }

        if(password.length() < MINIM_LENGTH){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(SHORT_PASSWORD_ERROR);

            return false;
        }

        errorTextView.setText(EMPTY_STRING);
        return true;
    }

    private boolean verifyConfirmedPassword(String password,String confirmedPassword) {
        if(!confirmedPassword.equals(password)){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(PASSWORD_NOT_EQUALS_ERROR);

            return false;
        }

        errorTextView.setText(EMPTY_STRING);
        return true;
    }

    private boolean verifyEmailAddress(String emailAddress) {
        if (emailAddress.equals(EMPTY_STRING)){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(EMPTY_EMAIL_ADDRESS_ERROR);

            return false;
        }

        errorTextView.setText(EMPTY_STRING);
        return true;
    }

    private boolean verifyPhoneNumber(String phoneNumber) {
        if (phoneNumber.equals(EMPTY_STRING)){
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(EMPTY_PHONE_NUMBER_ERROR);

            return false;
        }

        errorTextView.setText(EMPTY_STRING);
        return true;
    }
}