package com.example.appcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class page3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editText_nome;
    private EditText editText_cognome;
    private Spinner spinner;
    private EditText editText_data;
    private EditText editText_cell;
    private EditText editText_email;
    private Button btn_avanti2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        //btn_salvatutto = (Button) findViewById(R.id.btn_salvaTutto);

        spinner = (Spinner) findViewById(R.id.spinner_numPersone);
        String text_spinner = spinner.getSelectedItem().toString();

        editText_nome = (EditText) findViewById(R.id.editText_nome);
        String text_txtNome = editText_nome.getText().toString();

        editText_cognome = (EditText) findViewById(R.id.editText_cognome);
        String text_txtCognome = editText_cognome.getText().toString();

        editText_data = (EditText) findViewById(R.id.editText_data);
        editText_cell = (EditText) findViewById(R.id.editText_cellulare);
        editText_email = (EditText) findViewById(R.id.editText_email);

        MySpinner();

        btn_avanti2 = (Button) findViewById(R.id.btn_avanti2);

        btn_avanti2.setOnClickListener(new View.OnClickListener() {                              // Apro il calendario
            @Override
            public void onClick(View v) {
                if(editText_nome.getText().toString() != "" || editText_cognome.getText().toString() != "" || editText_data.getText().toString() != "" || editText_cell.getText().toString() != "" || editText_email.getText().toString() != "")
                    RichiamoDati(text_spinner, text_txtNome, text_txtCognome);
                else
                    Toast.makeText(page3.this, "Compilare tutti i campi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void RichiamoDati(String dato1, String dato2, String dato3) {
        spinner = (Spinner) findViewById(R.id.spinner_numPersone);
        editText_nome = (EditText) findViewById(R.id.editText_nome);

        Intent intent = new Intent(this, page4.class);
        intent.putExtra("key_text", spinner.getSelectedItem().toString());
        intent.putExtra("key_text1", editText_nome.getText());
        intent.putExtra("key_text2", editText_cognome.getText());
        startActivity(intent);
    }

    public void MySpinner() {
        spinner = (Spinner) findViewById(R.id.spinner_numPersone);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,  // Creo un ArrayAdapter usando l'array e lo spinner del layout
                R.array.list_numPersone, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specifico il layout da usare quando appare la lista
        spinner.setAdapter(adapter);                                                        // Applico l'Adapter allo spinner
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}