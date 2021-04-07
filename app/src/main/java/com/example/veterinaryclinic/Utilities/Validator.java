package com.example.veterinaryclinic.Utilities;

import android.util.Patterns;

public class Validator {

    // Empty string
    public static final String EMPTY_STRING = "";

    // Error messages
    public static final String EMPTY_NAME_ERROR = "Numele nu poate să lipsească !";
    public static final String EMPTY_SURNAME_ERROR = "Prenumele nu poate să lipsească !";
    public static final String EMPTY_USERNAME_ERROR = "Vă rugăm să introduceți un nume de utilizator !";
    public static final String EMPTY_PASSWORD_ERROR = "Parola nu poate să lipsească !";
    public static final String SHORT_PASSWORD_ERROR = "Parola trebuie să aibă minim 6 caractere !";
    public static final String PASSWORD_NOT_EQUALS_ERROR = "Parolele nu coincid !";
    public static final String EMPTY_EMAIL_ADDRESS_ERROR = "Vă rugăm să introduceți o adresă de email !";
    public static final String EMPTY_PHONE_NUMBER_ERROR = "Vă rugăm să introduceți un număr de telefon !";
    public static final String INVALID_EMAIL_ADDRESS_ERROR = "Adresa de email nu este validă !";
    public static final String INVALID_PHONE_NUMBER_ERROR = "Numărul de telefon este nu este valid !";


    private static final int MINIM_LENGTH = 6;


    // FUNCTIONS TO VERIFY THE INPUT DATA
    public static boolean verifyName(String name) {
        if (name.equals(EMPTY_STRING)){
            return false;
        }

        return true;
    }

    public static boolean verifySurname(String surname) {
        if (surname.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }


    public static boolean verifyUsername(String username) {
        if (username.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }

    public static boolean isPasswordEmpty(String password) {
        if (password.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }

    public static boolean isPasswordTooShort(String password){
        if(password.length() < MINIM_LENGTH){
            return false;
        }
        return true;
    }

    public static boolean verifyConfirmedPassword(String password,String confirmedPassword) {
        if(!confirmedPassword.equals(password)){
            return false;
        }
        return true;
    }

    public static boolean verifyEmailAddress(String emailAddress) {
        if (emailAddress.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }

    public static boolean verifyPhoneNumber(String phoneNumber) {
        if (phoneNumber.equals(EMPTY_STRING)){
            return false;
        }
        return true;
    }

    // Method to check if a email address is valid
    public static boolean validateEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Method to check if a phone number is valid
    public static boolean validatePhoneNumber(String phoneNumber){
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }

}
