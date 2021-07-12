package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    Button volver;
    ListView lis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        volver = (Button)findViewById(R.id.vol);
        lis = (ListView)findViewById(R.id.lista);

        ArrayList<String>peliculas = new ArrayList<String>();
        ArrayList<Integer>peliculas_pk= new ArrayList<Integer>();

        SQLiteDatabase db;
        dbhelper Conn = new dbhelper(getApplicationContext());
        db = Conn.getWritableDatabase();
        Cursor c = db.query("tabla_pelicula",null,null,null,null,null,null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    String informacion = c.getString(1)+" - "+c.getString(2);
                    peliculas_pk.add(c.getInt(0));
                    peliculas.add(informacion);
                } while(c.moveToNext());
            }
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,peliculas);

        lis.setAdapter(adaptador);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(i);
            }
        });
        lis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=lis.getItemAtPosition(position).toString();
                Integer pk = peliculas_pk.get(position);
                Intent i=new Intent(getApplicationContext(),MainActivity6.class);
                i.putExtra("pk",pk+"");
                startActivity(i);
            }
        });
    }
}