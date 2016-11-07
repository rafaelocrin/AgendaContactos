package com.zocrosfera.agendacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    TextView tvFechaNacimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion_Contacto));
        String fechaNacimento = parametros.getString(getResources().getString(R.string.pfecha_nascimento));

        tvNombre = (TextView) findViewById(R.id.tvNombre_ConfDatos);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono_ConfDatos);
        tvEmail = (TextView) findViewById(R.id.tvEmail_ConfDatos);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion_ConfDatos);
        tvFechaNacimento = (TextView) findViewById(R.id.tvFechaNacimento_ConfDatos);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
        tvFechaNacimento.setText(fechaNacimento);
    }

    public void editarDatos(View v){

        String nombre = tvNombre.getText().toString();
        String telefono = tvTelefono.getText().toString();
        String email = tvEmail.getText().toString();
        String descripcion = tvDescripcion.getText().toString();
        String fechaNacimento = tvFechaNacimento.getText().toString();

        Intent intent = new Intent(ConfirmacionDatos.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre), nombre);
        intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
        intent.putExtra(getResources().getString(R.string.pemail), email);
        intent.putExtra(getResources().getString(R.string.pdescripcion_Contacto), descripcion);
        intent.putExtra(getResources().getString(R.string.pfecha_nascimento), fechaNacimento);
        startActivity(intent);
    }
}
