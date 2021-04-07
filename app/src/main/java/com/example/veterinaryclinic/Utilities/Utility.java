package com.example.veterinaryclinic.Utilities;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utility {

    public static final String DIALOG = "example dialog";

    // Method used to check for the internet connection
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
