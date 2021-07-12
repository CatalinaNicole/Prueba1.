package com.csto.prueba1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {

    public static String nombre_bd = "pelicula";
    public static int version_bd = 1;

    public static String tabla_peliculas ="create table tabla_pelicula (id_pelicula integer primary key autoincrement,"+
        "nombre_pelicula text,genero_pelicula text)";

    public dbhelper(@Nullable Context context) {
        super(context,nombre_bd, null, version_bd);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_peliculas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tabla_pelicula");
        db.execSQL(tabla_peliculas);
    }
}
