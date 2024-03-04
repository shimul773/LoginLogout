package com.example.loginlogout.SharedPreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.loginlogout.R;

public class MainActivity extends AppCompatActivity {

    Button btn_login, btn_products, btn_home, btn_logout;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_home = findViewById(R.id.btn_home);
        btn_login = findViewById(R.id.btn_logn);
        btn_products = findViewById(R.id.btn_products);
        btn_logout = findViewById(R.id.btn_logout);
        frameLayout = findViewById(R.id.frameLayout);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new Home()).commit();

        // Check if the user is logged in
        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("check", false);
        // Show the appropriate button based on whether the user is logged in or not
        if (isLoggedIn) {
            btn_logout.setVisibility(View.VISIBLE);
            btn_login.setVisibility(View.GONE);
        } else {
            btn_logout.setVisibility(View.GONE);
            btn_login.setVisibility(View.VISIBLE);
        }



        btn_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Products()).commit();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Login()).commit();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Home()).commit();
            }
        });
    }
}