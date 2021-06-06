package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Acceso extends AppCompatActivity {

    EditText nombre;
    EditText apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        nombre=(EditText)findViewById(R.id.nom);
        apellido=(EditText)findViewById(R.id.ape);
        String nom =getIntent().getStringExtra("nom");
        String ap =getIntent().getStringExtra("apelli");
        nombre.setText(nom);
        apellido.setText(ap);
    }

}