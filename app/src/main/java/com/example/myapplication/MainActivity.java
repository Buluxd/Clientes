package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.db.contract.DatosContract;
import com.example.myapplication.entidad.clientes;

public class MainActivity extends AppCompatActivity {
    TextView tnombre ;
    TextView tapellido;
    TextView placa;
    TextView numer;
    clientes cli;
    actividad act;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tnombre = (TextView )findViewById(R.id.txtnombre);
        tapellido = (TextView)findViewById(R.id.txtapellido);
        placa = (TextView)findViewById(R.id.txtplaca);
        numer = (TextView)findViewById(R.id.numero);
        cli = new clientes() ;
        act = new actividad();
        cli.setContext(this);
    }
    public void limpiar (){
        tnombre.setText("");
        tapellido.setText("");
        placa.setText("");
        numer.setText("");
    }
    public void Mensaje(View view){
        cli.setNombre(tnombre.toString());
        cli.setApellido(tapellido.toString());
        cli.setPlaca(placa.getText().toString());
        cli.setNumer(Integer.valueOf(numer.getText().toString()));

        if (cli.guardar()) {
            Toast.makeText(this, "Contacto " + tnombre.getText()+ " guardado.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR! contacto no guardado", Toast.LENGTH_LONG).show();
        }

        limpiar();}

    public void Buscar(View view){
        Intent i = new Intent ( this, actividad.class);
        startActivity(i);
    }
}