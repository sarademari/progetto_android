package com.example.appcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class page4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editText_nticket;
    private EditText editText_nome;
    private EditText editText_cognome;
    private EditText editText_nPosti;
    private EditText editText_totale;
    private Button btn_prenota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        InserisciDati();

        editText_nome = (EditText) findViewById(R.id.editText_nome2);
        editText_nticket = (EditText) findViewById(R.id.editText_data);
        editText_totale = (EditText) findViewById(R.id.editText_totale2);
        editText_totale.setText(CostoTotale() + "");

        NumPosti();

        btn_prenota = (Button) findViewById(R.id.btn_prenota);
        btn_prenota.setOnClickListener(new View.OnClickListener() {                              // Apro il calendario
            @Override
            public void onClick(View v) {
                Toast.makeText(page4.this, "Grazie per la prenotazione! A presto!", Toast.LENGTH_SHORT).show();
                Intent openPage1 = new Intent(page4.this, page1.class);
                startActivity(openPage1);
            }
        });
    }

    public void InserisciDati() {
        editText_nome = (EditText) findViewById(R.id.editText_nome2);
        editText_cognome = (EditText) findViewById(R.id.editText_cognome2);
        editText_nticket = (EditText) findViewById(R.id.editText_data);

        Intent intent = getIntent();
        if(intent.hasExtra("key_text")) {
            String text = intent.getStringExtra("key_text");
            ((EditText) findViewById(R.id.editText_data)).setText(text);
            Toast.makeText(this, "Dato ricevuto: "+text, Toast.LENGTH_SHORT).show();
        }
        else if(intent.hasExtra("key_text1")) {
            String text2 = intent.getStringExtra("key_text1");
            ((EditText) findViewById(R.id.editText_nome2)).setText(text2);
            Toast.makeText(this, "Dato ricevuto: "+text2, Toast.LENGTH_SHORT).show();
        }
        else if(intent.hasExtra("key_text2")) {
            String text3 = intent.getStringExtra("key_text2");
            ((EditText) findViewById(R.id.editText_cognome2)).setText(text3);
            Toast.makeText(this, "Dato ricevuto: "+text3, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Errore di lettura del dato ", Toast.LENGTH_SHORT).show();
    }

    public int CostoTotale() {
        editText_nticket = (EditText) findViewById(R.id.editText_data);
        int txt = Integer.parseInt(editText_nticket.getText().toString());
        return txt * 10;
    }

    public static int RandInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void NumPosti() {
        editText_nPosti = (EditText) findViewById(R.id.editText_nPosti2);
        editText_nticket = (EditText) findViewById(R.id.editText_data);
        int txt = Integer.parseInt(editText_nticket.getText().toString());
        int n = 0;

        do {
            editText_nPosti.setText(RandInt(1, 99) + " ");
            n++;

        }while(n < txt);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}