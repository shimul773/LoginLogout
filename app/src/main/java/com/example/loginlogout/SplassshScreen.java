package com.example.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import java.util.logging.LogRecord;

public class SplassshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splasssh_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check = preferences.getBoolean("flag", false);

                if(check){
                    startActivity(new Intent(SplassshScreen.this,Home.class));
                }
                else {
                    startActivity(new Intent(SplassshScreen.this,LogIn.class));
                }
            }
        },4000);
    }
}