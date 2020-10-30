package com.example.myapplication.entidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.db.contract.DBHelper;
import com.example.myapplication.db.contract.DatosContract;

public class clientes {
    private String nombre;
    private String apellido;
    private String placa;
    private int numer;

    Context context;
    private SQLiteDatabase db;
    DBHelper nDBHelper;




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public boolean guardar(){
        try {
            nDBHelper = new DBHelper(context);
            db = nDBHelper.getWritableDatabase();
            ContentValues valor = new ContentValues();
            valor.put(DatosContract.Clientes.COLUMN_NAME, nombre);
            valor.put(DatosContract.Clientes.COLUMN_APELLIDO, apellido);
            valor.put(DatosContract.Clientes.COLUMN_TELEFONO, numer);
            valor.put(DatosContract.Clientes.COLUMN_PLACA, placa);
            db.insert(DatosContract.Clientes.TABLE_NAME, null, valor);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public Cursor Buscarnombre(){
        try{
            Cursor c = db.rawQuery( "SELECT PLACA FROM CLIENTES",   null);
            return c;



        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
