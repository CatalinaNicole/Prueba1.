package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    EditText ide,nomb,gene;
    Button elim,regre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Bundle b =getIntent().getExtras();
        String pkrecibida = b.get("pk").toString();

        ide =(EditText)findViewById(R.id.idd);
        ide.setEnabled(false);
        nomb =(EditText)findViewById(R.id.nom);
        gene =(EditText)findViewById(R.id.ge);

        elim =(Button)findViewById(R.id.elimina);
        regre =(Button)findViewById(R.id.re);

        SQLiteDatabase db;
        dbhelper Conn = new dbhelper(getApplicationContext());
        db = Conn.getWritableDatabase();
        String SQL="select nombre_pelicula,genero_pelicula from tabla_pelicula where id_pelicula=?";
        String[]where={pkrecibida};
        Cursor c = db.rawQuery(SQL,where);

        if(c!=null){
            if(c.moveToFirst()){
                nomb.setText(c.getString(0));
                gene.setText(c.getString(1));

            }
        }
        ide.setText(pkrecibida);

        regre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();

            }
        });

        elim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db;
                dbhelper Conn = new dbhelper(getApplicationContext());
                db = Conn.getWritableDatabase();
                String llave=ide.getText().toString();
                String wherecause="id_pelicula=?";
                String[]where={llave};
                db.delete("tabla_pelicula",wherecause,where);
                Toast.makeText(getApplicationContext(), "LA PELICULA SE HA ELIMINADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                regresar();

            }
        });

    }
    public void regresar(){
        Intent i = new Intent(getApplicationContext(),MainActivity5.class);
        startActivity(i);
    }
}