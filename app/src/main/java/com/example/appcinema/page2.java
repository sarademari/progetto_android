package com.example.appcinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class page2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    private static final String FILE_NAME = "utente.txt";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Button button1 = (Button) findViewById(R.id.btn_data);
        EditText editText_data = (EditText) findViewById(R.id.editText_nome);

        MySpinner();                                                                        // Richiamo il metodo MySpinner

        button1.setOnClickListener(new View.OnClickListener() {                              // Apro il calendario
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatepickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        Button button2 = (Button) findViewById(R.id.btn_avanti1);                                 // Apro la prossima activity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText_data.getText().toString() == "") {
                    Toast.makeText(page2.this, "Selezionare una data per la visione", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent openPage3 = new Intent(page2.this, page3.class);
                    startActivity(openPage3);
                }
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {           // Passo i parametri della classe DatePickerFragment
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        EditText editText = (EditText) findViewById((R.id.editText_nome)) ;                 // Istanzio l'EditText per visualizzare la data
        editText.setText(currentDateString);
    }

    public void MySpinner() {
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_titolo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,  // Creo un ArrayAdapter usando l'array e lo spinner del layout
                R.array.list_film, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specifico il layout da usare quando appare la lista
        spinner1.setAdapter(adapter);                                                        // Applico l'Adapter allo spinner
        spinner1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}