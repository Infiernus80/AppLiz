package com.example.diseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MisDatos extends AppCompatActivity {
    EditText etNombre, etApellido, etFechaNac, etTelefono, etCorreo, etContraseña, etSuledo;
    Button btnVolverD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_datos);
        //Declaracion de variables
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etFechaNac = findViewById(R.id.etFechaNac);
        etTelefono = findViewById(R.id.etTelefono);
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        etSuledo = findViewById(R.id.etSueldo);
        btnVolverD = findViewById(R.id.btnVolverD);

        btnVolverD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(getApplicationContext(), MenuPrincipalB.class);
                startActivity(volver);
            }
        });//Termina metodo onClick Volver
    }//Termina onCreate
}//Termina class Mis datos
