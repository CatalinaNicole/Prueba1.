package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText nom;
    EditText ape;
    EditText rut;
    CheckBox publi;
    Spinner ciuda;
    RadioButton hom;
    RadioButton mu;
    EditText correo;
    EditText contraseña;
    EditText contraseña2;
    Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nom=(EditText)findViewById(R.id.nombre);
        ape=(EditText)findViewById(R.id.apellido);
        rut=(EditText)findViewById(R.id.rut);
        ciuda = (Spinner)findViewById(R.id.ciudades);
        publi = (CheckBox)findViewById(R.id.si);
        hom= (RadioButton)findViewById(R.id.hombre);
        mu= (RadioButton)findViewById(R.id.mujer);
        correo=(EditText)findViewById(R.id.correos);
        contraseña=(EditText)findViewById(R.id.contra);
        contraseña2=(EditText)findViewById(R.id.contra1);
        regis=(Button) findViewById(R.id.registra);
    }
    public void registra(View v){

        String nombre = nom.getText().toString();
        String ap = ape.getText().toString();
        String r = rut.getText().toString();
        String corre = correo.getText().toString();
        String con = contraseña.getText().toString();
        String con2 = contraseña2.getText().toString();

        if(nombre=="" || ap=="" || r=="" || corre=="" || con=="" || con2==""){
            Toast.makeText(getApplicationContext(),"DEBE LLENAR TODO LOS CAMPOS",Toast.LENGTH_LONG).show();
        }else{
            if(con.equals(con2)){
                Log.d("CSTO","usted escribio esto en el cajon nombre: "+nombre);
                Log.d("CSTO","usted escribio esto en el cajon apellido: "+ap);
                Log.d("CSTO","usted escribio esto en el cajon rut: "+r);
                Log.d("CSTO","usted escribio esto en el cajon correo: "+corre);
                Log.d("CSTO","usted escribio esto en el cajon de contraseña: "+con);
                Log.d("CSTO","usted escribio esto en el cajon repetir la contraseña: "+con2);

                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                I.putExtra("nombres",nombre);
                I.putExtra("apellidos",ap);
                I.putExtra("correo",corre);
                I.putExtra("contraseña",con);
                startActivity(I);
            }else{
                Toast.makeText(getApplicationContext(),"AMBAS CONTRASEÑAS DEBEN SER IGUALES",Toast.LENGTH_LONG).show();
            }
        }

    }
}