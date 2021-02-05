package com.example.appcinema;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class page1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        Button b = (Button) findViewById(R.id.btn_prenota_ticket);
        b.setOnClickListener(new View.OnClickListener() {               // Apro la prossima activity
            @Override
            public void onClick(View v) {
                Intent openPage2 = new Intent(page1.this, page2.class);
                startActivity(openPage2);
            }
        });

        Button b2 = (Button) findViewById(R.id.btn_info);
        b2.setOnClickListener(new View.OnClickListener() {               // Apro la prossima activity
            @Override
            public void onClick(View v) {
                Intent i = new Intent(page1.this, info.class);
                startActivity(i);
            }
        });;
    }
}
