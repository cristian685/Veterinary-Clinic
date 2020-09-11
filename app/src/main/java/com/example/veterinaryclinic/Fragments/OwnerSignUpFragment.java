package com.example.veterinaryclinic.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.veterinaryclinic.Adapters.SpinnerAdapter;
import com.example.veterinaryclinic.R;

import java.util.ArrayList;


public class OwnerSignUpFragment extends Fragment {

    private static final String VETERINARIAN_STRING = "Medic veterinar";
    private static final String OWNER_STRING = "Stăpân";

    private ArrayList<String> accountTypes;
    private SpinnerAdapter spinnerAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_sign_up,container,false);

        initialiseList();

        Spinner spinner = view.findViewById(R.id.spinner);
        spinnerAdapter = new SpinnerAdapter(getContext(),accountTypes);
        spinner.setAdapter(spinnerAdapter);

        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);

                if(clickedItem.equals(VETERINARIAN_STRING)){
                    Fragment fragment = new VeterinarianSignUpFragment();
                    fragmentTransaction.replace(R.id.fragment_container,fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

   private void initialiseList(){
        accountTypes = new ArrayList<>();
        accountTypes.add(OWNER_STRING);
        accountTypes.add(VETERINARIAN_STRING);
   }
}