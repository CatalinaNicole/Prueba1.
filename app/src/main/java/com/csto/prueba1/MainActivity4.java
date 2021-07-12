package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    EditText nompeli, genpeli;
    Button inpeli, volpeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        nompeli = (EditText)findViewById(R.id.nombre);
        genpeli = (EditText)findViewById(R.id.genero);

        inpeli = (Button)findViewById(R.id.ingre);
        volpeli = (Button)findViewById(R.id.volver);

        inpeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db;
                dbhelper Conn = new dbhelper(getApplicationContext());
                db = Conn.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("nombre_pelicula",nompeli.getText().toString());
                cv.put("genero_pelicula",genpeli.getText().toString());
                db.insert("tabla_pelicula",null,cv);
                Toast.makeText(getApplicationContext(),"REGISTRO INGRESADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();

            }
        });

        volpeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(i);
            }
        });
    }
}