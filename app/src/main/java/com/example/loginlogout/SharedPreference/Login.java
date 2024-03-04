package com.example.loginlogout.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.loginlogout.R;


public class Login extends Fragment {

    View view;
    Button signin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        signin = view.findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = "kotha";  // get value while logging
                SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("check",true);
                editor.putString("username", username);
                editor.apply();

                getParentFragmentManager().beginTransaction().replace(R.id.frameLayout, new Home()).commit();

            }
        });


        return view;
    }
}