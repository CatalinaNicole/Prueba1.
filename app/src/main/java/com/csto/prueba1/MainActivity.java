package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText correo;
    EditText clave;
    Button acceso;
    Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo=(EditText)findViewById(R.id.correo);
        clave=(EditText)findViewById(R.id.contraseña);
        acceso=(Button) findViewById(R.id.conexion);
        registro=(Button) findViewById(R.id.registro);

    }
    public void registrar(View v){
        Intent i=new Intent(getApplicationContext(),Registro.class);
        startActivity(i);
    }

    public void ingresar(View v) {

        String c = correo.getText().toString();
        String co = clave.getText().toString();

        String nombre = getIntent().getStringExtra("nombres");
        String apellido = getIntent().getStringExtra("apellidos");
        String correo = getIntent().getStringExtra("correo");
        String contra = getIntent().getStringExtra("contraseña");

        if (c.equals(correo) && co.equals(contra)) {
            Intent I = new Intent(getApplicationContext(),Acceso.class);
            I.putExtra("nom", nombre);
            I.putExtra("apelli", apellido);
            startActivity(I);
        } else {
            Toast.makeText(getApplicationContext(), "DATOS DE AUTENTIFICACION INCORRECTOS VUELVA A INTENTARLO", Toast.LENGTH_LONG).show();
        }
    }

    public void irmapa(View v){
        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(i);
    }

    public void irbasedatos(View v){
        Intent i = new Intent(getApplicationContext(),MainActivity3.class);
        startActivity(i);
    }
}