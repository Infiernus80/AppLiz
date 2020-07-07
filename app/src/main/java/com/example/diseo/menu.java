package com.example.diseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menu extends AppCompatActivity {
    private Button Cerrar;
    ImageButton ibAgregar,ibModificar,ibConsultar,ibEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Cerrar = (Button) findViewById(R.id.btnVolver);
        ibAgregar = findViewById(R.id.ibAgregar);
        ibModificar = findViewById(R.id.ibModificar);
        ibConsultar = findViewById(R.id.ibConsultar);
        ibEliminar = findViewById(R.id.ibEliminar);

        //Ir a menu Agregar
        ibAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregar = new Intent(getApplicationContext(),AgregarProducto.class);
                startActivity(agregar);
            }
        });

        //Ir a menu Modificar
        ibModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modificar = new Intent(getApplicationContext(),MenuModificar.class);
                startActivity(modificar);
            }
        });
        //Ir a menu Consultar
        ibConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultar = new Intent(getApplicationContext(),MenuConsultar.class);
                startActivity(consultar);
            }
        });
        ibEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eliminar = new Intent(getApplicationContext(),MenuEliminar.class);
                startActivity(eliminar);
            }
        });

        Cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipalB.class);
                startActivity(intent);
            }
        });

    }
}
