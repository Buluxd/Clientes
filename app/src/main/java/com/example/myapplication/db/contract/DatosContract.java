package com.example.myapplication.db.contract;

import android.provider.BaseColumns;

public class DatosContract {
    public static class Clientes implements BaseColumns {
        public static final String TABLE_NAME = "CLIENTE";
        public static final String COLUMN_NAME = "NOMBRE";
        public static final String COLUMN_APELLIDO = "APELLIDO";
        public static final String COLUMN_PLACA = "PLACA";
        public static final String COLUMN_TELEFONO = "TELEFONO";

    }

    public static final String SQL_CREATE_ENTRIES = PR.CREATE_TABLE + Clientes.TABLE_NAME + "(" +
            Clientes._ID + PR.AUTO_INCREMENT + PR.COMMA_SEP + Clientes.COLUMN_NAME + PR.TEXT_TYPE
            + PR.COMMA_SEP + Clientes.COLUMN_APELLIDO + PR.TEXT_TYPE + PR.COMMA_SEP +
            Clientes.COLUMN_TELEFONO + PR.INTEGER_TYPE + PR.COMMA_SEP + Clientes.COLUMN_PLACA +
            PR.TEXT_TYPE + ")" ;


    public static final String SQL_DELETE_ENTRIES = PR.DROP_TALBE + Clientes.TABLE_NAME;

}
