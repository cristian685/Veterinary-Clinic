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
import android.widget.Spinner;

import com.example.veterinaryclinic.Adapters.SpinnerAdapter;
import com.example.veterinaryclinic.R;

import java.util.ArrayList;


public class VeterinarianSignUpFragment extends Fragment {

    private static final String VETERINARIAN_STRING = "Medic veterinar";
    private static final String OWNER_STRING = "Stăpân";

    private static final String SURGERY_STRING = "Chirurgie";
    private static final String DERMATOLOGY_STRING = "Dermatologie";
    private static final String INTERNAL_MEDICINE_STRING = "Medicină internă";


    private ArrayList<String> accountTypes;
    private ArrayList<String> veterinariansTypes;

    private SpinnerAdapter spinnerAdapter;
    private SpinnerAdapter specialisationsSpinnerAdapter;



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

        specialisationsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }


    private void initialiseLists(){
        accountTypes = new ArrayList<>();
        accountTypes.add(VETERINARIAN_STRING);
        accountTypes.add(OWNER_STRING);

        veterinariansTypes = new ArrayList<>();
        veterinariansTypes.add(SURGERY_STRING);
        veterinariansTypes.add(DERMATOLOGY_STRING);
        veterinariansTypes.add(INTERNAL_MEDICINE_STRING);

    }
}