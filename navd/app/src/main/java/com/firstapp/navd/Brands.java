package com.firstapp.navd;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.InflateException;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Brands extends android.support.v4.app.Fragment implements View.OnClickListener {

    EditText name;
    EditText address;
    EditText contact;
    Button detailsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_brands, container, false);
        name = (EditText)rootView.findViewById(R.id.name);
        address = (EditText)rootView.findViewById(R.id.address);
        contact = (EditText)rootView.findViewById(R.id.contact);
        detailsButton = (Button)rootView.findViewById(R.id.detailsButton);
        detailsButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(),problems.class);
        startActivity(intent);
        //Toast.makeText(getContext(),"Button Clicked",Toast.LENGTH_SHORT).show();
    }
}
