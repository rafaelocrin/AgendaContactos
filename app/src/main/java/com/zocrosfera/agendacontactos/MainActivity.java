package com.zocrosfera.agendacontactos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcionContacto;
    DatePicker dpFechaNacimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcionContacto = (EditText) findViewById(R.id.etDescripcionContacto);
        dpFechaNacimento = (DatePicker) findViewById(R.id.dpFechaNacimento);

        Bundle parametros = getIntent().getExtras();

        if (parametros != null) {
            String nombre = parametros.getString(getResources().getString(R.string.pnombre));
            String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            String email = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion_Contacto));
            String fechaNacimento = parametros.getString(getResources().getString(R.string.pfecha_nascimento));

            etNombre.setText(nombre);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcionContacto.setText(descripcion);

            int day = Integer.parseInt(fechaNacimento.split("/")[0]);
            int month = Integer.parseInt(fechaNacimento.split("/")[1]);
            int year = Integer.parseInt(fechaNacimento.split("/")[2]);

            dpFechaNacimento.updateDate(year, month, day);
        }
    }

    public void irALaSiguienteActivity(View v){


        String nombre = etNombre.getText().toString();
        String telefono = etTelefono.getText().toString();
        String email = etEmail.getText().toString();
        String descripcionContacto = etDescripcionContacto.getText().toString();
        String fechaNacimento = dpFechaNacimento.getDayOfMonth() + "/" +
                                dpFechaNacimento.getMonth() + "/" + dpFechaNacimento.getYear();

        Intent intent = new Intent(MainActivity.this, ConfirmacionDatos.class);
        intent.putExtra(getResources().getString(R.string.pnombre), nombre);
        intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
        intent.putExtra(getResources().getString(R.string.pemail), email);
        intent.putExtra(getResources().getString(R.string.pdescripcion_Contacto), descripcionContacto);
        intent.putExtra(getResources().getString(R.string.pfecha_nascimento), fechaNacimento);
        startActivity(intent);
        //finish();
    }
}
