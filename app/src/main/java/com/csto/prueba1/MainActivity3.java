package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void ingreso_datos(View v){
        Intent i = new Intent(getApplicationContext(),MainActivity4.class);
        startActivity(i);
    }

    public void listado_datos(View v){
        Intent i = new Intent(getApplicationContext(),MainActivity5.class);
        startActivity(i);
    }
}