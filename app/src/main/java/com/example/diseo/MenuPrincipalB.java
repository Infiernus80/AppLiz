package com.example.diseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuPrincipalB extends AppCompatActivity {
    ImageButton misDatos,menuProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_b);

        misDatos = findViewById(R.id.ibtnDatos);
        menuProductos = findViewById(R.id.ibtnProductos);

        misDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datos = new Intent(getApplicationContext(),MisDatos.class);
                startActivity(datos);
            }
        });//Termina OnClick de Mis datos

        menuProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productos = new Intent(getApplicationContext(),menu.class);
                startActivity(productos);
            }
        });


    }
}
