package com.example.veterinaryclinic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.veterinaryclinic.R;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<String> {

    public SpinnerAdapter(Context context, ArrayList<String> accountTypes){
        super(context,0,accountTypes);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item_style, parent, false);

        }

        TextView textViewName = convertView.findViewById(R.id.spinnerItemTextView);

        String currentItem = getItem(position);

        if (currentItem != null) {
            textViewName.setText(currentItem);
        }

        return convertView;
    }
}
