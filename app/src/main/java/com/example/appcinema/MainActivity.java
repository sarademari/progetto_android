package com.example.appcinema;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SplashScreen();
    }

    private void SplashScreen() {
        int timeout = 3000;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {            // Lascio l'activity per 3 secondi
            @Override
            public void run() {
               Intent openPage1 = new Intent(MainActivity.this, page1.class);
               startActivity(openPage1);
               finish();
            }
        }, timeout);
    }
}