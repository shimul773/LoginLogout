package com.example.loginlogout.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.loginlogout.R;


public class Products extends Fragment {

    View view;
    TextView hellotext;
    Button add_products, login_add_products;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products, container, false);

        hellotext = view.findViewById(R.id.hellotext);
        add_products = view.findViewById(R.id.add_products);
        login_add_products = view.findViewById(R.id.login_add_products);


        SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean isLoggedin = preferences.getBoolean("check", false);
        String username = preferences.getString("username","");

        if(isLoggedin){
            hellotext.setText("Welcome, " + username);
        }

        return view;
    }
}